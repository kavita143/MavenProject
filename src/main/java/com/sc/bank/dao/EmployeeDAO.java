package com.sc.bank.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.sc.bank.AppConfig;
import com.sc.bank.beans.Employee;
import com.sc.bank.exceptions.DuplicateIdException;
import com.sc.bank.exceptions.IdNotFoundException;

public class EmployeeDAO {
	
	private JdbcTemplate jdbcTemplate;

	public EmployeeDAO() {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		jdbcTemplate = context.getBean(JdbcTemplate.class);
	}

	public Employee addEmployee(Employee e) throws DuplicateIdException {

		String sql1 = "select * from employee where emp_id=?";

		List<Employee> l = jdbcTemplate.query(sql1, new EmployeeRowMapper(), e.getEmpId());

		if (l.size() == 0) {
			String sql2 = "insert into employee values(?,?,?)";
			jdbcTemplate.update(sql2, e.getEmpId(), e.getEmpSalary(), e.getProjectId());
			return e;
		} else
			throw new DuplicateIdException("Id already exist");
	}

	public boolean deleteEmployee(int empId) throws IdNotFoundException {
		String sql = "delete from employee where emp_id=?";
		int i = jdbcTemplate.update(sql, empId);
		if (i == 0)
			throw new IdNotFoundException("Id does not exist");
		else
			return true;
	}

	public Employee updateEmployeeDetails(Employee e) {
		String sql = "update employee set emp_salary=? and project_id=? where emp_id=?";
		jdbcTemplate.update(sql, e.getEmpSalary(), e.getProjectId(), e.getEmpId());
		return e;
	}

	public List<Employee> getEmployees() {
		System.out.println(jdbcTemplate);

		String sql = "select * from employee";
		return jdbcTemplate.query(sql, new EmployeeRowMapper());
	}

	public Employee searchEmployee(int empId) throws IdNotFoundException {

		String sql1 = "select * from employee where emp_id=?";

		List<Employee> l = jdbcTemplate.query(sql1, new EmployeeRowMapper(), empId);

		if (l.size() == 0)
			throw new IdNotFoundException("id is not present");
		else

			return l.get(0);

	}

}
