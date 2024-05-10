package person.employee;

import interfaces.IAnalystAllowance;
import service.ServiceEmployee;

public class Analyst extends Employee implements IAnalystAllowance {
	private double allowance;
	
	public Analyst() {}
	

	public Analyst(String name, String address, int age, String employeeId, String jobDesc, String placement) {
		super(name, address, age, employeeId, jobDesc, placement);
		
		setSalary(calculateSalary());
		setAllowance(calculateAnalystAllowance());
	}

	@Override
	public double calculateSalary() {
		ServiceEmployee serviceEmployee = new ServiceEmployee();

		double umk = serviceEmployee.getUmkByPlacement(getPlacement());
		double salaryPercentage = serviceEmployee.getSalaryPercentageByEmployeeType(LIST_PERCENTAGE_SALARY, this.getClass().getSimpleName());

		return salaryPercentage * umk;
	}

	@Override
	public double calculateAnalystAllowance() {
		return ANALYST_ALLOWANCE_PERCENTAGE * getSalary();
	}

	//setget

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}
	
}
