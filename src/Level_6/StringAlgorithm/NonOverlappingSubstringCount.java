//```
//        Non-overlapping Substring Count
//
//        Two string values S and P representing a string and pattern are passed as the input to the program. The program must print the number of non-overlapping occurrences of pattern P in the string S as the output.
//
//        Note: The string S and pattern P contains only lowercase alphabets.
//
//        Boundary Condition(s):
//        1 <= Length of S <= 10^5
//        1 <= Length of P <= 10
//
//        Input Format:
//        The first line contains S.
//        The second line contains P.
//
//        Output Format:
//        The first line contains the number of non-overlapping occurrences of P in S.
//
//        Example Input/Output 1:
//        Input:
//        abababa
//        aba
//
//        Output:
//        2
//
//        Explanation:
//        The pattern aba occurs two times on abababa without overlapping. So 2 is printed.
//
//        Example Input/Output 2:
//        Input:
//        techchampcheckin
//        ch
//
//        Output:
//        3
//        ```

package Level_6.StringAlgorithm;
import java.util.*;
public class NonOverlappingSubstringCount {
    private static boolean pattern(String s, String p, int i, int j){
        if(j == p.length()){
            return true;
        }
        if(i>= s.length()){
            return false;
        }
        if(s.charAt(i) != p.charAt(j)){
            return false;
        }
        return pattern(s,p,i+1,j+1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String s = sc.nextLine();
        System.out.println("enter pattern");
        String p = sc.nextLine();
        int count =0;
        int n = p.length();
        for (int i = 0; i < s.length() ; i++) {
            if(pattern(s,p,i,0)){
                count++;
                i = i+n-1;
            }
        }
        System.out.println(count);
    }
}
