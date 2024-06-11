import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import './PayrollDrawer.css';

const Drawer = ({ isOpen, onClose, onSave, payroll }) => {
  const [startDate, setStartDate] = useState('');
  const [endDate, setEndDate] = useState('');
  const [reason, setReason] = useState('');
  const [status, setStatus] = useState('');
  const [vacationType, setVacationType] = useState('');
  const [payrollId, setPayrollId] = useState();

  useEffect(() => {
    if (payroll) {
      setStartDate(payroll.startDate);
      setEndDate(payroll.endDate);
      setReason(payroll.reason);
      setStatus(payroll.status);
      setVacationType(payroll.vacationType);
      setPayrollId(payroll.payrollId);
    } else {
      setStartDate('');
      setEndDate('');
      setReason('');
      setStatus('');
      setVacationType('');
      setPayrollId('');
    }
  }, [payroll]);

  const handleSave = async () => {
    const payrollData = {
      startDate,
      endDate,
      reason,
      status,
      vacationType
    };

    try {
      const response = payrollId
        ? await axios.put(`http://localhost:8080/api/payrolls/updatePayroll/${payrollId}`, payrollData)
        : await axios.post('http://localhost:8080/api/payrolls/addPayroll/{employee_id}', payrollData);

      onSave(response.data);
      onClose();
    } catch (error) {
      console.error('Error saving payroll:', error);
    }
  };

  return (
    <div className={`drawer ${isOpen ? 'open' : ''}`}>
      <div className="head-group">
        <h2>{payroll ? 'Edit Payroll' : 'Add Payroll'}</h2>
        <div className="button-group">
          <Button variant="text" onClick={onClose} className="payroll-cancel-button">Cancel</Button>
          <Button variant="contained" onClick={handleSave} className="save-button">Save</Button>
        </div>
        <button className="payroll-drawer-close-button" onClick={onClose}>&times;</button>
      </div>
      <div className="form-container">
        <div className="payroll-form-group">
          <p>Start Date</p>
          <TextField
            id="start-date"
            type="date"
            variant="outlined"
            fullWidth
            value={startDate}
            onChange={(e) => setStartDate(e.target.value)}
          />
        </div>
        <div className="payroll-form-group">
          <p>End Date</p>
          <TextField
            id="end-date"
            type="date"
            variant="outlined"
            fullWidth
            value={endDate}
            onChange={(e) => setEndDate(e.target.value)}
          />
        </div>
        <div className="payroll-form-group">
          <p>Reason</p>
          <TextField
            id="reason"
            label="Reason"
            variant="outlined"
            fullWidth
            value={reason}
            onChange={(e) => setReason(e.target.value)}
          />
        </div>
        <div className="payroll-form-group">
          <p>Status</p>
          <TextField
            id="status"
            label="Status"
            variant="outlined"
            fullWidth
            value={status}
            onChange={(e) => setStatus(e.target.value)}
          />
        </div>
        <div className="payroll-form-group">
          <p>Vacation Type</p>
          <TextField
            id="vacation-type"
            label="Vacation Type"
            variant="outlined"
            fullWidth
            value={vacationType}
            onChange={(e) => setVacationType(e.target.value)}
          />
        </div>
      </div>
    </div>
  );
};

export default Drawer;
