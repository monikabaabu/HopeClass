//Matrix - Consecutive Odd/Even Integers
//
//The program must accept an integer matrix of size RxC as the input.
// The program must print the count of the longest consecutive odd or
// consecutive even integers both vertically and horizontally present in the matrix as the output.
//
//Boundary Condition(s):
//        1 <= R, C <= 1000
//
//Input Format:
//The first line contains R and C separated by a space.
//The next R lines contain C integers each separated by a space.
//
//Output Format:
//The first line contains the count of the longest consecutive odd or even integers.
//
//Example Input/Output 1:
//Input:
//
//        4 5
//        2 1 4 5 7
//        5 4 3 2 1
//        6 1 4 8 7
//        2 1 4 7 2
//
//
//Output:
//
//        3
//
//
//Explanation:
//The longest consecutive odd integers are present at the last column in the first three rows.
//
//Example Input/Output 2:
//Input:
//
//        6 6
//        49 50 45 12 33 19
//        11 27 44 17 14 47
//        38 12 42 50 13 19
//        46 21 10 46 39 48
//        28 43 43 20 43 20
//        29 45 39 36 10 38
//
//
//Output:
//
//        4
//
//
//Explanation:
//The longest consecutive even integers are present at the 3rd row and in the columns 1, 2, 3 and 4.

package EliteTest;
import java.util.*;
public class Matrix_ConsecutiveOddEvenIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter row size:");
        int r = sc.nextInt();
        System.out.println("enter col size");
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        System.out.println("enter elements");
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int max = 1;
        for (int i = 0; i <r ; i++) {
            int count =1;
            for (int j = 1; j < c; j++) {
                if(grid[i][j]%2 == grid[i][j-1]%2){
                    count++;
                    max = Math.max(count,max);
                }
                else{
                    count=1;
                }
            }
        }
        for (int j = 0; j <c ; j++) {
            int count =1;
            for (int i = 1; i < r ; i++) {
                if(grid[i][j]%2 == grid[i-1][j]%2){
                    count++;
                    max = Math.max(count,max);
                }
                else{
                    count=1;
                }
            }
        }
        System.out.println(max);
    }
}
