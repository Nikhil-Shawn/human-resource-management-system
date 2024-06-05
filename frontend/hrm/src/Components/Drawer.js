import React from 'react';
import TextField from '@mui/material/TextField';
import './Drawer.css'; // Make sure to create and style this CSS file

const Drawer = ({ isOpen, onClose }) => {
  return (
    <div className={`drawer ${isOpen ? 'open' : ''}`}>
      <button className="drawer-close-button" onClick={onClose}>X</button>
      <h2>Add Employee Details</h2>
      {/* Add your form fields here */}
      <div>
        <p>Job title</p>
        <TextField id="outlined-basic" label="Job Title" variant="outlined" fullWidth />

        <p>Another field</p>
        <TextField id="outlined-basic" label="Another Field" variant="outlined" fullWidth />
      </div>
    </div>
  );
}

export default Drawer;
