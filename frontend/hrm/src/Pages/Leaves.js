import React from "react";
import "./Leaves.css";
import { BsThreeDotsVertical } from "react-icons/bs";
import Sidebar from "../Components/Sidebar";
import HeaderComponent from "../Components/HeaderComponent";
import { useEffect, useState, useRef } from "react";
import axios from "axios";
import LeaveDrawer from '../Components/LeaveDrawer';


function Leaves() {
	const [employees, setEmployees] = useState([]);
	const [isDrawerOpen, setIsDrawerOpen] = useState(false);
	const [currentLeave, setCurrentLeave] = useState(null);
	const [dropdownOpen, setDropdownOpen] = useState(null);
	const dropdownRef = useRef(null);

	useEffect(() => {
		axios.get("http://localhost:8080/api/vacations").then((response) => {
				setEmployees(response.data);
				console.log(response.data);
			}).catch((error) => {
				console.error("There was an error fetching the employee data!", error);
			});
	}, []);

	const handleDrawerOpen = (leave) => {
		setIsDrawerOpen(true);
		setCurrentLeave(leave)
	  };
	
	  const handleDrawerClose = () => {
		setIsDrawerOpen(false);
		setCurrentLeave(null)
	  };
	
	  const handleSave = (newLeave) => {
		if (currentLeave) {
		  setEmployees(employees.map(leave => leave.id === newLeave.id ? newLeave : leave));
		} else {
		  setEmployees([...employees, newLeave]);
		}
	  };

	  const handleDelete = (leaveId) => {
		axios.delete(`http://localhost:8080/api/vacations/deleteVacation/${leaveId}`)
		  .then(response => {
			setEmployees(employees.filter(leave => leave.id !== leave));
		  })
		  .catch(error => {
			console.error('There was an error deleting the leave!', error);
		  });
	  };

	  const toggleDropdown = (index) => {
		setDropdownOpen(dropdownOpen === index ? null : index);
	  };

	const getStatusStyle = (status) => {
		switch (status) {
			case "APPROVED":
				return { backgroundColor: "#DDFCE0", color: "#0EB01D" };
			case "NEW LEAVE":
				return { backgroundColor: "#FFF9C4", color: "#FF9800" };
			case "REJECTED":
				return { backgroundColor: "#F8D7DA", color: "#DC3545" };
			case "PENDING":
				return { backgroundColor: "#E0BBFF", color: "#6F42C1" };
			default:
				return { backgroundColor: "#E0E0E0", color: "#000000" };
		}
	};

	return (
		<div className="app">
			<Sidebar />
			<div className="main-content">
				<HeaderComponent />
				<div className="leaves-container">
					<div className="leaves-heading">
						<div className="leaves-text">Leaves</div>
						<div className="add-leave-button-container">
							<button onClick={() => handleDrawerOpen()}>+ Add Leave</button>
						</div>
					</div>
					<table className="employee-table">
						<thead>
							<tr
								style={{
									fontWeight: "0",
									fontSize: "0.8vw",
									color: "black",
								}}
							>
								<th
									style={{
										padding: "20px 0px 20px 40px",
										marginLeft: "10px",
									}}
								>
									Name
								</th>
								<th>reason</th>
								<th>Leave Type</th>
								<th>Start Date</th>
								<th>End Date</th>
								<th>Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody style={{ fontSize: "0.8vw", textAlign: "center" }}>
							{employees.map((employee,index) => (
								<tr key={index}>
									<td
										style={{
											display: "flex",
											alignItems: "center",
											borderLeft: "1px solid #E0E4EA",
											padding: "20px",
										}}
									>
										<img
											src={employee.img}
											alt={`${employee.name}'s profile`}
											style={{
												width: "40px",
												height: "40px",
												borderRadius: "50%",
												marginRight: "10px",
											}}
										/>
										<span>{employee.name}</span>
									</td>
									<td>
										<span
											style={{
												backgroundColor: "#DDCBFC",
												color: "black",
												borderRadius: "30px",
												padding: "8px 20px",
												display: "inline-block",
											}}
										>
											{employee.reason}
										</span>
									</td>
									<td>{employee.leaveType}</td>
									<td>{employee.startDate}</td>
									<td>{employee.endDate}</td>
									<td>
										<span
											style={{
												...getStatusStyle(employee.leaveStatus),
												borderRadius: "30px",
												padding: "8px 20px",
												display: "inline-block",
											}}
										>
											{employee.leaveStatus}
										</span>
									</td>
									<div className="dropdown-container" ref={dropdownOpen === index ? dropdownRef : null}>
                      <BsThreeDotsVertical onClick={() => toggleDropdown(index)} />
                      {dropdownOpen === index && (
                        <div className="dropdown-menu">
                          <div className="dropdown-item" onClick={() => handleDrawerOpen(employee)}>Edit</div>
                          <div className="dropdown-item" onClick={() => handleDelete(employee.id)}>Delete</div>
                        </div>
                      )}
                    </div>
								</tr>
							))}
						</tbody>
					</table>
				</div>
			</div>
			<LeaveDrawer isOpen={isDrawerOpen} onClose={handleDrawerClose} onSave={handleSave} leave={currentLeave}  />

		</div>
	);
}

export default Leaves;
