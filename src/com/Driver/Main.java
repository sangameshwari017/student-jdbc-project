package com.Driver;
import java.util.List;
import java.util.Scanner;
import com.dao.EmployeeDAO;
import com.dao.EmployeeDAOImpl;
import com.dto.Employee;

@SuppressWarnings("unused")
public class Main {
	public static void main(String[]args) {
	@SuppressWarnings("unused")
	EmployeeDAOImpl employeeDAOImp=new EmployeeDAOImpl();
	Employee employee =new Employee();
	Scanner sc=new Scanner(System.in);
	
    while(true)
    {
    System.out.println("Press 1 for insert: " );
    System.out.println("Press 2 for updates: ");
    System.out.println("Press 3 for delete: ");
    System.out.println("Press 4 for display: ");
    System.out.println("======================================================");
    System.out.println("Enter Your Choice:");
    
    int  choice=sc.nextInt();
    switch(choice){
    case 1:{
    	System.out.println("How many Employee Details Need to be Entered ?...");
    	int no=sc.nextInt();
    	for(int i=1;i<=no;i++) {
    		System.out.println("Enter the Eid: ");
    		int eid=sc.nextInt();
    		sc.nextLine();
    	
    		
    		System.out.println("Enter The Ename: ");
    		String ename=sc.nextLine();
    		
    		
    
    		
    		System.out.println("Enter the job :");
    		String job=sc.nextLine();
    		
    		
    		
    		System.out.println("Enter the Salary : ");
    		int sal=sc.nextInt();
    		sc.nextLine();
    		
    		employee.setEid(eid);
    		employee.setEname(ename);
    		employee.setJob(job);
    		employee.setSal(sal);
    		
    		System.out.println(employeeDAOImp.insertEmployee(employee.getEid(), employee.getEname(), employee.getjob(), employee.getSal()));
    		
    		
    		
    	}
    	System.out.println("Done!!!!!");
    	
    }
    break;
      
    
    case 2:{
    	System.out.println("Enter the Eid Update: ");
		int eid=sc.nextInt();
		
		System.out.println("Enter the Ename Update");
		String ename=sc.nextLine();
		
		System.out.println("Enter the job Update: ");
		String job=sc.nextLine();
		
		System.out.println("Enter the Salary Update: ");
		int sal=sc.nextInt();
		
		
		employee.setEid(eid);
		employee.setEname(ename);
		employee.setJob(job);
		employee.setSal(sal);
		
		
		
		System.out.println(employeeDAOImp.updateEmp(employee.getEid(),employee.getEname(),employee.getjob(),employee.getSal()));
		System.out.println("Done!!!!!");
    	
    }
    break;
    
    case 3:{
    	System.out.println("Enter The eid :");
    	int eid=sc.nextInt();
    	
    	employee.setEid(eid);
    	System.out.println(employeeDAOImp.deleteEmp(employee.getEid()));
    	System.out.println("Deleted Done!!!!");
    	
    }
    break;
    case 4:{
    	
    	List employee1=employeeDAOImp.getEmployee();
    	for(Object e:employee1) {
    	
    		Employee employee11 =(Employee) e;
    		System.out.println(employee11.getEid()+" : "+employee11.getEname()+" : "+employee11.getSal()+" : "+employee11.getjob());
    	
    	}
    	
    }
    break;
    
    
	}
    
	

	}
}
}