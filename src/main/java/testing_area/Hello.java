package testing_area;

public class Hello {
    public static void main(String[] args) {

        Car[] cars = new Car[3];
        System.out.println(cars.length);


    }
}
// Tic Tac Toe
// MIN Move amt 0 1 0 1 0
// MAX Move amt 0 1 0 1 0 1 0 1 0

class Car{
    int bhp;
    public Car(int bhp) {
        this.bhp = bhp;
    }

    public int getBhp() {
        return bhp;
    }

    public void setBhp(int bhp) {
        this.bhp = bhp;
    }
}