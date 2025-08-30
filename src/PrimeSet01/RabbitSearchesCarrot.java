//
//A rabbit wants to know if CARROT is present in the grid.
// The condition is that same cell cannot be visited more than once
// and the next character can be present in the top-right, right, left, top, bottom-right positions.
//Boundary Condition(s):
//        1 <= R,C <= 50
//Example Input/Output 1:
//Input:
//        5 6
//        CHAROE
//        OARCHT
//        MANGOL
//        CHESSK
//        RANDOM
//Output:
//yes
package PrimeSet01;
import java.util.*;

public class RabbitSearchesCarrot {

    private static boolean search(char[][] grid , String s , int r, int c , int i){
        if(i == s.length()){
            return true;
        }
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != s.charAt(i)){
            return false;
        }

        char temp = grid[r][c];
        grid[r][c] = '0';
        boolean found =
                search(grid, s, r-1, c, i+1) ||      // top
                        search(grid, s, r, c+1, i+1) ||      // right
                        search(grid, s, r, c-1, i+1) ||      // left
                        search(grid, s, r-1, c+1, i+1) ||    // top-right
                        search(grid, s, r+1, c+1, i+1);      // bottom-right

        grid[r][c] = temp;

        return found;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] grid = new char[r][c];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                grid[i][j] = sc.next().charAt(0);
            }
        }

        String s = "CARROT";
        boolean res = false;
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(grid[i][j] == s.charAt(0)){
                    res = search(grid, s, i, j, 0);
                    if(res){
                        break;
                    }
                    }
                }
            if(res){
                break; // returns the ans if the 1st found path is correct and does not loop again
            }
            }

        if(res){
        System.out.println("yes");
    }
      else{
        System.out.println("no");
    }
}
}
