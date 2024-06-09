import React, { useState } from "react";
import Sidebar from "../Components/Sidebar";
import HeaderComponent from "../Components/HeaderComponent";
import "./AddEducation.css";

function AddEducation() {
  const [education, setEducation] = useState("");
  const [experience, setExperience] = useState("");
  const [educations, setEducations] = useState([]);
  const [experiences, setExperiences] = useState([]);

  const handleAddEducation = () => {
    if (education.trim()) {
      setEducations([...educations, education]);
      setEducation("");
    }
  };

  const handleAddExperience = () => {
    if (experience.trim()) {
      setExperiences([...experiences, experience]);
      setExperience("");
    }
  };

  const handleSave = () => {
    console.log("Saved Educations:", educations);
    console.log("Saved Experiences:", experiences);
  };

  return (
    <div className="app">
      <Sidebar />
      <div className="main-content">
        <HeaderComponent />
        <div className="education-container">
          <div className="add-education-text">Add Education and Experience</div>
          <div className="input-container">
            <div className="input-section">
              <textarea
                placeholder="Type in your Education..."
                value={education}
                onChange={(e) => setEducation(e.target.value)}
              />
              <button onClick={handleAddEducation}>Add Education</button>
              <div className="list-section">
                {educations.map((edu, index) => (
                  <div key={index} className="list-item">
                    {edu}
                  </div>
                ))}
              </div>
            </div>
            <div className="input-section">
              <textarea
                placeholder="Type in your Experience..."
                value={experience}
                onChange={(e) => setExperience(e.target.value)}
              />
              <button onClick={handleAddExperience}>Add Experience</button>
              <div className="list-section">
                {experiences.map((exp, index) => (
                  <div key={index} className="list-item">
                    {exp}
                  </div>
                ))}
              </div>
            </div>
          </div>
          <div className="save-button">
            <button onClick={handleSave}>Save</button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default AddEducation;
