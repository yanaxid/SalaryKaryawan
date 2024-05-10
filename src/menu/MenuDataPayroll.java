package menu;

import java.util.ArrayList;
import java.util.List;

import person.employee.Analyst;
import person.employee.Employee;
import person.employee.Programmer;
import person.employee.ProjectLeader;

public class MenuDataPayroll {

	public void showTablePayroll(MainMenu mainMenu) {

		System.out.println("\n   MENU DATA PAYROLL");

		if (mainMenu.getRepoEmployees().size() == 0) {

			System.out.printf("   +--------------------------+");
			System.out.println();
			System.out.printf("   |   Data Payroll Kosong    |");
			System.out.println();
			System.out.printf("   +--------------------------+\n");

		} else {

			createTablePayroll(mainMenu.getRepoEmployees());
		}

		System.out.println("   0. Back");

		showTablePayrollOption(mainMenu);
	}

	public void showTablePayrollException(MainMenu mainMenu) {
		showTablePayroll(mainMenu);
	}

	public void showTablePayrollOption(MainMenu mainMenu) {
		System.out.print("   -> ");
		int x = mainMenu.getUiv().validateUserInputNumber("   -> ", "   Inputkan harus angka!");

		switch (x) {
		case 0: {
			mainMenu.mainMenu();
			break;
		}
		default: {
			mainMenu.displayErrorMessage("   Inputan tidak sesuai daftar menu!");
			showTablePayroll(mainMenu);
			break;
		}
		}
	}

	public void createTablePayroll(List<Employee> employees) {

		List<String[]> dataTable = new ArrayList<>();

		int columnCount = 0;

		int no = 1;

		for (int i = 1; i < employees.size(); i++) {

		
			Employee e = employees.get(i);

			if (dataTable.size() == 0) {
				String[] tableHeading = { "No", "Employee ID", "Nama", "Placement", "Allowance", "Salary" };
				columnCount = tableHeading.length;
				dataTable.add(tableHeading);
			} else if (i == employees.size()) {

				String[] tableFooter = { "", "", "", "", "Total Payroll", "200000" };
				dataTable.add(tableFooter);
			} else {
				String allowance = "";
				if (e instanceof Programmer) {
					allowance = String.format("%,.0f", (double) ((Programmer) e).getAllowance());
				}

				else if (e instanceof ProjectLeader) {
					allowance = String.format("%,.0f", (double) ((ProjectLeader) e).getAllowance());
				}

				else if (e instanceof Analyst) {
					allowance = String.format("%,.0f", (double) ((Analyst) e).getAllowance());
				}

				else if (!(e instanceof Analyst) && !(e instanceof Programmer) && !(e instanceof ProjectLeader)) {
					allowance = "-";

				}

				String[] tableBody = { String.valueOf(no), e.getEmployeeId(), e.getName(), e.getPlacement().getCity(),
						allowance, String.format("%,.0f", (double) e.getSalary()) };
				dataTable.add(tableBody);
			}
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

			if (i == 4 || i == 5) {
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
				System.out.printf("   " + setting, dataTable.get(i)[0], dataTable.get(i)[1], dataTable.get(i)[2],
						dataTable.get(i)[3], dataTable.get(i)[4], dataTable.get(i)[5]);
				System.out.println();
				System.out.println("   " + lines);
			} else {
				System.out.printf("   " + setting, dataTable.get(i)[0], dataTable.get(i)[1], dataTable.get(i)[2],
						dataTable.get(i)[3], dataTable.get(i)[4], dataTable.get(i)[5]);
				System.out.println();
			}

		}
		System.out.println("   " + lines);
	}

}
