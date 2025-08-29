//
//A rabbit is positioned in a grid(row and col indices are given).
// It can move to Left, Right, Top, Bottom but cannot go out of grid.
// There is a string with the movement instructions (L,R,T,B).
// The program must print count of the cells where the rabbit
// visited more than once(including the initial position).
//Boundary Condition(s):
//        1 <= R,C <= 200
//Example Input/Output 1:
//Input:
//        5 (row) 4(col)
//        1 3 starting point
//LLLLLLTTTTTTTBRRRRRRRRLBBRT
//Output:
//        4

package PrimeSet01;
import java.util.*;

public class RabbitMultipleVisitCount {
    private static void count(String s, int R, int C , int r, int c, int i, int[][] visited, int cnt){
        // Base condition: if instructions finished
        if(i == s.length()){
            System.out.println(cnt);
            return;
        }

        if( s.charAt(i) == 'L' && c>0) c--;
        else if( s.charAt(i) == 'R' && c<C-1) c++;
        else if( s.charAt(i)== 'T' && r>0) r--;
        else if( s.charAt(i) == 'B' && r<R-1) r++;
        else {
            // invalid move (out of grid), skip this instruction
            count(s, R, C, r, c, i + 1, visited, cnt);
            return;
        }

        // increase visit count
        visited[r][c]++;

        // if this is the 2nd visit, increase cnt
        if(visited[r][c] == 2){
            count(s, R, C, r, c, i + 1, visited, cnt + 1);
        } else {
            count(s, R, C, r, c, i + 1, visited, cnt);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        int r = sc.nextInt();
        int c = sc.nextInt();
        String s = sc.next();

        int[][] visited = new int[R][C];
        visited[r][c] = 1;  // mark start as visited

        count(s, R, C, r, c, 0, visited, 0);
    }
}
