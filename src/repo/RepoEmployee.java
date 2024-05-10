package repo;

import java.util.ArrayList;
import java.util.List;

import person.employee.Analyst;
import person.employee.Employee;
import person.employee.Programmer;
import person.employee.ProjectLeader;

public class RepoEmployee {
	
	public List<Employee> getAllEmployee(){
		
		List<Employee> employees =  new ArrayList<Employee>();
		
		Employee susi =  new Employee("Susi", "Bandung",27, "Emp-001", "Admin", "Jakarta");		
		Employee anto =  new Employee("Anto", "Bandung",35, "Emp-002", "Office Boy", "Bandung");
		Employee riman =  new Employee("Riman", "Jakarta",28, "Emp-003", "Human Resource Dev", "Bandung");
		employees.add(susi);
		employees.add(anto);
		employees.add(riman);
		
		
		Employee budi =  new Programmer("Budi", "Bandung",25, "Prog-001", "Backend Dev", "Jakarta", "Java", 2);		
		Employee ani =  new Programmer("Ani", "Bandung",30, "Prog-002", "Frontend Dev", "Bandung", "Reac Js", 6);	
		Employee ujang =  new Programmer("Ujang", "Jakarta",28, "Prog-003", "Full Stack Dev", "Bandung", "Kotlin", 4);	
		employees.add(budi);
		employees.add(ani);
		employees.add(ujang);
		
		Employee ahmad =  new ProjectLeader("Ahman", "Bandung",25, "PL-001", "Project Leader", "Garut", 2);		
		Employee dani =  new ProjectLeader("Dani", "Bandung",30, "PL-002", "Scrum Master", "Bekasi", 1);	
		Employee cecep =  new ProjectLeader("Cecep", "Jakarta",28, "PL-003", "Project Ownner", "Bogor", 4);
		employees.add(ahmad);
		employees.add(dani);
		employees.add(cecep);
		
		Employee indah =  new Analyst("Indah", "Garut",25, "AL-001", "Analyst", "Jakarta");		
		Employee puspa =  new Analyst("Puspa", "Bandung",30, "AL-002", "Analyst", "Bekasi");	
		Employee sari =  new Analyst("Sari", "Jakarta",28, "AL-003", "Analyst", "Bogor");
		employees.add(indah);
		employees.add(puspa);
		employees.add(sari);
		
		
		return employees;
		
	}

}
