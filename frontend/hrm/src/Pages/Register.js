import React from "react";
import loginImage from "../images/loginImage.svg";
import nexusLogo from "../images/nexusLogo.png";
import "./Register.css";
import { useNavigate } from "react-router-dom";
import { useState } from "react";

const Register = () => {
    const [email, setEmail] = useState();
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');

    const handleSubmit = (e) => {
        e.preventDefault();
        // Add form submission logic here
        console.log('Form submitted', { email, password, confirmPassword });
    };

    return (
        <div className="register-container">
            <div className="image-section">
                <img src={loginImage} alt="Human Resource System" />
            </div>
            <div className="form-section">
                <img src={nexusLogo} alt="HR Nexus Logo"/>
                <h2>Create an account</h2>
                <form onSubmit={handleSubmit}>
                    <input
                        type="email"
                        placeholder="email@domain.com"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        required
                    />
                    <input
                        type="password"
                        placeholder="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                    <input
                        type="password"
                        placeholder="repeat password"
                        value={confirmPassword}
                        onChange={(e) => setConfirmPassword(e.target.value)}
                        required
                    />
                    <button type="submit">Sign up with email</button>
                </form>
            </div>
        </div>
    );
};

export default Register;
