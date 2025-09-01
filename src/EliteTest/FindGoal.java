//Two boys A and B are inside a grid where '1' denotes a block.
// There is a gold mine denoted by G in the grid.
//Print A if only A can reach the gold mine.
//Print B if only B can reach.
//Print BOTH If both A and B can reach.
//Print NONE if both A and B cannot reach.
//A can move in bottom, right directions.
//B can move in top, left directions.
//Boundary Condition(s):
//Example Input/Output 1:
//         Input:
//               6  7
//               A000011
//               0000000
//               1000001
//               100G011
//               0000000
//               000001B
//         Output:
//                BOTH

package EliteTest;
import java.util.*;
public class FindGoal {
    private static boolean findA(char[][] grid, int r , int c, boolean[][] visitedA){
        if(r<0 || r>= grid.length || c<0 || c>= grid[0].length || grid[r][c] == '1' || visitedA[r][c]){
            return false;
        }
        if(grid[r][c] == 'G'){
            return true;
        }
        visitedA[r][c] = true;
        boolean foundA = findA(grid, r+1, c,visitedA) || findA(grid, r, c+1,visitedA);

        return foundA;
    }
    private static boolean findB(char[][] grid, int r , int c, boolean[][] visitedB){
        if(r<0 || r>= grid.length || c<0 || c>= grid[0].length || grid[r][c] == '1'|| visitedB[r][c]){
            return false;
        }
        if(grid[r][c] == 'G'){
            return true;
        }
        visitedB[r][c] = true;
        boolean foundB = findB(grid, r-1, c,visitedB) || findB(grid, r, c-1,visitedB);

        return foundB;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter row:");
        int r = sc.nextInt();
        System.out.println("enter column:");
        int c = sc.nextInt();
        System.out.println("enter elements:");
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <c ; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        boolean resA = false;
        boolean resB = false;
        boolean[][] visitedA = new boolean[r][c];
        boolean[][] visitedB= new boolean[r][c];
        for (int i = 0; i < r ; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 'A') {
                    resA = findA(grid, i, j,visitedA);
                }
                else if (grid[i][j] == 'B'){
                    resB = findB(grid, i,j,visitedB);
                }
            }
        }
        if( resA && resB){
            System.out.println("BOTH");
        } else if (resA) {
            System.out.println("A");
        }
        else if(resB){
            System.out.println("B");
        }
        else {
            System.out.println("NONE");
        }
    }
}
