import axios from 'axios';
import React, { useEffect, useState, useRef } from 'react';
import { BsThreeDotsVertical } from "react-icons/bs";
import AssetDrawer from '../Components/AssetDrawer';
import HeaderComponent from '../Components/HeaderComponent';
import Sidebar from '../Components/Sidebar';
import './Assets.css';

function Assets() {
  const [assetsData, setAssetsData] = useState([]);
  const [isDrawerOpen, setIsDrawerOpen] = useState(false);
  const [currentAsset, setCurrentAsset] = useState(null);
  const [dropdownOpen, setDropdownOpen] = useState(null);
  const dropdownRef = useRef(null);

  useEffect(() => {
    fetchAssets();
    document.addEventListener('mousedown', handleClickOutside);
    return () => {
      document.removeEventListener('mousedown', handleClickOutside);
    };
  }, []);

  const fetchAssets = () => {
    axios.get('http://localhost:8080/api/v1/assets/all')
      .then(response => {
        console.log("response", response);
        const formattedAssets = response.data.map(asset => ({
          ...asset,
          issued_date: formatDate(asset.issued_date), // Format issued date
          return_date: formatDate(asset.return_date), // Format return date
        }));
        setAssetsData(formattedAssets);
      })
      .catch(error => {
        console.error('There was an error fetching the assets data!', error);
      });
  };

  const formatDate = (dateString) => {
    const date = new Date(dateString);
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0'); // Months are zero-indexed
    const year = date.getFullYear();
    return `${day}/${month}/${year}`;
  };

  const handleDrawerOpen = (asset) => {
    setCurrentAsset(asset);
    setIsDrawerOpen(true);
  };

  const handleDrawerClose = () => {
    setIsDrawerOpen(false);
    setCurrentAsset(null);
  };

  const handleSave = (newAsset) => {
    if (currentAsset) {
      setAssetsData(assetsData.map(asset => asset.id === newAsset.id ? newAsset : asset));
    } else {
      setAssetsData([...assetsData, newAsset]);
    }
  };

  const handleDelete = (assetId) => {
    axios.delete(`http://localhost:8080/api/v1/assets/${assetId}`)
      .then(response => {
        console.log(response)
        setAssetsData(assetsData.filter(asset => asset.id !== assetId));
      })
      .catch(error => {
        console.error('There was an error deleting the asset!', error);
      });
  };

  const toggleDropdown = (index) => {
    setDropdownOpen(dropdownOpen === index ? null : index);
  };

  const handleClickOutside = (event) => {
    if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
      setDropdownOpen(null);
    }
  };

  return (
    <div className="app">
      <Sidebar />
      <div className="main-content">
        <HeaderComponent />
        <div className="assets-container">
          <div className="assets-heading">
            <div className="assets-text">Assets</div>
            <div className="add-asset-button-container">
              <button onClick={() => handleDrawerOpen(null)}>+ Add Asset</button>
            </div>
          </div>
          <table className="employee-table">
            <thead>
              <tr
                style={{
                  fontWeight: "0",
                  fontSize: "0.8vw",
                  color: "black",
                }}
              >
                <th
                  style={{
                    padding: "20px 0px 20px 40px",
                    marginLeft: "10px",
                    
                  }}
                >
                  Employee ID</th>
                <th>Asset Type</th>
                <th>Serial Number</th>
                <th>Issued Date</th>
                <th>Return Date</th>
                <th></th>
              </tr>
            </thead>
            <tbody style={{ fontSize: "0.8vw", textAlign: "center" }}>
              {assetsData.map((asset, index) => (
                <tr key={index}>
                  <td style={{
                    display: "flex",
                    alignItems: "center",
                    borderLeft: "1px solid #E0E4EA",
                    padding: "20px",
                  }}>
                    <span>{asset.employee_id}</span>
                    
                  </td>
                  <td>{asset.asset_type}</td>
                  <td>{asset.serial_number}</td>
                  <td>{asset.issued_date}</td>
                  <td>{asset.return_date}</td>
                  <td style={{ borderRight: "1px solid #E0E4EA" }}>
                    <div className="dropdown-container" ref={dropdownOpen === index ? dropdownRef : null}>
                      <BsThreeDotsVertical onClick={() => toggleDropdown(index)} />
                      {dropdownOpen === index && (
                        <div className="dropdown-menu">
                          <div className="dropdown-item" onClick={() => handleDrawerOpen(asset)}>Edit</div>
                          <div className="dropdown-item" onClick={() => handleDelete(asset.id)}>Delete</div>
                        </div>
                      )}
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
      <AssetDrawer isOpen={isDrawerOpen} onClose={handleDrawerClose} onSave={handleSave} asset={currentAsset} />
    </div>
  );
}

export default Assets;
