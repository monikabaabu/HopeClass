//Given 3 string values S1, S2 and S3, find if S3 is a valid mix of the first two string values S1 and S2.
// The third string value S3 is said to be a mix of the first S1 string and the second S2 string,
// if it can be formed by interleaving the characters of the first string and
// the second string in a way that maintains the left to right order of occurrence of the characters
// for S1 and S2 each string. The program must print YES if it is a valid mix.
// Else the program must print NO as the output.
//
//        Boundary Condition(s):
//        1 <= Length of S1, S2 <= 1000
//
//Input Format:
//The first line contains the string S1.
//The second line contains the string S2.
//The third line contains the string S3.
//
//Output Format:
//The first line contains either YES or NO.
//
//Example Input/Output 1:
//Input:
//mno
//        xyz
//xmnyzo
//
//Output:
//YES
//
//Explanation:
//The order of occurrence of xyz and mno is preserved in xmnyzo.
//Hence the output YES is printed.
//
//Example Input/Output 2:
//Input:
//MANO
//        KON
//MAKNOON
//
//Output:
//YES
//
//Example Input/Output 3:
//Input:
//MANO
//        KON
//MAKOONN
//
//Output:
//NO
// youtube:
//     logic:https://youtu.be/F5AnXSpwYG4
//     code: https://youtu.be/NRm7bdHDhOs

package PrimeContent.ElevateSet01;
import java.util.*;
public class ValidMixOfStringValues_17 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string 1:");
        String s1 = sc.nextLine();
        System.out.println("enter string 2:");
        String s2 = sc.nextLine();
        System.out.println("enter string 3:");
        String s3 = sc.nextLine();
        int i1 =0;
        int i2 =0;
        int i=0;

        if(validMix(s1,s2,s3,i1,i2,i)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }

    private static boolean validMix(String s1, String s2, String s3, int i1, int i2, int i) {
        while(i<s3.length()){
            if(i1<s1.length() && i2< s2.length() && s3.charAt(i)==s1.charAt(i1) && s3.charAt(i) == s2.charAt(i2)){
                if(validMix(s1, s2, s3, i1+1, i2, i+1)){
                    return true;
                }
                else{
                    return validMix(s1, s2, s3, i1, i2+1, i+1);
                }
            }
            else if(i1<s1.length() && s3.charAt(i) == s1.charAt(i1)){
                i1++;
                i++;
            }
            else if( i2< s2.length() && s3.charAt(i) == s2.charAt(i2)){
                i2++;
                i++;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
