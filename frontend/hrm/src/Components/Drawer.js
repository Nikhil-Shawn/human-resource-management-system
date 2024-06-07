import React from 'react';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import './Drawer.css'; 
import Button from '@mui/material/Button';

const industries = [
  { value: 'Information Technology', label: 'Information Technology' },
  { value: 'Finance', label: 'Finance' },
  { value: 'Healthcare', label: 'Healthcare' }
];

const Drawer = ({ isOpen, onClose }) => {
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
            />
            <input
              type='date'
              id="end-work"
              className="date-field"
            />
          </div>
        </div>
      </div>
      <div className="save-button-container">
        <Button variant="contained"  onClick={onClose} color="primary" className="save-button">Save</Button>
      </div>
    </div>
  );
};

export default Drawer;
