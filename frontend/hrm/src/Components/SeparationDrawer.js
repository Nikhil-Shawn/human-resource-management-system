import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import './SeparationDrawer.css';

const SeparationDrawer = ({ isOpen, onClose, onSave, separation }) => {
  const [employeeId, setEmployeeId] = useState('');
  const [separationDate, setSeparationDate] = useState('');
  const [separationType, setSeparationType] = useState('');
  const [separationReason, setSeparationReason] = useState('');
  const [separationStatus, setSeparationStatus] = useState('');
  const [separationId, setSeparationId] = useState('');
  const [errors, setErrors] = useState({});

  useEffect(() => {
    if (separation) {
      setEmployeeId(separation.employee_id || '');
      setSeparationDate(separation.separation_date || '');
      setSeparationType(separation.separation_type || '');
      setSeparationReason(separation.separation_reason || '');
      setSeparationStatus(separation.separation_status || '');
      setSeparationId(separation.separation_id || '');
    } else {
      setEmployeeId('');
      setSeparationDate('');
      setSeparationType('');
      setSeparationReason('');
      setSeparationStatus('');
      setSeparationId('');
    }
    setErrors({});
  }, [separation]);

  const validate = () => {
    const newErrors = {};
    if (!employeeId.trim()) newErrors.employeeId = 'Please enter this field';
    if (!separationDate.trim()) newErrors.separationDate = 'Please enter this field';
    if (!separationType.trim()) newErrors.separationType = 'Please enter this field';
    if (!separationReason.trim()) newErrors.separationReason = 'Please enter this field';
    if (!separationStatus.trim()) newErrors.separationStatus = 'Please enter this field';
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSave = async () => {
    if (!validate()) return;

    const separationData = {
      employee_id: employeeId.trim(),
      separation_date: separationDate.trim(),
      separation_type: separationType.trim(),
      separation_reason: separationReason.trim(),
      separation_status: separationStatus.trim(),
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
            error={!!errors.employeeId}
            helperText={errors.employeeId}
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
            error={!!errors.separationDate}
            helperText={errors.separationDate}
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
            error={!!errors.separationType}
            helperText={errors.separationType}
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
            error={!!errors.separationReason}
            helperText={errors.separationReason}
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
            error={!!errors.separationStatus}
            helperText={errors.separationStatus}
          />
        </div>
      </div>
    </div>
  );
};

export default SeparationDrawer;
