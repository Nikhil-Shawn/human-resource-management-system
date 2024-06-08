import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { BsThreeDotsVertical } from "react-icons/bs";
import HeaderComponent from '../Components/HeaderComponent';
import Sidebar from '../Components/Sidebar';
import AssetDrawer from '../Components/AssetDrawer';
import './Assets.css';

function Assets() {
  const [assetsData, setAssetsData] = useState([]);
  const [isDrawerOpen, setIsDrawerOpen] = useState(false);

  useEffect(() => {
    fetchAssets();
  }, []);

  const fetchAssets = () => {
    axios.get('http://localhost:8080/api/v1/assets/all')
      .then(response => {
        console.log(response);
        setAssetsData(response.data);
      })
      .catch(error => {
        console.error('There was an error fetching the assets data!', error);
      });
  };

  const handleDrawerOpen = () => {
    setIsDrawerOpen(true);
  };

  const handleDrawerClose = () => {
    setIsDrawerOpen(false);
  };

  const handleSave = (newAsset) => {
    setAssetsData([...assetsData, newAsset]);
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
              <button onClick={handleDrawerOpen}>+ Add Asset</button>
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
                  Name</th>
                <th>Position</th>
                <th>Department</th>
                <th>Issued Date</th>
                <th>Return Date</th>
                <th>Email</th>
                <th>Serial Number</th>
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
                    <img
                      src={asset.img || 'default-avatar.png'}
                      alt={`${asset.name}'s profile`}
                      style={{
                        width: "40px",
                        height: "40px",
                        borderRadius: "50%",
                        marginRight: "10px",
                      }}
                    />
                    <span>{asset.employeeName}</span>
                  </td>
                  <td>
                    <span style={{
                      backgroundColor: "#DDCBFC",
                      color: "black",
                      borderRadius: "30px",
                      padding: "8px 20px",
                      display: "inline-block",
                    }}>{asset.employeePosition}</span>
                  </td>
                  <td>{asset.department}</td>
                  <td>{asset.issuedDate}</td>
                  <td>{asset.returnDate}</td>
                  <td>{asset.employeeEmail}</td>
                  <td>{asset.serialNumber}</td>
                  <td style={{ borderRight: "1px solid #E0E4EA" }}>
                    <BsThreeDotsVertical />
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
      <AssetDrawer isOpen={isDrawerOpen} onClose={handleDrawerClose} onSave={handleSave} /> {/* Pass handleSave to AssetDrawer */}
    </div>
  );
}

export default Assets;
