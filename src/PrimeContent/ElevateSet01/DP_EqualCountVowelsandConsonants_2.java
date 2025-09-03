//**Problem: DP - Equal Count - Vowels & Consonants**
//
//The program must accept a string **S** (consisting of only vowels and consonants) and an integer **N**.
// The program must print the number of substring values of length **N** which have equal count of vowels and consonants.
//
//        **Note:** The value of **N** is always even.
//
//**Boundary Condition(s):**
//        1 <= Length of S <= $10^5$
//2 <= **N** <= Length of S
//
//**Input Format:**
//The first line contains **S**.
//The second line contains **N**.
//
//        **Output Format:**
//The first line contains an integer representing the number of substring values of length **N** which have equal count of vowels and consonants.
//
//        **Example Input/Output 1:**
//        **Input:**
//havenhelljoysorrow
//4
//
//        **Output:**
//        5
//
//        **Explanation:**
//There are 5 substring values of length N=4 which have equal count of vowels and consonants.
//have, aven, enhe, oyso, orro.
//
//**Example Input/Output 2:**
//        **Input:**
//skillrack
//2
//
//        **Output:**
//        4

package PrimeContent.ElevateSet01;

import java.util.Scanner;

public class DP_EqualCountVowelsandConsonants_2 {
    private static boolean isConsonant(char ch){
        ch= Character.toLowerCase(ch);
        return "aeiou".indexOf(ch) == -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string:");
        String s = sc.nextLine();
        System.out.println("enter k value");
        int k = sc.nextInt();
        int countc = 0;
        int countv=0;
        int count =0;
        for(int i=0;i<k;i++){
            if(isConsonant(s.charAt(i))){
                countc++;
            }
            else{
                countv++;
            }

        }
        if(countc == countv){
            count++;
        }

        for (int i = k; i < s.length() ; i++) {
            if(isConsonant(s.charAt(i-k))){
                countc--;
            }
            else{
                countv--;
            }
            if(isConsonant(s.charAt(i))){
                countc++;
            }
            else{
                countv++;
            }
            if(countc == countv){
                count++;
            }
        }
        System.out.println(count);
    }
}
