package interfaces;

public interface IProjectLeaderAllowance {
	
	/**
	 * LIST_PRGORAMMER_EXPERIENCE_PERCENTAGE
	 * {total current projects , percentage}
	 */
	int[][] LIST_CURRENT_PROJECTS_PERCENTAGE = {{2, 15}, {1, 5}};
	
	double calculateProjectAllowance();

}
