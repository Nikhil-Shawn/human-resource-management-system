import React from "react";
import { BsThreeDotsVertical } from "react-icons/bs";
import Sidebar from "../Components/Sidebar";
import HeaderComponent from "../Components/HeaderComponent";

function Payroll() {
	// Example data
	const employees = [
		{
			id: "1",
			img: "https://startup.telangana.gov.in/wp-content/uploads/2021/07/male-placeholder-1000x960.jpg",
			name: "John Smith",
			position: "Project Manager",
			department: "Development",
			status: "ACTIVE",
			joiningdate: "Sep 12, 2023",
			email: "jane.smith@hr-nexus.com",
			phone: "0149 421 4219",
			leaveType: "Maternity Leave",
			period: "Sep 9,2022 - Jan 15,2023",
			Reason: "Maternity Leave",
			leaveStatus: "REJECTED",
            bonus : "$2400",
            payrollStatus : "COMPLETED"
		},
		{
			id: "2",
			img: "https://startup.telangana.gov.in/wp-content/uploads/2021/07/male-placeholder-1000x960.jpg",
			name: "Jane Smith",
			position: "Project Manager",
			department: "Development",
			status: "ACTIVE",
			joiningdate: "Sep 12, 2023",
			email: "jane.smith@hr-nexus.com",
			phone: "0149 421 4219",
			leaveType: "Sick Leave",
			period: "Aug 9-15,2023",
			Reason: "Medical Reason",
			leaveStatus: "APPROVED",
            bonus : "$2400",
            payrollStatus : "IN PROGRESS"
		},
		{
			id: "3",
			name: "AS Smith",
			img: "https://startup.telangana.gov.in/wp-content/uploads/2021/07/male-placeholder-1000x960.jpg",
			position: "Project Manager",
			department: "Development",
			status: "REMOTE",
			joiningdate: "Sep 12, 2023",
			email: "jane.smith@hr-nexus.com",
			phone: "0149 421 4219",
			leaveType: "Casual Leave",
			period: "Aug 24,2023",
			Reason: "Personal Reasons",
			leaveStatus: "PENDING",
            bonus : "$2400",
            payrollStatus : "PENDING"

		},
		{
			id: "4",
			name: "Jane Smith",
			img: "https://startup.telangana.gov.in/wp-content/uploads/2021/07/male-placeholder-1000x960.jpg",
			position: "Project Manager",
			department: "Development",
			status: "ON LEAVE",
			joiningdate: "Sep 12, 2023",
			email: "jane.smith@hr-nexus.com",
			phone: "0149 421 4219",
			leaveType: "Paid Leave",
			period: "Jul 12, 2023",
			Reason: "Work Related",
			leaveStatus: "NEW LEAVE",
            bonus : "$2400",
            payrollStatus : "COMPLETED"
		},
		// Add more employees as needed
	];

	const getPayrollStyle = (payrollStatus) => {
		switch (payrollStatus) {
			case "COMPLETED":
				return { backgroundColor: "#DDFCE0", color: "#0EB01D" };
			case "IN PROGRESS":
				return { backgroundColor: "#FFF9C4", color: "#FF9800" };
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
						<div className="leaves-text">Payroll</div>
						<div className="add-leave-button-container">
							<button>+ Add Salary</button>
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
								<th>Position</th>
								<th>Deparment</th>
								<th>Period</th>
								<th>Bonus</th>
								<th>Status</th>
								<th></th>
							</tr>
						</thead>
						<tbody style={{ fontSize: "0.8vw", textAlign: "center" }}>
							{employees.map((employee) => (
								<tr key={employee.id}>
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
											{employee.position}
										</span>
									</td>
									<td>{employee.department}</td>
									
									<td>{employee.period}</td>
									<td>{employee.bonus}</td>
									<td>
										<span
											style={{
												...getPayrollStyle(employee.payrollStatus),
												borderRadius: "30px",
												padding: "8px 20px",
												display: "inline-block",
											}}
										>
											{employee.payrollStatus}
										</span>
									</td>
									<td style={{ borderRight: "1px solid #E0E4EA" }}>
										<BsThreeDotsVertical />
									</td>
								</tr>
							))}
						</tbody>
					</table>
				</div>
			</div>
		</div>
	);
}

export default Payroll;
