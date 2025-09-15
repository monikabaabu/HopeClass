//# Characters In All N String Values
//
//The program must accept N string values as the input.
// The program must print the common characters in all the N string values in sorted order as the output.
//
//**Note:** At least one character is always present in all the N string values.
//
//**Boundary Condition(s):**
//        2 <= N <= 10^4
//        1 <= Length of each string <= 10^4
//
//        **Input Format:**
//The first line contains N.
//The next N lines, each containing a string.
//
//**Output Format:**
//The first line contains the common characters in all the N string values in sorted order.
//
//        ---
//
//        **Example Input/Output 1:**
//        **Input:**
//        5
//engine
//        manager
//generation
//        pen
//mentor
//
//**Output:**
//en
//
//**Explanation:**
//The common characters in all the given 5 string values are **e** and **n**.
//Hence the output is en
//
//---
//
//        **Example Input/Output 2:**
//        **Input:**
//        3
//Africa
//        Australia
//Antarctica
//
//**Output:**
//Aair
//
//---
//
//        **Example Input/Output 3:**
//        **Input:**
//        2
//bbBBB
//        bbBBB
//
//**Output:**
//Bb
// youtube:
//    logic: https://youtu.be/PReV0m4msCA
//    code:https://youtu.be/K5NG2Rdtbu0

package PrimeContent.ElevateSet01;
import java.util.*;
public class CharactersInAllNStringValues_19 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("enter n value:");
        int n = sc.nextInt();
        sc.nextLine();
        System.out.println("enter string value:");
        String first = sc.nextLine();
        Set<Character> common = new HashSet<>();
        for(char c : first.toCharArray()){
            common.add(c);
        }
        for (int i = 1; i < n; i++) {
            String s = sc.nextLine();
            Set<Character> current = new HashSet<>();
            for (char c : s.toCharArray()) {
                current.add(c);
            }
            common.retainAll(current);
        }
        List<Character> result = new ArrayList<>(common);
        Collections.sort(result);
        for(char c: result){
            System.out.print(c);
        }
    }
}
