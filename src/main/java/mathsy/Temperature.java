package mathsy;

public class Temperature {

    private static double convertToCelcius ( double degreesFarenheit ){
        return 5.0 / 9.0 * ( degreesFarenheit - 32 );
    }

    private static double convertToFarenheit ( double degreesCelcius ){
        return ( 9.0 / 5.0 * degreesCelcius ) + 32 ;
    }


    public static void main(String[] args) {
        printLoop();
    }

    private static void printLoop (){
        for (int celcius = -50; celcius < 150; celcius++) {

            // Print to 2 decimal places -> %.2f
            System.out.printf("%.2f°C,\t%.2f°F\n",(double)celcius, convertToFarenheit(celcius));
        }
    }
}
