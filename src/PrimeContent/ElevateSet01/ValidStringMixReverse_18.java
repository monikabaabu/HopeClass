//# Valid String Mix Reverse
//
//Given three string values S1, S2 and S3,
//The third string value S3 is said to be a reversed valid mix of the first S1 string and the second S2 string,
// if it can be formed by interleaving the characters of the first string and the second string in a way that
// maintains the left to right order of occurrence of the characters for S1 and S2 each string from the end of S3 to the start of S3.
// The program must print YES if it is a valid mix. Else the program must print NO as the output.
//
//**Boundary Condition(s):**
//        1 <= Length of S1, S2 <= 1000
//
//        **Input Format:**
//The first line contains the string S1.
//The second line contains the string S2.
//The third line contains the string S3.
//
//**Output Format:**
//The first line contains either YES or NO.
//
//        ---
//
//        **Example Input/Output 1:**
//        **Input:**
//yummy
//        tasty
//ytymmusaty
//
//**Output:**
//YES
//
//**Explanation:**
//The order of occurrence of yummy and tasty is preserved in ytymmusaty from the end to start.
//Hence the output YES is printed.
//
//        ---
//
//        **Example Input/Output 2:**
//        **Input:**
//HEN
//        NECK
//KNECHEN
//
//**Output:**
//YES
//
//---
//
//        **Example Input/Output 3:**
//        **Input:**
//HEN
//        NECK
//KNCeHEN
//
//**Output:**
//NO


package PrimeContent.ElevateSet01;
import java.util.*;
public class ValidStringMixReverse_18 {
    private static boolean validMix(String s1, String s2, String s3, int i1, int i2, int i){
        while(i<s3.length()){
            if(i1< s1.length() && i2< s2.length() && s3.charAt(i) == s1.charAt(i1) && s3.charAt(i) == s2.charAt(i2)){
                if(validMix(s1,s2,s3,i1+1, i2,i+1)){
                    return true;
                }
                else{
                    return validMix(s1,s2,s3,i1,i2+1,i+1);
                }
            }
            else if( i1< s1.length() && s3.charAt(i) == s1.charAt(i1)){
                i++;
                i1++;
            }
            else if(i2< s2.length() && s3.charAt(i) == s2.charAt(i2)){
                i++;
                i2++;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string 1:");
        String s1 = sc.nextLine();
        System.out.println("enter string 2:" );
        String s2 = sc.nextLine();
        System.out.println("enter string 3:");
        String s3 = sc.nextLine();
        int i1 =0, i2=0,i=0;
        String reversed = new StringBuilder(s3).reverse().toString();
        if(validMix(s1,s2,reversed,i1,i2,i)){
            System.out.println("yes");
        }
        else{
            System.out.println("no");
        }
    }
}
