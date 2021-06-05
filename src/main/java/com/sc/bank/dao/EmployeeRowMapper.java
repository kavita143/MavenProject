package com.sc.bank.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.sc.bank.beans.Employee;

public class EmployeeRowMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee e = new Employee();
		e.setEmpId(rs.getInt(1));
		e.setEmpSalary(rs.getInt(2));
		e.setProjectId(rs.getString(3));
		return e;
	}

}
