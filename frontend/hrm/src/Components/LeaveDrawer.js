import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
import Select from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";
import axios from "axios";
import React, { useState, useEffect } from "react";
import "./LeaveDrawer.css";
import { FormControl, FormHelperText } from "@mui/material";
import InputLabel from "@mui/material/InputLabel";

const LeaveDrawer = ({ isOpen, onClose, onSave, leave }) => {
	const [employeeId, setEmployeeId] = useState("");
	const [vacationType, setVacationType] = useState("");
	const [reason, setReason] = useState("");
	const [startDate, setStartDate] = useState("");
	const [endDate, setEndDate] = useState("");
	const [vacationId, setVacationId] = useState(null);
	const [status, setStatus] = useState("");
	const [errors, setErrors] = useState({});

	useEffect(() => {
		console.log("mz current vacation= ", leave);
		if (leave) {
			setEmployeeId(leave.employeeId || "");
			setVacationType(leave.vacationType || "");
			setReason(leave.reason || "");
			setStartDate(leave.startDate || "");
			setEndDate(leave.endDate || "");
			setVacationId(leave.vacationId || null);
			setStatus(leave.status || "");
		} else {
			setEmployeeId("");
			setVacationType("");
			setReason("");
			setStartDate("");
			setEndDate("");
			setVacationId(null);
			setStatus("");
		}
		setErrors({});
	}, [leave]);

	const validate = () => {
		const newErrors = {};
		if (!employeeId.trim()) newErrors.employeeId = "Please enter this field";
		if (!vacationType.trim())
			newErrors.vacationType = "Please enter this field";
		if (!reason.trim()) newErrors.reason = "Please enter this field";
		if (!startDate.trim()) newErrors.startDate = "Please enter this field";
		if (!endDate.trim()) newErrors.endDate = "Please enter this field";
		if (!status.trim()) newErrors.status = "Please enter this field";
		setErrors(newErrors);
		return Object.keys(newErrors).length === 0;
	};

	const handleSave = async () => {
		if (!validate()) return;

		const leaveData = {
			employeeId: employeeId.trim(),
			vacationType: vacationType.trim(),
			reason: reason.trim(),
			startDate: startDate.trim(),
			endDate: endDate.trim(),
			status: status.trim(),
		};

		try {
			console.log("my vacationID= ", leaveData);
			const response = leave
				? await axios.put(
						`http://localhost:8080/api/vacations/updateVacation/${vacationId}`,
						leaveData
				  )
				: await axios.post(
						`http://localhost:8080/api/vacations/addVacation/${employeeId}`,
						leaveData
				  );

			onSave(response.data);
			onClose();
		} catch (error) {
			console.error("Error saving leave", error);
		}
	};

	const textFieldStyles = {
		"& .MuiOutlinedInput-root": {
			"& fieldset": {
				borderRadius: "8px",
			},
		},
	};

	return (
		<div className={`drawer ${isOpen ? "open" : ""}`}>
			<div className="head-group">
				<h2>{leave ? "Edit Leave" : "Add Leave"} to Employee</h2>
				<div className="button-group">
					<Button
						variant="text"
						onClick={onClose}
						className="assets-cancel-button"
					>
						Cancel
					</Button>
					<Button
						variant="contained"
						onClick={handleSave}
						className="save-button"
					>
						Save
					</Button>
				</div>
				<button className="assets-drawer-close-button" onClick={onClose}>
					&times;
				</button>
			</div>
			<div className="form-container">
				<div className="assets-form-group">
					<p>Employee ID</p>
					<TextField
						id="employee-id"
						label="Employee ID"
						variant="outlined"
						fullWidth
						value={employeeId}
						onChange={(e) => setEmployeeId(e.target.value)}
						error={!!errors.employeeId}
						helperText={errors.employeeId}
						sx={textFieldStyles}
					/>
				</div>
				<div className="assets-form-group">
					<p>Reason</p>
					<TextField
						id="employee-reason"
						label="Type in Reason"
						variant="outlined"
						fullWidth
						value={reason}
						onChange={(e) => setReason(e.target.value)}
						error={!!errors.reason}
						helperText={errors.reason}
						sx={textFieldStyles}
					/>
				</div>
				<div className="assets-form-group">
					<p>Leave Type</p>
					<FormControl
						variant="outlined"
						fullWidth
						error={!!errors.vacationType}
					>
						<InputLabel id="leave-type-label">Leave Type</InputLabel>
						<Select
							id="leave-type"
							label="Leave Type"
							variant="outlined"
							fullWidth
							value={vacationType}
							onChange={(e) => setVacationType(e.target.value)}
							sx={textFieldStyles}
						>
							<MenuItem value="paid leave">Paid Leave</MenuItem>
							<MenuItem value="unpaid leave">Unpaid Leave</MenuItem>
							<MenuItem value="sick leave">Sick Leave</MenuItem>
							<MenuItem value="maternity leave">Maternity Leave</MenuItem>
						</Select>
						{errors.vacationType && (
							<FormHelperText>{errors.vacationType}</FormHelperText>
						)}
					</FormControl>
				</div>
				<div className="assets-form-group">
					<p>Status</p>
					<TextField
						id="status"
						label="Enter Status"
						variant="outlined"
						fullWidth
						value={status}
						onChange={(e) => setStatus(e.target.value)}
						error={!!errors.status}
						helperText={errors.status}
						sx={textFieldStyles}
					/>
				</div>
				<div className="assets-form-group">
					<p>Leave Starting Date</p>
					<TextField
						id="start-date"
						type="date"
						variant="outlined"
						fullWidth
						value={startDate}
						onChange={(e) => setStartDate(e.target.value)}
						error={!!errors.startDate}
						helperText={errors.startDate}
						sx={textFieldStyles}
						InputLabelProps={{
							shrink: true,
						}}
					/>
				</div>
				<div className="assets-form-group">
					<p>Return Date</p>
					<TextField
						id="return-date"
						type="date"
						variant="outlined"
						fullWidth
						value={endDate}
						onChange={(e) => setEndDate(e.target.value)}
						error={!!errors.endDate}
						helperText={errors.endDate}
						sx={textFieldStyles}
						InputLabelProps={{
							shrink: true,
						}}
					/>
				</div>
			</div>
		</div>
	);
};

export default LeaveDrawer;
