package menu;


import java.util.List;
import java.util.Scanner;

import person.employee.Employee;
import repo.RepoEmployee;
import repo.RepoEmployeePlacement;
import repo.RepoEmployeePosition;
import service.UserInputValidation;

public class MainMenu {

	private Scanner scanner = new Scanner(System.in);
	private UserInputValidation uiv = new UserInputValidation();
	//
	private MenuAddEmployee menuAddEmployee = new MenuAddEmployee();
	private MenuDisplayEmployees menuDisplayEmployees = new MenuDisplayEmployees();
	private MenuDataPayroll menuDataPayroll = new MenuDataPayroll();
	private MenuDeleteEmployee menuDeleteEmployee = new MenuDeleteEmployee();
	private MenuSearchEmployee menuSearchEmployee = new MenuSearchEmployee();
	private MenuEditEmployee menuEditEmployee = new MenuEditEmployee();
	//
	private RepoEmployeePosition repoEmployeePositions = new RepoEmployeePosition();
	private RepoEmployeePlacement repoEmployeePlacements = new RepoEmployeePlacement();
	private RepoEmployee repoEmployee = new RepoEmployee();
	//
	private List<Employee> repoEmployees = getRepoEmployee().getAllEmployee();

	public void mainMenuException() {
		mainMenuOptions();
	}

	public void mainMenu() {

		System.out.println("\nAPLIKASI PENDATAAN KARYAWAN\n");
		System.out.println("MAIN MENU");
		System.out.println("1. Add Employee");
		System.out.println("2. Edit Employee");
		System.out.println("3. Data Employee");
		System.out.println("4. Data Payroll");
		System.out.println("5. Delete Employee");
		System.out.println("6. Searching");
		System.out.println("0. Exit");

		mainMenuOptions();

	}

	public void mainMenuOptions() {

		System.out.print("-> ");

		int x = getUiv().validateUserInputNumber("-> ", "Inputkan harus angka!");

		switch (x) {
			case 1: {
				getMenuAddEmployee().showMenuAddEmployee(this);
				break;
			}
			case 2: {
				getMenuEditEmployee().showEditEmployee(this);
				break;
			}
			case 3: {
				getMenuDisplayEmployees().showTableEmployee(this);
				break;
			}
			case 4: {
				getMenuDataPayroll().showTablePayroll(this);
				break;
			}
			case 5: {
				getMenuDeleteEmployee().showTableDeleteEmployee(this);
				break;
			}
			case 6: {
				getMenuSearchEmployee().showTableSearchEmployee(this);
				break;
			}
			case 0: {
				break;
			}
			default: {
				displayErrorMessage("Inputan tidak sesuai daftar menu!");
				mainMenuException();
				break;
			}
		}

	}

	public void displayErrorMessage(String ErrorMessage) {
		System.out.println(String.valueOf("\u001B[31m") + ErrorMessage + String.valueOf("\u001B[0m"));
	}

	public void displaySuccessMessage(String SuccessMesaage) {
		System.out.println(String.valueOf("\u001B[32m") + SuccessMesaage + String.valueOf("\u001B[0m"));
	}

	public RepoEmployeePlacement getRepoEmployeePlacements() {
		return repoEmployeePlacements;
	}

	public RepoEmployeePosition getRepoEmployeePositions() {
		return repoEmployeePositions;
	}

	public MenuAddEmployee getMenuAddEmployee() {
		return menuAddEmployee;
	}

	public UserInputValidation getUiv() {
		return uiv;
	}

	public Scanner getScanner() {
		return scanner;
	}

	public List<Employee> getRepoEmployees() {
		return repoEmployees;
	}

	public MenuDisplayEmployees getMenuDisplayEmployees() {
		return menuDisplayEmployees;
	}

	public MenuDataPayroll getMenuDataPayroll() {
		return menuDataPayroll;
	}

	public MenuDeleteEmployee getMenuDeleteEmployee() {
		return menuDeleteEmployee;
	}

	public MenuSearchEmployee getMenuSearchEmployee() {
		return menuSearchEmployee;
	}

	public MenuEditEmployee getMenuEditEmployee() {
		return menuEditEmployee;
	}

	public RepoEmployee getRepoEmployee() {
		return repoEmployee;
	}


}
