
package com.training.employeecasestudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * this class is used to interact with DB and do manipulations on employee and
 * address tables
 * 
 * @author 447383
 *
 */
@SuppressWarnings("deprecation")
public class EmployeeDAO {

	private static org.apache.log4j.Logger log = Logger.getLogger(EmployeeDAO.class);
	Session session;

	/**
	 * this method creates and returns session for the DB manipulations
	 * 
	 * @return
	 */
	public Session createSession() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		session = factory.openSession();
		log.info("Connection started Successfully for the DB operation");
		return session;
	}

	/**
	 * this method is used to insert records into DB
	 */
	public void insertRecords() {
		session = createSession();
		log.info("DB session is created to insert records");
		boolean checkValue=true;
		Transaction t = session.beginTransaction();
		Resource r = new ClassPathResource("SpringConfig.xml");
		BeanFactory factory = new XmlBeanFactory(r);
		Employee emp1 = (Employee) factory.getBean("emp");
		boolean check = emp1.validateEmail(emp1.getEmail());
		if (check == checkValue) {
			emp1.setEmail(emp1.getEmail());
		} else {
			try {
				throw new Exception("Wrong Email");
			} catch (Exception e) {
				t.rollback();
				System.out.println("Failed due to invalid email ID");
				log.error("Failed due to wrong Email");
			}
		}
		emp1.calcBonus();
		log.info("values set to employee object successfully");
		session.persist(emp1);
		t.commit();
		log.info("Record saved to Employee table successfully");
		session.close();
		System.out.println("successfully saved");

	}

	/**
	 * this method is used to delete records getting user response
	 * 
	 * @throws IOException
	 */
	public void deleteRecords() throws IOException {
		session = createSession();
		log.info("Session updated for delete operation");
		Transaction t = session.beginTransaction();
		System.out.println("Enter ID: ");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		long delId = Long.parseLong(br.readLine());
		Employee e1 = (Employee) session.get(Employee.class, delId);
		session.delete(e1);
		t.commit();
		log.info("Record " + delId + "deleted Employee table successfully");
		session.close();
		System.out.println("successfully saved");

	}

	/**
	 * this method displays records
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayRecords() {
		System.out.println();
		log.info("Session created successfully for the DB operation");
		session = createSession();
		Transaction t = session.beginTransaction();
		List<Employee> employee = session.createQuery("FROM Employee").list();
		for (Iterator iterator = employee.iterator(); iterator.hasNext();) {
			Employee e1 = (Employee) iterator.next();
			System.out.println("ID :" + e1.getId() + ",  Name: " + e1.getEmployeeName());
			System.out.println();
		}
		t.commit();
		session.close();

	}

	/**
	 * this method is used to update employee name getting values from employee
	 * 
	 * @throws IOException
	 */
	public void updateEmployeeName() throws IOException {
		log.info("Session created successfully for the DB operation");
		session = createSession();
		Transaction t = session.beginTransaction();
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.println("Enter ID: ");
		long delId = Long.parseLong(br.readLine());
		System.out.println("Enter Name: ");
		String name = br.readLine();
		Employee e1 = (Employee) session.get(Employee.class, delId);
		e1.setEmployeeName(name);
		session.persist(e1);
		t.commit();
		log.info("Record " + delId + "has been updated with name " + name);
		session.close();
	}
}
