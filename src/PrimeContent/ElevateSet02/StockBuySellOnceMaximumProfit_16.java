//Stock Buy & Sell Once - Maximum Profit
//
//The program must accept the stock prices on N days as the input. A person can buy a stock on a particular day and he can sell it once on any other given day. He can not buy and sell on the same day. The program must print the maximum possible profit P that can be obtained by buying and selling 1 stock once as the output.
//
//        Boundary Condition(s):
//        2 <= N <= 10^5
//        1 <= Each integer value <= 10^5
//
//Input Format:
//The first line contains N.
//The second line contains N integers separated by a space.
//
//Output Format:
//The first line contains P.
//
//Example Input/Output 1:
//Input:
//        7
//        50 100 40 60 70 50 80
//
//Output:
//        50
//
//Explanation:
//Here N = 7.
//The stock price on the 1st day is 50 and the stock price on the 2nd day is 100.
//On buying the stock on the 1st day and selling it on the 2nd day can earn the maximum profit 50 (100 - 50 = 50).
//Hence the output is 50
//
//Example Input/Output 2:
//Input:
//        10
//        15 10 60 70 45 5 70 30 100 90
//
//Output:
//        95
//        youtube:
//        logic: https://youtu.be/tXf4Vml2FYM
//        code: https://youtu.be/KwibR_lHWPY

package PrimeContent.ElevateSet02;
import java.util.*;
public class StockBuySellOnceMaximumProfit_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = arr[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else {
                int currprofit = arr[i] - min;
                if (currprofit > profit) {
                    profit = currprofit;
                }
            }
        }
        System.out.println(profit);
    }


}
