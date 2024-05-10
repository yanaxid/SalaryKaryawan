package person.employee;

import java.util.List;

import interfaces.ISalaryCalculation;
import person.Person;
import repo.RepoEmployeePlacement;

public class Employee extends Person implements ISalaryCalculation {

	private String employeeId, jobDesc;
	private double salary;
	private EmployeePlacement placement;
	
	public Employee() {};

	public Employee(String name, String address, int age, String employeeId, String jobDesc, String placement) {
		super(name, address, age);
		this.employeeId = employeeId;
		this.jobDesc = jobDesc;
		
		RepoEmployeePlacement repoPlacements = new RepoEmployeePlacement();
		List<EmployeePlacement> placements =  repoPlacements.getAllPlacement();
		
		for (int i = 0; i < placements.size(); i++) {
			if(placements.get(i).getCity().equalsIgnoreCase(placement)) {
				this.placement = placements.get(i);
			}
		}
		
		setSalary(calculateSalary());
	}
	
	@Override
	public double calculateSalary() {
		return placement.getUmk();
	}
	
	//setget

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getJobDesc() {
		return jobDesc;
	}

	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public EmployeePlacement getPlacement() {
		return placement;
	}

	public void setPlacement(EmployeePlacement placement) {
		this.placement = placement;
	}

	

	
}
