package com.training.employeecasestudy;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/EmployeeService")
public class EmployeeService {
	
	List<Employee> employeeList = new ArrayList<Employee>();
	EmployeeDAO ed = new EmployeeDAO();
	
	   @GET
	   @Path("/users")
	   @Produces(MediaType.APPLICATION_XML)
	   public void getEmployees()
	   {
		   ed.displayRecords();
	   }
}
