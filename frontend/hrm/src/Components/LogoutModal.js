import React from 'react';
import './LogoutModal.css';

function LogoutModal({ show, handleClose, handleConfirm }) {
    return (
        <>
            {show && (
                <div className="modal-overlay">
                    <div className="modal">
                        <h2>Confirm Logout?</h2>
                        <div className="modal-buttons">
                            <button onClick={handleClose} className="cancel-button">Cancel</button>
                            <button onClick={handleConfirm} className="confirm-button">Confirm</button>
                        </div>
                    </div>
                </div>
            )}
        </>
    );
}

export default LogoutModal;
