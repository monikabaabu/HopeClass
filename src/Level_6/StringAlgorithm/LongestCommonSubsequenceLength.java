
//        Longest Common Subsequence Length
//
//        The program must accept two string values A and B as the input.
//        The program must print the length of the longest common subsequence of the two string values as the output.
//        A common subsequence is a group of characters present in both the string values in the same order.
//
//        Boundary Condition(s):
//        1 <= A, B <= 1000
//
//        Input Format:
//        The first line contains A.
//        The second line contains B.
//
//        Output Format:
//        The first line contains the longest common subsequence of A and B.
//
//        Example Input/Output 1:
//        Input:
//        britanica
//        rtiac
//
//        Output:
//        4
//
//        Explanation:
//        The common subsequence of the two string values are riac.
//
//        Example Input/Output 2:
//        Input:
//        smartphone
//        marketplace
//
//        Output:
//        6

package Level_6.StringAlgorithm;
import java.util.*;

public class LongestCommonSubsequenceLength {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string 1:");
        String s1 = sc.nextLine();
        System.out.println("enter string 2:");
        String s2 = sc.nextLine();

        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}
