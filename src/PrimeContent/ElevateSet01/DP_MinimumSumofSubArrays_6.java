//DP - Minimum Sum of Sub-Arrays
//
//There are N integers passed as the input.
// The program must print the minimum possible sub-array sum S as the output.
//
//        **Boundary Condition(s):**
//        1 <= N <= 10^5
//        -1000 <= Each integer value <= 1000
//
//        **Input Format:**
//The first line contains N.
//The second line contains the N integer values separated by a space.
//
//        **Output Format:**
//The first line contains S.
//
//**Example Input/Output 1:**
//Input:
//        6
//        -5 2 9 -1 -8 -2
//
//Output:
//        -11
//
//        **Explanation:**
//The elements in a sub array must be continuous. The sub array having minimum sum is -1 -8 -2.
//
//        **Example Input/Output 2:**
//Input:
//        6
//        -5 -2 4 -1 -8 -2
//
//Output:
//        -14


package PrimeContent.ElevateSet01;
import java.util.*;
public class DP_MinimumSumofSubArrays_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array size:");
        int n = sc.nextInt();
        System.out.println("enter the elements:");
        int[] array = new int[n];
        for (int i = 0; i < n ; i++) {
            array[i] =sc.nextInt();
        }
        int curr = array[0];
        int min = array[0];
        for (int i = 1; i <n ; i++) {
            curr = Math.min(array[i], curr+array[i]);
            min = Math.min(curr,min);
        }
        System.out.println(min);
    }
}
