package person.employee;

public class EmployeePlacement {
	
	private String city;
	private double umk;
	
	public EmployeePlacement() {}
	
	public EmployeePlacement(String city, double umk) {
		super();
		this.city = city;
		this.umk = umk;
	}


	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getUmk() {
		return umk;
	}

	public void setUmk(double umk) {
		this.umk = umk;
	};
	
	

}
