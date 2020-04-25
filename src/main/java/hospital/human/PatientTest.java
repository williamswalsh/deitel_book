package hospital.human;

public class PatientTest {
    public static void main(String[] args) {

        Patient patient1 = new Patient ( "Michael", "O' Hanlon", 70);
        Patient patient2 = new Patient ( "William", "Walsh", 29);
        String printStr = "Patient: %s %s, Maximum Heart Rate: %.2f\n";
        System.out.printf(printStr, patient1.getFirstName(), patient1.getLastName(), patient1.calcMaxheartRate());
        System.out.printf(printStr, patient2.getFirstName(), patient2.getLastName(), patient2.calcMaxheartRate());

    }
}
