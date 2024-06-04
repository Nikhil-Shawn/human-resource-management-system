import React from "react";
import loginImage from "../images/loginImage.svg";
import nexusLogo from "../images/nexusLogo.png";
import "./Login.css";
import { useNavigate } from "react-router-dom";

function Login() {
	const navigate = useNavigate();
	const handleLogin = () => {
		navigate("/dashboard");
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
					/>
					<input
						type="password"
						placeholder="password"
						className="input-field"
					/>
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
