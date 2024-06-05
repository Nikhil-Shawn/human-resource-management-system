import React from 'react';
import { FaBriefcase, FaChartPie, FaDollarSign, FaLaptop, FaSignOutAlt, FaUserTie, FaUsers } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import './Sidebar.css';


function Sidebar() {
  return (
    <div className="sidebar">
      <div className="sidebar-header">
        <h2>NEXUS Systems</h2>
        <div className="sidebar-user">
          <p>Logged in as</p>
          <h3>Andreas Mueller</h3>
          <p>andreas.mueller@hr-nexus.com</p>
        </div>
      </div>
      <div className="sidebar-menu">
        <div className="sidebar-item">
          <FaChartPie className="sidebar-icon" />
          <span>Overview</span>
        </div>
        <div className="sidebar-item">
          <span>Employee Detail</span>
        </div>
        <div className="sidebar-item">
          <span>Create Employee</span>
        </div>
        <div className="sidebar-item">
          <span>Leaves</span>
        </div>
        <div className="sidebar-item">
          <FaUsers className="sidebar-icon" />
          <span>Employees</span>
        </div>
        <div className="sidebar-item">
          <FaBriefcase className="sidebar-icon" />
          <span>Leaves</span>
        </div>
        <div className="sidebar-item">
          <FaDollarSign className="sidebar-icon" />
          <span>Payroll</span>
        </div>
        <div className="sidebar-item">
          <FaSignOutAlt className="sidebar-icon" />
          <span>Separation</span>
        </div>
        <div className="sidebar-item">
          <FaLaptop className="sidebar-icon" />
          <span><Link to="/assets">Assets</Link></span>
        </div>
        <div className="sidebar-item">
          <FaUserTie className="sidebar-icon" />
          <span>Applicants</span>
        </div>
      </div>
    </div>
  );
}

export default Sidebar;
