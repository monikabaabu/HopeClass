//In a grid, a boy B has N power points.
// He must reach the magical wand 'W'.
// During his course of reaching the magical band,
// his power points will be deducted if a cell has a positive integer value.
// Print if the boy can reach the magical wand with the N power points.
// The boy can travel to left, right, top or bottom cells.
// He must visit each cell only once during his course.
// If the power points becomes negative, he cannot travel further.
//Example Input/Output 1:
//Input:
//        5  6
//        0B1111
//        110010
//        101000
//        010104
//        01110W
//        2(power point)
//Output:
//          yes
//Example Input/Output 2:
//Input:
//        5  6
//        0B1111
//        120010
//        101000
//        010104
//        01110W
//        0(power point)
//Output:
//         no

package PrimeSet01;
import java.util.*;
public class BoyReachMagicWand {
    private static boolean search(char[][] grid, int r, int c, int p){

        if(r<0 || r>= grid.length || c<0 || c>= grid[0].length || grid[r][c] == 'X' || p<0){
            return false;
        }
        if(grid[r][c] == 'W'){
            return true;
        }
        int cost =0;
        if( Character.isDigit(grid[r][c])){
            cost = grid[r][c]-'0';
        }
        char temp = grid[r][c];
        grid[r][c] = 'X';
        boolean found = search(grid, r+1, c, p-cost) ||
                        search(grid, r-1, c, p-cost) ||
                        search(grid, r, c+1, p-cost)||
                        search(grid, r, c-1, p-cost);
        grid[r][c]=temp;
        return found;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        char[][] grid = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        int p = sc.nextInt();
        boolean res = false;
        for(int i=0;i<r;i++){
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 'B'){
                    res = search(grid,i,j,p);
                }
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
