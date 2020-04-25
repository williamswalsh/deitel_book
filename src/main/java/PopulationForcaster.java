package ie.william;

public class PopulationForcaster {

	public static void main(String[] args) {
		
		long currentPop = 7700000000L;
		double popGrowth = 1.14;
		int numOfYears = 20;
			
		displayPopulationForecast( currentPop, popGrowth, numOfYears );
	}
	
	
	public static void displayPopulationForecast(long currentPop, double popGrowth, int numOfYears) {
		System.out.println("Year:\tPopulation:");
		for(int year=0;year<numOfYears;year++) {
			System.out.println(year + "\t" + calcPopulation(currentPop, popGrowth, year));
		}
	}
	
	public static long calcPopulation(long currentPop, double popGrowth, int numOfYears) {
		double compiledRate = getCompiledRate( popGrowth, numOfYears);
		// calculation using double
		// result cast to long to get whole number
		return (long)(compiledRate * currentPop);
	}
	
	public static double getCompiledRate( double popGrowth, int numOfYears ) {
		return Math.pow(popGrowth, numOfYears);
	}
}
