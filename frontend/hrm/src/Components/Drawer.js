import React, { useState } from 'react';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import './Drawer.css'; 
import Button from '@mui/material/Button';
import axios from 'axios';

const industries = [
  { value: 'Information Technology', label: 'Information Technology' },
  { value: 'Finance', label: 'Finance' },
  { value: 'Healthcare', label: 'Healthcare' }
];

const Drawer = ({ isOpen, onClose }) => {
  const [jobTitle, setJobTitle] = useState('');
  const [industry, setIndustry] = useState('');
  const [companyName, setCompanyName] = useState('');
  const [startWork, setStartWork] = useState('');
  const [endWork, setEndWork] = useState('');

  const handleSave = async () => {
    const experienceData = {
      person_id: "1",
      degree: jobTitle,
      institution: companyName,
      major: industry,
      graduation_start_date: startWork,
      graduation_end_date: endWork
    };

    // Log the experience data before sending it
    console.log('Experience Data:', experienceData);

    try {
      const response = await axios.post('http://localhost:8000/api/v1/experience/save', experienceData);
      console.log('Experience saved successfully:', response.data);
      onClose();
    } catch (error) {
      console.error('Error saving experience:', error);
    }
  };

  const textFieldStyles = {
    alignItems: 'right',
    '& .MuiOutlinedInput-root': {
      '& fieldset': {
        borderRadius: '8px',
      },
      '& .MuiSelect-select': {
        fontSize: '12px', 
        padding: '15px', 
        display: 'flex',
        alignItems: 'center', 
      },
    },
    '& .MuiInputLabel-root': {
      fontSize: '15.5px', 
    },
    '& .MuiMenuItem-root': {
      fontSize: '12px', 
    },
  };

  return (
    <div className={`drawer ${isOpen ? 'open' : ''}`}>
      <div className="head-group">
        <div>
          <h2>Add Experience</h2>
        </div>
        <div className='button-group'>
          <Button variant="outlined" onClick={onClose} className="cancel-button">Cancel</Button>
        </div>
      </div>
      <div className="form-container">
        <div className="form-group">
          <p>Job Title</p>
          <TextField
            id="job-title"
            label="Enter Job Title"
            variant="outlined"
            fullWidth
            value={jobTitle}
            onChange={(e) => setJobTitle(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
        <div className="form-group">
          <p>Company's Industry</p>
          <TextField
            id="company-industry"
            select
            label="Company's Industry"
            variant="outlined"
            fullWidth
            value={industry}
            onChange={(e) => setIndustry(e.target.value)}
            sx={textFieldStyles}
          >
            {industries.map((option) => (
              <MenuItem key={option.value} value={option.value}>
                {option.label}
              </MenuItem>
            ))}
          </TextField>
        </div>
        <div className="form-group">
          <p>Company Name</p>
          <TextField
            id="company-name"
            label="Company Name"
            variant="outlined"
            fullWidth
            value={companyName}
            onChange={(e) => setCompanyName(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
        <div className="form-group">
          <p>Period of Work</p>
          <div className="date-fields">
            <input
              type='date'
              id="start-work"
              className="date-field"
              value={startWork}
              onChange={(e) => setStartWork(e.target.value)}
            />
            <input
              type='date'
              id="end-work"
              className="date-field"
              value={endWork}
              onChange={(e) => setEndWork(e.target.value)}
            />
          </div>
        </div>
      </div>
      <div className="save-button-container">
        <Button variant="contained" color="primary" className="save-button" onClick={handleSave}>Save</Button>
      </div>
    </div>
  );
};

export default Drawer;
