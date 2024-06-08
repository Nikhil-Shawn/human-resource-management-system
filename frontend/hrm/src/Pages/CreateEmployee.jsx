import React, { useState } from "react";
import Sidebar from "../Components/Sidebar";
import Drawer from "../Components/Drawer";
import "./EmployeeList";
import HeaderComponent from "../Components/HeaderComponent";
import "./CreateEmployee.css";

function CreateEmployee() {
	const [firstname, setFirstname] = useState("");
	const [lastname, setLastname] = useState("");
	const [dob, setDob] = useState("");
	const [nationality, setNationality] = useState("");
	const [gender, setGender] = useState("");
	const [phone, setPhone] = useState("");
	const [email, setEmail] = useState("");
	const [department, setDepartment] = useState("");
	const [dateOfJoining, setDateOfJoining] = useState("");
	const [dateOfTermination, setDateOfTermination] = useState("");
	const [maritalStatus, setMaritalStatus] = useState("");
	const [street, setStreet] = useState("");
	const [streetNo, setStreetNo] = useState("");
	const [postcode, setPostcode] = useState("");
	const [city, setCity] = useState("");
	const [country, setCountry] = useState("");
	const [workLocation, setworkLocation] = useState("");
	const [passportExpDate, setPassportExpDate] = useState("");
	const [personType, setPersonType] = useState("");
	const [designation, setDesignation] = useState("");
	const [employment, setEmploymentType] = useState("");
	const [mangeWhom, setManageWhom] = useState("");
	const [isSupervisor, setIsSupervisor] = useState(false);
	const [isAdmin, setIsAdmin] = useState(false);

	const handleSupervisorChange = (e) => {
		console.log(e.target.checked);
		setIsSupervisor(e.target.checked);
	};

	const handleAdminChange = (e) => {
		console.log(e.target.checked);
		setIsAdmin(e.target.checked);
	};

	const handleSubmit = (e) => {
		e.preventDefault();
		console.log("Form submitted:", {
			firstname,
			lastname,
			email,
			phone,
			dob,
			gender,
			nationality,
			maritalStatus,
			city,
			postcode,
			country,
			workLocation,
			dateOfJoining,
			dateOfTermination,
			personType,
			department,
			designation,
			employment,
			mangeWhom,
			isAdmin,
			isSupervisor,
		});
	};

	return (
		<div className="app">
			<Sidebar />
			<div className="main-content">
				<HeaderComponent />
				<div className="employee-container">
					<div className="save-button-container">
						<div className="create-employee-text">Create Employee</div>
						<div>
							<button onClick={handleSubmit}>Save and continue</button>
						</div>
					</div>
					<div className="form-cont">
						<form>
							<div className="form-section-wrapper">
								<div className="personal-info">
									<h3>Basic Information</h3>
									<input
										type="text"
										placeholder="Firstname"
										value={firstname}
										onChange={(e) => setFirstname(e.target.value)}
										required
									/>
									<input
										type="text"
										placeholder="Lastname"
										value={lastname}
										onChange={(e) => setLastname(e.target.value)}
										required
									/>
									<input
										type="text"
										placeholder="Email"
										value={email}
										onChange={(e) => setEmail(e.target.value)}
										required
									/>
									<input
										type="text"
										placeholder="Phone number"
										value={phone}
										onChange={(e) => setPhone(e.target.value)}
										required
									/>
									<label>
										Date of Birth
										<input
											type="date"
											placeholder="Date of Birth"
											value={dob}
											onChange={(e) => setDob(e.target.value)}
											required
										/>
									</label>
									<input
										type="text"
										placeholder="Gender"
										value={gender}
										onChange={(e) => setGender(e.target.value)}
										required
									/>
									<input
										type="text"
										placeholder="Marital Status"
										value={nationality}
										onChange={(e) => setMaritalStatus(e.target.value)}
										required
									/>
									<input
										type="text"
										placeholder="Nationality"
										value={nationality}
										onChange={(e) => setNationality(e.target.value)}
										required
									/>
									<input
										type="text"
										placeholder="City"
										value={city}
										onChange={(e) => setCity(e.target.value)}
										required
									/>

									<input
										type="text"
										placeholder="Postcode"
										value={postcode}
										onChange={(e) => setPostcode(e.target.value)}
										required
									/>

									<input
										type="text"
										placeholder="Country"
										value={country}
										onChange={(e) => setCountry(e.target.value)}
										required
									/>
									<input
										type="text"
										placeholder="Work location"
										value={workLocation}
										onChange={(e) => setworkLocation(e.target.value)}
										required
									/>
								</div>

								<div className="address-info">
									<h3>Employment Information</h3>

									<label>
										Joining Date
										<input
											type="date"
											placeholder="Date of Joining"
											value={dateOfJoining}
											onChange={(e) => setDateOfJoining(e.target.value)}
											required
										/>
									</label>
									<label>
										Termination Date
										<input
											type="date"
											placeholder="Date of Termination"
											value={dateOfTermination}
											onChange={(e) => setDateOfTermination(e.target.value)}
											required
										/>
									</label>

									<input
										type="text"
										placeholder="Person Type"
										value={nationality}
										onChange={(e) => setPersonType(e.target.value)}
										required
									/>

									<input
										type="text"
										placeholder="Department"
										value={department}
										onChange={(e) => setDepartment(e.target.value)}
										required
									/>
									<input
										type="text"
										placeholder="Designation"
										value={department}
										onChange={(e) => setDesignation(e.target.value)}
										required
									/>
									<input
										type="text"
										placeholder="Employee Type"
										value={department}
										onChange={(e) => setEmploymentType(e.target.value)}
										required
									/>
									<input
										type="text"
										placeholder="Manage whom"
										value={department}
										onChange={(e) => setManageWhom(e.target.value)}
										required
									/>
									<div className="checkbox-container">
										<input
											type="checkbox"
											id="isSupervisor"
											checked={isSupervisor}
											onChange={handleSupervisorChange}
										/>
										<label>Supervisor</label>
										<input
											className="adminCheckbox"
											type="checkbox"
											id="isAdmin"
											checked={isAdmin}
											onChange={handleAdminChange}
										/>
										<label>Admin</label>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	);
}

export default CreateEmployee;
