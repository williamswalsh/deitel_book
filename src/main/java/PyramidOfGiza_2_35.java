package ie.william;

public class PyramidOfGiza_2_35 {
	public static void main(String[] args) {
		
		int yearsToBuild = 60;
		int numStones = 590712;
	
		// 17 tonnes
		double singleStone=17;
		double singleStoneKgs=17000;
		
		// How much used in a year
		double stonesPerYear = numStones / (double)yearsToBuild;
		
		// How much used in a single month
		double stonesPerMonth = numStones / (yearsToBuild * 12.0);
		
		// How much used in a day
		double stonesPerDay = numStones / (yearsToBuild * 12.0 * 365);
		
		// How much used in a hour
		double stonesPerHour = numStones / (yearsToBuild * 12.0 * 365 * 24);

		// How much used in a minute
		double stonesPerMinute = numStones / (yearsToBuild * 12.0 * 365 * 24 * 60);
		
		System.out.println("Stones per year: " + stonesPerYear + ", Mass: " + stonesPerYear * singleStone);
		System.out.println("Stones per month: " + stonesPerMonth + ", Mass: " + stonesPerMonth * singleStone);
		System.out.println("Stones per day: " + stonesPerDay + ", Mass: " + stonesPerDay * singleStone);
		System.out.println("Stones per hour: " + stonesPerHour + ", Mass: " + stonesPerHour * singleStone);
		System.out.println("Stones per minute: " + stonesPerMinute + ", Mass: " + stonesPerMinute * singleStone);
	}	
}
