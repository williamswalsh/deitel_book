package mathsy;

public class PythagoreanTriple {

    public static void main(String[] args) {
        //  3      4      5
        int side1, side2, hypotenuse;
        side1 = 3;
        side2 = 4;
        hypotenuse = 5;

        System.out.println("Boolean: " + isPythagoreanTriple(side1, side2, hypotenuse));

    }

    public static int calcSumOfSquares(int side1, int side2) {
        return (int) (Math.pow(side1, 2.0) + Math.pow(side2, 2.0));
    }


    public static boolean isPythagoreanTriple(int side1, int side2, int hypotenuse) {
        int sumOfSquares = calcSumOfSquares(side1, side2);
        int hypoSqrd = (int) Math.pow(hypotenuse, 2.0);

        if (sumOfSquares == hypoSqrd) {
            return true;
        }
        return false;
    }


}
