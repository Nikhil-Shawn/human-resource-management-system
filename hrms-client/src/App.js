import "./App.css";
import loginImage from "./images/loginImage.svg";
import nexusLogo from "./images/nexusLogo.png";

function App() {
	return (
		<div>
			<div className="login-image">
				<img
					src={loginImage}
					alt="loginImage"
					style={{ width: "700px", height: "540px" }}
				/>
			</div>
			<div className="logo">
				<img
					src={nexusLogo}
					alt="logo"
					style={{ width: "150px", height: "150px" }}
				></img>
			</div>
			<div className="button-container">
				<button className="emp-button">Employee</button>
				<button className="applicant-button">Applicant</button>
				<div className="heading">Create an account</div>
				<div className="email">Enter your email to sign up</div>
				<div className="input-container">
					<input
						className="input-field"
						type="text"
						placeholder="email@domain.com"
					></input>
					<input
						className="password-field"
						type="text"
						placeholder="password"
					></input>
				</div>
				<div className="login-container">
					<button className="applicant-button">Login</button>
				</div>
			</div>
		</div>
	);
}

export default App;
