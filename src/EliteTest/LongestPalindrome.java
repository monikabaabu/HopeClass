// input : TOYOTA
// output : 5

package EliteTest;
import java.util.*;
public class LongestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the String");
        String s = sc.next().trim();
        int n = s.length();
        if(n==0){
            System.out.println("0");
        }
        boolean dp[][] = new boolean[n][n];
        int maxLen =1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for(int i=0; i< n-1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] = true;
                maxLen = 2;
            }
        }
        for (int len = 3; len <=n ; len++) {
            for (int i = 0; i < n- len +1 ; i++) {
                int j= i + len -1;
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j] = true;
                    maxLen=len;
                }

                }
            }
        System.out.println(maxLen);
        }
    }

