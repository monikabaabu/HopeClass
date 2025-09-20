//Path Exists from Source to Destination Cell
//
//The program must accept a matrix of size R*C and the indices of two cells (Source and Destination) in the matrix as the input.
// The matrix contains only 1's and 0's. The cell value 1 indicates the presence of a path.
// The cell value 0 indicates the presence of a stone (i.e., no path).
// The movement from one cell to another can be in the left, right, bottom and top directions.
// The program must print yes if there is a path from the given source cell to the destination cell.
// Else the program must print no as the output.
//
//        Boundary Condition(s):
//        2 <= R, C <= 50
//
//Input Format:
//The first line contains R and C separated by a space.
//The next R lines, each containing C integers separated by a space.
//The (R+2)^th line contains two integers representing the indices of the source cell.
//The (R+3)^th line contains two integers representing the indices of the destination cell.
//
//Output Format:
//The first line contains yes or no.
//
//Example Input/Output 1:
//Input:
//        4 5
//        1 0 1 1 0
//        0 1 0 1 1
//        1 1 0 1 0
//        1 1 1 1 1
//        1 1
//        1 4
//Output:
//yes
//
//Explanation:
//One of the possible paths from the source cell to the destination cell in the matrix is highlighted below.
//1 0 1 1 0
//        0 1 0 1 1
//        1 1 0 1 0
//        1 1 1 1 1
//
//Example Input/Output 2:
//Input:
//        3 3
//        1 0 1
//        0 1 1
//        1 0 1
//        0 2
//        2 0
//Output:
//no
// youtube:
//        logic:https://youtu.be/vwyE4puUpw0
//        code:https://youtu.be/BRpSkgvb2OU

package PrimeContent.ElevateSet02;
import java.util.*;
public class PathExistsfromSourcetoDestinationCell_10 {
    static int dr;
    static int dc;
    private static boolean find(int[][] grid, int r, int c, int[][] visited){
        if(r == dr && c == dc){
            return true;
        }
        if(r<0 || c<0 || r>= grid.length || c >= grid[0].length || visited[r][c] == 2 || grid[r][c] == 0){
            return false;
        }
        int temp = grid[r][c];
        visited[r][c] = 2;
        boolean res = find(grid, r+1, c, visited) ||
                find(grid, r, c+1, visited) ||
                find(grid, r-1, c, visited) ||
                find(grid, r, c-1, visited);
        visited[r][c] = temp;
        return res;
    }
    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        System.out.println("enter row size");
        int r = z.nextInt();
        System.out.println("enter col size");
        int c = z.nextInt();
        int[][] grid = new int[r][c];
        System.out.println("enter elements");
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j <c ; j++) {
                grid[i][j]= z.nextInt();
            }
        }

        System.out.println("enter source row");
        int sr = z.nextInt();
        System.out.println("enter source col");
        int sc = z.nextInt();
        System.out.println("enter dest row");
        dr = z.nextInt();
        System.out.println("enter dest col");
        dc = z.nextInt();
        int[][] visited = new int[r][c];
        boolean res = find(grid, sr, sc,visited);
        if(res){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
