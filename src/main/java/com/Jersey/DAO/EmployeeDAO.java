package com.Jersey.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.Jersey.model.Employee;

public class EmployeeDAO 
{
	static Connection con = null;
	//static Statement st = null;
	public EmployeeDAO()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandeep","root","oracle");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null)
		{
			System.out.println("connected");
		}
		else
		{
			System.out.println("not connected");
		}
	
	}
	public Employee getproductByid(int id)
	{
		Employee e1 = new Employee();
		
		String query = "select * from loginbean1 where id  = ?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
			{
				e1.setId(rs.getInt("id"));
				e1.setUsername(rs.getString("password"));
				e1.setPassword(rs.getString("username"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return e1;
		
	}
	public void insert(Employee emp)
	{
		String query = "insert into loginbean1(id,password,username) values(?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getPassword());
			ps.setString(3, emp.getUsername());
			ps.executeUpdate();
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		}
	public static void isClose(Connection con, Statement st) throws SQLException
	{
		if(con!=null)
				{
				con.close();
				}
	}

}
