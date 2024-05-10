package menu;

import java.util.ArrayList;
import java.util.List;

import person.employee.Analyst;
import person.employee.Employee;
import person.employee.EmployeePlacement;
import person.employee.Programmer;
import person.employee.ProjectLeader;

public class MenuEditEmployee {

	public void showEditEmployee(MainMenu mainMenu) {

		System.out.println("\n   MENU EDIT EMPLOYEE");

		if (mainMenu.getRepoEmployees().size() == 0) {

			System.out.printf("   +--------------------------+");
			System.out.println();
			System.out.printf("   |   Data Employee Kosong   |");
			System.out.println();
			System.out.printf("   +--------------------------+\n");

			showEditEmployeeException(mainMenu);

		} else {
			createTableEditEmployee(mainMenu.getRepoEmployees());
			showEditEmployeeOptions(mainMenu);

		}
	}

	public void showEditEmployeeException(MainMenu mainMenu) {
		System.out.println("   0. Back");
		System.out.print("   -> ");

		int x = mainMenu.getUiv().validateUserInputNumber("   -> ", "   Inputkan harus angka!");

		switch (x) {
			case 0: {
				mainMenu.mainMenu();
				break;
			}
			default: {
				mainMenu.displayErrorMessage("   Inputan tidak sesuai daftar menu!");
				showEditEmployeeException(mainMenu);
				break;
			}
		}
	}

	public void showEditEmployeeOptions(MainMenu mainMenu) {

		System.out.println("   1. Edit Employee");
		System.out.println("   0. Back");
		System.out.print("   -> ");

		int x= mainMenu.getUiv().validateUserInputNumber("   -> ", "   Inputkan harus angka!");

		switch (x) {
			case 1: {
				showSubEditEmployee(mainMenu);
				break;
			}
			case 0: {
				mainMenu.mainMenu();
				break;
			}
			default: {

				mainMenu.displayErrorMessage("   Inputan tidak sesuai daftar menu!");
				showEditEmployeeOptions(mainMenu);
				break;
			}
		}
	}

	public void showSubEditEmployee(MainMenu mainMenu) {

		System.out.print("   Masukan ID : ");
		String employeeId = mainMenu.getScanner().nextLine();

		Employee emp = null;

		for (int i = 0; i < mainMenu.getRepoEmployees().size(); i++) {

			if (mainMenu.getRepoEmployees().get(i).getEmployeeId().equalsIgnoreCase(employeeId)) {
				emp = mainMenu.getRepoEmployees().get(i);
			}
		}

		if (emp == null) {
			mainMenu.displayErrorMessage("   Id yang anda masukan tidak terdaftar");
			showSubEditEmployee(mainMenu);
		} else {
			
			List<Employee> employees = new ArrayList<Employee>();
			employees.add(emp);
			
			createTableEditEmployee(employees);

			System.out.println("   Pilih data yang akan di ubah");
			System.out.println("   1. Name");
			System.out.println("   2. Adress");
			System.out.println("   3. Age");
			System.out.println("   4. Placement");
			System.out.println("   5. Job Desc");
			System.out.println("   0. Back");
			System.out.print("   -> ");

			int x = mainMenu.getUiv().validateUserInputNumber("   -> ", "   Inputkan harus angka!");

			switch (x) {
				case 1: {
					System.out.print("   Name : " + emp.getName() + " > ");
					String name = mainMenu.getScanner().nextLine();

					String o = emp.getName();
					emp.setName(name);
					mainMenu.displaySuccessMessage("   Berhasil merubah nama "+ emp.getEmployeeId()+" : "+o+" > " +emp.getName());
					break;

				}
				case 2: {

					System.out.print("   Adress : " + emp.getAdress() + " > ");
					String address = mainMenu.getScanner().nextLine();
					String o = emp.getAdress();
					emp.setAdress(address);
					mainMenu.displaySuccessMessage("   Berhasil merubah address "+ emp.getEmployeeId()+" : "+o+" > " +emp.getAdress());
					break;
				}
				case 3: {

					System.out.print("   Age : " + emp.getAge() + " > ");
					int age = inputAgeMenuEdit(mainMenu);
					int o = emp.getAge();
					emp.setAge(age);
					mainMenu.displaySuccessMessage("   Berhasil merubah address "+ emp.getEmployeeId()+" : "+o+" > " +emp.getAge());
					break;
				}
				case 4: {

					
					EmployeePlacement placement = inputEditPlacement(mainMenu, emp);
					
					String o = emp.getPlacement().getCity();

					if (emp instanceof Programmer) {
						((Programmer) emp).setPlacement(placement);
						((Programmer) emp).setSalary(((Programmer) emp).calculateSalary());
						((Programmer) emp).setAllowance(((Programmer) emp).calculateProgrammerAllowance());;
					} else if (emp instanceof ProjectLeader) {
						((ProjectLeader) emp).setPlacement(placement);
						((ProjectLeader) emp).setSalary(((ProjectLeader) emp).calculateSalary());
						((ProjectLeader) emp).setAllowance(((ProjectLeader) emp).calculateProjectAllowance());
					} else if (emp instanceof Analyst) {
						((Analyst) emp).setPlacement(placement);
						((Analyst) emp).setSalary(((Analyst) emp).calculateSalary());
						((Analyst) emp).setAllowance(((Analyst) emp).calculateAnalystAllowance());
					} else if (!(emp instanceof Programmer) && !(emp instanceof ProjectLeader) && !(emp instanceof Analyst)) {
						emp.setPlacement(placement);
						emp.setSalary(emp.calculateSalary());
					}
					
					mainMenu.displaySuccessMessage("   Berhasil merubah placement "+ emp.getEmployeeId()+" : "+o+" > " +emp.getPlacement().getCity());
					break;

				}
				case 5:{
					System.out.print("   JobDesc : " + emp.getJobDesc() + " > ");
					String jobDesc = mainMenu.getScanner().nextLine();
					String o = emp.getJobDesc();
					emp.setJobDesc(jobDesc);
					mainMenu.displaySuccessMessage("   Berhasil merubah Jobdesc "+ emp.getEmployeeId()+" : "+o+" > " +emp.getJobDesc());
					break;
				}case 0: {
					showEditEmployee(mainMenu);
					break;
					
				}
				
				default: {
					mainMenu.displayErrorMessage("   Inputan tidak sesuai daftar menu!");
					showSubEditEmployee(mainMenu);
					break;
				}

			}
			
			for (int i = 0; i < mainMenu.getRepoEmployees().size(); i++) {
				if(mainMenu.getRepoEmployees().get(i).getEmployeeId().equalsIgnoreCase(emp.getEmployeeId())) {
					mainMenu.getRepoEmployees().get(i).setName(emp.getName());
					mainMenu.getRepoEmployees().get(i).setAdress(emp.getAdress());
					mainMenu.getRepoEmployees().get(i).setAge(emp.getAge());
					mainMenu.getRepoEmployees().get(i).setPlacement(emp.getPlacement());
					mainMenu.getRepoEmployees().get(i).setJobDesc(emp.getJobDesc());
				}
				
			}
			
			showEditEmployee(mainMenu);
		}

	}

	public int inputAgeMenuEdit(MainMenu mainMenu) {

		int age = 0;
		boolean isAgeValid = false;
		while (isAgeValid == false) {

			age = mainMenu.getUiv().validateUserInputNumber("   Age : ", "   Ulangi, age harus berupa angka!");
			if (age == 0) {
				mainMenu.displayErrorMessage("   Age tidak boleh 0!");
			} else {
				isAgeValid = true;
			}

		}

		return age;
	}

	public EmployeePlacement inputEditPlacement(MainMenu mainMenu, Employee emp) {

		EmployeePlacement employeePlacement = null;
		String placement = "";
		System.out.println("\n   Daftar Placement");
		List<EmployeePlacement> employeePlacements = mainMenu.getRepoEmployeePlacements().getAllPlacement();

		for (EmployeePlacement e : employeePlacements) {
			System.out.println("   - " + e.getCity());

		}

		boolean status = false;
		System.out.print("\n   Placement : " + emp.getPlacement().getCity() + " > ");
		placement = mainMenu.getScanner().next();

		for (int i = 0; i < employeePlacements.size(); i++) {
			if (placement.equalsIgnoreCase(employeePlacements.get(i).getCity())) {
				status = true;

				employeePlacement = employeePlacements.get(i);
			}
		}

		while (status == false) {
			mainMenu.displayErrorMessage("   Placemen yang anda masukan tidak terdaftar!");
			System.out.print("\n   Placement : " + emp.getPlacement().getCity() + " > ");
			placement = mainMenu.getScanner().next();

			for (int i = 0; i < employeePlacements.size(); i++) {

				if (placement.equalsIgnoreCase(employeePlacements.get(i).getCity())) {
					status = true;

					employeePlacement = employeePlacements.get(i);
				}
			}
		}

		return employeePlacement;
	}

	public void createTableEditEmployee(List<Employee> employees) {

		List<String[]> dataTable = new ArrayList<>();

		int columnCount = 0;

		int no = 1;
		for (Employee e : employees) {

			if (dataTable.size() == 0) {
				String[] tableHeading = { "No", "Employee ID", "Nama", "Address", "Age", "Placement", "Allowance", "Salary", "JobDesk", "Dll" };
				columnCount = tableHeading.length;
				dataTable.add(tableHeading);
			}

			String dll = "-";
			String allowance = "-";
			if (e instanceof Programmer) {
				allowance = String.format("%,.0f", (double) ((Programmer) e).getAllowance());
				dll = "Programm_Lang : " + ((Programmer) e).getProgrammingLanguage() + ", Experience : " + ((Programmer) e).getExperiences();
			}

			else if (e instanceof ProjectLeader) {
				allowance = String.format("%,.0f", (double) ((ProjectLeader) e).getAllowance());
				dll = "Total Project : " + ((ProjectLeader) e).getTotalProject();
			}

			else if (e instanceof Analyst) {
				allowance = String.format("%,.0f", (double) ((Analyst) e).getAllowance());
			}

			else if (!(e instanceof Analyst) && !(e instanceof Programmer) && !(e instanceof ProjectLeader)) {
			}

			String[] tableBody = { String.valueOf(no), e.getEmployeeId(), e.getName(), e.getAdress(), String.valueOf(e.getAge()), e.getPlacement().getCity(), allowance, String.format("%,.0f", (double) e.getSalary()), e.getJobDesc(), dll };
			dataTable.add(tableBody);
			no++;

		}

		// get column width
		int[] listColumnWidht = new int[columnCount];

		for (int x = 0; x < columnCount; x++) {
			int[] columnConten = new int[dataTable.size()];
			// get nilai per kolom
			for (int i = 0; i < dataTable.size(); i++) {
				columnConten[i] = dataTable.get(i)[x].length();
			}
			// cari nilai terbesar
			int max = 0;
			for (int i = 0; i < columnConten.length; i++) {
				if (max < columnConten[i] || max == 0) {
					max = columnConten[i];
				}
			}
			// save to list
			listColumnWidht[x] = max;

		}

		//
		String lines = "+";
		for (int i = 0; i < listColumnWidht.length; i++) {
			String line = "--";
			for (int j = 0; j < listColumnWidht[i]; j++) {
				line += "-";
			}
			lines += line + "+";
		}
		//
		String separator = "|";

		//
		String setting = "";
		for (int i = 0; i < listColumnWidht.length; i++) {

			if (i == 6 || i == 7) {
				setting += separator + " %" + listColumnWidht[i] + "s ";
			} else {
				setting += separator + " %-" + listColumnWidht[i] + "s ";
			}

		}
		setting += "|";

		//
		System.out.println("   " + lines);
		for (int i = 0; i < dataTable.size(); i++) {
			if (i == 0) {
				System.out.printf("   " + setting, dataTable.get(i)[0], dataTable.get(i)[1], dataTable.get(i)[2], dataTable.get(i)[3], dataTable.get(i)[4], dataTable.get(i)[5], dataTable.get(i)[6], dataTable.get(i)[7], dataTable.get(i)[8], dataTable.get(i)[9]);
				System.out.println();
				System.out.println("   " + lines);
			} else {
				System.out.printf("   " + setting, dataTable.get(i)[0], dataTable.get(i)[1], dataTable.get(i)[2], dataTable.get(i)[3], dataTable.get(i)[4], dataTable.get(i)[5], dataTable.get(i)[6], dataTable.get(i)[7], dataTable.get(i)[8], dataTable.get(i)[9]);
				System.out.println();
			}

		}
		System.out.println("   " + lines);
	}

}
