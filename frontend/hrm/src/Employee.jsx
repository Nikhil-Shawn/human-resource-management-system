import React from 'react';
import './Employee.css';
import Sidebar from './Components/Sidebar';

function Employee() {
  // Example data
  const employees = [
    {
      id: 1,
      name: 'John Doe',
      position: 'Software Engineer',
      email: 'john.doe@hr-nexus.com',
    },
    {
      id: 2,
      name: 'Jane Smith',
      position: 'Project Manager',
      email: 'jane.smith@hr-nexus.com'
    },
    {
        id: 2,
        name: 'Jane Smith',
        position: 'Project Manager',
        email: 'jane.smith@hr-nexus.com'
      },
      {
        id: 2,
        name: 'Jane Smith',
        position: 'Project Manager',
        email: 'jane.smith@hr-nexus.com'
      },
    // Add more employees as needed
  ];

  return (
    <div className="app">
      <Sidebar />
      <div className="main-content">
    <div className="employee-container">
      <h1>Employee List</h1>
      <table className="employee-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Position</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.map(employee => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.name}</td>
              <td>{employee.position}</td>
              <td>{employee.email}</td>
              <td>
                <button className="view-button">View</button>
                <button className="edit-button">Edit</button>
                <button className="delete-button">Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
    </div>
    </div>
  );
}

export default Employee;
