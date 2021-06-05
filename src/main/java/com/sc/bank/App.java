package com.sc.bank;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sc.bank.beans.Employee;
import com.sc.bank.exceptions.DuplicateIdException;
import com.sc.bank.exceptions.IdNotFoundException;
import com.sc.bank.services.EmployeeServiceImpl;
import com.sc.bank.services.IEmployeeService;

public class App {
	
		public static void main(String[] x) {
		
	      // TODO Auto-generated method stub
		IEmployeeService obj = new EmployeeServiceImpl();
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.println("please enter 1 to add new customer "
					+ "\nenter 2 to delete the employee"
					+ "\nenter 3 to display all employees"
					+ "\nenter 4 to search the employee"
					+ "\nenter 5 to exit the application");
			int option = s.nextInt();
			switch (option) {

			case 1:
				System.out.println("add new employee");
				Employee h = new Employee();
				System.out.println("enter project id");
				h.setProjectId(s.next());
				System.out.println("enter empid");
				h.setEmpId(s.nextInt());
				System.out.println("enter emp salary");
				h.setEmpSalary(s.nextLong());
				try {
					h = obj.addEmployee(h);
				} catch (DuplicateIdException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(e.getMessage());
					System.out.println("inside catch");
				}
				break;
			case 2:
				System.out.println("delete the employee");
				System.out.println("enter empid");
				int id = s.nextInt();
				try {
					obj.deleteEmployee(id);
				} catch (IdNotFoundException e1) {
					e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
				
				break;
			case 3:
				System.out.println("display employees");
				List<Employee> list=obj.displayEmployees();
				for(Employee e:list)
				{
					System.out.println(e);
				}
				break;
				
			case 4:
				System.out.println("please enter id");
				int empId= s.nextInt();
				try {
					System.out.println(obj.searchEmployee(empId));
				} catch (IdNotFoundException e1) {
					e1.printStackTrace();
				}
				break;
			case 5:
				System.exit(1);

			}
		}

	}

}

