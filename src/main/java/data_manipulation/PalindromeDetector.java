package data_manipulation;

public class PalindromeDetector {

    public static int countDigits(int num) {
        int numLen = 0;
        while (num > 0) {

            num = num / 10;
            numLen++;
        }
        return numLen;
    }

    public static int[] breakIntoDigits(int num) {
        int digit;
        int[] arr = new int[countDigits(num)];
        int i = arr.length-1;

        while (num > 0) {
            arr[i] = num % 10;
            num /= 10;
            --i;
        }
        return arr;
    }

    public static boolean isPalindrome(int num) {
        int numLen = countDigits(num);
        int[] arr = breakIntoDigits(num);

        int i, j;
        for (i = 0, j = numLen - 1; i < Math.round(numLen / 2.0); i++, j--) {
            if (arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }

    public static void displayIsPalindrome(int num) {
        System.out.printf("Is %d a palindrome:\t%s\n", num, (isPalindrome(num)) ? "true" : "false");
    }

    public static void main(String[] args) {

        displayIsPalindrome(1245);
        displayIsPalindrome(1331);
        displayIsPalindrome(1334);
        displayIsPalindrome(12321);

    }
}
