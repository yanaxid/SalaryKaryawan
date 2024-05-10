package interfaces;

public interface IProgrammerAllowance {
	
	/**
	 * LIST_PRGORAMMER_EXPERIENCE_PERCENTAGE
	 * {category , percentage}
	 */
	int[][] LIST_PRGORAMMER_EXPERIENCE_PERCENTAGE = {{5, 20}, {4, 10}};
	
	double calculateProgrammerAllowance();

}
