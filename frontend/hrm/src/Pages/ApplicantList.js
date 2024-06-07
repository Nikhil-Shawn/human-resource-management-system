import React from 'react';
import { BsThreeDotsVertical } from "react-icons/bs";
import HeaderComponent from '../Components/HeaderComponent';
import Sidebar from '../Components/Sidebar';
import './ApplicantList.css';

function getStatusClass(status) {
  return status.toLowerCase().replace(/\s+/g, '-');
}

function getProgressSteps(status) {
  const steps = {
    'new-applicant': 1,
    'in-progress': 2,
    'on-hold': 3,
    'accepted': 4,
    'rejected': 4 // Both 'accepted' and 'rejected' represent 100% progress
  };
  return steps[getStatusClass(status)] || 1;
}

function ProgressBar({ status }) {
  const steps = getProgressSteps(status);
  return (
    <div className={`progress-bar-container status-${getStatusClass(status)}`}>
      <div className="progress-bar">
        {Array.from({ length: 4 }).map((_, i) => (
          <div key={i} style={{ width: `${100 / 4}%` }} />
        ))}
      </div>
    </div>
  );
}

function ApplicantList() {
  const ApplicantListData = [
    {
      name: 'Brendan Bradt',
      position: 'UI/UX Designer',
      applicationDate: 'Sep. 12 2023',
      status: 'New Applicant',
      email: 'b.bradtk@example.com',
      img: 'path/to/image1.jpg'
    },
    {
      name: 'Jameson Steut',
      position: 'Full Stack Developer',
      applicationDate: 'Sep. 10 2023',
      status: 'In progress',
      email: 'steuber2012@example.com',
      img: 'path/to/image2.jpg'
    },
    {
      name: 'Ellen Howell',
      position: 'UI/UX Designer',
      applicationDate: 'Sep. 3 2023',
      status: 'On hold',
      email: 'elen4452@example.com',
      img: 'path/to/image3.jpg'
    },
    {
      name: 'Krystina Kautz',
      position: 'Data Analyst',
      applicationDate: 'Sep. 1 2023',
      status: 'Accepted',
      email: 'krkautze@example.com',
      img: 'path/to/image4.jpg'
    },
    {
      name: 'Colt Lakin',
      position: 'Frontend Developer',
      applicationDate: 'Aug. 28 2023',
      status: 'Rejected',
      email: 'coltlakin@example.com',
      img: 'path/to/image5.jpg'
    },
    {
      name: 'Donnie Howell',
      position: 'C++ Game Developer',
      applicationDate: 'Aug. 24 2023',
      status: 'New Applicant',
      email: 'd.qwert@example.com',
      img: 'path/to/image6.jpg'
    },
    {
      name: 'Ellen Howell',
      position: 'PHP Web Developer',
      applicationDate: 'Aug. 24 2023',
      status: 'In progress',
      email: 'e.howell12@example.com',
      img: 'path/to/image7.jpg'
    },
    {
      name: 'Gabriella Lakin',
      position: 'Project Manager',
      applicationDate: 'Aug. 22 2023',
      status: 'On hold',
      email: 'g.lakin1990@example.com',
      img: 'path/to/image8.jpg'
    }
  ];

  return (
    <div className="app">
      <Sidebar />
      <div className="main-content">
        <HeaderComponent />
        <div className="applicant-container">
          <div className="applicant-heading">
            <div className="applicant-text">Applicant List</div>
            <div className="add-applicant-button-container">
              <button>+ Add Applicant</button>
            </div>
          </div>
          <table className="applicant-table">
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
                  Applicant Name
                </th>
                <th>Position Applied</th>
                <th>Application Date</th>
                <th>Status</th>
                <th>Contact information</th>
                <th></th>
              </tr>
            </thead>
            <tbody style={{ fontSize: "0.8vw", textAlign: "center" }}>
              {ApplicantListData.map((applicant, index) => (
                <tr key={index}>
                  <td style={{
                    display: "flex",
                    alignItems: "center",
                    borderLeft: "1px solid #E0E4EA",
                    padding: "20px",
                  }}>
                    <img
                      src={applicant.img || 'default-avatar.png'}
                      alt={`${applicant.name}'s profile`}
                      style={{
                        width: "40px",
                        height: "40px",
                        borderRadius: "50%",
                        marginRight: "20px", // Increased margin for more space
                      }}
                    />
                    <span>{applicant.name}</span>
                  </td>
                  <td>
                    <span style={{
                      backgroundColor: "#DDCBFC",
                      color: "black",
                      borderRadius: "30px",
                      padding: "8px 20px",
                      display: "inline-block",
                    }}>{applicant.position}</span>
                  </td>
                  <td>{applicant.applicationDate}</td>
                  <td>
                    {applicant.status}
                    <ProgressBar status={applicant.status} />
                  </td>
                  <td>{applicant.email}</td>
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

export default ApplicantList;
