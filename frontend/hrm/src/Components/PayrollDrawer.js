import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Checkbox from '@mui/material/Checkbox';
import FormControlLabel from '@mui/material/FormControlLabel';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import './PayrollDrawer.css';

const PayrollDrawer = ({ isOpen, onClose, onSave, payroll }) => {
  const [employeeId, setEmployeeId] = useState('');
  const [payAmount, setPayAmount] = useState('');
  const [payFrequency, setPayFrequency] = useState('');
  const [bonus, setBonus] = useState('');
  const [incrementApplicable, setIncrementApplicable] = useState(false);
  const [percentageIncrement, setPercentageIncrement] = useState('');
  const [payrollId, setPayrollId] = useState(null);

  useEffect(() => {
    if (payroll) {
      setEmployeeId(payroll.employeeId || '');
      setPayAmount(payroll.payAmount || '');
      setPayFrequency(payroll.payFrequency || '');
      setBonus(payroll.bonus || '');
      setIncrementApplicable(payroll.incrementApplicable || false);
      setPercentageIncrement(payroll.percentageIncrement || '');
      setPayrollId(payroll.payroll_id || null);
      console.log("pazrollID= ",payroll.payroll_id);
    } else {
      setEmployeeId('');
      setPayAmount('');
      setPayFrequency('');
      setBonus('');
      setIncrementApplicable(false);
      setPercentageIncrement('');
      setPayrollId(null);
    }
  }, [payroll]);

  const handleSave = async () => {
    const payrollData = {
      employeeId,
      payAmount,
      payFrequency,
      bonus,
      incrementApplicable,
      percentageIncrement,
    };

    try {
      const response = payrollId
        ? await axios.put(`http://localhost:8080/api/payrolls/updatePayroll/${payrollId}`, payrollData)
        : await axios.post(`http://localhost:8080/api/payrolls/addPayroll/${employeeId}`, payrollData);

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
          <p>Employee ID</p>
          <TextField
            id="employee-id"
            label="Employee ID"
            variant="outlined"
            fullWidth
            value={employeeId}
            onChange={(e) => setEmployeeId(e.target.value)}
            disabled={!!payrollId} // Disable the field if updating
          />
        </div>
        <div className="payroll-form-group">
          <p>Pay Amount</p>
          <TextField
            id="pay-amount"
            label="Pay Amount"
            variant="outlined"
            fullWidth
            value={payAmount}
            onChange={(e) => setPayAmount(e.target.value)}
          />
        </div>
        <div className="payroll-form-group">
          <p>Pay Frequency</p>
          <TextField
            id="pay-frequency"
            label="Pay Frequency"
            variant="outlined"
            fullWidth
            value={payFrequency}
            onChange={(e) => setPayFrequency(e.target.value)}
          />
        </div>
        <div className="payroll-form-group">
          <p>Bonus</p>
          <TextField
            id="bonus"
            label="Bonus"
            variant="outlined"
            fullWidth
            value={bonus}
            onChange={(e) => setBonus(e.target.value)}
          />
        </div>
        <div className="payroll-form-group">
          <p>Increment Applicable</p>
          <FormControlLabel
            control={
              <Checkbox
                checked={incrementApplicable}
                onChange={(e) => setIncrementApplicable(e.target.checked)}
                name="incrementApplicable"
                color="primary"
              />
            }
            label="Increment Applicable"
          />
        </div>
        <div className="payroll-form-group">
          <p>Percentage Increment</p>
          <TextField
            id="percentage-increment"
            label="Percentage Increment"
            variant="outlined"
            fullWidth
            value={percentageIncrement}
            onChange={(e) => setPercentageIncrement(e.target.value)}
          />
        </div>
      </div>
    </div>
  );
};

export default PayrollDrawer;
