import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import './SeparationDrawer.css';

const Drawer = ({ isOpen, onClose, onSave, separation }) => {
  const [employeeId, setEmployeeId] = useState('');
  const [separationDate, setSeparationDate] = useState('');
  const [separationType, setSeparationType] = useState('');
  const [separationReason, setSeparationReason] = useState('');
  const [separationStatus, setSeparationStatus] = useState('');
  const [separationId, setSeparationId] = useState();

  useEffect(() => {
    if (separation) {
      setEmployeeId(separation.employee_id);
      setSeparationDate(separation.separation_date);
      setSeparationType(separation.separation_type);
      setSeparationReason(separation.separation_reason);
      setSeparationStatus(separation.separation_status);
      setSeparationId(separation.separation_id);
    } else {
      setEmployeeId('');
      setSeparationDate('');
      setSeparationType('');
      setSeparationReason('');
      setSeparationStatus('');
      setSeparationId('');
    }
  }, [separation]);

  const handleSave = async () => {
    const separationData = {
      employee_id: employeeId,
      separation_date: separationDate,
      separation_type: separationType,
      separation_reason: separationReason,
      separation_status: separationStatus,
    };

    try {
      const response = separationId
        ? await axios.put(`http://localhost:8080/api/v1/separation/update/${separationId}`, separationData)
        : await axios.post('http://localhost:8080/api/v1/separation/save', separationData);

      onSave(response.data);
      onClose();
    } catch (error) {
      console.error('Error saving separation:', error);
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
        <h2>{separation ? 'Edit Separation' : 'Add Separation'}</h2>
        <div className="button-group">
          <Button variant="text" onClick={onClose} className="separation-cancel-button">Cancel</Button>
          <Button variant="contained" onClick={handleSave} className="save-button">Save</Button>
        </div>
        <button className="separation-drawer-close-button" onClick={onClose}>&times;</button>
      </div>
      <div className="form-container">
        <div className="separation-form-group">
          <p>Employee ID</p>
          <TextField
            id="employee-id"
            label="Employee ID"
            variant="outlined"
            fullWidth
            value={employeeId}
            onChange={(e) => setEmployeeId(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
        <div className="separation-form-group">
          <p>Separation Date</p>
          <TextField
            id="separation-date"
            type="date"
            variant="outlined"
            fullWidth
            value={separationDate}
            onChange={(e) => setSeparationDate(e.target.value)}
            sx={textFieldStyles}
            InputLabelProps={{
              shrink: true,
            }}
          />
        </div>
        <div className="separation-form-group">
          <p>Separation Type</p>
          <TextField
            id="separation-type"
            label="Separation Type"
            variant="outlined"
            fullWidth
            value={separationType}
            onChange={(e) => setSeparationType(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
        <div className="separation-form-group">
          <p>Separation Reason</p>
          <TextField
            id="separation-reason"
            label="Separation Reason"
            variant="outlined"
            fullWidth
            value={separationReason}
            onChange={(e) => setSeparationReason(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
        <div className="separation-form-group">
          <p>Separation Status</p>
          <TextField
            id="separation-status"
            label="Separation Status"
            variant="outlined"
            fullWidth
            value={separationStatus}
            onChange={(e) => setSeparationStatus(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
      </div>
    </div>
  );
};

export default Drawer;
