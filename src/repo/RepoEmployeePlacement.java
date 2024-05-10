package repo;

import java.util.ArrayList;
import java.util.List;

import person.employee.EmployeePlacement;

public class RepoEmployeePlacement {

	public List<EmployeePlacement> getAllPlacement() {

		List<EmployeePlacement> placements = new ArrayList<EmployeePlacement>();

		EmployeePlacement garut = new EmployeePlacement("Garut", 1_961_085);
		EmployeePlacement bandung = new EmployeePlacement("Bandung", 3_742_276);
		EmployeePlacement jakarta = new EmployeePlacement("jakarta", 4_453_935);
		EmployeePlacement bekasi = new EmployeePlacement("Bekasi", 4_782_935);
		EmployeePlacement bogor = new EmployeePlacement("Bogor", 4_330_249);
		
		placements.add(garut);
		placements.add(bandung);
		placements.add(jakarta);
		placements.add(bekasi);
		placements.add(bogor);

		return placements;
	}

}
