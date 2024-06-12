import React, { useState } from "react";
import Sidebar from "../Components/Sidebar";
import HeaderComponent from "../Components/HeaderComponent";
import "./AddEducation.css";

function AddEducation() {
  const [education, setEducation] = useState({
    employee_id: "",
    degree: "",
    institution: "",
    major: "",
    graduation_start_date: "",
    graduation_end_date: "",
  });

  const [experience, setExperience] = useState({
    employee_id: "",
    company_name: "",
    employment_type: "",
    no_of_years: "",
    position: "",
    start_date: "",
    end_date: "",
  });

  const [educations, setEducations] = useState([]);
  const [experiences, setExperiences] = useState([]);
  const [successMessage, setSuccessMessage] = useState('');

  const handleAddEducation = async () => {
    if (education.degree && education.institution && education.major) {
      try {
        const response = await fetch('http://localhost:8080/api/v1/education/save', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(education),
        });

        if (response.ok) {
          setEducations([...educations, education]);
          setEducation({
            employee_id: "",
            degree: "",
            institution: "",
            major: "",
            graduation_start_date: "",
            graduation_end_date: "",
          });
          setSuccessMessage('Successfully added education');
          setTimeout(() => setSuccessMessage(''), 3000); // Clear message after 3 seconds
        } else {
          console.error('Failed to save education.');
        }
      } catch (error) {
        console.error('Error:', error);
      }
    }
  };

  const handleAddExperience = async () => {
    if (experience.company_name && experience.position) {
      try {
        const response = await fetch('http://localhost:8080/api/v1/experience/save', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json',
          },
          body: JSON.stringify(experience),
        });

        if (response.ok) {
          setExperiences([...experiences, experience]);
          setExperience({
            employee_id: "",
            company_name: "",
            employment_type: "",
            no_of_years: "",
            position: "",
            start_date: "",
            end_date: "",
          });
          setSuccessMessage(`Successfully added experience - ${experience.position} at ${experience.company_name}`);
          setTimeout(() => setSuccessMessage(''), 3000); // Clear message after 3 seconds
        } else {
          console.error('Failed to save experience.');
        }
      } catch (error) {
        console.error('Error:', error);
      }
    }
  };

  const handleEducationChange = (e) => {
    const { name, value } = e.target;
    setEducation({ ...education, [name]: value });
  };

  const handleExperienceChange = (e) => {
    const { name, value } = e.target;
    setExperience({ ...experience, [name]: value });
  };

  return (
    <div className="app">
      <Sidebar />
      <div className="main-content">
        <HeaderComponent />
        <div className="form-cont">
          <div className="add-education-text">Add Education and Experience</div>
          <div className="form-section-wrapper">
            <div className="personal-info">
              <h3>Add Education</h3>
              <label>Employee ID</label>
              <input
                type="text"
                name="employee_id"
                value={education.employee_id}
                onChange={handleEducationChange}
              />
              <label>Degree</label>
              <input
                type="text"
                name="degree"
                value={education.degree}
                onChange={handleEducationChange}
              />
              <label>Institution</label>
              <input
                type="text"
                name="institution"
                value={education.institution}
                onChange={handleEducationChange}
              />
              <label>Major</label>
              <input
                type="text"
                name="major"
                value={education.major}
                onChange={handleEducationChange}
              />
              <label>Graduation Start Date</label>
              <input
                type="date"
                name="graduation_start_date"
                value={education.graduation_start_date}
                onChange={handleEducationChange}
              />
              <label>Graduation End Date</label>
              <input
                type="date"
                name="graduation_end_date"
                value={education.graduation_end_date}
                onChange={handleEducationChange}
              />
              <button className="save-button" onClick={handleAddEducation}>Add Education</button>
              <div className="list-section">
                {educations.map((edu, index) => (
                  <div key={index} className="list-item">
                    {edu.degree} from {edu.institution}
                  </div>
                ))}
              </div>
            </div>
            <div className="address-info">
              <h3>Add Experience</h3>
              <label>Employee ID</label>
              <input
                type="text"
                name="employee_id"
                value={experience.employee_id}
                onChange={handleExperienceChange}
              />
              <label>Company Name</label>
              <input
                type="text"
                name="company_name"
                value={experience.company_name}
                onChange={handleExperienceChange}
              />
              <label>Employment Type</label>
              <input
                type="text"
                name="employment_type"
                value={experience.employment_type}
                onChange={handleExperienceChange}
              />
              <label>No. of Years</label>
              <input
                type="text"
                name="no_of_years"
                value={experience.no_of_years}
                onChange={handleExperienceChange}
              />
              <label>Position</label>
              <input
                type="text"
                name="position"
                value={experience.position}
                onChange={handleExperienceChange}
              />
              <label>Start Date</label>
              <input
                type="date"
                name="start_date"
                value={experience.start_date}
                onChange={handleExperienceChange}
              />
              <label>End Date</label>
              <input
                type="date"
                name="end_date"
                value={experience.end_date}
                onChange={handleExperienceChange}
              />
              <button className="save-button" onClick={handleAddExperience}>Add Experience</button>
              <div className="list-section">
                {experiences.map((exp, index) => (
                  <div key={index} className="list-item">
                    {exp.position} at {exp.company_name}
                  </div>
                ))}
              </div>
            </div>
          </div>
          {successMessage && <div className="success-message">{successMessage}</div>}
        </div>
      </div>
    </div>
  );
}

export default AddEducation;
