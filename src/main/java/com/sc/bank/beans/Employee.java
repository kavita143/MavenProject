package com.sc.bank.beans;

public class Employee {

	private Integer empId; // instance variables
	private long empSalary;
	private String projectId;

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Employee() {
		super();
	}

	public int getEmpId() {
		return empId;
	}

	public long getEmpSalary() {
		return empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empSalary=" + empSalary + ", projectId=" + projectId + "]";
	}

	public void setEmpSalary(long empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((empId == null) ? 0 : empId.hashCode());
		result = prime * result + (int) (empSalary ^ (empSalary >>> 32));
		result = prime * result + ((projectId == null) ? 0 : projectId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (empId == null) {
			if (other.empId != null)
				return false;
		} else if (!empId.equals(other.empId))
			return false;
		if (empSalary != other.empSalary)
			return false;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		return true;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public Employee(int empId, long empSalary, String projectId, String name) {
		// super(name);
		this.empId = empId;
		this.empSalary = empSalary;
		this.projectId = projectId;
	}

}
