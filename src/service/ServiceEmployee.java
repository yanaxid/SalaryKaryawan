package service;

import java.util.List;

import person.employee.EmployeePlacement;
import repo.RepoEmployeePlacement;

public class ServiceEmployee {
	

	public double getUmkByPlacement(EmployeePlacement placement) {

		RepoEmployeePlacement repoPlacement = new RepoEmployeePlacement();
		List<EmployeePlacement> placements = repoPlacement.getAllPlacement();

		double umk = 0;

		for (int i = 0; i < placements.size(); i++) {
			if (placements.get(i).getCity().equalsIgnoreCase(placement.getCity())) {
				umk = placements.get(i).getUmk();
			}
		}

		return umk;
	}

	public double getSalaryPercentageByEmployeeType(String[][] listSalary, String clasName) {

		double salaryPercentage = 0;

		for (int i = 0; i < listSalary.length; i++) {
			
			if (listSalary[i][0].equalsIgnoreCase(clasName)) {
				salaryPercentage = Double.valueOf(listSalary[i][1]) / 100;
			}
		}
		return salaryPercentage;
	}

	public int defineEmployeeCategory(int[][] listCategories, int value) {

		int min = 0, max = 0, allowanceCategory = 0;

		for (int i = 0; i < listCategories.length; i++) {

			if (value >= listCategories[i][0]) {
				if (min <= listCategories[i][0] || min == 0) {
					min = listCategories[i][0];
				}
			}

			if (value <= listCategories[i][0]) {
				if (max >= listCategories[i][0] || max == 0) {
					max = listCategories[i][0];
				}
			}
		}

		if (min == 0) {
			allowanceCategory = max;
		} else {
			allowanceCategory = min;
		}

		return allowanceCategory;

	}

	public double defineEmployeePercentage(int[][] listPercentage, int value) {

		double allowancePercentage = 0;

		for (int i = 0; i < listPercentage.length; i++) {
			if (value == listPercentage[i][0]) {
				allowancePercentage = ((double) listPercentage[i][1]) / 100;
			}
		}
		return allowancePercentage;

	}

}
