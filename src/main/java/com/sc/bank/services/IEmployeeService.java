package com.sc.bank.services;

import java.util.List;

import com.sc.bank.beans.Employee;
import com.sc.bank.exceptions.DuplicateIdException;
import com.sc.bank.exceptions.IdNotFoundException;
public interface IEmployeeService {

	public Employee  addEmployee(Employee e) throws DuplicateIdException;
	public boolean deleteEmployee(int empId) throws  IdNotFoundException;
	public List<Employee> displayEmployees();
	public Employee searchEmployee(int empId) throws IdNotFoundException;
	
}
