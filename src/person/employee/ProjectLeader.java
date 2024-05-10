package person.employee;

import interfaces.IProjectLeaderAllowance;
import service.ServiceEmployee;

public class ProjectLeader extends Employee implements IProjectLeaderAllowance {

	private int totalProject;
	private double allowance;

	public ProjectLeader() {
	}

	public ProjectLeader(String name, String adress, int age, String employeeId, String jobDesc, String placement,
			int totalProject) {
		super(name, adress, age, employeeId, jobDesc, placement);
		this.totalProject = totalProject;
		
		setSalary(calculateSalary());
		setAllowance(calculateProjectAllowance());
	}


	
	@Override
	public double calculateSalary() {
		ServiceEmployee serviceEmployee = new ServiceEmployee();

		double umk = serviceEmployee.getUmkByPlacement(getPlacement());
		double salaryPercentage = serviceEmployee.getSalaryPercentageByEmployeeType(LIST_PERCENTAGE_SALARY, this.getClass().getSimpleName());

		return salaryPercentage * umk;
	};
	
	@Override
	public double calculateProjectAllowance() {
		ServiceEmployee serviceEmployee = new ServiceEmployee();

		int allowanceCategory = serviceEmployee.defineEmployeeCategory(LIST_CURRENT_PROJECTS_PERCENTAGE,
				getTotalProject());
		double allowancePercentage = serviceEmployee.defineEmployeePercentage(LIST_CURRENT_PROJECTS_PERCENTAGE, allowanceCategory);
		
		return allowancePercentage * getSalary();
	}




	// setget

	public int getTotalProject() {
		return totalProject;
	}

	public void setTotalProject(int totalProject) {
		this.totalProject = totalProject;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

}
