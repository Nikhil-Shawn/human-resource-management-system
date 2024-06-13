import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
import Select from '@mui/material/Select';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import InputLabel from '@mui/material/InputLabel';
import FormHelperText from '@mui/material/FormHelperText';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import './AssetDrawer.css';
 
const Drawer = ({ isOpen, onClose, onSave, asset }) => {
  const [assetType, setAssetType] = useState('');
  const [serialNumber, setSerialNumber] = useState('');
  const [employeeId, setEmployeeId] = useState('');
  const [issuedDate, setIssuedDate] = useState('');
  const [returnDate, setReturnDate] = useState('');
  const [assetId, setAssetId] = useState(null);
  const [errors, setErrors] = useState({});
 
  useEffect(() => {
    if (asset) {
      setAssetType(asset.asset_type);
      setSerialNumber(asset.serial_number);
      setEmployeeId(asset.employee_id);
      setIssuedDate(asset.issued_date);
      setReturnDate(asset.return_date);
      setAssetId(asset.asset_id);
    } else {
      setAssetType('');
      setSerialNumber('');
      setEmployeeId('');
      setIssuedDate('');
      setReturnDate('');
      setAssetId(null);
    }
    setErrors({});
  }, [asset]);
 
  const validate = () => {
    const newErrors = {};
    const alphanumericRegex = /^[a-z0-9 ]+$/i;
 
    if (!assetType || !alphanumericRegex.test(assetType)) newErrors.assetType = 'Please enter a valid asset type ';
    if (!serialNumber || !alphanumericRegex.test(serialNumber)) newErrors.serialNumber = 'Please enter a valid serial number (alphanumeric and spaces only)';
    if (!employeeId || !alphanumericRegex.test(employeeId)) newErrors.employeeId = 'Please enter a valid employee ID (numeric only)';
    if (!issuedDate) newErrors.issuedDate = 'Please enter this field';
    if (!returnDate) newErrors.returnDate = 'Please enter this field';
 
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };
 
  const handleSave = async () => {
    if (!validate()) return;
 
    const assetData = {
      asset_type: assetType,
      serial_number: serialNumber,
      issued_date: issuedDate,
      return_date: returnDate,
      employee_id: employeeId,
    };
 
    try {
      const response = assetId
        ? await axios.put(`http://localhost:8080/api/v1/assets/update/${assetId}`, assetData, {
            headers: {
              'Content-Type': 'application/json'
            }
          })
        : await axios.post('http://localhost:8080/api/v1/assets/save', assetData, {
            headers: {
              'Content-Type': 'application/json'
            }
          });
 
      onSave(response.data);
      onClose();
    } catch (error) {
      console.error('Error saving asset:', error);
      console.log(error.response);
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
        <h2>{asset ? 'Edit Asset' : 'Add Asset'}</h2>
        <div className="button-group">
          <Button variant="text" onClick={onClose} className="assets-cancel-button">Cancel</Button>
          <Button variant="contained" onClick={handleSave} className="save-button">Save</Button>
        </div>
        <button className="assets-drawer-close-button" onClick={onClose}>&times;</button>
      </div>
      <div className="form-container">
        <div className="assets-form-group">
          <p>Asset Type</p>
          <FormControl variant="outlined" fullWidth error={!!errors.assetType}>
            <InputLabel id="asset-type-label">Asset Type</InputLabel>
            <Select
              labelId="asset-type-label"
              id="asset-type"
              value={assetType}
              onChange={(e) => setAssetType(e.target.value)}
              label="Asset Type"
            >
              <MenuItem value="Laptop">Laptop</MenuItem>
              <MenuItem value="SmartPhone">Smart Phone</MenuItem>
              <MenuItem value="Tablet">Tablet</MenuItem>
              <MenuItem value="Headset">Headset</MenuItem>
            </Select>
            {errors.assetType && <FormHelperText>{errors.assetType}</FormHelperText>}
          </FormControl>
        </div>
        <div className="assets-form-group">
          <p>Serial Number</p>
          <TextField
            id="serial-number"
            label="Serial Number"
            variant="outlined"
            fullWidth
            value={serialNumber}
            onChange={(e) => setSerialNumber(e.target.value)}
            error={!!errors.serialNumber}
            helperText={errors.serialNumber}
            sx={textFieldStyles}
          />
        </div>
        <div className="assets-form-group">
          <p>Employee ID</p>
          <TextField
            id="employee-id"
            label="Employee ID"
            variant="outlined"
            fullWidth
            value={employeeId}
            onChange={(e) => setEmployeeId(e.target.value)}
            error={!!errors.employeeId}
            helperText={errors.employeeId}
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
            error={!!errors.issuedDate}
            helperText={errors.issuedDate}
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
            error={!!errors.returnDate}
            helperText={errors.returnDate}
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