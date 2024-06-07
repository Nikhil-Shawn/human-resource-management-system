import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Dashboard from './Pages/Dashboard';
import Employee from './Employee';
import Register from './Pages/Register';
import Leaves from './Pages/Leaves';
import Payroll from './Pages/Payroll';
import Separation from './Pages/Separation';
import Assets from './Pages/Assets';
import ApplicantList from './Pages/ApplicantList';



const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
  <React.StrictMode>
    <Routes>
    <Route path="/" element={<App />} />
    <Route path="/dashboard" element={<Dashboard/>}></Route>
    <Route path="/employee" element={<Employee/>}></Route>
    <Route path="/register" element={<Register/>}></Route>
    <Route path="/leaves" element={<Leaves/>}></Route>
    <Route path="/payroll" element={<Payroll/>}></Route>
    <Route path="/separation" element={<Separation/>}></Route>
    <Route path="/assets" element={<Assets/>}></Route>
    <Route path="/applicantList" element={<ApplicantList/>}></Route>
    </Routes>
  </React.StrictMode>
  </BrowserRouter>
);


// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
