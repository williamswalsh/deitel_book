package heartrate;

public class HeartRate {
    private double heartRate;

    public double getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(double heartRate) {
        if ( heartRate < 0.00 || heartRate > 500.00 ) {
            this.heartRate = heartRate;
        }
    }
}
