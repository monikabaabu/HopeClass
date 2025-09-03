//Boy Chocolate or Ice-cream
//
//A boy can have either a chocolate(C) or an ice-cream(I) on a given day.
// But to avoid catching cold, his mom has prevented him from having ice-cream on consecutive days.
// The program must print the number of ways W in which the boy can have chocolate or ice-cream over the period of N days.
//
//**Boundary Condition(s):**
//        1 <= N <= 80
//
//        **Input Format:**
//The first line contains N.
//
//**Output Format:**
//The first line contains W.
//
//**Example Input/Output 1:**
//Input:
//        3
//
//Output:
//        5
//
//        **Explanation:**
//The 5 ways to have over three days are
//        CCC
//CCI
//        CIC
//ICC
//        ICI
//
//**Example Input/Output 2:**
//Input:
//        5
//
//Output:
//        13

package PrimeContent.ElevateSet01;
import java.util.*;
public class BoyChocolateorIceCream_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of days:");
        int n = sc.nextInt();
        long[] dp = new long[n+1];
        dp[1] = 2;
        if(n>1) {
            dp[2] = 3;
        }
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
