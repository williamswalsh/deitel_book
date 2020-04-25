package files;

public enum MenuOptions {
    ZERO_BALANCE(1),
    CREDIT_BALANCE(2),
    DEBIT_BALANCE(3),
    END(4);

    private final int value;

    MenuOptions(int inputValue){
        value = inputValue;
    }

    public int getValue(){
        return value;
    }
}
