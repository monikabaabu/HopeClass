
//In a grid of size R*C, a rabbit(R) has to reach the carrot(C).
// The rabbit can move to the right or bottom.
// The program must print if the rabbit can reach the carrot.
// 1 indicates a path is available in that cell and 0 indicates that a path is not available through that cell.
//Example Input/Output 1:
//Input:
//        3 4
//        1000
//        R110
//        011C
//Output:
//yes
//Example Input/Output 2:
//Input:
//        3 4
//        R000
//        1110
//        010C
//Output:
//no

package PrimeSet01;
import java.util.*;
public class RabbitReachCarrotRightBottom {
    private static boolean search(char[][] grid, int r, int c){
        if(c<0  || r<0 || r>= grid.length || c>= grid[0].length || grid[r][c] == '0' ){
            return false;
        }
        if(grid[r][c] == 'C'){
            return true;
        }
        return search(grid,r+1,c) || search(grid, r, c+1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] matrix = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                matrix[i][j] = sc.next().charAt(0);
            }
        }
        boolean result = false;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 'R') {
                    result = search(matrix, i, j);
                }
            }
        }
        if(result){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
