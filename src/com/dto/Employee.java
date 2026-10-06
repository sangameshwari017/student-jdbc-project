package com.dto;

@SuppressWarnings("unused")
public class Employee {
	private int eid;
	private String ename;
	private String job;
	private int sal;
	
	public Employee() {
		
	}
	public Employee(int eid,String ename,String job,int sal) {
		super();
		this.eid=eid;
		this.ename=ename;
		this.job=job;
		this.sal=sal;
		
		
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid=eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		
		this.ename=ename;	}
	public String getjob() {
		return job;
	}
	public void setJob(String job) {
		this.job=job;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal=sal;
	}
	
	
	
	
}