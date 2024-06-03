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
      img: 'https://startup.telangana.gov.in/wp-content/uploads/2021/07/male-placeholder-1000x960.jpg',
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
      img: 'https://startup.telangana.gov.in/wp-content/uploads/2021/07/male-placeholder-1000x960.jpg',
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
      img: 'https://startup.telangana.gov.in/wp-content/uploads/2021/07/male-placeholder-1000x960.jpg',
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
      img: 'https://startup.telangana.gov.in/wp-content/uploads/2021/07/male-placeholder-1000x960.jpg',
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
          <tr style={{
            fontWeight: '0',
                fontSize: '0.8vw',
                color: 'black'
              }} >
            <th style={{
                padding: '20px 0px 20px 40px',
                marginLeft: '10px'
              }}>Name</th>
            <th>Position</th> 
            <th>Deparment</th>
            <th>Status</th>
            <th>Joining Date</th>
            <th>Email address</th>
            <th>Phone</th>
            <th></th>
          </tr>
        </thead>
        <tbody style={{fontSize: '0.8vw', textAlign: 'center'}}>
          {employees.map(employee => (
            <tr key={employee.id}>
               <td style={{ display: 'flex', alignItems: 'center', borderLeft: '1px solid #E0E4EA', padding: '20px' }}>
        <img
          src={employee.img}
          alt={`${employee.name}'s profile`}
          style={{
            width: '40px',
            height: '40px',
            borderRadius: '50%',
            marginRight: '10px'
          }}
        />
        <span>{employee.name}</span>
      </td>
              <td><span style={{
                backgroundColor: '#DDCBFC',
                color: 'black',
                borderRadius: '30px',
                padding: '8px 20px',
                display: 'inline-block'
              }}>{employee.position}</span></td>
              <td>{employee.department}</td>
              <td><span style={{
                backgroundColor: '#DDFCE0',
                color: '#0EB01D',
                borderRadius: '30px',
                padding: '8px 20px',
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
