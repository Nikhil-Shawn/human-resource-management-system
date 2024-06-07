import React from 'react';
import { FaBriefcase, FaChartPie, FaDollarSign, FaLaptop, FaSignOutAlt, FaUserTie, FaUsers } from 'react-icons/fa';
import './Sidebar.css';
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

const displayAssets = () => {
  navigate('/assets')
}

const displayApplicantList = () => {
  navigate('/applicantList')
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
        <div className="sidebar-item" onClick={displayAssets}>
          <FaLaptop className="sidebar-icon" />
          <span>Assets</span>
        </div>
        <div className="sidebar-item" onClick={displaySeparation}>
          <FaSignOutAlt className="sidebar-icon" />
          <span>Separation</span>
        </div>
        <div className="sidebar-item" onClick={displayApplicantList}>
          <FaUserTie className="sidebar-icon" />
          <span>Applicants</span>
        </div>
      </div>
    </div>
  );
}

export default Sidebar;
