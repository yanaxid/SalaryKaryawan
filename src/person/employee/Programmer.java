package person.employee;

import interfaces.IProgrammerAllowance;
import service.ServiceEmployee;

public class Programmer extends Employee implements IProgrammerAllowance {

	private String programmingLanguage;
	private int experiences;
	private double allowance;

	public Programmer() {
	};

	public Programmer(String name, String address, int age, String employeeId, String jobDesc, String placement,
			String programmingLanguage, int experiences) {
		super(name, address, age, employeeId, jobDesc, placement);
		this.programmingLanguage = programmingLanguage;
		this.experiences = experiences;

		setSalary(calculateSalary());
		setAllowance(calculateProgrammerAllowance());

//		System.out.println(getSalary());

	}

	@Override
	public double calculateSalary() {
		ServiceEmployee serviceEmployee = new ServiceEmployee();

		double umk = serviceEmployee.getUmkByPlacement(getPlacement());
		String className = this.getClass().getSimpleName();
		double salaryPercentage = serviceEmployee.getSalaryPercentageByEmployeeType(LIST_PERCENTAGE_SALARY, className);

		

		return salaryPercentage * umk;
	}

	@Override
	public double calculateProgrammerAllowance() {
		ServiceEmployee serviceEmployee = new ServiceEmployee();

		int allowanceCategory = serviceEmployee.defineEmployeeCategory(LIST_PRGORAMMER_EXPERIENCE_PERCENTAGE,
				getExperiences());
		double allowancePercentage = serviceEmployee.defineEmployeePercentage(LIST_PRGORAMMER_EXPERIENCE_PERCENTAGE,
				allowanceCategory);

		return allowancePercentage * getSalary();
	}

	// setget

	public String getProgrammingLanguage() {
		return programmingLanguage;
	}

	public void setProgrammingLanguage(String programmingLanguage) {
		this.programmingLanguage = programmingLanguage;
	}

	public int getExperiences() {
		return experiences;
	}

	public void setExperiences(int experiences) {
		this.experiences = experiences;
	}

	public double getAllowance() {
		return allowance;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

}
