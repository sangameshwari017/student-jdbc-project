package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.DBconnection.ConnectionFactory;
import com.dao.EmployeeDAO;
import com.dto.Employee;
public  class EmployeeDAOImpl implements EmployeeDAO{
	
	Connection con1=null;
	
	public List getEmployee() {
		
		ArrayList<Employee> e=new ArrayList<Employee>();
		Statement stmt1=null;
		ResultSet executeQuery=null;
		con1=ConnectionFactory.getConnection();
		String q="select * from employee";
		
		
		try {
			stmt1=con1.createStatement();
			executeQuery=stmt1.executeQuery(q);
			
			while(executeQuery.next()) {
				int eid=executeQuery.getInt(1);
				String ename=executeQuery.getString(2);
				String job=executeQuery.getString(3);
				int sal=executeQuery.getInt(4);
				
				Employee employee=new Employee(eid,ename,job,sal);
				e.add(employee);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		finally {
			try {
				executeQuery.close();
				stmt1.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return e;
		
		
	}

	@Override
	public boolean insertEmployee(int eid, String ename, String job, int sal) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt=null;
		con1=ConnectionFactory.getConnection();
		String q="insert into employee(eid,ename,job,sal)values(?,?,?,?)";
		
		try {
			pstmt=con1.prepareStatement(q);
			pstmt.setInt(1, eid);
			pstmt.setString(2,ename);
			pstmt.setString(3, job);
			pstmt.setInt(4, sal);
			
			pstmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public Employee getEmployee(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEmp(int eid) {
		// TODO Auto-generated method stub
		
		int res=0;
		con1=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		String q="delete from employee where eid=?";
		
		try {
			pstmt=con1.prepareStatement(q);
			pstmt.setInt(1, eid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public int updateEmp(int eid,String ename,String job, int sal) {
		// TODO Auto-generated method stub
		con1=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		int res=0;
		
		String q="update employee set sal=? where eid=? ";
		
		try {
			pstmt=con1.prepareStatement(q);
			pstmt.setInt(1, sal);
			pstmt.setInt(2, eid);
			res=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return res;
	}

}