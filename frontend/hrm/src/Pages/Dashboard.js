import React, { useEffect, useState } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import { useNavigate } from "react-router-dom";
import "../App.css";
import HeaderComponent from "../Components/HeaderComponent.js";
import Sidebar from "../Components/Sidebar.jsx";
import "./Dashboard.css";
import { useAuth } from "./AuthContext";

function Dashboard() {
    const { authData } = useAuth();
    const [startDate, setStartDate] = useState(new Date());
    const navigate = useNavigate();

    console.log("AUTHDATA HERE", authData.data.employeeId);
    const employeeId = authData.data.employeeId;
    console.log(employeeId);


    const displayEmployee = () => {
        navigate('/employee');
    };

    const displayLeaves = () => {
        navigate('/leaves');
    };

    const displayDepartment = () => {
        navigate('/department');
    };

    const displayPayroll = () => {
        navigate('/payroll');
    };

    const displaySeparation = () => {
        navigate('/separation');
    };

    const displayAssets = () => {
        navigate('/assets');
    };

    return (
        <div className="dashboard-container">
            <Sidebar />
            <div className="dashboard-content">
                <HeaderComponent />
                <div className="dashboard-main">
                    <div className="dashboard-grid">
                        <div className="dashboard-card" onClick={displayEmployee}>
                            <div className="card-title">Employee</div>
                            <div className="card-icon employee-icon"></div>
                            <div className="card-subtitle">No. of Employees</div>
                        </div>
                        <div className="dashboard-card" onClick={displayLeaves}>
                            <div className="card-title">Leaves</div>
                            <div className="card-icon leaves-icon"></div>
                            <div className="card-subtitle">No. of Leaves</div>
                        </div>
                        <div className="dashboard-card" onClick={displayPayroll}>
                            <div className="card-title">Payroll</div>
                            <div className="card-icon payroll-icon"></div>
                            <div className="card-subtitle">Payroll details</div>
                        </div>
                        <div className="dashboard-card" onClick={displayAssets}>
                            <div className="card-title">Asset</div>
                            <div className="card-icon assets-icon"></div>
                            <div className="card-subtitle">Asset Management</div>
                        </div>
                        <div className="dashboard-card" onClick={displayDepartment}>
                            <div className="card-title">Department</div>
                            <div className="card-icon assets-icon"></div>
                            <div className="card-subtitle">Depatment Details</div>
                        </div>
                        <div className="dashboard-card" onClick={displaySeparation}>
                            <div className="card-title">Separation</div>
                            <div className="card-icon separation-icon"></div>
                            <div className="card-subtitle">Contract Termination</div>
                        </div>
                        {/* Work in Progress */}
                        {/* <div className="dashboard-card">
                            <div className="card-title">Applicants</div>
                            <div className="card-icon applicants-icon"></div>
                            <div className="card-subtitle">Applicant information</div>
                        </div> */}
                    </div>
                    <div className="dashboard-calendar">
                        <DatePicker
                            selected={startDate}
                            onChange={date => setStartDate(date)}
                            inline
                        />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Dashboard;
