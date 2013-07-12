package com.uha.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	public void insertPatient(int id, String name) {
		insertPatient(id, name, true);
	}
	
	public void insertPatient(int id, String name, boolean available) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Patients VALUES (?, ?, ?)";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setBoolean(3, available);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertService(int id, String name, int priority) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Services VALUES (?, ?, ?)";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3, priority);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void insertDoctor(int id, String name, int service_id) {
		insertDoctor(id, name, service_id, true, true);
	}
	
	public void insertDoctor(int id, String name, int service_id, boolean available, boolean checked_in) {
		PreparedStatement stmt = null;
		String sql = "INSERT INTO Doctors VALUES (?, ?, ?, ?, ?)";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setInt(3, service_id);
			stmt.setBoolean(4, available);
			stmt.setBoolean(5, checked_in);
			stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
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
	
}
