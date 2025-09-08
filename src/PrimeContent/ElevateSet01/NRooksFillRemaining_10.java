//In a N*N square chessboard, certain number of rooks are placed.
// The program must accept the positions of R rooks (marked by 1).
// The empty squares are marked by the value 0.
// The program must fill in the remaining N-R rooks with the condition
// that only one rook must be in a row and one rook must be in a column so that the rooks do not attack each other.
// The program must finally print the arrangement of the rooks in the chessboard (if multiple arrangements
// are possible print the possibility which occurs with the left most column filled starting from the top row).
//
//Note: In chess, a rook can move along a row or a column. The movement can happen till the end of the board is reached or another piece (like Rook, Knight, Bishop, Pawn etc is encountered). But in this program only the N rooks are placed and no other pieces will be present on the board.
//
//        Boundary Condition(s):
//        2 <= N <= 20
//        0 <= R <= N-1
//
//Input Format:
//The first line contains N.
//The next N lines contain N values (0 or 1) each separated by a space.
//
//Output Format:
//The first N lines contain N values (0 or 1) each separated by a space.
//
//Example Input/Output 1:
//Input:
//        4
//        1 0 0 0
//        0 0 0 0
//        0 0 0 1
//        0 1 0 0
//
//Output:
//        1 0 0 0
//        0 0 1 0
//        0 0 0 1
//        0 1 0 0
//
//Example Input/Output 2:
//Input:
//        3
//        0 0 0
//        0 0 0
//        0 0 0
//
//Output:
//        1 0 0
//        0 1 0
//        0 0 1

package PrimeContent.ElevateSet01;
import java.util.*;
public class NRooksFillRemaining_10 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size");
        int n = sc.nextInt();
        System.out.println("enter elements");
        boolean[] rookrow = new boolean[n];
        boolean[] rookcol = new boolean[n];
        byte[][] grid = new byte[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextByte();
                if(grid[i][j] == 1){
                    rookrow[i] = true;
                    rookcol[j] = true;
                }
            }

        }
        for (int i = 0; i < n; i++) {
            if(!rookrow[i]){
                for (int j = 0; j <n ; j++) {
                    if(!rookcol[j]) {
                        grid[i][j] = 1;
                        rookrow[i] = true;
                        rookcol[j]= true;
                        break;
                    }
                }
            }

        }
            for (int i = 0; i <n ; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(grid[i][j]+" ");
                }
                System.out.println();
            }

    }
}
