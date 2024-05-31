import React from 'react';
import './Employee.css';
import Sidebar from './Components/Sidebar';
import { BsThreeDotsVertical } from "react-icons/bs";
import { FaPhoneAlt } from 'react-icons/fa';
import { IoIosMail } from "react-icons/io";


function Employee() {
  // Example data
  const employees = [
    {
      id: '1',
      name: 'John Smith',
      position: 'Project Manager',
      department: 'Development',
      status: 'ACTIVE',
      joiningdate: 'Sep 12, 2023',
      email: 'jane.smith@hr-nexus.com',
      phone: '0149 421 4219'
    },
    {
      id: '2',
      name: 'Jane Smith',
      position: 'Project Manager',
      department: 'Development',
      status: 'ACTIVE',
      joiningdate: 'Sep 12, 2023',
      email: 'jane.smith@hr-nexus.com',
      phone: '0149 421 4219'
    },
    {
      id: '3',
      name: 'AS Smith',
      position: 'Project Manager',
      department: 'Development',
      status: 'REMOTE',
      joiningdate: 'Sep 12, 2023',
      email: 'jane.smith@hr-nexus.com',
      phone: '0149 421 4219'
    },
    {
      id: '4',
      name: 'Jane Smith',
      position: 'Project Manager',
      department: 'Development',
      status: 'ON LEAVE',
      joiningdate: 'Sep 12, 2023',
      email: 'jane.smith@hr-nexus.com',
      phone: '0149 421 4219'
    }
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
            <th>Name</th>
            <th>Position</th> 
            <th>Deparment</th>
            <th>Status</th>
            <th>Joining Date</th>
            <th>Email address</th>
            <th>Phone</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
          {employees.map(employee => (
            <tr key={employee.id}>
              <td style={{ borderLeft: '1px solid #E0E4EA' }} >{employee.name}</td>
              <td><span style={{
                backgroundColor: '#DDCBFC',
                color: 'white',
                borderRadius: '5px',
                padding: '4px 5px',
                display: 'inline-block'
              }}>{employee.position}</span></td>
              <td>{employee.department}</td>
              <td><span style={{
                backgroundColor: '#DDFCE0',
                color: '#0EB01D',
                borderRadius: '30px',
                padding: '15px 25px',
                display: 'inline-block'
              }}>{employee.status}</span></td>
              <td>{employee.joiningdate}</td>
              <td><IoIosMail style={{marginRight: '5px' }}/>{employee.email}</td>
              <td><FaPhoneAlt style={{marginRight: '5px' }}/>{employee.phone}</td>
              <td style={{ borderRight: '1px solid #E0E4EA' }}>
                <BsThreeDotsVertical/>
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
