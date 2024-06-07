import React from 'react';
import { Box, Grid, Paper, Typography, Button, TextField, MenuItem } from '@mui/material';
import Sidebar from '../Components/Sidebar'; // Assuming you have a Sidebar component
import './Employee.css'; // Create CSS for custom styles

const industries = [
  { value: 'Information Technology', label: 'Information Technology' },
  { value: 'Finance', label: 'Finance' },
  { value: 'Healthcare', label: 'Healthcare' },
];

const EmployeeDetail = () => {
  return (
    <Box display="flex">
      <Sidebar />
      <Box flexGrow={1} p={2}>
        <Paper elevation={3} className="employee-detail-container">
          <Grid container spacing={2}>
            <Grid item xs={12} sm={6}>
              <Box className="section-container">
                <Typography variant="h6">Personal Info</Typography>
                <Box>
                  <Typography variant="body1">Julia Maier</Typography>
                  <Typography variant="body2">Project Manager</Typography>
                  <Typography variant="body2">Sales & Marketing</Typography>
                  <Typography variant="body2">Date of Joining: Jan 19, 2020</Typography>
                  <Typography variant="body2">Email: o.williams@gmail.com</Typography>
                  <Typography variant="body2">Joined: 12 Apr, 2020</Typography>
                </Box>
              </Box>
            </Grid>
            <Grid item xs={12} sm={6}>
              <Box className="section-container">
                <Typography variant="h6">Bank Information</Typography>
                <Box>
                  <Typography variant="body2">Bank Account No.: 00234552976293057</Typography>
                  <Typography variant="body2">IFSC Code: CC128693311</Typography>
                  <Typography variant="body2">PAN No.: 0012998383647383</Typography>
                </Box>
              </Box>
            </Grid>
            <Grid item xs={12}>
              <Box className="section-container">
                <Typography variant="h6">Skills</Typography>
                <Box className="skills-container">
                  {["Project Management", "Team Leadership", "Data Agile Methodologies", "Risk Management"].map(skill => (
                    <Button key={skill} variant="outlined" className="skill-chip">{skill}</Button>
                  ))}
                </Box>
              </Box>
            </Grid>
            <Grid item xs={12}>
              <Box className="section-container">
                <Typography variant="h6">Experience</Typography>
                <Box>
                  <Typography variant="body2">Senior Project Manager (Aug 2023 - Present) - Frankfurt</Typography>
                  <Typography variant="body2">Assistant Project Manager (Jul 2018 - Dec 2019) - Köln</Typography>
                </Box>
              </Box>
            </Grid>
            <Grid item xs={12}>
              <Box className="section-container">
                <Typography variant="h6">Salary Information</Typography>
                <Box>
                  <Typography variant="body2">Salary Basis: Monthly</Typography>
                  <Typography variant="body2">Salary Amount Per Month: $1300</Typography>
                  <Typography variant="body2">Effective Date: 13/06/2024</Typography>
                </Box>
              </Box>
            </Grid>
            <Grid item xs={12}>
              <Box className="section-container">
                <Typography variant="h6">Educations</Typography>
                <Box>
                  <Typography variant="body2">Bachelor of Science in Computer Science</Typography>
                  <Typography variant="body2">University of Technology - Graduated May 2017</Typography>
                </Box>
              </Box>
            </Grid>
          </Grid>
        </Paper>
      </Box>
    </Box>
  );
};

export default EmployeeDetail;
