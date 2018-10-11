package com.xxa.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.xxa.dao.AppointmentDao;
import com.xxa.entity.Appointment;

public class AppointmentDaoTest extends BookTest {
	@Autowired
	private AppointmentDao appointmentDao;
    
/*	@Test
	public void testinsertApponintment() {
		long bookId = 1000;
		long studentId = 1234L;
		int number = appointmentDao.insertApponintment(bookId, studentId);
		System.out.println(number);
	}*/
	@Test
	public void testqueryByKeyWithBook() {
		long bookId = 1000;
		long studentId = 1234L;
		Appointment  Appointment  =  appointmentDao.queryByKeyWithBook(bookId, studentId);
		System.out.println(Appointment.getBook().getName());
		
	}
}
