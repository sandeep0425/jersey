package com.Jersey;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlRootElement;

import com.Jersey.DAO.EmployeeDAO;
import com.Jersey.model.Employee;
import com.sun.research.ws.wadl.Application;
@Path("/empimpl")

public class EmpImpl
{
	
	EmployeeDAO edao;
	public EmpImpl()
	{
		 edao = new EmployeeDAO();
	}
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
public Employee fetchEmlyee(@PathParam("id") int id)
{
		Employee e = edao.getproductByid(id);
		
		return e;
	}
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/add")
	public String insertDate(@FormParam("id") int id,@FormParam("username") String username,@FormParam("password") String password)
	{
		Employee emp = new Employee(id,username,password);
		
		edao.insert(emp);
		return "data inserted";
	}
	
	
}
