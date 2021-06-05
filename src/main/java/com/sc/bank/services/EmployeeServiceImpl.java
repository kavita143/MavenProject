package com.sc.bank.services;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.sc.bank.beans.Employee;
import com.sc.bank.dao.EmployeeDAO;
import com.sc.bank.exceptions.DuplicateIdException;
import com.sc.bank.exceptions.IdNotFoundException;

public  class EmployeeServiceImpl implements IEmployeeService {

	
	EmployeeDAO dao = new EmployeeDAO();

	@Override
	public  Employee addEmployee(Employee e) throws DuplicateIdException {
		// TODO Auto-generated method stub
		
		return dao.addEmployee(e);
	}

	@Override
	public boolean deleteEmployee(int empId) throws  IdNotFoundException {
		// TODO Auto-generated method stub
		return dao.deleteEmployee(empId);
	}
	
	public List<Employee> displayEmployees(){
		return dao.getEmployees();
	}

	@Override
	public Employee searchEmployee(int empId) throws IdNotFoundException{
		// TODO Auto-generated method stub
		return dao.searchEmployee(empId);
	}

}
