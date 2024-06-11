import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import './LeaveDrawer.css';

const LeaveDrawer = ({ isOpen, onClose, onSave, leave, currentVacationId}) => {
  const [reason, setReason] = useState('');
  const [leaveType, setLeaveType] = useState('');
  const [startDate, setStartDate] = useState('');
  const [returnDate, setReturnDate] = useState('');

  useEffect(() => {
    if (leave) {
      setReason(leave.reason);
      setLeaveType(leave.leaveType);
      setStartDate(leave.startDate);
      setReturnDate(leave.returnDate);
    } else {
      setReason('');
      setLeaveType('');
      setStartDate('');
      setReturnDate('');
    }
  }, [leave]);

  const handleSave = async () => {
    const leaveData = {
      ...leave,
      reason,
      leaveType,
      startDate,
      returnDate,
      vacationId: currentVacationId, // Include the vacation ID in the leave data
    };
    console.log("Leave data:", leaveData);

    try {
      const response = leave
        ? await axios.put(`http://localhost:8080/api/vacations/updateVacation/${leave.vacationId}`, leaveData)
        : await axios.post(`http://localhost:8080/api/vacations/addVacation`, leaveData);

        

      onSave(response.data);
      onClose();
      console.log(response.data);
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
            onChange={(e) => setLeaveType(e.target.value)}
            sx={textFieldStyles}
          />
        </div>
      
        <div className="assets-form-group">
          <p>Leave Starting Date</p>
          <TextField
            id="start-date"
            type="date"
            variant="outlined"
            fullWidth
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
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

export default LeaveDrawer;
