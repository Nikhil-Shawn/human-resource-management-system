import React from 'react';
import TextField from '@mui/material/TextField';
import MenuItem from '@mui/material/MenuItem';
import './Drawer.css'; 

const industries = [
  { value: 'Information Technology', label: 'Information Technology' },
  { value: 'Finance', label: 'Finance' },
  { value: 'Healthcare', label: 'Healthcare' }
];

const Drawer = ({ isOpen, onClose }) => {
  const textFieldStyles = {
    '& .MuiOutlinedInput-root': {
      '& fieldset': {
        borderRadius: '8px',
      },
      '& input': {
        fontSize: '12px', 
        padding: '16px', 
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
      <button className="drawer-close-button" onClick={onClose}>X</button>
      <h2>Add Employee Details</h2>
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
            <TextField
              id="start-work"
              label="Start Work"
              variant="outlined"
              fullWidth
              sx={textFieldStyles}
            />
            <TextField
              id="end-work"
              label="End Work"
              variant="outlined"
              fullWidth
              sx={textFieldStyles}
            />
          </div>
        </div>
      </div>
    </div>
  );
};

export default Drawer;
