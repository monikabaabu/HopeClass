//DP - Maximum Sum of Sub-Arrays
//
//The program must accept an array of N integers as the input.
// The program must print the maximum sum of sub-arrays in the given array as the output.
//
//Boundary Condition(s):
//        1 <= N <= 10^6
//        -1000 <= Each integer value <= 1000
//
//Input Format:
//The first line contains N.
//The second line contains N integers separated by a space.
//
//Output Format:
//The first line contains the maximum sum of sub-arrays in the given array.
//
//Example Input/Output 1:
//Input:
//        5
//        3 2 -2 5 -4
//Output:
//        8
//Explanation:
//The sub-array with the maximum sum 8 is given below.
//3 2 -2 5
//
//Example Input/Output 2:
//Input:
//        3
//        -5 -4 -6
//Output:
//        -4

package PrimeContent.ElevateSet01;
import java.util.*;
public class DP_MaximumSumofSubArrays_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array size:");
        int n = sc.nextInt();
        System.out.println("enter elements:");
        int[] array = new int[n];
        for (int i = 0; i <n ; i++) {
            array[i] = sc.nextInt();
        }
        int curr = array[0];
        int max =array[0];
        for (int i = 1; i <n ; i++) {
            curr = Math.max(array[i], curr+array[i]);
            max = Math.max(curr,max);
        }
        System.out.println(max);
    }
}
