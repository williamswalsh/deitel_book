package car_park;

import java.time.Duration;

public class Parking {

    double minHrFee = 2.00; // Euro
    double minHrFeeDuration = 180.00; // minutes
    double maxDailyFee = 10.00; // Euro

    public static void main(String[] args) {

        // Break up using the monetization stategy
        // calcDays () Get days
        // calcHours() Get hours

        // CalcCharge( days hours minutes)
        // if minutes > 0;
        //    hours+= 1;
//        calc hourharge
        // if hours <= 3.0
//                hourCharge=minHrFee
//         else
//

        // if hours > 3.0
                // Get mins -> if minutes>0.0 Just charge based on hours otherwise charge based on hours+1
        // => * pricePerDay => 10.00
        // Summate charges -> dayCharge + hourCharge -> totalCharge
        // Display Charge
        // Enable payment options
        //
    }

    public static int calcDuration (  ){
        return 0;
    }

    public static int calcDays ( Duration duration ){
        return 0;
    }

    public static boolean IssueTicket () {
        // Create new serialUUID
        // Take image of vehicle - parallelTasks()
            // Possibly read license plate from image
            // Flag if License plate can't be detected
        // Record LocalDateTime


        // printTicket()
        // outputTicket()
        return true;
    }

    public static boolean readTicket () {
        // Record LocalDateTime
        // Read serialUUID from ticket
        return true; // isReadable;
    }

    // SerialUUID parameter
    public static boolean retrieveTicket (String uuid) {
        // Retrieve object from persistent storage using serialUUID
        return true; // isRetrievable;
    }
    public static boolean renderToUI(){
        // Render to UI
        return true; // isRenderable;
    }

    public static boolean persistTicket (Object newTicket ) {
        // Persist data object -> ORM -> DB
        return true; // isPersistable;
    }
}
