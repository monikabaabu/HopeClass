//The program must accept a string S and a pattern P as the input.
// The program must print the count of occurrence of the pattern in the given string S as the output.
//
//        Boundary Condition(s):
//        1 <= Length of P <= length of S <= 10^6
//
//        Input Format:
//        The first line contains S.
//        The second line contains P.
//
//        Output Format:
//        The first line contains a string value "Count=" followed by the count of occurrence of the pattern in the given string.
//
//        Example Input/Output 1:
//        Input:
//        AaabcbabababcaabcdAbcd
//        abc
//
//        Output:
//        Count=3
//
//        Explanation:
//        Here the given string is **AaabcbabababcaabcdAbcd** and the pattern is **abc**.
//        The occurrence of the pattern abc in the given string is highlighted below.
//        **AaabcbabababcaabcdAbcd**
//        In the given string, the pattern occurs 3 times.
//        Hence the output is Count=3.
//
//        Example Input/Output 2:
//        Input:
//        XyzzxxXyZzyxXyzzxXzz
//        xXyzz
//
//        Output:
//        Count=1
//
//        Example Input/Output 3:
//        Input:
//        Aa#12aBabc#123abc#abc#123
//        abc#123
//
//        Output:
//        Count=2

package PrimeContent.ElevateSet01;

import java.util.Scanner;

public class StringPatternCountKMPAlgorithm_11 {
//    private static boolean search(String s1, String s2,int i1, int i2){
//        if(i2 == s2.length()){
//            return true;
//        }
//        if(i1>= s1.length() || s1.charAt(i1) != s2.charAt(i2)){
//            return false;
//        }
//        return search(s1,s2,i1+1,i2+1);
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int count = 0;
        boolean res = false;
        int j=0;
        for (int i = 0; i < s1.length();) {
            if (s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
                if(j==s2.length()){
                    count++;
                    i = i+j-1;
                }
//                res = search(s1, s2, i,0);
//                if (res) {
//                    count++;
//                }
            }
        }
        System.out.println(count);
    }
}
