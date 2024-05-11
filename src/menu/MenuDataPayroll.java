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
		double totalSalary = 0;
		double totalAlowance = 0;
		
		for (int i = 0; i < employees.size(); i++) {

			Employee e = employees.get(i);

			if (dataTable.size() == 0) {
				String[] tableHeading = { "No", "Employee ID", "Nama", "Placement", "Allowance", "Salary" };
				columnCount = tableHeading.length;
				dataTable.add(tableHeading);
			}

			String allowance = "";
			if (e instanceof Programmer) {
				allowance = String.format("%,.0f", (double) ((Programmer) e).getAllowance());
				totalAlowance += ((Programmer) e).getAllowance();
			}

			else if (e instanceof ProjectLeader) {
				allowance = String.format("%,.0f", (double) ((ProjectLeader) e).getAllowance());
				totalAlowance += ((ProjectLeader) e).getAllowance();
			}

			else if (e instanceof Analyst) {
				allowance = String.format("%,.0f", (double) ((Analyst) e).getAllowance());
				totalAlowance += ((Analyst) e).getAllowance();
			}

			else if (!(e instanceof Analyst) && !(e instanceof Programmer) && !(e instanceof ProjectLeader)) {
				allowance = "-";

			}

			String[] tableBody = { String.valueOf(no), e.getEmployeeId(), e.getName(), e.getPlacement().getCity(), allowance, String.format("%,.0f", (double) e.getSalary()) };
			dataTable.add(tableBody);

			totalSalary += e.getSalary();
			
			
			
			if (dataTable.size() > employees.size()) {

				String[] tableHeading = { "", "", "", "", "Total Payroll", String.format("%,.0f", (double) totalSalary + totalAlowance) };
				dataTable.add(tableHeading);
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
				System.out.printf("   " + setting, dataTable.get(i)[0], dataTable.get(i)[1], dataTable.get(i)[2], dataTable.get(i)[3], dataTable.get(i)[4], dataTable.get(i)[5]);
				System.out.println();
				System.out.println("   " + lines);
			} else if (i > 0 && i < dataTable.size() - 1) {

				System.out.printf("   " + setting, dataTable.get(i)[0], dataTable.get(i)[1], dataTable.get(i)[2], dataTable.get(i)[3], dataTable.get(i)[4], dataTable.get(i)[5]);
				System.out.println();
			} else if (i == dataTable.size() - 1) {
				
				
				String settingExtended = "";
				for (int x = 0; x < listColumnWidht.length; x++) {

					if (x == 5 || x == 6) {
						settingExtended += "|" + " %" + listColumnWidht[x] + "s |";
					}else if (x == 0) {
						settingExtended += "|" + " %" + listColumnWidht[x] + "s ";
					}
					
					else {
						settingExtended += " " + " %" + listColumnWidht[x] + "s ";
					}
				}


				System.out.println("   " + lines);
				System.out.printf("   " + settingExtended, dataTable.get(i)[0], dataTable.get(i)[1], dataTable.get(i)[2], dataTable.get(i)[3], dataTable.get(i)[4], dataTable.get(i)[5]);
				System.out.println();
			}

		}
		
		
		
		String linesExtended = "+";
		for (int x = 0; x < listColumnWidht.length; x++) {
			String line = "--";
			for (int j = 0; j < listColumnWidht[x]; j++) {
				line += "-";
			}
			
			if(x == listColumnWidht.length -1 || x == listColumnWidht.length -2) {
				linesExtended += line + "+";
			} 
			
			else {
				linesExtended += line + "-";
			}
			
		}
		System.out.println("   " + linesExtended);
	}

}
