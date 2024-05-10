package person.employee;

public class EmployeePosition {
	
	private String employeePosition;
	private int salaryPercentage;
	
	
	
	
	public EmployeePosition(String employeePosition, int salaryPercentage) {
		this.employeePosition = employeePosition;
		this.salaryPercentage = salaryPercentage;
	}
	
	
	public String getEmployeePosition() {
		return employeePosition;
	}
	public void setEmployeePosition(String employeePosition) {
		this.employeePosition = employeePosition;
	}
	public int getSalaryPercentage() {
		return salaryPercentage;
	}
	public void setSalaryPercentage(int salaryPercentage) {
		this.salaryPercentage = salaryPercentage;
	}
	
	
	

}
