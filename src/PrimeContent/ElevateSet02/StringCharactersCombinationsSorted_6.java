//
//String Characters - Combinations Sorted
//The program must accept a string S as the input. The program must print the combinations of the characters in the string S in sorted order.
//
//Boundary Condition(s):
//        2 <= Length of S <= 15
//
//Input Format:
//The first line contains the string S.
//
//Output Format:
//The lines containing the string values representing the combinations of the characters in the string S in sorted order.
//
//Example Input/Output 1:
//Input:
//abc
//
//Output:
//        a
//        ab
//        abc
//        ac
//        b
//        bc
//        c
//Example Input/Output 2:
//Input:
//virus
//
//Output:
//        i
//        ir
//        irs
//        iru
//        irus
//        is
//        iu
//        ius
//        r
//        rs
//        ru
//        rus
//        s
//        u
//        us
//        v
//        vi
//        vir
//        virs
//        viru
//        virus
//        vis
//        viu
//        vius
//        vr
//        vrs
//        vru
//        vrus
//        vs
//        vu
//        vus
//
//        youtube:
//            logic:https://youtu.be/dfKB6oVb0DM
//            code:https://youtu.be/dfKB6oVb0DM

package PrimeContent.ElevateSet02;
import java.util.*;
public class StringCharactersCombinationsSorted_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        List<String> list = new ArrayList<>();
        for (int i = 1; i < (1<<s.length()) ; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length() ; j++) {
                if((i & 1<<j)!=0){
                    sb.append(s.charAt(j));
                }
            }
            if(sb.length()>0) {
                list.add(sb.toString());
            }
        }
        Collections.sort(list);
        for (String l:list) {
            System.out.println(l);
        }
    }
}
