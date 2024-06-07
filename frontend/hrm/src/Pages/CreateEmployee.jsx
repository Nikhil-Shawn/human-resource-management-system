import React, { useState } from 'react';
import Sidebar from '../Components/Sidebar';
import Drawer from '../Components/Drawer'; // Import the Drawer component
import './EmployeeList';

function CreateEmployee() {
  const [isDrawerOpen, setIsDrawerOpen] = useState(false);

  const openDrawer = () => {
    setIsDrawerOpen(true);
  };

  const closeDrawer = () => {
    setIsDrawerOpen(false);
  };

  return (
    <div className="app">
      <Sidebar />
      <div className="main-content">
        <div className="employee-container">
          <div className='heading' style={{display: 'flex', justifyContent: 'space-between'}}>
            <h1>Create Employee</h1>
            <button className="login-button" style={{width: '30%'}} onClick={openDrawer}>
              Add Employee
            </button>
          </div>
        </div>
      </div>
      <Drawer isOpen={isDrawerOpen} onClose={closeDrawer} />
    </div>
  );
}

export default CreateEmployee;
