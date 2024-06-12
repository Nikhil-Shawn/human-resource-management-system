import React, { useState } from "react";
import loginImage from "../images/loginImage.svg";
import nexusLogo from "../images/nexusLogo.png";
import "./Login.css";
import { useNavigate } from "react-router-dom";
import axios from "axios";

function Login() {
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const navigate = useNavigate();

    const handleLogin = async () => {
        try {
            const response = await axios.post("http://localhost:8080/api/login", {
                email,
                password,
                personType: "employee"
            });
            if (response.data.success) {
                navigate("/dashboard");
            } else {
                setError("Invalid email or password");
            }
        } catch (error) {
            setError("An error occurred. Please try again.");
        }
    };

    const handleCreateAccount = () => {
        navigate("/register");
    };

    return (
        <div className="container">
            <div className="login-image">
                <img src={loginImage} alt="login illustration" />
            </div>
            <div className="login-form">
                <div className="logo">
                    <img src={nexusLogo} alt="HR Nexus logo" />
                </div>
                <div className="button-container">
                    <button className="emp-button">Employee</button>
                    <button className="applicant-button">Applicant</button>
                </div>
                <div className="form-container">
                    <h2>Login to your account</h2>
                    <p>Enter your email and password to sign in</p>
                    <input
                        type="text"
                        placeholder="email@domain.com"
                        className="input-field"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <input
                        type="password"
                        placeholder="password"
                        className="input-field"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    {error && <p className="error-message">{error}</p>}
                    <button className="login-button" onClick={handleLogin}>
                        Login
                    </button>
                    <p className="create-account-message">
                        No account?{" "}
                        <span className="create-account-link" onClick={handleCreateAccount}>
                            Create an account here
                        </span>
                    </p>
                </div>
            </div>
        </div>
    );
}

export default Login;
