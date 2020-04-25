package card_game;

import java.util.Random;

public class Craps {
    private static final Random r = new Random();

    private enum Status {CONTINUE, WON, LOST}

    ;

    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;

    public static void main(String[] args) {
        int runs = 100000;
        GameResult[] results = getCrapsGameResults(runs);
        //System.out.println("Average Game Duration: " + getAverageGameDuration(results));
        printWinsToLosses(results);
    }

    private static void analyseCrapsGameResults(GameResult[] results) {
        int[] winsFrequency = getWinningFrequency(results);
        int[] lossesFrequency = getLosingFrequency(results);

        System.out.println("Wins");
        displayFrequency(winsFrequency);

        System.out.println("Losses");
        displayFrequency(lossesFrequency);

        System.out.printf("Total Wins:%20d\n", sumOccurences(winsFrequency));
        System.out.printf("Total Losses:%20d\n",sumOccurences(lossesFrequency));
    }

    private static void printWinsToLosses(GameResult[] results) {

        int[] winsFrequency = getWinningFrequency(results);
        int[] lossesFrequency = getLosingFrequency(results);
        double ratio=0.0;
        for (int i = 1; i < lossesFrequency.length; i++) {
            System.out.print("Roll #" + i + ",\t\t\tWins: " + winsFrequency[i] +",\t\t\tLosses: "+ lossesFrequency[i]);
            if (lossesFrequency[i] > 0) {
                ratio = (double) winsFrequency[i] / lossesFrequency[i];
                System.out.printf(",\t\t\tRatio: %2.5f\n",ratio);
            }else{
                System.out.println();
            }
        }
    }


    private static int getAverageGameDuration(GameResult[] results) {
        long sum = 0L;
        for (int i = 0; i < results.length; i++) {
            sum += results[i].getRollCount();
        }
        return (int)(sum / results.length);
    }

    private static long sumOccurences(int[] events){
        long sum = 0L;
        for(int eventOccurences : events){
            sum += eventOccurences;
        }
        return sum;
    }

    private static void displayFrequency(int[] frequency) {
        for (int event = 0; event < frequency.length; event++) {
            System.out.println("Event#: " + event + ",\tOccurrances of event: "+ frequency[event]);
        }
    }
    
    private static int[] getWinningFrequency(GameResult[] results) {
        int[] frequency = new int[100];
        for (int index = 1; index < results.length; index++) {
            if(results[index].isGameWon()){
                frequency[results[index].getRollCount()]++;
            }
        }
        return frequency;
    }

    private static int[] getLosingFrequency(GameResult[] results) {
        int[] frequency = new int[100];
        for (int index = 0; index < results.length; index++) {
            if( !results[index].isGameWon()){
                frequency[results[index].getRollCount()]++;
            }
        }
        return frequency;
    }

    private static GameResult[] getCrapsGameResults(int runs) {
        GameResult[] gameResults = new GameResult[runs];
        for (int i = 0; i < runs; i++) {
            gameResults[i] = crapsGame();
        }
        return gameResults;
    }

    public static GameResult crapsGame() {
        int rollNumber = 1;
        int myPoint = 0;
        Status gameStatus;
        int sumOfDice = rollTwoDice();

        switch (sumOfDice) {
            case SEVEN:
            case YO_LEVEN:
                gameStatus = Status.WON;
                break;

            case SNAKE_EYES:
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST;
                break;

            default:
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;
                break;
        }

        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollTwoDice();

            if (sumOfDice == myPoint) {
                gameStatus = Status.WON;
            } else {
                if (sumOfDice == SEVEN) {
                    gameStatus = Status.LOST;
                }
            }
            rollNumber++;
        }

        if (gameStatus == Status.WON) {

            return new GameResult(rollNumber, true);
        } else {
            return new GameResult(rollNumber, false);
        }
    }

    private static int rollDie() {
        return r.nextInt(6) + 1;
    }

    private static int rollTwoDice() {
        return rollDie() + rollDie();
    }
}

class GameResult {
    private int rollCount;
    private boolean gameWon;

    public GameResult(int rollCount, boolean gameWon) {
        this.rollCount = rollCount;
        this.gameWon = gameWon;
    }

    public int getRollCount() {
        return rollCount;
    }

    public boolean isGameWon() {
        return gameWon;
    }
}
