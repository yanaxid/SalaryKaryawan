package menu;

import java.util.ArrayList;
import java.util.List;

import person.employee.Employee;

public class MenuSearchEmployee {

	public void showTableSearchEmployee(MainMenu mainMenu) {
		System.out.println("\n   MENU SEARCH EMPLOYEE");
		showMenuTableSearchEmployeeOptions(mainMenu);
	}

	public void showMenuTableSearchEmployeeException(MainMenu mainMenu) {

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
				showTableSearchEmployee(mainMenu);
				break;
			}
		}

	}

	public void showMenuTableSearchEmployeeOptions(MainMenu mainMenu) {

		System.out.println("   1. Search by Placement");
		System.out.println("   0. Back");
		System.out.print("   -> ");
		int x = mainMenu.getUiv().validateUserInputNumber("   -> ", "   Inputkan harus angka!");

		switch (x) {

			case 1: {
				searchEmployee(mainMenu);
				showTableSearchEmployee(mainMenu);
				break;
			}
			case 0: {
				mainMenu.mainMenu();
				break;
			}
			default: {
				mainMenu.displayErrorMessage("   Inputan tidak sesuai daftar menu!");
				showTableSearchEmployee(mainMenu);
				break;
			}
		}

	}

	private void searchEmployee(MainMenu mainMenu) {

		System.out.print("   Masukan Placement : ");
		String placement = mainMenu.getScanner().nextLine();

		List<Employee> employees = new ArrayList<Employee>();

		for (int i = 0; i < mainMenu.getRepoEmployees().size(); i++) {

			if (mainMenu.getRepoEmployees().get(i).getPlacement().getCity().equalsIgnoreCase(placement)) {
				employees.add(mainMenu.getRepoEmployees().get(i));
			}
		}

		if(employees.size() > 0){
			mainMenu.getMenuDisplayEmployees().createTableEmployee(employees);
		}else {
			mainMenu.displayErrorMessage("   Placement yang anda masukan tidak ada");
		}
		
	}

	

}
