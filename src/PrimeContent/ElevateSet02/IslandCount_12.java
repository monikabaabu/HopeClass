//The program must accept an integer matrix of size R*C containing only 1's and 0's as the input.
// The input 1 indicates land and 0 indicates water.
// The program must print the number of islands in the given matrix as the output.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically or diagonally.
//
//Boundary Condition(s):
//        3 <= R, C <= 50
//
//Input Format:
//The first line contains R and C separated by a space.
//The next R lines, each containing C integers separated by a space.
//
//Output Format:
//The first line contains the number of islands in the given matrix.
//
//Example Input/Output 1:
//Input:
//        5 6
//        0 1 0 1 1 1
//        1 0 0 1 1 1
//        1 0 0 1 0 0
//        0 0 0 1 0 1
//        0 1 1 0 0 1
//
//Output:
//        3
//
//Explanation:
//The 3 islands in the matrix are highlighted below.
//0 1 0 1 1 1
//        1 0 0 1 1 1
//        1 0 0 1 0 0
//        0 0 0 1 0 1
//        0 1 1 0 0 1
//
//Example Input/Output 2:
//Input:
//        6 4
//        0 1 1 1
//        1 0 1 0
//        1 1 1 0
//        0 0 0 1
//        0 1 1 1
//        1 1 1 1
//
//Output:
//        1
//     youtube:
//      logic:https://youtu.be/Srq5PsC9M-c
//      code:

package PrimeContent.ElevateSet02;
import java.util.*;
public class IslandCount_12 {
    private static void island(int[][] grid, int r,int c){
        if(r>=0 && c>=0 && r< grid.length && c<grid[0].length ) {
            if (grid[r][c] == 0) {
                return;
            }grid[r][c] = 0;
            island(grid, r + 1, c);
            island(grid, r - 1, c);
            island(grid, r, c + 1);
            island(grid, r, c - 1);
            island(grid, r + 1, c + 1);
            island(grid, r + 1, c - 1);
            island(grid, r - 1, c + 1);
            island(grid, r - 1, c - 1);
        }
        return;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter row:");
        int r = sc.nextInt();
        System.out.println("enter col");
        int c = sc.nextInt();
        System.out.println("enter elements");
        int[][] grid = new int[r][c];
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int count =0;
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                if(grid[i][j]==1){
                    count++;
                    island(grid,i,j);
                }
            }
        }
        System.out.println(count);
    }
}
