//Maximum Sum - K*K Sub-Matrix
//
//The program must accept an integer matrix of size R*C and an integer K as the input.
// The program must print the sum of integers in the K*K sub-matrix which has the maximum
// sum among the all possible K*K sub-matrices in the given R*C matrix as the output.
//
//        Boundary Condition(s):
//        2 <= R, C <= 1000
//        2 <= K <= R and C
//
//Input Format:
//The first line contains R and C separated by a space.
//The next R lines, each containing C integers separated by a space.
//The (R+2)nd line contains K.
//
//Output Format:
//The first line contains S.
//
//Example Input/Output 1:
//Input:
//        4 5
//        10 20 80 40 55
//        90 50 90 200 65
//        60 20 5 20 12
//        10 50 40 60 8
//        3
//Output:
//        567
//
//Explanation:
//The 3*3 sub-matrix which has the maximum sum is given below.
//80 40 55
//        90 200 65
//        5 20 12
//
//Example Input/Output 2:
//Input:
//        4 3
//        4 9 8
//        2 4 4
//        5 7 3
//        7 6 8
//        2
//Output:
//        25
//        youtube:
//        logic:https://youtu.be/c033YjJMO0w
//        code:https://youtu.be/8lWruKXUcVU

package PrimeContent.ElevateSet02;
import java.util.*;
public class MaximumSumKKSubMatrix_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid = new int[r][c+1];
        for (int i = 0; i < r; i++) {
            for (int j = 1; j <=c ; j++) {
                grid[i][j] = sc.nextInt();
                grid[i][j]+= grid[i][j-1];
            }
        }
        int k = sc.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <=r-k ; i++) {
            for (int j = 1; j <=c-k+1 ; j++) {
                int sum = 0;
                for (int srow = i; srow <i+k ; srow++) {
                    sum+= grid[srow][j+k-1]- grid[srow][j-1];

                }
                if(sum>max){
                    max = sum;
                }
            }
        }
        System.out.println(max);
    }
}
