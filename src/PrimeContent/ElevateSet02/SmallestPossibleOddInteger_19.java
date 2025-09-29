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
                if (!sc.hasNext()) return;
                String s = sc.next().trim();
                if (s.length() == 0) return;

                // Count digits
                int[] digits = new int[10];
                for (char c : s.toCharArray()) {
                    if (Character.isDigit(c)) digits[c - '0']++;
                    else {
                        // if input contains non-digit chars, ignore them (or you can exit)
                    }
                }

                // Find the largest odd digit to use as the unit digit
                int unit = -1;
                for (int d = 9; d >= 1; d -= 2) {
                    if (digits[d] > 0) {
                        unit = d;
                        digits[d]--;
                        break;
                    }
                }

                if (unit == -1) {
                    System.out.println("no");
                    return;
                }

                StringBuilder sb = new StringBuilder();

                // Append the smallest non-zero digit first (to avoid leading zeros),
                // if any non-zero digits remain.
                boolean placedFirstNonZero = false;
                for (int d = 1; d <= 9; d++) {
                    if (digits[d] > 0) {
                        sb.append((char)('0' + d));
                        digits[d]--;
                        placedFirstNonZero = true;
                        break;
                    }
                }

                // Append all remaining digits in ascending order (this will put zeros
                // right after the first non-zero digit, avoiding leading zeros).
                for (int d = 0; d <= 9; d++) {
                    while (digits[d] > 0) {
                        sb.append((char)('0' + d));
                        digits[d]--;
                    }
                }

                // Append the chosen unit digit at the end
                sb.append((char)('0' + unit));

                // Remove any leading zeros (if the entire prefix was zeros, this will shrink them).
                // This prevents answers like "003" and prints "3" instead.
                String out = sb.toString().replaceFirst("^0+(?!$)", "");

                System.out.println(out);
            }
        }