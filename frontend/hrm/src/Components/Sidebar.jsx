import React, { useState, useEffect } from 'react';
import { FaBriefcase, FaChartPie, FaDollarSign, FaLaptop, FaSignOutAlt, FaUserTie, FaUsers, FaRegBuilding } from 'react-icons/fa';
import './Sidebar.css';
import { useNavigate } from 'react-router-dom';
import { useAuth } from '../Pages/AuthContext'; // Ensure this is correctly imported
import axios from 'axios';
import Department from '../Pages/Department';

function Sidebar() {
    const { authData } = useAuth();
    const [employeeData, setEmployeeData] = useState({});
    const navigate = useNavigate();

    const employeeId = authData.data.employeeId;
    console.log("is id proper?", employeeId);

    useEffect(() => {
        const fetchEmployeeData = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/api/v1/employee/${employeeId}`);
                setEmployeeData(response.data.person);
                console.log(response.data.person.firstName)
            } catch (error) {
                console.error("Error fetching employee data:", error);
            }
        };

        if (authData && employeeId) {
            fetchEmployeeData();
        }
    }, [authData]);

    const displayDashboard = () => {
        navigate('/dashboard')
    }

    const displayEmployee = () => {
        navigate('/employee')
    }

    const displayLeaves = () => {
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

    const displayDepartment = () => {
      navigate('/department')
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
                    <h3>{employeeData.firstName || 'Loading...'}</h3>
                    <p>{employeeData.personEmail || 'Loading...'}</p>
                </div>
            </div>
            <div className="sidebar-menu">
                <div className="sidebar-item" onClick={displayDashboard}>
                    <FaChartPie className="sidebar-icon" />
                    <span>Overview</span>
                </div>
                <div className="sidebar-item" onClick={displayEmployee}>
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
                <div className="sidebar-item" onClick={displayDepartment}>
                    <FaRegBuilding className="sidebar-icon" />
                    <span>Department</span>
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
