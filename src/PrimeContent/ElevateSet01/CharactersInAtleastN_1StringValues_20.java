//Characters in at least N-1 String Values
//
//        The program must accept N string values as the input.
//        The program must print the common characters that are present in N or N-1 string values in sorted order as the output.
//        Note: At least one character is always present in N or N-1 string values.
//
//        Boundary Condition(s):
//        3 <= N <= 10^4
//        1 <= Length of each string <= 10^4
//
//        Input Format:
//        The first line contains N.
//        The next N lines, each containing a string.
//
//        Output Format:
//        The first line contains the common characters in sorted order that are present in N or N-1 string values in sorted order.
//
//        Example Input/Output 1:
//        Input:
//        3
//        orange
//        apple
//        pineapple
//
//        Output:
//        aelnp
//
//        Explanation:
//        The common characters that are present in 3 or 2 string values are a, e, l, n and p.
//        Hence the output is aelnp
//
//        Example Input/Output 2:
//        Input:
//        4
//        HardWork
//        HomeWork
//        Hungry
//        Wood
//
//        Output:
//        HWor
//        youtube:
//            code:https://youtu.be/nTkVZAdv0ok

package PrimeContent.ElevateSet01;
import java.util.*;
public class CharactersInAtleastN_1StringValues_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        int[] count = new int[256];
        for (int i = 0; i <n ; i++) {
            String s = sc.nextLine();
            boolean[] seen = new boolean[256];
            for (char c : s.toCharArray()) {
                if(!seen[c]){
                    count[c]++;
                    seen[c] = true;
                }
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            if(count[i] == n || count[i] == n-1){
                list.add((char) i);
            }
        }
        Collections.sort(list);
        for(char c: list){
            System.out.print(c);
        }
    }
}
