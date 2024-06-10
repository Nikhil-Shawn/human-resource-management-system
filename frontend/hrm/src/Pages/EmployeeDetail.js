import React, { useState } from 'react';
import HeaderComponent from '../Components/HeaderComponent';
import Sidebar from '../Components/Sidebar';
import './EmployeeDetail.css';

function EmployeeDetail() {
  const [isEditing, setIsEditing] = useState(false);

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
              <h1 className="employee-name-card">Julia Maier</h1>
              <span className="badge">Project Manager</span>
              <div className="info-group">
                <label>Department:</label>
                <span>Sales & Marketing</span>
              </div>
              <div className="info-group">
                <label>Date of Joining:</label>
                <span>Jan 19, 2020</span>
              </div>
              <div className="info-group">
                <label>Email:</label>
                <span>o.williams@gmail.com</span>
              </div>
              <div className="info-group">
                <label>Last Promotion:</label>
                <span>12 Apr, 2020</span>
              </div>
            </div>


            <div className="info-card salary-info-card">
              <h2>Salary Information</h2>
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <div className="info-group">
                <label>Salary Basis:</label>
                <span>Monthly</span>
              </div>
              <div className="info-group">
                <label>Salary Amount Per Month:</label>
                <span>$1300</span>
              </div>
              <div className="info-group">
                <label>Effective Date:</label>
                <span>13/06/2024</span>
              </div>
              <div className="info-group">
                <label>Payment Type:</label>
                <span>Transfer</span>
              </div>
              <div className="info-group">
                <label>Bill Rate:</label>
                <span>20%</span>
              </div>
            </div>

         

            <div className="info-card personal-info-card">
              <h2>Personal Info</h2>
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <div className="info-group">
                <label>Gender:</label>
                <span>Female</span>
              </div>
              <div className="info-group">
                <label>Date of Birth:</label>
                <span>12/07/1998</span>
              </div>
              <div className="info-group">
                <label>Phone Number:</label>
                <span>+49 151 42611442</span>
              </div>
              <div className="info-group">
                <label>Marital Status:</label>
                <span>Married</span>
              </div>
              <div className="info-group">
                <label>Nationality:</label>
                <span>German</span>
              </div>
              <div className="info-group">
                <label>Street Name:</label>
                <span>Eppelheimer Str. 12</span>
              </div>
              <div className="info-group">
                <label>Postcode:</label>
                <span>69115</span>
              </div>
              <div className="info-group">
                <label>City:</label>
                <span>Heidelberg</span>
              </div>
            </div>

          

            <div className="info-card education-card">
              <h2>Educations</h2>
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <div className="education-group">
                <label>Bachelor of Science in Computer Science</label>
                <span>University of Technology</span>
                <span>Graduated May 2017</span>
              </div>
              <div className="education-group">
                <label>Master of Science in Computer Science</label>
                <span>University of Technology</span>
                <span>Graduated April 2019</span>
              </div>
              <div className="education-group">
                <label>Certification in Full Stack Web Development</label>
                <span>Coding Academy</span>
                <span>Graduated June 2020</span>
              </div>
              <div className="education-group">
                <label>Certification as Scrum-Master</label>
                <span>Coding Academy</span>
                <span>Graduated June 2020</span>
              </div>
            </div>

            <div className="info-card experience-card">
              <h2>Experience</h2>
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <div className="experience-group">
                <label>Senior Project Manager</label>
                <span>Frankfurt</span>
                <span>Aug 2023 - Present</span>
                <span>Tech Solutions Pro</span>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. When an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
              </div>
              <div className="experience-group">
                <label>Assistant Project Manager</label>
                <span>Köln</span>
                <span>Jul 2018 - Dec 2019</span>
                <span>Tech Innovators Ltd.</span>
                <p>Assisted Project Managers in coordinating project activities, resources, and timelines. Prepared project status reports, tracked progress, and managed project documentation.</p>
              </div>
              <div className="experience-group">
                <label>Project Coordinator</label>
                <span>Mainz</span>
                <span>Aug 2023 - Present</span>
                <span>Software Solutions</span>
                <p>Assisted Project Managers in coordinating project activities and ensuring adherence to timelines. Prepared and delivered project status reports.</p>
              </div>
            </div>

            <div className="info-card skills-card">
              <h2>Skills</h2>
              <button className="edit-button" onClick={handleEditToggle}>Edit</button>
              <div className="skills">
                <span>Project Management</span>
                <span>Team Leadership</span>
                <span>Data Agile Methodologies</span>
                <span>Risk Management</span>
                <span>Budgeting and Financial Management</span>
                <span>Stakeholder Communication</span>
                <span>Process Improvement</span>
                <span>Scope Management</span>
                <span>Quality Assurance</span>
                <span>Presentation Skills</span>
                <span>Conflict Resolution</span>
                <span>Data Analytics Tools</span>
                <span>Trello</span>
                <span>JIRA</span>
                <span>Microsoft Project</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default EmployeeDetail;
