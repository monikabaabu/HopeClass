//Longest Substring - Equal Alphabets & Digits
//
//        The program must accept a string S containing lowercase alphabets and digits as the input. The program must print the length L of the longest substring with equal number of alphabets and digits in it.
//        Note: Optimize the algorithm so that the program executes successfully within the time limit.
//
//        Boundary Condition(s):
//        1 <= Length of S <= $10^5$
//
//        Input Format:
//        The first line contains S.
//
//        Output Format:
//        The first line contains L.
//
//        Example Input/Output 1:
//        Input:
//        ab547b23
//
//        Output:
//        6
//
//        Explanation:
//        The longest substring which contains equal number of alphabets and digits is ab547b whose length is 6.
//
//        Example Input/Output 2:
//        Input:
//        memory1terabytes
//
//        Output:
//        2
//        youtube:
//        logic:https://youtu.be/R3KFda5KpEY
//        code:https://youtu.be/KCKZ2xkQgM0

package PrimeContent.ElevateSet02;
import java.util.*;
public class LongestSubstring_EqualAlphabetsandDigits_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string");
        String s = sc.nextLine();
        int alpha=0;
        int position =0;
        int max = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(alpha,position);
        for (char c: s.toCharArray()) {
            position++;
            if(!Character.isDigit(c)){
                alpha++;
            }
            else{
                alpha--;
            }
            if(map.containsKey(alpha)){
                int currlen = position-map.get(alpha);
                max= Math.max(max,currlen);
            }
            else{
                map.put(alpha,position);
            }
        }
        System.out.println(max);
    }
}
