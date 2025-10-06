//Solve Sudoku
//
//        The program must accept an integer matrix of size $9 \times 9$ representing a sudoku as the input. The sudoku matrix contains the integers from $0$ to $9$ where **$0$ represents the empty cells**. If the sudoku matrix is valid, the program must fill in the empty cells of the sudoku matrix and print it as the output. Else the program must print **Not Solved** as the output.
//
//        **Sudoku:**
//        Sudoku is a logic-based, combinatorial number-placement puzzle. The objective is to fill a $9 \times 9$ grid with digits so that each column, each row, and each of the nine $3 \times 3$ subgrids that compose the grid contain all of the digits from $1$ to $9$.
//
//        **Input Format:**
//        The first $9$ lines each contain $9$ integers separated by a space.
//
//        **Output Format:**
//        The first $9$ lines each contain $9$ integers separated by a space or the first line contains **Not Solved**.
//
//        Example Input/Output 1:
//        Input:
//        0 0 0 2 6 0 7 0 1
//        6 8 0 0 7 0 0 9 0
//        1 9 0 0 0 4 5 0 0
//        8 2 0 1 0 0 0 4 0
//        0 0 4 6 0 2 9 0 0
//        0 5 0 0 0 3 0 2 8
//        0 0 9 3 0 0 0 7 4
//        0 4 0 0 5 0 0 3 6
//        7 0 3 0 1 8 0 0 0
//
//        Output:
//        4 3 5 2 6 9 7 8 1
//        6 8 2 5 7 1 4 9 3
//        1 9 7 8 3 4 5 6 2
//        8 2 6 1 9 5 3 4 7
//        3 7 4 6 8 2 9 1 5
//        9 5 1 7 4 3 6 2 8
//        5 1 9 3 2 6 8 7 4
//        2 4 8 9 5 7 1 3 6
//        7 6 3 4 1 8 2 5 9
//
//        Example Input/Output 2:
//        Input:
//        0 6 0 3 0 0 8 0 4
//        5 3 7 0 9 0 0 0 0
//        0 4 0 0 0 6 3 0 7
//        0 9 0 5 1 0 2 3 8
//        0 0 0 0 0 0 0 0 0
//        7 1 3 2 0 0 0 0 0
//        3 0 6 4 0 0 0 1 0
//        0 0 0 6 0 5 2 3
//        1 0 2 0 0 3 0 8 0
//
//        Output:
//        Not Solved
//
//        youtube:
//        logic: https://youtu.be/ziChV7_MFos
//        code: https://youtu.be/2MWRITy9_Ac

package PrimeContent.ElevateSet02;
import java.util.*;
class Slot{
    int r;
    int c;
}
public class SolveSudoku_23 {
    private static boolean canFillRow(int[][] matrix, Slot slot, int digit){
        for (int col = 0; col < 9; col++) {
            if(matrix[slot.r][col]==digit){
                return false;
            }
        }
        return true;
    }
    private static boolean canFillCol(int[][] matrix, Slot slot, int digit){
        for (int row = 0; row < 9; row++) {
            if(matrix[row][slot.c]==digit){
                return false;
            }
        }
        return true;
    }
    private static boolean canFillSubMatrix(int[][] matrix, Slot slot, int digit){
        int startRow = (slot.r/3)*3;
        int startCol = (slot.c/3)*3;
        for (int row = startRow; row <= startRow+2 ; row++) {
            for (int col = startCol; col <= startCol+2 ; col++) {
                if(matrix[row][col]== digit){
                    return  false;
                }
            }
        }
        return true;
    }
    private static Slot getFreeSlot(int[][] matrix){
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                if(matrix[i][j]==0){
                    Slot slot = new Slot();
                    slot.r = i;
                    slot.c = j;
                    return slot;
                }
            }
        }
        return  null;
    }
    private static boolean solve(int[][] matrix){
        Slot slot = getFreeSlot(matrix);
        if(slot==null){
            return true;
        }
        for (int digit = 1; digit <=9 ; digit++) {
            if(canFillRow(matrix,slot,digit) && canFillCol(matrix,slot,digit) && canFillSubMatrix(matrix,slot,digit)){
                matrix[slot.r][slot.c] = digit;
                if(solve(matrix)) {
                    return true;
                }
                matrix[slot.r][slot.c] =0;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matrix = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j <9 ; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        if(solve(matrix)){
            for (int i = 0; i <9 ; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(matrix[i][j]+" ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("not solved");
        }
    }
}
