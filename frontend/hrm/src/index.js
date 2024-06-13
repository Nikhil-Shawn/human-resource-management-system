import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Dashboard from './Pages/Dashboard';
import Employee from './Pages/EmployeeDetail';
import EmployeeList from './Pages/EmployeeList';
import Register from './Pages/Register';
import Leaves from './Pages/Leaves';
import CreateEmployee from './Pages/CreateEmployee';
import Payroll from './Pages/Payroll';
import Separation from './Pages/Separation';
import Assets from './Pages/Assets';
import ApplicantList from './Pages/ApplicantList';
import AddEducation from './Pages/AddEducation';
import { AuthProvider } from './Pages/AuthContext'; // Ensure the path is correct
import Department from './Pages/Department'

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <AuthProvider>
      <BrowserRouter>
        <Routes>
        <Route path="/department" element={<Department />} />
          <Route path="/" element={<App />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/employee" element={<Employee />} />
          <Route path="/register" element={<Register />} />
          <Route path="/leaves" element={<Leaves />} />
          <Route path="/payroll" element={<Payroll />} />
          <Route path="/separation" element={<Separation />} />
          <Route path="/assets" element={<Assets />} />
          <Route path="/create-employee" element={<CreateEmployee />} />
          <Route path="/employee-list" element={<EmployeeList />} />
          <Route path="/applicantList" element={<ApplicantList />} />
          <Route path="/add-education" element={<AddEducation />} />
          {/* <Route path="/separation" element={<Separation />} /> */}
        </Routes>
      </BrowserRouter>
    </AuthProvider>
  </React.StrictMode>
);

reportWebVitals();
