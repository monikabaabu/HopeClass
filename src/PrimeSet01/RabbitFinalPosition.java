//
//A rabbit is positioned in a grid(row and col index are given as input).
// It can move to Left, Right, Top, Bottom but cannot go out of grid.
// There is a string with the movement instructions (L,R,T,B).
// The program must print the rabbit position (row and column indices)
// after completing all the movement instructions.
//Boundary Condition(s):
//        1 <= R,C <= 200
//Example Input/Output 1: Input:
//        5 (row) 4(col)
//        1 3 (starting point)
//LLTBRLBBRT
//Output:
//        2 2
package PrimeSet01;
import java.util.*;
public class RabbitFinalPosition {
    private static void position(String s, int R, int C, int r, int c, int i){
        if(r<0 || r == R || c<0 || c== C || i == s.length()){
            System.out.println(r+" "+c);
            return;
        }
        else if(s.charAt(i) == 'L'){
            position(s,R,C,r,c-1,i+1);
        }
        else if(s.charAt(i) == 'R'){
            position(s,R,C,r,c+1,i+1);
        }
        else if(s.charAt(i) == 'T'){
            position(s,R,C,r-1,c,i+1);
        }
        else if(s.charAt(i) == 'B'){
            position(s,R,C,r+1,c,i+1);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        String s = sc.next();
        position(s,R,C,r,c,0);
    }
}
