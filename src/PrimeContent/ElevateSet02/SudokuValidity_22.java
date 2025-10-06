//Given a $9 \times 9$ sudoku, the program must evaluate it for its correctness.
// The program must check both the sub sudoku correctness and the entire sudoku correctness using the following rules.
//
//        **Rule 1: Each $3 \times 3$ sub matrix must contain all digits from $1$ to $9$.**
//
//        **Rule 2: The digits $1$ to $9$ must not repeat in a given or column in the $9 \times 9$ sudoku matrix.**
//
//Boundary Condition(s):
//Sudoku matrix is $9 \times 9$ matrix.
//
//Input Format:
//$9$ lines containing $9$ integer values representing the column values.
//
//Output Format:
//The first line contains **VALID** or **INVALID**
//
//Example Input/Output 1:
//Input:
//        1 1 3 6 8 7 2 4 9
//        8 4 9 5 2 1 6 3 7
//        2 6 7 3 4 9 5 8 1
//        1 5 8 4 6 3 9 7 2
//        9 7 4 2 1 8 3 6 5
//        3 2 6 7 9 5 4 1 8
//        7 8 2 9 3 4 1 5 6
//        6 3 5 1 7 2 8 9 4
//        1 9 4 8 5 6 7 2 3
//
//Output:
//INVALID
//
//Explanation:
//        1 is repeated along first row. (Also 1 is repeated along first column).
//
//Example Input/Output 2:
//Input:
//        5 1 3 6 8 7 2 4 9
//        8 4 9 5 2 1 6 3 7
//        2 6 7 3 4 9 5 8 1
//        1 5 8 4 6 3 9 7 2
//        9 7 4 2 1 8 3 6 5
//        3 2 6 7 9 5 4 1 8
//        7 8 2 9 3 4 1 5 6
//        6 3 5 1 7 2 8 9 4
//        4 9 1 8 5 6 7 2 3
//
//Output:
//VALID
//        youtube:
//            logic:https://youtu.be/wVnvzXClo8Y
//            code:https://youtu.be/479p377yrE4

package PrimeContent.ElevateSet02;
import java.util.*;
public class SudokuValidity_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rflag = new int[9];
        int[] cflag = new int[9];
        int[] smflag = new int[9];
        for (int i = 0; i <9 ; i++) {
            rflag[i]=cflag[i]=smflag[i]=1;
        }
        int n =0;
        for (int i = 0; i <9 ; i++) {
            for (int j = 0; j <9 ; j++) {
                n = sc.nextInt();
                rflag[i]|=(1<<n);
                cflag[j]|=(1<<n);
                smflag[(i/3)*3 +(j/3)] |= (1<<n);
            }
        }
        int val = (1<<10)-1;
        boolean ans = false;
        for (int i = 0; i <9 ; i++) {
            if(rflag[i] != val || cflag[i] != val || smflag[i] != val ){
                ans = true;
                System.out.println("not valid");
                break;
            }
        }
        if(!ans){
            System.out.println("valid");
        }
    }
}
