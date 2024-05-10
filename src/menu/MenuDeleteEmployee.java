package menu;

import person.employee.Employee;

public class MenuDeleteEmployee {

	public void showTableDeleteEmployee(MainMenu mainMenu) {
		
		System.out.println("\n   MENU DELETE EMPLOYEE");

		if (mainMenu.getRepoEmployees().size() == 0) {

			System.out.printf("   +--------------------------+");
			System.out.println();
			System.out.printf("   |   Data Employee Kosong   |");
			System.out.println();
			System.out.printf("   +--------------------------+\n");
			
			
			showMenuTableDeleteEmployeeException(mainMenu);

		} else {

			mainMenu.getMenuDisplayEmployees().createTableEmployee(mainMenu.getRepoEmployees());
			
			showMenuTableDeleteEmployeeOptions(mainMenu);

		}
		
	}


	public void showMenuTableDeleteEmployeeException(MainMenu mainMenu) {

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
				showTableDeleteEmployee(mainMenu);
				break;
			}
		}

	}
	
	
	public void showMenuTableDeleteEmployeeOptions(MainMenu mainMenu) {

		System.out.println("   1. Delete Employee");
		System.out.println("   0. Back");
		System.out.print("   -> ");
		int x = mainMenu.getUiv().validateUserInputNumber("   -> ", "   Inputkan harus angka!");

		switch (x) {
			
			case 1: {
				deleteEmployee(mainMenu);
				showTableDeleteEmployee(mainMenu);
				break;
			}
			case 0: {
				mainMenu.mainMenu();
				break;
			}
			default: {
				mainMenu.displayErrorMessage("   Inputan tidak sesuai daftar menu!");
				showTableDeleteEmployee(mainMenu);
				break;
			}
		}

	}

	private void deleteEmployee(MainMenu mainMenu) {
		System.out.print("   Masukan ID : ");
		String employeeId = mainMenu.getScanner().nextLine();
		
		
		Employee emp = null;
		
		for (int i = 0; i < mainMenu.getRepoEmployees().size(); i++) {
			
			if(mainMenu.getRepoEmployees().get(i).getEmployeeId().equalsIgnoreCase(employeeId)) {
				emp = mainMenu.getRepoEmployees().get(i);
			}
		}
		
		if(emp != null) {
			mainMenu.getRepoEmployees().remove(emp);
			mainMenu.displaySuccessMessage("   Berhasil menghapus " + emp.getEmployeeId());
		}else {
			mainMenu.displayErrorMessage("   Id yang anda masukan tidak terdaftar");
		}
		
		
	}

	
}
