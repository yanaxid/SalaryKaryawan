package menu;

import java.util.ArrayList;
import java.util.List;

import person.employee.Analyst;
import person.employee.Employee;
import person.employee.Programmer;
import person.employee.ProjectLeader;

public class MenuDisplayEmployees {

	public void showTableEmployee(MainMenu mainMenu) {

		System.out.println("\n   MENU DATA EMPLOYEE");

		if (mainMenu.getRepoEmployees().size() == 0) {

			System.out.printf("   +--------------------------+");
			System.out.println();
			System.out.printf("   |   Data Employee Kosong   |");
			System.out.println();
			System.out.printf("   +--------------------------+\n");

		} else {

			createTableEmployee(mainMenu.getRepoEmployees());
		}

		System.out.println("   0. Back");

		showDataTableEmployeeOptions(mainMenu);
	}

	public void showTableEmployeeException(MainMenu mainMenu) {
		showTableEmployee(mainMenu);
	}

	public void showDataTableEmployeeOptions(MainMenu mainMenu) {

		System.out.print("   -> ");
		int x = mainMenu.getUiv().validateUserInputNumber("   -> ", "   Inputkan harus angka!");

		switch (x) {
			case 0: {
				mainMenu.mainMenu();
				break;
			}
			default: {
				mainMenu.displayErrorMessage("   Inputan tidak sesuai daftar menu!");
				showTableEmployee(mainMenu);
				break;
			}
		}

	}

	public void createTableEmployee(List<Employee> employees) {

		List<String[]> dataTable = new ArrayList<>();

		int columnCount = 0;

		int no = 1;
		for (Employee e : employees) {

			if (dataTable.size() == 0) {
				String[] tableHeading = { "No", "Employee ID", "Nama", "Address", "Age", "Placement", "JobDesk", "Dll" };
				columnCount = tableHeading.length;
				dataTable.add(tableHeading);
			}

			String dll = "-";

			if (e instanceof Programmer) {
				dll = "Programm_Lang : " + ((Programmer) e).getProgrammingLanguage() + ", Experience : " + ((Programmer) e).getExperiences();
			}

			else if (e instanceof ProjectLeader) {
				dll = "Total Project : " + ((ProjectLeader) e).getTotalProject();
			}

			String[] tableBody = { String.valueOf(no), e.getEmployeeId(), e.getName(), e.getAdress(), String.valueOf(e.getAge()), e.getPlacement().getCity(), e.getJobDesc(), dll };
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

			setting += separator + " %-" + listColumnWidht[i] + "s ";

		}
		setting += "|";

		//
		System.out.println("   " + lines);
		for (int i = 0; i < dataTable.size(); i++) {
			if (i == 0) {
				System.out.printf("   " + setting, dataTable.get(i)[0], dataTable.get(i)[1], dataTable.get(i)[2], dataTable.get(i)[3], dataTable.get(i)[4], dataTable.get(i)[5], dataTable.get(i)[6],
						dataTable.get(i)[7]);
				System.out.println();
				System.out.println("   " + lines);
			} else {
				System.out.printf("   " + setting, dataTable.get(i)[0], dataTable.get(i)[1], dataTable.get(i)[2], dataTable.get(i)[3], dataTable.get(i)[4], dataTable.get(i)[5], dataTable.get(i)[6],
						dataTable.get(i)[7]);
				System.out.println();
			}
		}
		System.out.println("   " + lines);
	}
}
