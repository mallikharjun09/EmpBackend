package com.ems.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ems.config.DBConfiguration;
import com.ems.models.Employee;

public class EmployeeDAO {
	DBConfiguration db = new DBConfiguration();
	Connection con = db.getDB();
	
	
	public void registerEmployee(Employee emp) {
				
		try {
			//Get the connection object
			
			
			String query = "insert into employees values(?,?,?,?,?,?,?,?)";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, emp.getEmpId());
			st.setString(2, emp.getEmpName());
			st.setString(3, emp.getGender());
			st.setString(4, emp.getRole());
			st.setDouble(5, emp.getSalary());
			st.setString(6, emp.getPass());
			st.setInt(7, emp.getDeptId());
			st.setDate(8, (Date) emp.getDob());
			st.execute();
			//con.commit();
			System.out.println("Employee registered successfully");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to insert the data");
		}
	}
	
	
	
	
	public List<Employee> displayEmployee() {
		List<Employee> empList = new ArrayList<Employee>();
		try {
			String query = "select * from employees";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setDeptId(rs.getInt("deptid"));
				emp.setDob(rs.getDate("dob"));
				emp.setEmpId(rs.getInt("empid"));
				emp.setEmpName(rs.getString("empName"));
				emp.setGender(rs.getString("gender"));
				emp.setPass(rs.getString("pass"));
				emp.setRole(rs.getString("role"));
				emp.setSalary(rs.getDouble("salary"));
				
				empList.add(emp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return empList;
	}




	public Employee displayEmployee(int empId) {
		// TODO Auto-generated method stub
		Employee emp = new Employee();
		emp.setEmpId(0);
		try {
			String query = "select * from employees where empid = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, empId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				emp.setDeptId(rs.getInt("deptid"));
				emp.setDob(rs.getDate("dob"));
				emp.setEmpId(rs.getInt("empid"));
				emp.setEmpName(rs.getString("empName"));
				emp.setGender(rs.getString("gender"));
				emp.setPass(rs.getString("pass"));
				emp.setRole(rs.getString("role"));
				emp.setSalary(rs.getDouble("salary"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return emp;
	}
	
	public void updateEmployee(Employee emp) {
		
		try {
			//Get the connection object
			
			
			String query = "update employees set empname=?,gender=?,role=?,salary=?,deptid=?,dob=? where empid=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(7, emp.getEmpId());
			st.setString(1, emp.getEmpName());
			st.setString(2, emp.getGender());
			st.setString(3, emp.getRole());
			st.setDouble(4, emp.getSalary());
			st.setInt(5, emp.getDeptId());
			st.setDate(6, (Date) emp.getDob());
			st.execute();
			//con.commit();
			System.out.println("Employee Updated successfully");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Unable to insert the data");
		}
	}
 
	public void deleteEmployee(Employee emp) {
		try {
			//Get the connection object
					
			String query = "delete employees where empid=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, emp.getEmpId());
			st.execute();
			//con.commit();
			System.out.println("Employee Deleted successfully");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Unable to insert the data");
		}
	}
	
	public Employee displayEmployee(int empId,String pwd) {
		Employee emp = new Employee();
		emp.setEmpId(0);
		try {
			String query = "select * from employees where empid = ? and pass = ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, empId);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				emp.setDeptId(rs.getInt("deptid"));
				emp.setDob(rs.getDate("dob"));
				emp.setEmpId(rs.getInt("empid"));
				emp.setEmpName(rs.getString("empName"));
				emp.setGender(rs.getString("gender"));
				emp.setPass(rs.getString("pass"));
				emp.setRole(rs.getString("role"));
				emp.setSalary(rs.getDouble("salary"));
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return emp;
	}
}
