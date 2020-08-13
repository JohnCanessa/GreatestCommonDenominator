import java.util.Arrays;
import java.util.Scanner;


/**
 * Greatest Common Divisor
 */
class Solution {


    /**
     * Find the GCD of the integers in the specified array.
     */
    static int findGCD(int[] arr) {

        // **** ****
        int result = 0;

        // **** loop through the elements in the array O(n) ****
        for (int e : arr) {

            // **** compute the GDC between the current value and the next value in the array  ****
            result = gcd(result, e);

            // **** for optimization ****
            if (result == 1) {
                return 1;
            }
        }

        // **** ****
        return result;
    }


    /**
     * Find the GCD of the specified integers.
     * Recursive function.
     */
    static int gcd(int a, int b) {

        // **** end condition ****
        if (a == 0)
            return b;

        // **** recursive call ****
        return gcd(b % a, a);
    }


    /**
     * Iterative GCD approach.
     */
    static int iterativeGCD(int[] arr) {

        // **** ****
        int b;
        int r;

        // **** first value to use ****
        int a = arr[0];

        // **** loop once per pair of values ****
        for (int i = 1; (i < arr.length) && (a > 1); i++) {

            // **** current value to use ****
            b = arr[i];

            // **** gcd for these two values ****
            while (b != 0) {
                r = a % b;
                a = b;
                b = r;
            }
        }

        // **** return the gcd ****
        return a;
    }


    /**
     * Finding the GCD by subtraction.
     */
    static int subtractingGCD(int[] arr) {

        // **** ****
        int b;

        // **** first value to use ****
        int a = arr[0];

        // **** loop once per pair of values ****
        for (int i = 1; (i < arr.length) && (a > 1); i++) {

            // **** current value to use ****
            b = arr[i];

            // **** gcd for these two values ****
            while (a != b) {
                if (a > b) {
                    a -= b;
                } else {
                    b -= a;
                }
            }
        }

        // **** return the gcd ****
        return a;
    }


    /**
     * Test scaffolding.
     */
    public static void main(String[] args) {
        
        // **** open scanner ****
        Scanner sc = new Scanner(System.in);

        // **** read n ****
        int n = sc.nextInt();

        // ???? ????
        System.out.println("main <<< n: " + n);

        // **** array of integers ****
        int[] arr = new int[n];

        // **** loop reading values ****
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // **** close scanner ****
        sc.close();

        // ???? ????
        System.out.println("main <<< arr: " + Arrays.toString(arr));

        // **** find and display the GCD for the specified array ****
        System.out.println("main <<<        findGCD: " + findGCD(arr));

        // **** find and display the GCD for the specified array ****
        System.out.println("main <<<   iterativeGCD: " + iterativeGCD(arr));

        // **** find and display the GCD for the specified array ****
        System.out.println("main <<< subtractingGCD: " + subtractingGCD(arr));
    }

}