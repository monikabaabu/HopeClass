//Word Search in Matrix
//
//The program must accept a character matrix of size R*C and a string S as input. The program must search the string S in the given R*C character matrix by traversing horizontally and vertically. If the string S is found in the matrix, the program must print yes. Else the program must print no as the output.
//
//        Boundary Condition(s):
//        2 <= R, C, Length of S <= 50
//
//Input Format:
//The first line contains R and C separated by a space.
//The next R lines, each containing C characters separated by a space.
//The (R+2)^nd line contains the string S.
//
//Output Format:
//The first line contains the either yes or no.
//
//Example Input/Output 1:
//Input:
//        5 8
//kertunop
//        rainqbow
//vanguecl
//        rattongh
//hwyfnxog
//        ringtone
//
//Output:
//yes
//
//Explanation:
//Here, the string ringtone is found in the given matrix and it is highlighted below.
//kertunop
//        rainingbow
//vanguecl
//        rattongh
//hwyfnxog
//
//Example Input/Output 2:
//Input:
//        4 7
//pokranw
//        meneeerl
//jnginov
//        addfgstc
//engineering
//
//Output:
//no
//youtube:
//        logic:https://youtu.be/YGk1yAeOUsw
//        code:https://youtu.be/_GIT1qHUy8Y
package PrimeContent.ElevateSet02;
import java.util.*;
public class WordSearchInMatrix_13 {
    private static boolean find(char[][] grid, int r, int c,int i, String s){
        if(i==s.length()){
            return true;
        }
        if(r<0 || c<0 || r>= grid.length || c>= grid[0].length|| grid[r][c] != s.charAt(i) ){
            return false;
        }
        char temp = grid[r][c];
        grid[r][c] = '-';
        boolean res = find(grid, r+1, c, i+1, s) || find(grid, r, c+1, i+1, s) || find(grid, r-1, c, i+1, s) || find(grid, r, c-1, i+1, s);
        grid[r][c] = temp;
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        System.out.println("enter row");
        int r = sc.nextInt();
//        System.out.println("enter col");
        int c = sc.nextInt();
        char[][] grid = new char[r][c];
//        System.out.println("enter elements");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j <c ; j++) {
                grid[i][j]= sc.next().charAt(0);
            }
        }
        String s = sc.next();
        boolean ans = false;
        for (int i = 0; i <r ; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]==s.charAt(0)){
                    ans = find(grid,i,j,0,s);

                }
                if(ans){
                    break;
                }

            }
            if(ans){
                break;
            }
        }
        if(ans) {
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
