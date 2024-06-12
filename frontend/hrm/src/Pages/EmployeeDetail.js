import React, { useEffect, useState } from 'react';
import HeaderComponent from '../Components/HeaderComponent';
import Sidebar from '../Components/Sidebar';
import dateDot from '../images/dateIcon.png';
import locationDot from '../images/locationIcon.png';
import './EmployeeDetail.css';
import axios from 'axios';
import { useAuth } from './AuthContext';

function EmployeeDetail() {
  const { authData } = useAuth();
  const [employeeData, setEmployeeData] = useState({});
  const [isEditing, setIsEditing] = useState(false);

  useEffect(() => {
    const fetchEmployeeData = async () => {
      try {
        const employeeId = authData.data.employeeId;
        console.log("is id proper?", employeeId);
        const response = await axios.get(`http://localhost:8080/api/v1/employee/${employeeId}`);
        const { person, designation } = response.data;
        setEmployeeData({ ...person, designation });
        console.log("Employee data:", employeeData.designation);
      } catch (error) {
        console.error("Error fetching employee data:", error);
      }
    };

    if (authData) {
      fetchEmployeeData();
    }
  }, [authData]);

  const handleEditToggle = () => {
    setIsEditing(!isEditing);
  };

  return (
    <div className="employee-detail">
      <Sidebar />
      <div className="main-content">
        <HeaderComponent />
        <div className="content-area">
          <div className="info-section">
            
            <div className="info-card profile-info-card">
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <h1> Nikhil the Allrounder</h1>  {/* Use this for API maybe-->  className="employee-name-card">{employeeData.firstName} {employeeData.lastName} */}
              <span className="badge">{employeeData.designation}</span>
              <div className="info-group">
                <label>Department:</label>
                <span>{employeeData.departmentId}</span>
              </div>
              <div className="info-group">
                <label>Date of Joining:</label>
                <span>{employeeData.createdAt}</span>
              </div>
              <div className="info-group">
                <label>Email:</label>
                <span>{employeeData.personEmail}</span>
              </div>
              <div className="info-group">
                <label>Designation:</label>
                <span>{employeeData.designation}</span>
              </div>
            </div>

            <div className="info-card salary-info-card">
              <h2>Salary Information</h2>
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <div className="info-group">
                <label>Salary Basis:</label>
                <span>{employeeData.salaryBasis}</span>
              </div>
              <div className="info-group">
                <label>Salary Amount Per Month:</label>
                <span>{employeeData.salaryAmount}</span>
              </div>
              <div className="info-group">
                <label>Effective Date:</label>
                <span>{employeeData.effectiveDate}</span>
              </div>
              <div className="info-group">
                <label>Payment Type:</label>
                <span>{employeeData.paymentType}</span>
              </div>
              <div className="info-group">
                <label>Bill Rate:</label>
                <span>{employeeData.billRate}</span>
              </div>
            </div>

            <div className="info-card personal-info-card">
              <h2>Personal Info</h2>
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <div className="info-group">
                <label>Gender:</label>
                <span>{employeeData.gender}</span>
              </div>
              <div className="info-group">
                <label>Date of Birth:</label>
                <span>{employeeData.dateOfBirth}</span>
              </div>
              <div className="info-group">
                <label>Phone Number:</label>
                <span>{employeeData.phone}</span>
              </div>
              <div className="info-group">
                <label>Marital Status:</label>
                <span>{employeeData.maritalStatus}</span>
              </div>
              <div className="info-group">
                <label>Nationality:</label>
                <span>{employeeData.nationality}</span>
              </div>
              <div className="info-group">
                <label>Street Name:</label>
                <span>{employeeData.address}</span>
              </div>
              <div className="info-group">
                <label>Postcode:</label>
                <span>{employeeData.postcode}</span>
              </div>
              <div className="info-group">
                <label>City:</label>
                <span>{employeeData.city}</span>
              </div>
            </div>

            <div className="info-card education-card">
              <h2>Education</h2>
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <div className="education-group">
                <label>Bachelor of Science in Computer Science</label>
                <div className="education-detail">
                  <img src={locationDot} alt="location icon" className="icon"/>
                  <span>{employeeData.bachelorUniversity}</span>
                </div>
                <div className="education-detail">
                  <img src={dateDot} alt="date icon" className="icon"/>
                  <span>Graduated {employeeData.bachelorGraduationDate}</span>
                </div>
              </div>
              <div className="education-group">
                <label>Master of Science in Computer Science</label>
                <div className="education-detail">
                  <img src={locationDot} alt="location icon" className="icon"/>
                  <span>{employeeData.masterUniversity}</span>
                </div>
                <div className="education-detail">
                  <img src={dateDot} alt="date icon" className="icon"/>
                  <span>Graduated {employeeData.masterGraduationDate}</span>
                </div>
              </div>
              <div className="education-group">
                <label>Certification in Full Stack Web Development</label>
                <div className="education-detail">
                  <img src={locationDot} alt="location icon" className="icon"/>
                  <span>{employeeData.certificationInstitution}</span>
                </div>
                <div className="education-detail">
                  <img src={dateDot} alt="date icon" className="icon"/>
                  <span>Graduated {employeeData.certificationDate}</span>
                </div>
              </div>
              <div className="education-group">
                <label>Certification as Scrum-Master</label>
                <div className="education-detail">
                  <img src={locationDot} alt="location icon" className="icon"/>
                  <span>{employeeData.scrumInstitution}</span>
                </div>
                <div className="education-detail">
                  <img src={dateDot} alt="date icon" className="icon"/>
                  <span>Graduated {employeeData.scrumDate}</span>
                </div>
              </div>
            </div>

            <div className="info-card experience-card">
              <h2>Experience</h2>
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <div className="experience-group">
                <label>Senior Project Manager</label>
                <div className="experience-detail">
                  <img src={locationDot} alt="location icon" className="icon"/>
                  <span>{employeeData.seniorLocation}</span>
                </div>
                <div className="experience-detail">
                  <img src={dateDot} alt="date icon" className="icon"/>
                  <span>{employeeData.seniorDate}</span>
                </div>
                <span>{employeeData.seniorCompany}</span>
                <p>{employeeData.seniorDescription}</p>
              </div>
              <div className="experience-group">
                <label>Assistant Project Manager</label>
                <div className="experience-detail">
                  <img src={locationDot} alt="location icon" className="icon"/>
                  <span>{employeeData.assistantLocation}</span>
                </div>
                <div className="experience-detail">
                  <img src={dateDot} alt="date icon" className="icon"/>
                  <span>{employeeData.assistantDate}</span>
                </div>
                <span>{employeeData.assistantCompany}</span>
                <p>{employeeData.assistantDescription}</p>
              </div>
              <div className="experience-group">
                <label>Project Coordinator</label>
                <div className="experience-detail">
                  <img src={locationDot} alt="location icon" className="icon"/>
                  <span>{employeeData.coordinatorLocation}</span>
                </div>
                <div className="experience-detail">
                  <img src={dateDot} alt="date icon" className="icon"/>
                  <span>{employeeData.coordinatorDate}</span>
                </div>
                <span>{employeeData.coordinatorCompany}</span>
                <p>{employeeData.coordinatorDescription}</p>
              </div>
            </div>

            <div className="info-card skills-card">
              <h2>Skills</h2>
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <div className="skills">
                {employeeData.skills && employeeData.skills.map((skill, index) => (
                  <span key={index}>{skill}</span>
                ))}
              </div>
            </div>

          </div>
        </div>
      </div>
    </div>
  );
}

export default EmployeeDetail;
