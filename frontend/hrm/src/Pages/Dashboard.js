import React from "react";
import Sidebar from "../Components/Sidebar.jsx";
import "./Dashboard.css";
import "../App.css";
import nexusLogo from "../images/nexusLogo.png";
import { useNavigate } from "react-router-dom";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import { useState } from "react";

function Dashboard() {
	const navigate = useNavigate();
	const [date, setDate] = useState(new Date());

	const handleLogin = () => {
		navigate("/");
	};
	return (
		<div className="dashboard-container">
      <Sidebar />
      <div className="dashboard-content">
        <div className="dashboard-header">
          <div className="logo">
            <img src={nexusLogo} alt="HR Nexus logo" />
          </div>
          <div className="logout-button-container">
            <button onClick={handleLogin}>Logout</button>
          </div>
        </div>
        <div className="dashboard-main">
          <div className="dashboard-grid">
            <div className="dashboard-card">
              <div className="card-title">Employee</div>
              <div className="card-icon employee-icon"></div>
              <div className="card-subtitle">No. of Employees</div>
            </div>
            <div className="dashboard-card">
              <div className="card-title">Leaves</div>
              <div className="card-icon leaves-icon"></div>
              <div className="card-subtitle">No. of Leaves</div>
            </div>
            <div className="dashboard-card">
              <div className="card-title">Payroll</div>
              <div className="card-icon payroll-icon"></div>
              <div className="card-subtitle">Payroll details</div>
            </div>
            <div className="dashboard-card">
              <div className="card-title">Asset</div>
              <div className="card-icon assets-icon"></div>
              <div className="card-subtitle">Asset management</div>
            </div>
            <div className="dashboard-card">
              <div className="card-title">Separation</div>
              <div className="card-icon separation-icon"></div>
              <div className="card-subtitle">Contract Termination</div>
            </div>
            <div className="dashboard-card">
              <div className="card-title">Applicants</div>
              <div className="card-icon applicants-icon"></div>
              <div className="card-subtitle">Applicant information</div>
            </div>
          </div>
          <div className="dashboard-calendar">
            <Calendar onChange={setDate} value={date} />
          </div>
        </div>
      </div>
    </div>
	);
}

export default Dashboard;
