import axios from 'axios';
import React, { useEffect, useState, useRef } from 'react';
import { BsThreeDotsVertical } from "react-icons/bs";
import Sidebar from "../Components/Sidebar";
import HeaderComponent from "../Components/HeaderComponent";
import SeparationDrawer from '../Components/SeparationDrawer';
import './Separation.css';

function Separation() {
    const [employees, setEmployees] = useState([]);
    const [isDrawerOpen, setIsDrawerOpen] = useState(false);
    const [currentSeparation, setCurrentSeparation] = useState(null);
    const [dropdownOpen, setDropdownOpen] = useState(null);
    const dropdownRef = useRef(null);

    useEffect(() => {
        fetchSeparations();
        document.addEventListener('mousedown', handleClickOutside);
        return () => {
            document.removeEventListener('mousedown', handleClickOutside);
        };
    }, []);

    const fetchSeparations = () => {
        axios.get('http://localhost:8080/api/v1/separation/all')
            .then(response => {
                setEmployees(response.data);
            })
            .catch(error => {
                console.error('There was an error fetching the separations data!', error);
            });
    };

    const handleDrawerOpen = (separation) => {
        setCurrentSeparation(separation);
        setIsDrawerOpen(true);
    };

    const handleDrawerClose = () => {
        setIsDrawerOpen(false);
        setCurrentSeparation(null);
    };

    const handleSave = (newSeparation) => {
        if (currentSeparation) {
            setEmployees(employees.map(emp => emp.id === newSeparation.id ? newSeparation : emp));
        } else {
            setEmployees([...employees, newSeparation]);
        }
    };

    const toggleDropdown = (index) => {
        setDropdownOpen(dropdownOpen === index ? null : index);
    };

    const handleClickOutside = (event) => {
        if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
            setDropdownOpen(null);
        }
    };

    const getSeparationStyle = (separationStatus) => {
        switch (separationStatus) {
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
                        <div className="leaves-text">Employment Separation</div>
                        <div className="add-leave-button-container">
                            <button onClick={() => handleDrawerOpen(null)}>+ Add Separation</button>
                        </div>
                    </div>
                    <table className="employee-table">
                        <thead>
                            <tr style={{ fontWeight: "0", fontSize: "0.8vw", color: "black" }}>
                                <th style={{ padding: "20px 0px 20px 40px", marginLeft: "10px" }}>Name</th>
                                <th>Position</th>
                                <th>Date of Separation</th>
                                <th>Type</th>
                                <th>Reason</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody style={{ fontSize: "0.8vw", textAlign: "center" }}>
                            {employees.map((employee, index) => (
                                <tr key={index}>
                                    <td style={{ display: "flex", alignItems: "center", borderLeft: "1px solid #E0E4EA", padding: "20px" }}>
                                        <img
                                            src={employee.img}
                                            alt={`${employee.name}'s profile`}
                                            style={{ width: "40px", height: "40px", borderRadius: "50%", marginRight: "10px" }}
                                        />
                                        <span>{employee.name}</span>
                                    </td>
                                    <td>{employee.position}</td>
                                    <td>{employee.separationDate}</td>
                                    <td>{employee.separationType}</td>
                                    <td>{employee.separationReason}</td>
                                    <td>
                                        <span style={{ ...getSeparationStyle(employee.separationStatus), borderRadius: "30px", padding: "8px 20px", display: "inline-block" }}>
                                            {employee.separationStatus}
                                        </span>
                                    </td>
                                    <td style={{ borderRight: "1px solid #E0E4EA" }}>
                                        <div className="dropdown-container" ref={dropdownOpen === index ? dropdownRef : null}>
                                            <BsThreeDotsVertical onClick={() => toggleDropdown(index)} />
                                            {dropdownOpen === index && (
                                                <div className="dropdown-menu">
                                                    <div className="dropdown-item" onClick={() => handleDrawerOpen(employee)}>Edit</div>
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
            <SeparationDrawer isOpen={isDrawerOpen} onClose={handleDrawerClose} onSave={handleSave} separation={currentSeparation} />
        </div>
    );
}

export default Separation;
