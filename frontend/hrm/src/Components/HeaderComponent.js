import React from "react";
import { useNavigate } from "react-router-dom";
import nexusLogo from "../images/nexusLogo.png";
import "./HeaderComponent.css";

function HeaderComponent() {
    const navigate = useNavigate();

    const handleLogout = () => {
        navigate("/");
    };

    return (
        <div className="header-container">
            <div className="logo">
                <img src={nexusLogo} alt="HR Nexus logo" />
            </div>
            <div className="logout-button-container">
                <button onClick={handleLogout}>Logout</button>
            </div>
        </div>
    );
}

export default HeaderComponent;