//Longest Common Signal
//
//The program must accept the alphabets emitted by the two signal systems (S1, S2) as the input.
// The program must print the length of the longest common signal emitted by these two signal systems as the output.
//
//Boundary Condition(s):
//        1 <= Length of S1, S2 <= 10^4
//
//Input Format:
//The first line contains S1.
//The second line contains S2.
//
//Output Format:
//The first line contains the length of the longest common signal emitted by the two signal systems.
//
//Example Input/Output 1:
//Input:
//nose
//        raise
//
//Output:
//        2
//
//Explanation:
//se is the longest common signal whose length is 2.
//
//Example Input/Output 2:
//Input:
//abcdelkgxwvu
//        abcilkgxyz
//
//Output:
//        4
//
//        youtube:
//            logic:https://youtu.be/oQbU2ws1lWg
//            code:https://youtu.be/p7n6pxLVo3s

package PrimeContent.ElevateSet02;
import java.util.*;
public class LongestCommonSignal_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter String 1");
        String s1 = sc.nextLine();
        System.out.println("enter string 2");
        String s2 = sc.nextLine();
        int[][] grid = new int[s1.length()][s2.length()];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s1.length() ; i++) {
            for (int j = 0; j < s2.length() ; j++) {
                if(s1.charAt(i) == s2.charAt(j) ) {
                    if (i == 0 || j== 0) {
                        grid[i][j]= 1;
                    } else {
                        grid[i][j] = grid[i-1][j-1]+ 1;
                    }
                }
                max = Math.max(max, grid[i][j]);
            }
        }
        System.out.println(max);
    }
}
