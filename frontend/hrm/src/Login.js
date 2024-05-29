import React from "react";
import loginImage from "./images/loginImage.svg";
import nexusLogo from "./images/nexusLogo.png";
import "./Login.css";
 
function Login() {
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
<h2>Create an account</h2>
<p>Enter your email to sign up</p>
<input type="text" placeholder="email@domain.com" className="input-field" />
<input type="password" placeholder="password" className="input-field" />
<button className="login-button">Login</button>
</div>
</div>
</div>
  );
}
 
export default Login;
