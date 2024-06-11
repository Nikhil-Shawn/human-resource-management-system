import React, { useEffect, useState, useRef } from "react";
import axios from "axios";
import "./Leaves.css";
import { BsThreeDotsVertical } from "react-icons/bs";
import Sidebar from "../Components/Sidebar";
import HeaderComponent from "../Components/HeaderComponent";
import LeaveDrawer from "../Components/LeaveDrawer";

function Leaves() {
    const [vacations, setVacations] = useState([]); // Initialize as empty array
    const [isDrawerOpen, setIsDrawerOpen] = useState(false);
    const [currentLeave, setCurrentLeave] = useState(null);
	const [currentVacationId, setCurrentVacationId] = useState(null);
    const [dropdownOpen, setDropdownOpen] = useState(null);
    const dropdownRef = useRef(null);
    const [employees, setEmployees] = useState([]);

    useEffect(() => {
        axios.get('http://localhost:8080/api/v1/employee/1')
            .then(response => {
                setEmployees(response.data);
                console.log("employeedata", response.data);
            })
            .catch(error => {
                console.error("There was an error fetching the employee data!", error);
            });

        axios.get("http://localhost:8080/api/vacations")
            .then((response) => {
                const data = response.data;
                console.log("Response data:", data);
                // Extract the vacations array from the response data
                const vacationsData = data.data.vacations;
                console.log("Nikhil b", vacationsData);
                vacationsData.map(vacation => console.log("Vacation ID:", vacation.vacationId));
                setVacations(vacationsData);
            })
            .catch((error) => {
                console.error("Error fetching vacation data:", error);
            });
    }, []);

    const handleDrawerOpen = (vacation) => {
		setIsDrawerOpen(true);
		setCurrentLeave(vacation); // Set currentLeave
		setCurrentVacationId(vacation.vacationId); // Set currentVacationId
		console.log("drawer", vacation.vacationId);
	};
	
    const handleDrawerClose = () => {
        setIsDrawerOpen(false);
        setCurrentLeave(null);
    };

    const handleSave = (newVacation) => {
        if (currentLeave) {
            setVacations(vacations.map(vacation => vacation.vacationId === newVacation.vacationId ? newVacation : vacation));
        } else {
            setVacations([...vacations, newVacation]);
        }
    };

    const handleDelete = (vacationId) => {
        console.log("vacation new log", vacationId);
        axios.delete(`http://localhost:8080/api/vacations/deleteVacation/${vacationId.vacationId}`)
            .then(response => {
                console.log(response);
                setVacations(vacations.filter(vacation => vacation.vacationId !== vacationId));
            })
            .catch(error => {
                console.error('There was an error deleting the leave!', error);
            });
    };

    const toggleDropdown = (index) => {
        setDropdownOpen(dropdownOpen === index ? null : index);
    };

    const handleClickOutside = (event) => {
        if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
            setDropdownOpen(null);
        }
    };

    const getStatusStyle = (status) => {
        switch (status) {
            case "Accepted":
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

                    <table className="vacation-table">
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
                                <th>Reason</th>
                                <th>Leave Type</th>
                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody style={{ fontSize: "0.8vw", textAlign: "center" }}>
                            {vacations && vacations.map((vacation, index) => (
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
                                            src={vacation.img}
                                            alt={`${vacation.name}'s profile`}
                                            style={{
                                                width: "40px",
                                                height: "40px",
                                                borderRadius: "50%",
                                                marginRight: "10px",
                                            }}
                                        />
                                        {/* <span>{vacation.status}</span> */}
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
                                            {vacation.reason}
                                        </span>
                                    </td>
                                    <td>{vacation.vacationType}</td>
                                    <td>{vacation.startDate}</td>
                                    <td>{vacation.endDate}</td>
                                    <td>
                                        <span
                                            style={{
                                                ...getStatusStyle(vacation.status),
                                                borderRadius: "30px",
                                                padding: "8px 20px",
                                                display: "inline-block",
                                            }}
                                        >
                                            {vacation.status}
                                        </span>
                                    </td>
                                    <td>
                                        <div className="dropdown-container" ref={dropdownOpen === index ? dropdownRef : null}>
                                            <BsThreeDotsVertical onClick={() => toggleDropdown(index)} />
                                            {dropdownOpen === index && (
                                                <div className="dropdown-menu">
                                                    <div className="dropdown-item" onClick={() => handleDrawerOpen(vacation.vacationId)}>Edit</div>
                                                    <div className="dropdown-item" onClick={() => handleDelete(vacation.vacationId)}>Delete</div>
                                                </div>
                                            )}
                                        </div>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </div>
			
            <LeaveDrawer isOpen={isDrawerOpen} onClose={handleDrawerClose} onSave={handleSave} leave={currentLeave}  currentVacationId={currentVacationId}/>
        </div>
    );
}

export default Leaves;
