import React from 'react';
import { BsThreeDotsVertical } from "react-icons/bs";
import HeaderComponent from '../Components/HeaderComponent';
import Sidebar from '../Components/Sidebar';
import './Assets.css';


function Assets() {
const assetsData = [
  {
    name: 'Kallie Towne',
    position: 'PHP Web Developer',
    department: 'Development',
    issuedDate: 'Nov, 12 2024',
    returnDate: 'Dec, 12 2024',
    email: 'felix.maier@nexus.com',
    serialNumber: 'LAP123456789'
  },
  {
    name: 'Chester Wiza',
    position: 'Full Stack Developer',
    department: 'Sales & Marketing',
    issuedDate: 'Oct, 2 2024',
    returnDate: 'Dec, 2 2024',
    email: 'wiza1234@nexus.com',
    serialNumber: 'LAP987654321'
  },
  {
    name: 'Max Mustermann',
    position: 'UI/UX Designer',
    department: 'Development',
    issuedDate: 'Sep, 12 2024',
    returnDate: 'Nov, 12 2024',
    email: 'max.mustermannn@nexus.com',
    serialNumber: 'MOB123456789'
  },
  {
    name: 'Zechariah Botsford',
    position: 'Data Analyst',
    department: 'Analytics & Data',
    issuedDate: 'Aug, 5 2024',
    returnDate: 'Oct, 5 2024',
    email: 'bitsfor-z@nexus.com',
    serialNumber: 'MOB987654321'
  },
  {
    name: 'Triston Bode',
    position: 'Frontend Developer',
    department: 'Development',
    issuedDate: 'Jul, 11 2024',
    returnDate: 'Sep, 11 2024',
    email: 'tristonbode@nexus.com',
    serialNumber: 'TAB123456789'
  },
  {
    name: 'Graham Rice',
    position: 'C++ Game Developer',
    department: 'Development',
    issuedDate: 'Jun, 29 2024',
    returnDate: 'Aug, 29 2024',
    email: 'graham-ric@nexus.com',
    serialNumber: 'TAB987654321'
  },
  {
    name: 'Annette Jast',
    position: 'Project Manager',
    department: 'Analytics & Data',
    issuedDate: 'May, 18 2024',
    returnDate: 'Jul, 18 2024',
    email: 'ann.jast@nexus.com',
    serialNumber: 'LAP112233445'
  },
  {
    name: 'Kallie Towne',
    position: 'Graphic Designer',
    department: 'Sales & Marketing',
    issuedDate: 'Apr, 10 2024',
    returnDate: 'Jun, 10 2024',
    email: 'towne2209@example.com',
    serialNumber: 'MOB223344556'
  }
];


  return (
    <div className="app">
      <Sidebar />
      <div className="main-content">
        <HeaderComponent />
        <div className="assets-container">
          <div className="assets-heading">
            <div className="assets-text">Assets</div>
            <div className="add-asset-button-container">
              <button>+ Add Asset</button>
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
                    <span>{asset.name}</span>
                  </td>
                  <td>
                    <span style={{
                      backgroundColor: "#DDCBFC",
                      color: "black",
                      borderRadius: "30px",
                      padding: "8px 20px",
                      display: "inline-block",
                    }}>{asset.position}</span>
                  </td>
                  <td>{asset.department}</td>
                  <td>{asset.issuedDate}</td>
                  <td>{asset.returnDate}</td>
                  <td>{asset.email}</td>
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
    </div>
  );
}

export default Assets;