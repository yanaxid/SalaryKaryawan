package repo;

import java.util.ArrayList;
import java.util.List;

import person.employee.EmployeePosition;


public class RepoEmployeePosition {

	public List<EmployeePosition> getAllRepoEmployeePositions() {
		
		List<EmployeePosition> listEmployeePositions = new ArrayList<EmployeePosition>();
		
		EmployeePosition employee = new EmployeePosition("Employee", 100);
		EmployeePosition programmer = new EmployeePosition("Programmer", 150);
		EmployeePosition projectLeader = new EmployeePosition("Project Leader", 200);
		EmployeePosition analyst = new EmployeePosition("Analyst", 160);
		
		listEmployeePositions.add(employee);
		listEmployeePositions.add(programmer);
		listEmployeePositions.add(projectLeader);
		listEmployeePositions.add(analyst);
		
		return listEmployeePositions;

	}

}
