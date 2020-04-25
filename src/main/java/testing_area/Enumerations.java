package testing_area;

public class Enumerations {
    public static void main(String[] args) {
        GameState gameState = GameState.IN_PROGRESS;
        EnumsWithFields today = EnumsWithFields.SUNDAY;
        System.out.println(today);

        // values() -> returns reference to Array
        System.out.println(today.values().length);
    }
}

enum GameState{
    WON,
    LOST,
    IN_PROGRESS
}

enum EnumsWithFields{
    MONDAY("Today is Monday"),
    TUESDAY("Today is Tuesday"),
    WEDNESDAY("Today is Wednesday"),
    THURSDAY("Today is Thursday"),
    FRIDAY("Today is Friday"),
    SATURDAY("Today is Saturday"),
    SUNDAY("Today is Sunday");

    private final String todayMessage;

    EnumsWithFields(String todayMessage){
        this.todayMessage = todayMessage;
    }
}