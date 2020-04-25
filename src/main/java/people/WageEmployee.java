package people;

public class WageEmployee extends people.Employee{

    private double wagePerHour;
    private int hoursWorked;

    // Time over which workers work to get time and a half
    private int singlePayCutoff;
    private int timeAndAHalfPayCutoff;

    public WageEmployee(String firstName, String lastName, double wagePerHour, int singlePayCutoff) {
        super(firstName, lastName);
        this.setWagePerHour(wagePerHour);
        this.setSinglePayCutoff(singlePayCutoff);
    }

    public WageEmployee(String firstName, String lastName, int age, double wagePerHour, int singlePayCutoff) {
        super(firstName, lastName, age);
        this.setWagePerHour(wagePerHour);
        this.setSinglePayCutoff(singlePayCutoff);
    }


    public WageEmployee(String firstName, String lastName, double wagePerHour) {
        super(firstName, lastName);
        this.setWagePerHour(wagePerHour);
        this.setSinglePayCutoff(40);
    }

    public WageEmployee(String firstName, String lastName, int age, double wagePerHour) {
        super(firstName, lastName, age);
        this.setWagePerHour(wagePerHour);
        this.setSinglePayCutoff(40);
    }

    public double getWagePerHour() {
        return wagePerHour;
    }

    public void setWagePerHour(double wagePerHour) {
        if ( wagePerHour > 0.0 ) {
            this.wagePerHour = wagePerHour;
        }
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public int getSinglePayCutoff() {
        return singlePayCutoff;
    }

    public void setSinglePayCutoff(int singlePayCutoff) {
        this.singlePayCutoff = singlePayCutoff;
    }

    public int getTimeAndAHalfPayCutoff() {
        return timeAndAHalfPayCutoff;
    }

    public void setTimeAndAHalfPayCutoff(int timeAndAHalfPayCutoff) {
        this.timeAndAHalfPayCutoff = timeAndAHalfPayCutoff;
    }


    public double calcWeekWage(){
        // First 40 hours * time
        // Remaining hours * timeAndHalf
        int totalHours = this.getHoursWorked();
        if (totalHours <= singlePayCutoff){
            return totalHours * this.wagePerHour;
        }

        int timeAndAHalfHours = (totalHours - singlePayCutoff);
        return (singlePayCutoff * this.wagePerHour) + (timeAndAHalfHours * wagePerHour * 1.5);
    }
}
