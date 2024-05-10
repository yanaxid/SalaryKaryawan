package interfaces;


public interface ISalaryCalculation {

	String[][] LIST_PERCENTAGE_SALARY = { 
			{ "Employee", "100" }, 
			{ "Programmer", "150" }, 
			{ "ProjectLeader", "200" },
			{ "Analyst", "160" }
	};

	double calculateSalary();
}
