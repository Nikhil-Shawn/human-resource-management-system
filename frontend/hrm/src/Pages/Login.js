import React, { useState } from 'react';
import loginImage from '../images/loginImage.svg';
import nexusLogo from '../images/nexusLogo.png';
import './Login.css';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import { useAuth } from '../Pages/AuthContext'; // Adjust the import path as needed

function Login() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');
    const navigate = useNavigate();
    const { login } = useAuth();

    const validateEmail = (email) => {
        const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
        return re.test(String(email).toLowerCase());
    };

    const validatePassword = (password) => {
        const hasUpperCase = /[A-Z]/.test(password);
        const hasLowerCase = /[a-z]/.test(password);
        const hasNumber = /[0-9]/.test(password);
        const hasMinLength = password.length >= 8;
        return hasUpperCase && hasLowerCase && hasNumber && hasMinLength;
    };

    const handleLogin = async () => {
        if (!validateEmail(email)) {
            setError('Please enter a valid email address.');
            return;
        }

        if (!validatePassword(password)) {
            setError('Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, and one number.');
            return;
        }

        try {
            const response = await axios.post('http://localhost:8080/api/login', {
                email,
                password,
                personType: 'employee'
            });

            if (response.data.success) {
                const authData = {
                    employeeId: response.data.employeeId, // Assuming employeeId is in the response
                    ...response.data
                };
                login(authData); // Store the authentication data
                navigate('/dashboard');
            } else {
                setError('Invalid email or password');
            }
        } catch (error) {
            setError('An error occurred. Please try again.');
        }
    };

    const handleCreateAccount = () => {
        navigate('/register');
    };

    return (
        <div className="container">
            <div className="login-image">
                <img src={loginImage} alt="login illustration" />
            </div>
            <div className="login-form">
                <div className="logo">
                    <img src={nexusLogo} alt="HR Nexus logo" />
                </div>
                <div className="form-container">
                    <h2>Login to your account</h2>
                    <p>Enter your email and password to sign in</p>
                    <input
                        type="text"
                        placeholder="email@domain.com"
                        className="input-field"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                    />
                    <input
                        type="password"
                        placeholder="password"
                        className="input-field"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                    />
                    {error && <p className="error-message">{error}</p>}
                    <button className="login-button" onClick={handleLogin}>
                        Login
                    </button>
                    {/* <p className="create-account-message">
                        No account?{' '}
                        <span className="create-account-link" onClick={handleCreateAccount}>
                            Create an account here
                        </span>
                    </p> */}
                </div>
            </div>
        </div>
    );
}

export default Login;

