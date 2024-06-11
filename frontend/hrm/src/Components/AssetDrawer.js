import Button from '@mui/material/Button';
import TextField from '@mui/material/TextField';
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
  }, [asset]);

  const handleSave = async () => {
    const assetData = {
      asset_type: assetType,
      serial_number: serialNumber,
      issued_date: issuedDate,
      return_date: returnDate,
      employee_id: employeeId,
    };

    console.log("new assetId = ", assetId);
    console.log("assetData = ", assetData);

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
      console.log(error.response); // Add this line to get more details about the error response
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
          <TextField
            id="asset-type"
            label="Asset Type"
            variant="outlined"
            fullWidth
            value={assetType}
            onChange={(e) => setAssetType(e.target.value)}
            sx={textFieldStyles}
          />
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
