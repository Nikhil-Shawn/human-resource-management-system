import React from 'react';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import './Drawer.css'; // Ensure this file exists and is styled appropriately

const industries = [
  { value: 'Information Technology', label: 'Information Technology' },
  { value: 'Finance', label: 'Finance' },
  { value: 'Healthcare', label: 'Healthcare' },
  // Add more industries as needed
];

const Drawer = ({ isOpen, onClose }) => {
  return (
    <div className={`drawer ${isOpen ? 'open' : ''}`}>
      <button className="drawer-close-button" onClick={onClose}>X</button>
      <h2>Add Employee Details</h2>
      <div>
        <div className="form-group">
          <p>Job Title</p>
          <TextField id="job-title" label="Enter Job Title" variant="outlined" fullWidth />
        </div>
        <div className="form-group">
          <p>Company's Industry</p>
          <TextField
            id="company-industry"
            select
            label="Company's Industry"
            variant="outlined"
            fullWidth
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
          <TextField id="company-name" label="Company Name" variant="outlined" fullWidth />
        </div>
        <div className="form-group">
          <p>Period of Work</p>
          <div className="date-fields">
            <TextField id="start-work" label="Start Work" variant="outlined" fullWidth />
            <TextField id="end-work" label="End Work" variant="outlined" fullWidth />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Drawer;
