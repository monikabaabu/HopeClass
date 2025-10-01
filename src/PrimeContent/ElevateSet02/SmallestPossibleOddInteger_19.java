//Smallest Possible Odd Integer
//
//The program must accept an integer N as the input.
// The program must print the smallest possible odd integer using all the digits in N as the output.
// If it is not possible to form such an integer, the program must print no as the output.
//
//        Boundary Condition(s):
//        10≤N≤10
//        17
//
//
//Input Format:
//The first line contains N.
//
//Output Format:
//The first line contains the smallest possible odd integer using all the digits in N or no.
//
//Example Input/Output 1:
//Input:
//        1670078423
//
//Output:
//        1002346787
//
//Explanation:
//The smallest possible odd integer using all the digits in 1670078423 is 1002346787.
//
//Example Input/Output 2:
//Input:
//        40068
//
//Output:
//no
// youtube:
//        code:https://youtu.be/gjW1nuv6tno

package PrimeContent.ElevateSet02;
import com.sun.security.jgss.GSSUtil;

import java.util.*;
public class SmallestPossibleOddInteger_19 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int[] digit = new int[10];
        while (n != 0) {
            int rem = (int) (n % 10);
            digit[rem]++;
            n = n / 10;
        }
        int unit = -1;
        for (int d = 9; d >= 1; d -= 2) {
            if (digit[d] > 0) {
                unit = d;
                digit[d]--;
                break;
            }
        }
        int num = 0;
        if (unit == -1) {
            System.out.println("no");
            return;
        } else {
            for (int d = 1; d <= 9; d++) {
                if (digit[d] > 0) {

                    digit[d]--;
                    System.out.print(d);
                    num = d;
                    break;
                }
            }
            if (num != 0) {
                for (int d = 0; d <= 9; d++) {
                    while (digit[d] > 0) {

                        System.out.print(d);
                        digit[d]--;
                    }
                }
                System.out.print(unit);
            } else {
                for (int d = 1; d <= 9; d++) {
                    while (digit[d] > 0) {

                        System.out.print(d);
                        digit[d]--;
                    }
                }
                System.out.print(unit);
            }

        }
    }
}