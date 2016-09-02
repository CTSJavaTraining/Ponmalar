
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


@SuppressWarnings("deprecation")
public class EmployeeDAO {

	private static org.apache.log4j.Logger log = Logger.getLogger(EmployeeDAO.class);
	Session session;


	public Session createSession() {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		session = factory.openSession();
		log.info("Connection started Successfully for the DB operation");
		return session;
	}

	public void insertRecords() {
		session = createSession();
		log.info("Session created successfully for the DB operation");
		Transaction t = session.beginTransaction();
		 Resource r=new ClassPathResource("SpringConfig.xml");  
		 BeanFactory factory=new XmlBeanFactory(r);
		 Employee emp1 = (Employee) factory.getBean("emp");
		/*List<Address> address = new ArrayList<Address>();
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
		e1.setAddress(address);*/
		emp1.calcBonus();
		log.info("values set to employee object successfully");
		session.persist(emp1);
		t.commit();
		log.info("Record saved to Employee table successfully");
		session.close();
		System.out.println("successfully saved");

	}

	public void deleteRecords() throws NumberFormatException, IOException {
		session = createSession();
		log.info("Session created successfully for the DB operation");
		Transaction t = session.beginTransaction();
		System.out.println("Enter ID: ");
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		long delId=Long.parseLong(br.readLine());
		Employee e1 = (Employee) session.get(Employee.class, delId);
		session.delete(e1);
		t.commit();
		log.info("Record " +delId +"deleted Employee table successfully");
		session.close();
		System.out.println("successfully saved");

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void displayRecords() {
		System.out.println();
		log.info("Session created successfully for the DB operation");
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

	}

	public void updateEmployeeName() throws NumberFormatException, IOException
	{
		log.info("Session created successfully for the DB operation");
		session = createSession();
		Transaction t = session.beginTransaction();
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		System.out.println("Enter ID: ");
		long delId=Long.parseLong(br.readLine());
		System.out.println("Enter Name: ");
		String name=br.readLine();
		Employee e1 = (Employee) session.get(Employee.class, delId);
		e1.setEmployeeName(name);
		session.persist(e1); 
		t.commit();
		log.info("Record " +delId +"has been updated with name " + name);
		session.close();
	}
}
