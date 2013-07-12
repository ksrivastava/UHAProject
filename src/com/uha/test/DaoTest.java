package com.uha.test;

import org.junit.Test;

import com.uha.server.Model;

public class DaoTest {

	@Test
	public void testDao() {
		Model dao = new Model();
		assert (dao) != null;
	}

	@Test
	public void testInsertPatientIntString() {
		Model dao = new Model();
		dao.insertPatient(123, "Ritika Mehta");
	}

	@Test
	public void testInsertPatientIntStringBoolean() {
		Model dao = new Model();
		dao.insertPatient(192, "Kos Srivastava", false);
	}

	@Test
	public void testInsertServices() {
		Model dao = new Model();
		dao.insertService(1, "Heart", 2);
		dao.insertService(11, "Kidney", 23);
	}

	@Test
	public void testInsertDoctorIntStringInt() {
		Model dao = new Model();
		dao.insertDoctor(321, "Emma Argiroff", 1);
	}

	@Test
	public void testInsertDoctorIntStringIntBooleanBoolean() {
		Model dao = new Model();
		dao.insertDoctor(291, "Tushnika Dayal", 11, false, false);
	}

}
