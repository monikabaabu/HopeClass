//N Bishops - Fill Remaining
//
//In a N*N square chessboard, certain number of bishops are placed.
// The program must accept the positions of B bishops(marked by 1).
// The empty squares are marked by the value 0.
// The program must fill in the remaining N-B bishops with the condition that only one bishop
// must be in a row and one bishop must be in a column so that the bishops do not attack each other.
// The program must finally print the arrangement of the bishops in the chessboard
// (if multiple arrangements are possible print the possibility which occurs with the left most column filled starting from the top row).
// If such an arrangement is not possible, then the program must print NotPossible as the output.
//
//        Note: In Chess, a bishop can move diagonally. The movement can happen till the end of the board is reached or another piece (like Rook, Knight, Bishop, Pawn etc is encountered). But in this program only the N bishops are placed and no other pieces will be present on the board.
//
//        Boundary Condition(s):
//        2 <= N <= 20
//        0 <= B <= N-1
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
//        1 0 0 0
//        0 0 0 1
//        0 1 0 0
//Example Input/Output 2:
//Input:
//        3
//        0 0 0
//        0 0 0
//        0 0 0
//
//Output:
//        1 0 0
//        1 0 0
//        1 0 0
//
//Explanation:
//Here multiple arrangements are possible. But starting from the top row, we consider the possibility once the left most column is filled.
//
//Example Input/Output 3:
//Input:
//        4
//        1 0 0 0
//        0 0 0 0
//        0 1 0 0
//        0 0 0 0
//
//Output:
//NotPossible
package PrimeContent.ElevateSet01;
import java.util.*;
public class NBishopsFillRemaining_9 {
    private static boolean canPlace(int n, int r, byte[][] board, boolean[] swDiag, boolean[] nwDiag, boolean[] bishoprow){
        if(r==n){
            return true;
        }
        if(bishoprow[r]){
            return canPlace(n,r+1,board,swDiag,nwDiag,bishoprow);
        }
        for (int c = 0; c <n ; c++) {
            if(!swDiag[c-r+n-1]  && !nwDiag[r+c]){
                board[r][c]=1;
                bishoprow[r]=true;
                swDiag[c-r+n-1]=true;
                nwDiag[r+c]=true;
                if(canPlace(n, r+1, board, swDiag, nwDiag, bishoprow)){
                    return true;
                }
                else{
                    board[r][c]=0;
                    bishoprow[r]=false;
                    swDiag[c-r+n-1]=false;
                    nwDiag[r+c]=false;
                }
            }

        }
        return false;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter n value:");
        int n = sc.nextInt();
        byte[][] grid = new byte[n][n];
        boolean swDiag[]= new boolean[2*n-1];
        boolean nwDiag[] = new boolean[2*n-1];
        boolean bishoprow[] = new boolean[n];

        System.out.println("enter elements");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextByte();
                if (grid[i][j] == 1) {
                    bishoprow[i] = true;
                    swDiag[j - i + n - 1] = true;//col-row+n-1
                    nwDiag[j + i] = true;//col+row
                }
            }
        }
        if(canPlace(n,0,grid,swDiag,nwDiag,bishoprow)){
            for(int r =0; r<n;r++){
                for (int c = 0; c <n ; c++) {
                    System.out.print(grid[r][c]+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("NotPossible");
        }

    }
}
