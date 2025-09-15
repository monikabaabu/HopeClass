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
// youtube:
//         logic:  https://youtu.be/S50mCVovRwQ
//         code: https://youtu.be/A6qCbbaoO84?si=aVMm3UmqDmlRq84u
package PrimeContent.ElevateSet01;

import java.util.Scanner;

public class StringPatternCountKMPAlgorithm_11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        int keylen = s2.length();
        int slen = s1.length();
        int[] lps = new int[keylen];
        lps[0]=0;
        int len =0;
        for (int i = 1; i < keylen ; ) {
            if(s2.charAt(i) == s2.charAt(len)){
                lps[i] = len+1;
                i++;
                len++;
            }
            else{
                if(len ==0){
                    lps[i] =0;
                    i++;
                }
                else{
                    len = lps[len-1];
                }
            }
        }
        int count =0;
        for (int si = 0,ki = 0; si < slen ;) {
            if(s1.charAt(si)== s2.charAt(ki)){
                si++;
                ki++;
                if(ki== s2.length()){
                    count++;
                    ki=0;
                }
            }
            else {
                if(ki==0){
                    si++;
                }
                else{
                    ki= lps[ki-1];
                }
            }

        }
        System.out.println(count);
    }
}
