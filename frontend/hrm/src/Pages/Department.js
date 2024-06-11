import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react';
import { BsThreeDotsVertical } from "react-icons/bs";
import DepartmentDrawer from '../Components/DepartmentDrawer';
import HeaderComponent from '../Components/HeaderComponent';
import Sidebar from '../Components/Sidebar';
import './Department.css';

function Department() {
  const [departmentsData, setDepartmentsData] = useState([]);
  const [isDrawerOpen, setIsDrawerOpen] = useState(false);
  const [currentDepartment, setCurrentDepartment] = useState(null);
  const [dropdownOpen, setDropdownOpen] = useState(null);
  const dropdownRef = useRef(null);

  useEffect(() => {
    fetchDepartments();
    document.addEventListener('mousedown', handleClickOutside);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  const fetchDepartments = () => {
    axios.get('http://localhost:8080/api/departments', {
      // Include authentication headers if required
      headers: {
        // 'Authorization': 'Bearer YOUR_TOKEN',
        // or any other necessary headers
      }
    })
      .then(response => {
        // Ensure that the response data is an array
        if (Array.isArray(response.data)) {
          setDepartmentsData(response.data);
        } else {
          console.error('Expected an array but got:', response.data);
        }
      })
      .catch(error => {
        if (error.response && error.response.status === 403) {
          console.error('Access forbidden: You do not have permission to access this resource.');
        } else {
          console.error('There was an error fetching the departments data!', error);
        }
      });
  };

  const handleDrawerOpen = (department) => {
    setCurrentDepartment(department);
    setIsDrawerOpen(true);
  };

  const handleDrawerClose = () => {
    setIsDrawerOpen(false);
    setCurrentDepartment(null);
  };

  const handleSave = (newDepartment) => {
    if (currentDepartment) {
      setDepartmentsData(departmentsData.map(department => department.departmentId === newDepartment.departmentId ? newDepartment : department));
    } else {
      setDepartmentsData([...departmentsData, newDepartment]);
    }
  };

  const handleDelete = (departmentId) => {
    axios.delete(`http://localhost:8080/api/departments/deleteDepartment/${departmentId}`)
      .then(response => {
        setDepartmentsData(departmentsData.filter(department => department.departmentId !== departmentId));
      })
      .catch(error => {
        console.error('There was an error deleting the department!', error);
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
        <div className="departments-container">
          <div className="departments-heading">
            <div className="departments-text">Departments</div>
            <div className="add-department-button-container">
              <button onClick={() => handleDrawerOpen(null)}>+ Add Department</button>
            </div>
          </div>
          <table className="department-table">
            <thead>
              <tr>
                <th>Department Name</th>
                <th>Status</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
              {Array.isArray(departmentsData) ? (
                departmentsData.map((department, index) => (
                  <tr key={index}>
                    <td>{department.departmentName}</td>
                    <td>{department.departmentStatus}</td>
                    <td>
                      <div className="dropdown-container" ref={dropdownOpen === index ? dropdownRef : null}>
                        <BsThreeDotsVertical onClick={() => toggleDropdown(index)} />
                        {dropdownOpen === index && (
                          <div className="dropdown-menu">
                            <div className="dropdown-item" onClick={() => handleDrawerOpen(department)}>Edit</div>
                            <div className="dropdown-item" onClick={() => handleDelete(department.departmentId)}>Delete</div>
                          </div>
                        )}
                      </div>
                    </td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="3">No departments available</td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
      <DepartmentDrawer isOpen={isDrawerOpen} onClose={handleDrawerClose} onSave={handleSave} department={currentDepartment} />
    </div>
  );
}

export default Department;
