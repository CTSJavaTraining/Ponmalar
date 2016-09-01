
package com.training.employeecasestudy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CRUDMain {

	Session session;

	@SuppressWarnings("deprecation")
	public Session createSession() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		session = factory.openSession();
		return session;
	}

	public void inserRecords() {
		session = createSession();
		Transaction t = session.beginTransaction();
		List<Address> address = new ArrayList<Address>();
		Employee e1 = new Employee();
		e1.setId(12);
		e1.setEmployeeName("xxx");
		e1.setDesignation("MA");
		e1.setDoj("12-12-2016");
		e1.setEmail("abc@email.com");
		e1.setGrade('B');
		e1.setSalary(50000);
		e1.setBonus(5000);
		Address addr1 = new Address(e1, "14\15", "Vadapalani", "TN");
		address.add(addr1);
		e1.setAddress(address);
		session.persist(e1);
		t.commit();
		session.close();
		System.out.println("successfully saved");

	}

	public void deleteRecords() throws NumberFormatException, IOException {
		session = createSession();
		Transaction t = session.beginTransaction();
		System.out.println("Enter ID: ");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		long del_id=Long.parseLong(br.readLine());
		Employee e1 = (Employee) session.get(Employee.class, del_id);
		session.delete(e1);
		t.commit();
		session.close();
		System.out.println("successfully saved");

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayRecords() {
		session = createSession();
		Transaction t = session.beginTransaction();
		 List<Employee> employee = session.createQuery("FROM Employee").list(); 
         for (Iterator iterator = employee.iterator(); iterator.hasNext();){
            Employee e1 = (Employee) iterator.next();
            System.out.println("ID :" + e1.getId()+  ",  Name: " +e1.getEmployeeName());
            System.out.println();
         }
		t.commit();
		session.close();
		System.out.println("successfully saved");

	}

}
