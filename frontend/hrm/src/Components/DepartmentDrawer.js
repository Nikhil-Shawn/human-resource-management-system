import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import './DepartmentDrawer.css';

const Drawer = ({ isOpen, onClose, onSave, department }) => {
  const [departmentName, setDepartmentName] = useState('');
  const [departmentStatus, setDepartmentStatus] = useState('');
  const [departmentId, setDepartmentId] = useState();

  useEffect(() => {
    if (department) {
      setDepartmentName(department.departmentName);
      setDepartmentStatus(department.departmentStatus);
      setDepartmentId(department.departmentId);
    } else {
      setDepartmentName('');
      setDepartmentStatus('');
      setDepartmentId('');
    }
  }, [department]);

  const handleSave = async () => {
    const departmentData = {
      departmentName,
      departmentStatus
    };

    try {
      const response = departmentId
        ? await axios.put(`http://localhost:8080/api/departments/updateDepartment/${departmentId}`, departmentData)
        : await axios.post('http://localhost:8080/api/departments/addDepartment', departmentData);

      onSave(response.data);
      onClose();
    } catch (error) {
      console.error('Error saving department:', error);
    }
  };

  return (
    <div className={`drawer ${isOpen ? 'open' : ''}`}>
      <div className="head-group">
        <h2>{department ? 'Edit Department' : 'Add Department'}</h2>
        <div className="button-group">
          <Button variant="text" onClick={onClose} className="department-cancel-button">Cancel</Button>
          <Button variant="contained" onClick={handleSave} className="save-button">Save</Button>
        </div>
        <button className="department-drawer-close-button" onClick={onClose}>&times;</button>
      </div>
      <div className="form-container">
        <div className="department-form-group">
          <p>DEPARTMENT NAME</p>
          <TextField
            id="department-name"
            label="Type in Name"
            variant="outlined"
            fullWidth
            value={departmentName}
            onChange={(e) => setDepartmentName(e.target.value)}
          />
        </div>
        <div className="department-form-group">
          <p>STATUS</p>
          <TextField
            id="department-status"
            label="Type in Active or Inactive"
            variant="outlined"
            fullWidth
            value={departmentStatus}
            onChange={(e) => setDepartmentStatus(e.target.value)}
          />
        </div>
      </div>
    </div>
  );
};

export default Drawer;
