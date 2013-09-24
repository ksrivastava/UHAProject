package com.uha.common;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.uha.client.MainScreen;
import com.uha.server.Model;

public class Controller {

	private Model model;
	private MainScreen frame;

	public Controller(Model model) {
		this.model = model;
	}

	public void selectAll() {
		model.selectAll();

	}

	public boolean insertPatient(UHAClient client) {
		try {
			model.insertPatient((Patient) client);
			showConfirmation(Confirmations.SAVED);
			return true;
		} catch (MySQLIntegrityConstraintViolationException e) {
			showErrorMessage(Errors.DUPLICATE);
		} catch (SQLException e) {
			showErrorMessage(Errors.GENERAL);
			e.printStackTrace();
		}
		return false;
	}

	public void showErrorMessage(Errors error) {
		JOptionPane.showMessageDialog(frame, error.getLabel(), "Error",
				JOptionPane.ERROR_MESSAGE);

	}

	public void registerView(MainScreen frame) {
		this.frame = frame;

	}

	public void showConfirmation(Confirmations confirmation) {
		JOptionPane.showMessageDialog(frame, confirmation.getLabel(),
				"Success", JOptionPane.PLAIN_MESSAGE);

	}

	public boolean insertDoctor(UHAClient client) {
		try {
			model.insertDoctor((Doctor) client);
			showConfirmation(Confirmations.SAVED);
			return true;
		} catch (MySQLIntegrityConstraintViolationException e) {
			showErrorMessage(Errors.DUPLICATE);
		} catch (SQLException e) {
			showErrorMessage(Errors.GENERAL);
			e.printStackTrace();
		}
		return false;
	}

	public UHAClient getPatient(String id) {
		try {
			return model.getPatient(id);
		} catch (SQLException e) {
			e.printStackTrace();
			showErrorMessage(Errors.GENERAL);
		}
		return null;
	}

	public Doctor getDoctor(String id) {
		try {
			return model.getDoctor(id);
		} catch (SQLException e) {
			e.printStackTrace();
			showErrorMessage(Errors.GENERAL);
		}
		return null;
	}

	public void updateDoctorCheckedIn(String id, boolean status) {
		if (model.updateDoctorCheckedIn(id, status)) {
			showConfirmation(Confirmations.UPDATED);
		}
		else {
			showErrorMessage(Errors.GENERAL);
		}
	}

}
