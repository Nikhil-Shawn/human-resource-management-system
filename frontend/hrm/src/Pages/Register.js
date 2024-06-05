import React, { useState } from "react";
import loginImage from "../images/loginImage.svg";
import nexusLogo from "../images/nexusLogo.png";
import "./Register.css";

const Register = () => {
  // State variables for form inputs and validation
  const [step, setStep] = useState(1); // Step for rendering forms

  // State variables for the first page inputs
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [confirmPassword, setConfirmPassword] = useState('');
  const [passwordError, setPasswordError] = useState('');

  // State variables for the second page inputs
  const [firstname, setFirstname] = useState('');
  const [lastname, setLastname] = useState('');
  const [dob, setDob] = useState('');
  const [nationality, setNationality] = useState('');
  const [gender, setGender] = useState('');
  const [phone, setPhone] = useState('');
  const [maritalStatus, setMaritalStatus] = useState('');
  const [street, setStreet] = useState('');
  const [streetNo, setStreetNo] = useState('');
  const [postcode, setPostcode] = useState('');
  const [city, setCity] = useState('');
  const [country, setCountry] = useState('');

  // Function to validate password strength
  const validatePassword = (password) => {
    const passwordRegex = /^(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    return passwordRegex.test(password);
  };

  // Function to handle the first form submission
  const handleFirstSubmit = (e) => {
    e.preventDefault();
    // Check if passwords match
    if (password !== confirmPassword) {
      setPasswordError('Passwords do not match'); // Set error message if passwords do not match
    } else if (!validatePassword(password)) {
      setPasswordError('Password must be at least 8 characters long and contain at least one uppercase letter, one number, and one special character'); // Set error message if password is not strong enough
    } else {
      setPasswordError(''); // Clear error message if passwords match and are strong enough
      setStep(2); // Move to the second form
    }
  };

  // Function to handle the second form submission
  const handleSecondSubmit = (e) => {
    e.preventDefault();
    // Process form data (e.g., send to server)
    console.log('Form submitted', {
      email, password, confirmPassword,
      firstname, lastname, dob, nationality,
      gender, phone, maritalStatus,
      street, streetNo, postcode, city, country
    });
  };

  // Function to handle going back to the first page
  const handleBack = () => {
    setStep(1);
  };

  return (
    <div className="register-container">
      {step === 1 ? (
        // First form for email and password
        <>
          <div className="image-section">
            <img src={loginImage} alt="Human Resource System" />
          </div>
          <div className="form-section">
            <img src={nexusLogo} alt="HR Nexus Logo" className="logo" />
            <h2>Create an account</h2>
            <h5>Please type in your E-Mail and Password</h5>
            <form onSubmit={handleFirstSubmit}>
              <input
                type="email"
                placeholder="email@domain.com"
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required
              />
              <input
                type="password"
                placeholder="password"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                required
              />
              <input
                type="password"
                placeholder="repeat password"
                value={confirmPassword}
                onChange={(e) => setConfirmPassword(e.target.value)}
                required
              />
              {passwordError && <p className="error">{passwordError}</p>}
              <button type="submit">Next</button>
            </form>
          </div>
        </>
      ) : (
        // Second form for personal information and address
        <>
          <div className="form-section">
            <button className="back-button" type="button" onClick={handleBack}>Back</button>
            <img src={nexusLogo} alt="HR Nexus Logo" className="logo-large" />
            <h2>Create an account</h2>
            <form onSubmit={handleSecondSubmit}>
              <div className="form-group">
                <div className="personal-info">
                  <h3>Personal Information</h3>
                  <input
                    type="text"
                    placeholder="Firstname"
                    value={firstname}
                    onChange={(e) => setFirstname(e.target.value)}
                    required
                  />
                  <input
                    type="text"
                    placeholder="Lastname"
                    value={lastname}
                    onChange={(e) => setLastname(e.target.value)}
                    required
                  />
                  <input
                    type="date"
                    placeholder="Date of birth"
                    value={dob}
                    onChange={(e) => setDob(e.target.value)}
                    required
                  />
                  <input
                    type="text"
                    placeholder="Nationality"
                    value={nationality}
                    onChange={(e) => setNationality(e.target.value)}
                    required
                  />
                  <input
                    type="text"
                    placeholder="Gender"
                    value={gender}
                    onChange={(e) => setGender(e.target.value)}
                    required
                  />
                  <input
                    type="text"
                    placeholder="Phone number"
                    value={phone}
                    onChange={(e) => setPhone(e.target.value)}
                    required
                  />
                  <input
                    type="text"
                    placeholder="Marital Status"
                    value={maritalStatus}
                    onChange={(e) => setMaritalStatus(e.target.value)}
                    required
                  />
                </div>
                <div className="address-info">
                  <h3>Address</h3>
                  <input
                    type="text"
                    placeholder="Street"
                    value={street}
                    onChange={(e) => setStreet(e.target.value)}
                    required
                  />
                  <input
                    type="text"
                    placeholder="Street No."
                    value={streetNo}
                    onChange={(e) => setStreetNo(e.target.value)}
                    required
                  />
                  <input
                    type="text"
                    placeholder="Postcode"
                    value={postcode}
                    onChange={(e) => setPostcode(e.target.value)}
                    required
                  />
                  <input
                    type="text"
                    placeholder="City"
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                    required
                  />
                  <input
                    type="text"
                    placeholder="Country"
                    value={country}
                    onChange={(e) => setCountry(e.target.value)}
                    required
                  />
                </div>
              </div>
              <button type="submit">Create account</button>
            </form>
          </div>
          <div className="image-section">
            <img src={loginImage} alt="Human Resource System" />
          </div>
        </>
      )}
    </div>
  );
};

export default Register;
