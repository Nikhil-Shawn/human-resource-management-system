import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';
import { BsThreeDotsVertical } from "react-icons/bs";
import HeaderComponent from '../Components/HeaderComponent';
import PayrollDrawer from '../Components/PayrollDrawer';
import Sidebar from '../Components/Sidebar';
import './Payroll.css';

function Payroll() {
  const [payrollData, setPayrollData] = useState([]);
  const [isDrawerOpen, setIsDrawerOpen] = useState(false);
  const [currentPayroll, setCurrentPayroll] = useState(null);
  const [dropdownOpen, setDropdownOpen] = useState(null);
  const dropdownRef = useRef(null);

  useEffect(() => {
    fetchPayrolls();
    document.addEventListener('mousedown', handleClickOutside);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  const fetchPayrolls = () => {
    axios.get('http://localhost:8080/api/payrolls')
      .then(response => {
        setPayrollData(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the payroll data!', error);
      });
  };

  const handleDrawerOpen = (payroll) => {
    setCurrentPayroll(payroll);
    setIsDrawerOpen(true);
  };

  const handleDrawerClose = () => {
    setIsDrawerOpen(false);
    setCurrentPayroll(null);
  };

  const handleSave = (newPayroll) => {
    if (currentPayroll) {
      setPayrollData(payrollData.map(payroll => payroll.payrollId === newPayroll.payrollId ? newPayroll : payroll));
    } else {
      setPayrollData([...payrollData, newPayroll]);
    }
  };

  const handleDelete = (payrollId) => {
    axios.delete(`http://localhost:8080/api/payrolls/deletePayroll/${payrollId}`)
      .then(response => {
        setPayrollData(payrollData.filter(payroll => payroll.payrollId !== payrollId));
      })
      .catch(error => {
        console.error('There was an error deleting the payroll!', error);
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
                <th>Name</th>
                <th>Position</th>
                <th>Department</th>
                <th>Period</th>
                <th>Bonus</th>
                <th>Status</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {payrollData.map((payroll, index) => (
                <tr key={index}>
                  <td>{payroll.employeeName}</td>
                  <td>{payroll.position}</td>
                  <td>{payroll.department}</td>
                  <td>{payroll.period}</td>
                  <td>{payroll.bonus}</td>
                  <td>{payroll.status}</td>
                  <td>
                    <div className="dropdown-container" ref={dropdownOpen === index ? dropdownRef : null}>
                      <BsThreeDotsVertical onClick={() => toggleDropdown(index)} />
                      {dropdownOpen === index && (
                        <div className="dropdown-menu">
                          <div className="dropdown-item" onClick={() => handleDrawerOpen(payroll)}>Edit</div>
                          <div className="dropdown-item" onClick={() => handleDelete(payroll.payrollId)}>Delete</div>
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
