package com.dao;

import java.util.List;

import com.dto.Employee;

public  interface EmployeeDAO {

	
	 boolean insertEmployee(int eid,String ename,String job,int sal) ;
	
	 List getEmployee();
	 Employee getEmployee(int eid);
	 boolean deleteEmp(int eid);
	 int  updateEmp(int eid,String ename,String job,int sal);
	
}