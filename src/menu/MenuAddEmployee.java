package menu;

import java.util.ArrayList;
import java.util.List;
import person.employee.Analyst;
import person.employee.Employee;
import person.employee.EmployeePlacement;
import person.employee.EmployeePosition;
import person.employee.Programmer;
import person.employee.ProjectLeader;

public class MenuAddEmployee {

	public void showMenuAddEmployeeException(MainMenu mainMenu) {
		showMenuAddEmployeeOptions(mainMenu);
	}

	public void showMenuAddEmployee(MainMenu mainMenu) {

		System.out.println("\n   MENU ADD EMPLOYEE\n");
		System.out.println("   1. Add Employee");
		System.out.println("   0. Back");

		showMenuAddEmployeeOptions(mainMenu);

	}

	public void showMenuAddEmployeeOptions(MainMenu mainMenu) {

		System.out.print("   -> ");
		int x = mainMenu.getUiv().validateUserInputNumber("   -> ", "   Inputkan harus angka!");

		switch (x) {
			case 1: {
				showSubMenuAddEmployee(mainMenu);
				break;
			}
			case 0: {
				mainMenu.mainMenu();
				break;
			}
			default: {
				mainMenu.displayErrorMessage("   Inputan tidak sesuai daftar menu!");
				showMenuAddEmployeeException(mainMenu);
				break;
			}
		}

	}

	public void showSubMenuAddEmployee(MainMenu mainMenu) {

		System.out.println("\n   Form add employee");
		System.out.print("   Name ----------- : ");
		
		String name = mainMenu.getScanner().nextLine();
	
		System.out.print("   Address -------- : ");
		String address = mainMenu.getScanner().nextLine();

		
		int age = inputAge(mainMenu);
		String posisi = inputPosisi(mainMenu);
		String placement = inputPlacement(mainMenu);

		if (Programmer.class.getSimpleName().equalsIgnoreCase(posisi)) {

			System.out.print("   Job Desc ------- : ");
			mainMenu.getScanner().nextLine();
			String jobDesc = mainMenu.getScanner().nextLine();

			System.out.print("   Prog Lang ------ : ");
			String progLang = mainMenu.getScanner().nextLine();

			System.out.print("   Experience ----- : ");
			int experience = mainMenu.getUiv().validateUserInputNumber("   Experience ----- : ", "   Experience diinputkan dalam angka!");

			//

			List<Programmer> programmers = new ArrayList<Programmer>();

			for (int i = 0; i < mainMenu.getRepoEmployees().size(); i++) {
				if (mainMenu.getRepoEmployees().get(i) instanceof Programmer) {
					programmers.add((Programmer) mainMenu.getRepoEmployees().get(i));
				}

			}

			String employeeId = "";
			if (programmers.size() == 0) {
				employeeId = "Prog-001";
			} else {

				int index = Integer.valueOf(programmers.get(programmers.size() - 1).getEmployeeId().substring(5)) + 1;

				if (index <= 9) {
					employeeId = "Prog-00" + String.valueOf(index);
				} else if (index >= 10) {
					employeeId = "Prog-0" + String.valueOf(index);
				} else if (index >= 100) {
					employeeId = "Prog-" + String.valueOf(index);
				}

			}

			mainMenu.getRepoEmployees().add(new Programmer(name, address, age, employeeId, jobDesc, placement, progLang, experience));
			mainMenu.displaySuccessMessage("   Berhasil add Programmer");
			showMenuAddEmployee(mainMenu);

		}

		else if (Employee.class.getSimpleName().equalsIgnoreCase(posisi)) {

			System.out.print("   Job Desc ------- : ");
			mainMenu.getScanner().nextLine();
			String jobDesc = mainMenu.getScanner().nextLine();

			//

			List<Employee> employees = new ArrayList<Employee>();

			for (int i = 0; i < mainMenu.getRepoEmployees().size(); i++) {
				if (!(mainMenu.getRepoEmployees().get(i) instanceof Programmer) && !(mainMenu.getRepoEmployees().get(i) instanceof Analyst) && !(mainMenu.getRepoEmployees().get(i) instanceof ProjectLeader)) {
					employees.add((Employee) mainMenu.getRepoEmployees().get(i));
				}
			}

			String employeeId = "";
			if (employees.size() == 0) {
				employeeId = "Emp-001";
			} else {

				int index = Integer.valueOf(employees.get(employees.size() - 1).getEmployeeId().substring(4)) + 1;

//				System.out.println("--- " + employees.get(employees.size() - 1).getEmployeeId());
//				System.out.println("--- " + index);

				if (index <= 9) {
					employeeId = "Emp-00" + String.valueOf(index);
				} else if (index >= 10) {
					employeeId = "Emp-0" + String.valueOf(index);
				} else if (index >= 100) {
					employeeId = "Emp-" + String.valueOf(index);
				}

			}

			mainMenu.getRepoEmployees().add(new Employee(name, address, age, employeeId, jobDesc, placement));
			mainMenu.displaySuccessMessage("   Berhasil add Employee");
			showMenuAddEmployee(mainMenu);

		}

		else if (ProjectLeader.class.getSimpleName().equalsIgnoreCase(posisi)) {
			System.out.print("   Job Desc ------- : ");
			mainMenu.getScanner().nextLine();
			String jobDesc = mainMenu.getScanner().nextLine();

			System.out.print("   Total Projects - : ");
			int totalProjects = mainMenu.getUiv().validateUserInputNumber("   Job Desc ------- : ", "   Total project harus angka!");

//

			List<ProjectLeader> projectLeaders = new ArrayList<ProjectLeader>();

			for (int i = 0; i < mainMenu.getRepoEmployees().size(); i++) {
				if (mainMenu.getRepoEmployees().get(i) instanceof ProjectLeader) {
					projectLeaders.add((ProjectLeader) mainMenu.getRepoEmployees().get(i));
				}

			}

			String employeeId = "";
			if (projectLeaders.size() == 0) {
				employeeId = "PL-001";
			} else {

				int index = Integer.valueOf(projectLeaders.get(projectLeaders.size() - 1).getEmployeeId().substring(3)) + 1;

				if (index <= 9) {
					employeeId = "PL-00" + String.valueOf(index);
				} else if (index >= 10) {
					employeeId = "PL-0" + String.valueOf(index);
				} else if (index >= 100) {
					employeeId = "PL-" + String.valueOf(index);
				}

			}

			mainMenu.getRepoEmployees().add(new ProjectLeader(name, address, age, employeeId, jobDesc, placement, totalProjects));

			mainMenu.displaySuccessMessage("   Berhasil add Project Leader");
			showMenuAddEmployee(mainMenu);

		}

		else if (Analyst.class.getSimpleName().equalsIgnoreCase(posisi)) {
			System.out.print("   Job Desc ------- : ");
			mainMenu.getScanner().nextLine();
			String jobDesc = mainMenu.getScanner().nextLine();

//

			List<Analyst> analyst = new ArrayList<Analyst>();

			for (int i = 0; i < mainMenu.getRepoEmployees().size(); i++) {
				if (mainMenu.getRepoEmployees().get(i) instanceof Analyst) {
					analyst.add((Analyst) mainMenu.getRepoEmployees().get(i));
				}

			}

			String employeeId = "";
			if (analyst.size() == 0) {
				employeeId = "AL-001";
			} else {

				int index = Integer.valueOf(analyst.get(analyst.size() - 1).getEmployeeId().substring(3)) + 1;

				if (index <= 9) {
					employeeId = "AL-00" + String.valueOf(index);
				} else if (index >= 10) {
					employeeId = "AL-0" + String.valueOf(index);
				} else if (index >= 100) {
					employeeId = "AL-" + String.valueOf(index);
				}
			}

			mainMenu.getRepoEmployees().add(new Analyst(name, address, age, employeeId, jobDesc, placement));
			mainMenu.displaySuccessMessage("   Berhasil add Project Leader");
			showMenuAddEmployee(mainMenu);

		}

	}

	public int inputAge(MainMenu mainMenu) {

		int age = 0;
		boolean isAgeValid = false;
		while (isAgeValid == false) {

			System.out.print("   Age ------------ : ");
			age = mainMenu.getUiv().validateUserInputNumber("   Age ------------ : ", "   Ulangi, age harus berupa angka!");
			if (age == 0) {
				mainMenu.displayErrorMessage("   Age tidak boleh 0!");
			} else {
				isAgeValid = true;
			}

		}

		return age;
	}

	public String inputPosisi(MainMenu mainMenu) {

		String posisi = "";

		System.out.println("\n   Daftar posisi");

		List<EmployeePosition> employeePositions = mainMenu.getRepoEmployeePositions().getAllRepoEmployeePositions();

		for (EmployeePosition e : employeePositions) {
			System.out.println("   - " + e.getEmployeePosition());

		}

		boolean status = false;

		System.out.print("\n   Posisi --------- : ");
//		mainMenu.getScanner().nextLine();
		posisi = mainMenu.getScanner().nextLine();
		posisi = posisi.replaceAll("\\s+", "");

		for (int i = 0; i < employeePositions.size(); i++) {

			String employeePosition = employeePositions.get(i).getEmployeePosition();
			employeePosition = employeePosition.replaceAll("\\s+", "");

			if (posisi.equalsIgnoreCase(employeePosition)) {
				status = true;
			}
		}

		while (status == false) {
			mainMenu.displayErrorMessage("   Posisi yang anda masukan tidak terdaftar!");
			System.out.print("   Posisi --------- : ");

			posisi = mainMenu.getScanner().nextLine();
			posisi = posisi.replaceAll("\\s+", "");

			for (int i = 0; i < employeePositions.size(); i++) {

				String employeePosition = employeePositions.get(i).getEmployeePosition();
				employeePosition = employeePosition.replaceAll("\\s+", "");

				if (posisi.equalsIgnoreCase(employeePosition)) {
					status = true;
				}
			}
		}

		return posisi;
	}

	public String inputPlacement(MainMenu mainMenu) {

		String placement = "";
		System.out.println("\n   Daftar Placement");
		List<EmployeePlacement> employeePlacements = mainMenu.getRepoEmployeePlacements().getAllPlacement();

		for (EmployeePlacement e : employeePlacements) {
			System.out.println("   - " + e.getCity());

		}

		boolean status = false;
		System.out.print("\n   Placement ------ : ");
		placement = mainMenu.getScanner().next();

		for (int i = 0; i < employeePlacements.size(); i++) {
			if (placement.equalsIgnoreCase(employeePlacements.get(i).getCity())) {
				status = true;
			}
		}

		while (status == false) {
			mainMenu.displayErrorMessage("   Placemen yang anda masukan tidak terdaftar!");
			System.out.print("   Placement ------ : ");
			placement = mainMenu.getScanner().next();

			for (int i = 0; i < employeePlacements.size(); i++) {

				if (placement.equalsIgnoreCase(((EmployeePlacement) employeePlacements.get(i)).getCity())) {
					status = true;
				}
			}
		}

		return placement;
	}

}
