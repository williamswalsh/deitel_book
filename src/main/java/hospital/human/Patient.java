package hospital.human;


import heartrate.HeartRate;

public class Patient extends Human implements CalcMaxHeartRate{

    public Patient(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
    }
    public HeartRate heartRate;

    public HeartRate getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(HeartRate heartRate) {
        this.heartRate = heartRate;
    }

    @Override
    public double calcMaxheartRate() {
        return 220.00 - getAge();
    }
}
