//Iterations Count All Zero
//
//The program must accept an integer matrix of size R*C and an integer K as the input.
// For each occurrence of K in the matrix, the program must replace K and all the
// adjacent non-zero cell values with zero which are to it's left, right, top and bottom.
// The program must repeat the process untill all the values become zero.
// The program must print how many times the process has to be performed to convert all the cell values to zero.
//
//Boundary Condition(s):
//        2 <= R, C <= 50
//
//Input Format:
//The first line contains R and C separated by a space.
//The next R lines, each containing C integers separated by a space.
//The (R+2)^nd line contains K.
//
//Output Format:
//The first line contains an integer representing the number of times the above process has to be performed to convert all the cell values to zero.
//
//Example Input/Output 1:
//Input:
//        5 5
//        5 6 0 5 6
//        1 8 8 0 2
//        5 5 5 0 6
//        4 5 5 5 0
//        8 8 8 8 8
//        6
//Output:
//        2
//
//Explanation:
//After performing the process for the first occurrence of 6, the matrix becomes
//0 0 0 5 6
//        0 0 0 0 2
//        0 0 0 0 6
//        0 0 0 0 0
//        0 0 0 0 0
//After performing the process for the second occurrence of 6, the matrix becomes
//0 0 0 0 0
//        0 0 0 0 0
//        0 0 0 0 0
//        0 0 0 0 0
//        0 0 0 0 0
//Now, all the cell values in the matrix become zero.
//Hence the output is 2
//
//Example Input/Output 2:
//Input:
//        4 5
//        5 0 0 5 6
//        1 0 8 1 0
//        0 5 0 0 6
//        4 5 0 5 2
//        5
//
//Output:
//      4
//   youtube:
//        logic:https://youtu.be/ZeLqTTEVlTc
//        code:https://youtu.be/6Bg4wugczH0

package PrimeContent.ElevateSet02;
import java.util.*;
public class IterationsCountAllZero_11 {
    private static void find(int[][] grid,int r, int c){
        if(r>=0 && r< grid.length && c>=0 && c<grid[0].length){
            if(grid[r][c] == 0){
                return;
            }
            grid[r][c] =0;
            find(grid, r+1, c);
            find(grid, r, c+1);
            find(grid, r-1, c);
            find(grid, r, c-1);
        }
        return;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter row size");
        int r = sc.nextInt();
        System.out.println("enter col size");
        int c = sc.nextInt();
        System.out.println("enter elements:");
        int[][] grid = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j]=sc.nextInt();
            }
        }
        System.out.println("enter k value:");
        int k = sc.nextInt();
        int count=0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]==k){
                    count++;
                    find(grid,i,j);
                    }
                }
            }

        System.out.println(count);
    }
}
