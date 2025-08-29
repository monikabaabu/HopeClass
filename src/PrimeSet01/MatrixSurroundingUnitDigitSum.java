//
//In a grid of size R*C,
// modify the grid so that for each cell value,
// the sum of the unit digits of all surrounding cells is added to it.
//Example Input/Output 1:
//Input:
//        54
//         8 11  5 48
//        49 45  5 25
//        46 30 27 46
//         4 31 23  9
//        37 30 18 47
//Output:
//        23 43 29 63
//        69 86 42 56
//        65 70 61 75
//        18 66 61 40
//        42 53 38 67

package PrimeSet01;
import java.util.*;
public class MatrixSurroundingUnitDigitSum {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int[][] grid = new int[R][C];
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                grid[i][j] = sc.nextInt();

        int[][] result = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int sum = 0;
                for (int d = 0; d < 8; d++) {
                    int ni = i + dx[d], nj = j + dy[d];
                    if (ni >= 0 && ni < R && nj >= 0 && nj < C) {
                        sum += grid[ni][nj] % 10; // take unit digit
                    }
                }
                result[i][j] = grid[i][j] + sum;
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++)
                System.out.print(result[i][j] + " ");
            System.out.println();

        }
    }
}
