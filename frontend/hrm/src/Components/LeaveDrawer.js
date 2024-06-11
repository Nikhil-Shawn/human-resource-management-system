import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import './LeaveDrawer.css';

const Drawer = ({ isOpen, onClose, onSave, leave }) => {

  const [employee_id, setEmployeeId] = useState('');
  const [leaveType, setleaveType] = useState('');
  const [reason, setReason] = useState('');
  const [startDate, setstartDate] = useState('');
  const [returnDate, setReturnDate] = useState('');

  useEffect(() => {
    if (leave) {
      setEmployeeId(leave.employee_id);
      setleaveType(leave.employeeEmail);
      setReason(leave.employeePosition);
      setstartDate(leave.startDate);
      setReturnDate(leave.returnDate);
    } else {
      setEmployeeId('1');
      setleaveType('');
      setReason('');
      setstartDate('');
      setReturnDate('');
    }
  }, [leave]);

  const handleSave = async () => {
    console.log("employeeID= ",employee_id);
    const leaveData = {
      ...leave,
      employee_id,
      leaveType,
      reason,
      startDate,
      returnDate,
    };

    try {
      console.log(employee_id)
      const response = leave
        ? await axios.put(`http://localhost:8080/api/vacations/updateVacation/${leave.id}`, leaveData)
        : await axios.post(`http://localhost:8080/api/vacations/addVacation/${leave.employee_id}`, leaveData);

      onSave(response.data);
      onClose();
    } catch (error) {
      console.error('Error saving leave', error);
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
        <h2>{leave ? 'Edit Leave' : 'Add Leave'} to Employee</h2>
        <div className="button-group">
          <Button variant="text" onClick={onClose} className="assets-cancel-button">Cancel</Button>
          <Button variant="contained" onClick={handleSave} className="save-button">Save</Button>
        </div>
        <button className="assets-drawer-close-button" onClick={onClose}>&times;</button>
      </div>
      <div className="form-container">
   
      <div className="assets-form-group">
          <p>Reason</p>
          <TextField
            id="employee-reason"
            label="Type in Reason"
            variant="outlined"
            fullWidth
            value={reason}
            onChange={(e) => setReason(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
        
        <div className="assets-form-group">
          <p>Leave Type</p>
          <TextField
            id="leave-type"
            label="Enter Leave Type"
            variant="outlined"
            fullWidth
            value={leaveType}
            onChange={(e) => setleaveType(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
      
        <div className="assets-form-group">
          <p>Leave starting Date</p>
          <TextField
            id="start-date"
            type="date"
            variant="outlined"
            fullWidth
            value={startDate}
            onChange={(e) => setstartDate(e.target.value)}
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
