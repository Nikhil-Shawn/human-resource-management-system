import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import nexusLogo from "../images/nexusLogo.png";
import LogoutModal from "./LogoutModal";
import "./HeaderComponent.css";

function HeaderComponent() {
    const navigate = useNavigate();
    const [showModal, setShowModal] = useState(false);

    const handleLogoutClick = () => {
        setShowModal(true);
    };

    const handleConfirmLogout = () => {
        setShowModal(false);
        navigate("/");
    };

    const handleCloseModal = () => {
        setShowModal(false);
    };

    return (
        <div className="header-container">
            <div className="logo">
                <img src={nexusLogo} alt="HR Nexus logo" />
            </div>
            <div className="logout-button-container">
                <button onClick={handleLogoutClick}>Logout</button>
            </div>
            <LogoutModal show={showModal} handleClose={handleCloseModal} handleConfirm={handleConfirmLogout} />
        </div>
    );
}

export default HeaderComponent;
