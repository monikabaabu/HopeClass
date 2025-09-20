//**Permutations - String Characters**
//
//The program must accept a string S as the input. The program must print all the permutations of the string S as the output.
//
//        **Boundary Condition(s):**
//        2 <= Length of S <= 10
//
//        **Input Format:**
//The first line contains S.
//
//**Output Format:**
//The lines containing all the permutations of the string S.
//
//        **Example Input/Output 1:**
//Input:
//abc
//
//Output:
//        abc
//        acb
//        bac
//        bca
//        cba
//        cab
//
//**Example Input/Output 2:**
//Input:
//rack
//
//Output:
//        rack
//        rakc
//        rcka
//        rkca
//        rkac
//        arck
//        arkc
//        ackr
//        akcr
//        akrc
//        cark
//        cakr
//        crka
//        ckra
//        ckar
//        kacr
//        karc
//        kcar
//        kcra
//        krka
//        krac

package PrimeContent.ElevateSet02;
import java.util.*;
public class PermutationsStringCharacters_8 {
    private static void swap(char s[], int x, int y){
        char temp = s[x];
        s[x]=s[y];
        s[y]=temp;
    }
    private static void permute(char[] s, int left, int right){
        if(left == right){
            System.out.println(s);
            return;
        }
        for (int i = left; i <= right ; i++) {
            swap(s,left,i);
            permute(s,left+1,right);
            swap(s,left,i); // backtracking beacause after swaping for onr permutation we should return it to original vale so that other permutations can be identified
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        char[] str = s.toCharArray();
        int n = s.length();
        permute(str,0,n-1);
    }
}
