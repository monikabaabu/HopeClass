//**Problem: Path - Top Left to Bottom Right**
//
//The program must accept a matrix of size **R** x **C**.
// The matrix contains only **1**'s and **0**'s.
// The cell value **1** indicates the presence of a **path**.
// The cell value **0** indicates the presence of a **stone** (i.e., no path).
// The movement from one cell to another can be to the **right** or **bottom** directions.
// The program must print **yes** if there is a path from the **top left** cell to the **bottom right** cell
// and also the number of paths available. Else the program must print **no** as the output.
//
//**Boundary Condition(s):**
//        2 <= **R**, **C** <= 15
//
//        **Input Format:**
//The first line contains **R** and **C** separated by a space.
//The next **R** lines, each contains **C** integers separated by a space.
//
//**Output Format:**
//The first line contains the string value "**yes**" followed by the number of paths available or the string value "**no**".
//
//        **Example Input/Output 1:**
//        **Input:**
//        4 5
//        1 1 1 1 0
//        0 1 0 1 1
//        1 1 0 1 0
//        1 1 1 1 1
//
//        **Output:**
//yes 2
//
//        **Explanation:**
//There are **2 paths** from the top left cell to the bottom right cell.
//The path 1 is highlighted below.
//1 1 1 1 0
//        0 1 0 1 1
//        1 1 0 1 0
//        1 1 1 1 1
//The path 2 is highlighted below.
//1 1 1 1 0
//        0 1 0 1 1
//        1 1 0 1 0
//        1 1 1 1 1
//
//        **Example Input/Output 2:**
//        **Input:**
//        4 5
//        1 1 1 1 0
//        0 1 0 1 1
//        1 1 0 1 1
//        1 1 1 1 1
//
//        **Output:**
//yes 4
//
//        **Example Input/Output 3:**
//        **Input:**
//        4 5
//        1 1 1 1 0
//        0 1 0 0 1
//        1 1 0 1 1
//        1 1 0 1 1
//
//        **Output:**
//no

package PrimeContent.ElevateSet01;
import java.util.*;
public class Path_TopLefttoBottomRight_3 {
    private static int findpath(int[][] grid, int r, int c){
        if(r==grid.length-1 && c == grid[0].length-1 && grid[r][c] == 1){
            return 1;
        }
        if(r<0 || r>= grid.length || c<0 || c>= grid[0].length || grid[r][c] == 0){
            return 0;
        }
         int  temp = grid[r][c];
        grid[r][c] = 3;
        int result = findpath(grid,r+1,c) + findpath(grid,r,c+1);
        grid[r][c] = temp;
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter row size:");
        int r = sc.nextInt();
        System.out.println("enter col size:");
        int c = sc.nextInt();
        int[][] grid = new int[r][c];
        System.out.println("enter elements");
        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int res =0;
        res = findpath(grid,0,0);
        if(res>0) {
            System.out.println("yes "+res);
        }
        else{
            System.out.println("no");
        }
    }
}
