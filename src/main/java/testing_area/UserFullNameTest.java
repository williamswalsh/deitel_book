package testing_area;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class UserFullNameTest {

    public static void main(String[] args) {

        String userFullName = "William Walsh";
        String userFirstName = null;

        // If user userFullName is null -> ""
        // If userFirstName is null -> userFullName

        // Most likely case -> 11 10 01 00


//        userFullName=userFullName!"" - done

//        userFirstName=userFirstName!userFullName


//        userFullName=userFullName!userFirstName

        UserFullNameTest test = new UserFullNameTest();
        UserFullNameTest.X x = test.new X();
        X myX = test.new X();
    }

    void method(String full, String first) {
        if (full == null && first != null) {            // 01
            full = first;
        } else if (full != null && first == null) {     // 10
            first = full;
        } else if (full == null && first == null) {     // 00
            full = first = "";
        } else {
            // 11
        }
    }

    protected Map<String, Object> mapUserParams() {
        final Map<String, Object> retval = new HashMap<>();

        retval.put("userFullName", ("william walsh" == null) ? "" : "william walsh");
        retval.put("userFirstName", ("william" == null) ? "william walsh" : "william");

        // Easier to read
//        String userFullName = (params.getUserFullName() != null) ? params.getUserFullName(): "";
//        String userFirstName = (params.getUserFirstName() != null) ? params.getUserFirstName(): userFullName;
//
//        String userFullName2 = (params.getUserFullName() == null) ? "" : params.getUserFullName();
//        String userFirstNam2 = (params.getUserFirstName() == null) ? userFullName : params.getUserFirstName();

//        retval.put("userFullName", userFullName);
//        retval.put("userFirstName", userFirstName);


        return retval;
    }

    private final class X{
        public int y;
    }
}
