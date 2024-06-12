import React, { useEffect, useState, useRef } from "react";
import axios from "axios";
import "./Payroll.css";
import { BsThreeDotsVertical } from "react-icons/bs";
import Sidebar from "../Components/Sidebar";
import HeaderComponent from "../Components/HeaderComponent";
import PayrollDrawer from "../Components/PayrollDrawer";

function Payroll() {
  const [payrolls, setPayrolls] = useState(null);
  const [isDrawerOpen, setIsDrawerOpen] = useState(false);
  const [currentPayroll, setCurrentPayroll] = useState(null);
  const [dropdownOpen, setDropdownOpen] = useState(null);
  const dropdownRef = useRef(null);

  const fetchPayrolls = () => {
    axios.get("http://localhost:8080/api/payrolls")
      .then((response) => {
        const data = response.data;
        console.log("Full response data:", data); // Log the full response data
        setPayrolls(data); // Ensure this matches the response structure
        console.log("Payrolls data:", data); // Log the payrolls data
      })
      .catch((error) => {
        console.error("Error fetching payroll data:", error);
        if (error.response && error.response.status === 403) {
          console.error("Access forbidden: You don't have permission to access this resource.");
        } else {
          console.error("An error occurred while fetching payroll data.");
        }
      });
  };

  useEffect(() => {
    fetchPayrolls();
  }, []);

  const handleDrawerOpen = (payroll) => {
    setIsDrawerOpen(true);
    setCurrentPayroll(payroll || null);
  };

  const handleDrawerClose = () => {
    setIsDrawerOpen(false);
    setCurrentPayroll(null);
  };

  const handleSave = (newPayroll) => {
    if (currentPayroll) {
      setPayrolls(payrolls.map(payroll => payroll.payrollId === newPayroll.payrollId ? newPayroll : payroll));
      console.log("currentPayroll= ", currentPayroll);
    } else {
      setPayrolls([...payrolls, newPayroll]);
    }
    fetchPayrolls(); // Refresh the data after save
  };

  const handleDelete = (payrollId) => {
  
    axios.delete(`http://localhost:8080/api/payrolls/deletePayroll/${payrollId}`)
      .then(response => {
        fetchPayrolls(); // Refresh the data after delete
      })
      .catch(error => {
        console.error('There was an error deleting the payroll!', error);
        if (error.response && error.response.status === 403) {
          console.error("Access forbidden: You don't have permission to access this resource.");
        } else {
          console.error("An error occurred while deleting the payroll.");
        }
      });
  };

  const toggleDropdown = (index) => {
    setDropdownOpen(dropdownOpen === index ? null : index);
  };

  const handleClickOutside = (event) => {
    if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
      setDropdownOpen(null);
    }
  };

  return (
    <div className="app">
      <Sidebar />
      <div className="main-content">
        <HeaderComponent />
        <div className="payroll-container">
          <div className="payroll-heading">
            <div className="payroll-text">Payroll</div>
            <div className="add-payroll-button-container">
              <button onClick={() => handleDrawerOpen(null)}>+ Add Payroll</button>
            </div>
          </div>

          <table className="payroll-table">
            <thead>
              <tr>
                <th>Employee ID</th>
                <th>Pay Amount</th>
                <th>Pay Frequency</th>
                <th>Bonus</th>
                <th>Increment Applicable</th>
                <th>Percentage Increment</th>
                <th></th>
              </tr>
            </thead>

            <tbody>
              {payrolls && payrolls.map((payroll, index) => (
                <tr key={index}>
                  <td>{payroll.employeeId}</td>
                  <td>{payroll.payAmount}</td>
                  <td>{payroll.payFrequency}</td>
                  <td>{payroll.bonus}</td>
                  <td>{payroll.incrementApplicable ? 'Yes' : 'No'}</td>
                  <td>{payroll.percentageIncrement}</td>
                  <td>
                    <div className="dropdown-container" ref={dropdownOpen === index ? dropdownRef : null}>
                      <BsThreeDotsVertical onClick={() => toggleDropdown(index)} />
                      {dropdownOpen === index && (
                        <div className="dropdown-menu">
                          <div className="dropdown-item" onClick={() => handleDrawerOpen(payroll)}>Edit</div>
                          <div className="dropdown-item" onClick={() => handleDelete(payroll.payroll_id)}>Delete</div>
                        </div>
                      )}
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
      <PayrollDrawer isOpen={isDrawerOpen} onClose={handleDrawerClose} onSave={handleSave} payroll={currentPayroll} />
    </div>
  );
}

export default Payroll;
