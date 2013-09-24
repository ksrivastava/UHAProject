package com.uha.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.uha.common.Doctor;
import com.uha.common.Patient;
import com.uha.common.Services;
import com.uha.common.UHAClient;
import com.uha.core.Pair;

public class Model {

	private Connection connection = null;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String server = "localhost";
	private static final String port = "3306";
	private static final String db = "UHA_DB";
	private static final String url = "jdbc:mysql://" + server + ":" + port
			+ "/" + db;

	public Model() {
		connect();
	}

	private void connect() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, "kaustubh", "admin");
			// System.out.println("Successfully connected to DB");
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException: " + e.getMessage());
		}

	}

	public void insertPatient(String id, String name)
			throws MySQLIntegrityConstraintViolationException, SQLException {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Patients (P_Id, Name) VALUES (?, ?)";
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setString(2, name);
		stmt.executeUpdate();
		stmt.close();
	}

	private void insertAppointment(String patient_id, String service_name,
			boolean complete)
			throws MySQLIntegrityConstraintViolationException, SQLException {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Appointments (Patient_ID, Service_ID, Complete) VALUES (?, ?, ?)";
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, patient_id);
		stmt.setString(2, service_name);
		stmt.setBoolean(3, complete);
		stmt.executeUpdate();
		stmt.close();

	}

	private void insertDoctor(String id, String name, String service_name)
			throws MySQLIntegrityConstraintViolationException, SQLException {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Doctors (D_Id, Name, Service_ID) VALUES (?, ?, ?)";
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setString(2, name);
		stmt.setString(3, service_name);
		stmt.executeUpdate();
		stmt.close();
		checkInDoctor(id);
	}

	public UHAClient getPatient(String id)
			throws MySQLIntegrityConstraintViolationException, SQLException {
		// HAVE TRY CLAUSE IN MODEL ITSELF TO CLOSE CONNECTION
		Statement stmt = null;
		String sql = "SELECT * FROM Patients WHERE P_Id = " + "'" + id + "'";
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		Patient patient = new Patient();
		patient.setId(rs.getString(1));
		patient.setName(rs.getString(2));
		patient.setAvailable(rs.getBoolean(3));
		getPatientServices(patient);
		stmt.close();
		return patient;
	}
	
	public Doctor getDoctor(String id) throws MySQLIntegrityConstraintViolationException, SQLException {
		Statement stmt = null;
		String sql = "SELECT * FROM Doctors WHERE D_Id = " + "'" + id + "'";
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		Doctor doctor = new Doctor();
		doctor.setId(rs.getString(1));
		doctor.setName(rs.getString(2));
		doctor.setPrimaryService(Services.valueOf(rs.getString(3)));
		doctor.setAvailable(rs.getBoolean(4));
		doctor.setCheckedIn(rs.getBoolean(5));
		stmt.close();
		return doctor;
	}

	private void checkInDoctor(String id) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Doctors_Times (Doctor_Id, Check_in) VALUES (?, ?)";
		stmt = connection.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setTimestamp(2, new Timestamp(System.currentTimeMillis()));
		stmt.executeUpdate();
		stmt.close();
		
	}
	
	private void checkOutDoctor(String id) throws SQLException {
		PreparedStatement stmt = null;
		String sql = "UPDATE Doctors_Times SET Check_out = ? WHERE Doctor_Id = ?";
		stmt = connection.prepareStatement(sql);
		stmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
		stmt.setString(2, id);
		stmt.executeUpdate();
		stmt.close();
		
	}

	private void getPatientServices(Patient client)
			throws MySQLIntegrityConstraintViolationException, SQLException {
		Statement stmt = null;
		String sql = "SELECT Service_ID, Complete FROM Appointments WHERE Patient_Id = "
				+ "'" + client.getId() + "'";
		stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			client.addService(Services.valueOf(rs.getString(1)),
					new Boolean(rs.getBoolean(2)));
		}
		stmt.close();
	}

	public void selectAll() {
		Statement stmt = null;
		String query = "SELECT * FROM Patients";

		try {
			stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				boolean available = rs.getBoolean(3);

				String availableString;
				if (available)
					availableString = "available";
				else
					availableString = "not available";

				System.out.println("Candidate: " + id + "  " + "My name is "
						+ name + ". " + "I am " + availableString);
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete() {
		PreparedStatement stmt = null;
		String sql = "DELETE FROM People WHERE Name LIKE ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, "Anjana");
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void insertPatient(Patient client)
			throws MySQLIntegrityConstraintViolationException, SQLException {
		insertPatient(client.getId(), client.getName());
		for (Pair<Services, Boolean> service : client.getServices()) {
			insertAppointment(client.getId(), service.getFirst().name(),
					service.getSecond().booleanValue());
		}
	}

	public void insertDoctor(Doctor client)
			throws MySQLIntegrityConstraintViolationException, SQLException {
		insertDoctor(client.getId(), client.getName(), client
				.getPrimaryService().name());
	}

	public void updatePatientServices(Patient client)
			throws MySQLIntegrityConstraintViolationException, SQLException {
		for (Pair<Services, Boolean> service : client.getServices()) {
			insertAppointment(client.getId(), service.getFirst().name(),
					service.getSecond().booleanValue());
		}
	}

	public boolean updateDoctorCheckedIn(String id, boolean status) {
		PreparedStatement stmt = null;
		String sql = "UPDATE Doctors SET Checked_in= ? WHERE D_ID= ?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setBoolean(1, status);
			stmt.setString(2, id);
			stmt.executeUpdate();
			stmt.close();
			
			if(status) {
				checkInDoctor(id);
			} else {
				checkOutDoctor(id); 
			}
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}


}
