//DP - Array Elements Equal Left & Right Sum
//The program must accept N integers and print the integers where the sum of all integers present to it's left is equal to the sum of all integers present to it's right.
//
//Note: At least one such integer is always present in the given integers.
//
//Boundary Condition(s):
//        3≤N≤10
//        6
//
//        −10
//        6
//        ≤ Each integer value ≤10
//        6
//
//
//Input Format:
//The first line contains N.
//The second line contains N integers separated by a space.
//
//Output Format:
//The first line contains the integer value(s) separated by a space.
//
//Example Input/Output 1:
//Input:
//
//        6
//        7 2 1 -5 5 5
//Output:
//
//        -5 5
//Example Input/Output 2:
//Input:
//
//        4
//        20 10 50 30
//Output:
//
//        50
//        youtube:
//        logic:https://youtu.be/F1SKWOg6GjA
//        code:https://youtu.be/KkuRz_eIc4Q


package PrimeContent.ElevateSet02;
import java.util.*;
public class DPArrayElementsEqualLeftandRightSum_24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n+1];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
            dp[i+1] = dp[i]+ arr[i];
        }
        for (int i = 0; i <n ; i++) {
            if(dp[i+1]-arr[i] == dp[n]-dp[i+1]){
                System.out.println(arr[i]);
            }
        }
    }
}
