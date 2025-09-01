
//Count Overlapping String Pattern
//Two string values S and P representing a string and pattern are passed as the input to the program.
// The program must print the number of overlapping occurrences of pattern P in the string S as the output.
//        Note: The string S and pattern P contains only lowercase alphabets.
//Boundary Condition(s):
//        1 <= Length of S <= 2000000
//        1 <= Length of P <= 10
//Input Format:
//The first line contains S.
//The second line contains P.

//Output Format:
//The first line contains the number of overlapping occurrences of P in S.
//
//Example Input/Output 1:
//Input:
//   precondition
//   on
//Output:
//        2
//
//Explanation:
//The pattern on occurs two times in precondition so 2 is printed.
//
//Example Input/Output 2:
//Input:
//       tetetetmtey
//        tet
//Output:
//        3
//        ```

package Level_6.StringAlgorithm;
import java.util.*;
public class CountOverLappingStringPattern {
    private static boolean pattern ( String s, String p, int i,int j){
        if(j == p.length()){
            return true;
        }
        if(i >= s.length()){
            return false;
        }
        if( s.charAt(i) != p.charAt(j) ){
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
        boolean res = false;
        for (int i = 0; i < s.length(); i++) {
            if(p.charAt(0) == s.charAt(i)){
                res = pattern(s,p,i,0);
                if(res){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
