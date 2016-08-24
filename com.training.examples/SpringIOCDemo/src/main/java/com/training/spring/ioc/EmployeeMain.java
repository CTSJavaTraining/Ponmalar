package com.training.spring.ioc;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@SuppressWarnings("deprecation")
public class EmployeeMain {


	public static void main(String[] args) {
		
		//SpringApplication.run(EmployeeMain.class, args); 
		Resource res= new ClassPathResource("SpringContext.xml");
		BeanFactory ac = new XmlBeanFactory(res);


		//ApplicationContext ac = new ClassPathXmlApplicationContext("SpringContext.xml");
		Employee empl = (Employee) ac.getBean("emp");
		empl.display();
	}

}
