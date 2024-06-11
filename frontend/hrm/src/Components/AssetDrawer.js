import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import './AssetDrawer.css';

const Drawer = ({ isOpen, onClose, onSave, asset }) => {
  const [employeeName, setEmployeeName] = useState('');
  const [employeeEmail, setEmployeeEmail] = useState('');
  const [employeePosition, setEmployeePosition] = useState('');
  const [issuedDate, setIssuedDate] = useState('');
  const [returnDate, setReturnDate] = useState('');

  useEffect(() => {
    if (asset) {
      setEmployeeName(asset.employeeName);
      setEmployeeEmail(asset.employeeEmail);
      setEmployeePosition(asset.employeePosition);
      setIssuedDate(asset.issuedDate);
      setReturnDate(asset.returnDate);
    } else {
      setEmployeeName('');
      setEmployeeEmail('');
      setEmployeePosition('');
      setIssuedDate('');
      setReturnDate('');
    }
  }, [asset]);

  const handleSave = async () => {
    const assetData = {
      ...asset,
      employeeName,
      employeeEmail,
      employeePosition,
      issuedDate,
      returnDate,
    };

    try {
      const response = asset
        ? await axios.put(`http://localhost:8080/api/v1/assets/${asset.id}`, assetData)
        : await axios.post('http://localhost:8080/api/v1/assets/save', assetData);

      onSave(response.data);
      console.log(response.data);
      onClose();
    } catch (error) {
      console.error('Error saving asset:', error);
    }
  };

  const textFieldStyles = {
    '& .MuiOutlinedInput-root': {
      '& fieldset': {
        borderRadius: '8px',
      },
    },
  };

  return (
    <div className={`drawer ${isOpen ? 'open' : ''}`}>
      <div className="head-group">
        <h2>{asset ? 'Edit Asset' : 'Add Asset'} to Employee</h2>
        <div className="button-group">
          <Button variant="text" onClick={onClose} className="assets-cancel-button">Cancel</Button>
          <Button variant="contained" onClick={handleSave} className="save-button">Save</Button>
        </div>
        <button className="assets-drawer-close-button" onClick={onClose}>&times;</button>
      </div>
      <div className="form-container">
        <div className="assets-form-group">
          <p>Select Staff</p>
          <TextField
            id="employee-name"
            label="Type in Name"
            variant="outlined"
            fullWidth
            value={employeeName}
            onChange={(e) => setEmployeeName(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
        <div className="assets-form-group">
          <p>Employee Email</p>
          <TextField
            id="employee-email"
            label="@example.com"
            variant="outlined"
            fullWidth
            value={employeeEmail}
            onChange={(e) => setEmployeeEmail(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
        <div className="assets-form-group">
          <p>Employee Position</p>
          <TextField
            id="employee-position"
            label="Type in Employee Position"
            variant="outlined"
            fullWidth
            value={employeePosition}
            onChange={(e) => setEmployeePosition(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
        <div className="assets-form-group">
          <p>Issued Date</p>
          <TextField
            id="issued-date"
            type="date"
            variant="outlined"
            fullWidth
            value={issuedDate}
            onChange={(e) => setIssuedDate(e.target.value)}
            sx={textFieldStyles}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </div>
        <div className="assets-form-group">
          <p>Return Date</p>
          <TextField
            id="return-date"
            type="date"
            variant="outlined"
            fullWidth
            value={returnDate}
            onChange={(e) => setReturnDate(e.target.value)}
            sx={textFieldStyles}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </div>
      </div>
    </div>
  );
};

export default Drawer;
