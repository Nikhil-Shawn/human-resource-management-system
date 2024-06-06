import React from 'react';
import { FaBriefcase, FaChartPie, FaDollarSign, FaLaptop, FaSignOutAlt, FaUserTie, FaUsers } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import './Sidebar.css';
import { FaUsers, FaBriefcase, FaDollarSign, FaSignOutAlt, FaLaptop, FaUserTie, FaChartPie } from 'react-icons/fa';
import { useNavigate } from 'react-router-dom';




function Sidebar() {

  const navigate = useNavigate();

  const displayDashboard = () => {
    navigate('/dashboard')
  }

  const displayEmployeee = () => {
    navigate('/employee')
}

const displayLeaves = () =>{
    navigate('/leaves')
}

const displayPayroll = () => {
    navigate('/payroll')
}

const displaySeparation = () => {
    navigate('/separation')
}

  

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
        <div className="sidebar-item" onClick={displayDashboard}>
          <FaChartPie className="sidebar-icon" />
          <span>Overview</span>
        </div>
        <div className="sidebar-item" onClick={displayEmployeee}>
          <FaUsers className="sidebar-icon" />
          <span>Employees</span>
        </div>
        <div className="sidebar-item" onClick={displayLeaves}>
          <FaBriefcase className="sidebar-icon" />
          <span>Leaves</span>
        </div>
        <div className="sidebar-item" onClick={displayPayroll}>
          <FaDollarSign className="sidebar-icon" />
          <span>Payroll</span>
        </div>
        <div className="sidebar-item">
          <FaLaptop className="sidebar-icon" />
          <span><Link to="/assets">Assets</Link></span>
        </div>
        <div className="sidebar-item" onClick={displaySeparation}>
          <FaSignOutAlt className="sidebar-icon" />
          <span>Separation</span>
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
