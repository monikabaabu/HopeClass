//The program must accept an integer K and a string S containing only alphabets as the input.
// The program must print the count of consonants in each sliding window of size K in the string S as the output.
//
//Boundary Condition(s):
//        1<=K<= Length of S <=10
//        5
//
//
//Input Format:
//The first line contains K.
//The second line contains S.
//
//Output Format:
//The first line contains the count of consonants in each sliding window of size K in the string S.
//
//Example Input/Output 1:
//Input:
//        3
//pineapple
//
//Output:
//        2 1 1 1 2 3 2
//
//Explanation:
//The sliding window size K = 3.
//        1st window is pin -> 2 consonants
//2nd window is ine -> 1 consonant
//3rd window is nea -> 1 consonant
//4th window is eap -> 1 consonant
//5th window is app -> 2 consonants
//6th window is ppl -> 3 consonants
//7th window is ple -> 2 consonants
//
//Example Input/Output 2:
//Input:
//        2
//PROGRAMMING
//
//Output:
//        2 1 1 2 1 1 2


package PrimeContent.ElevateSet01;
import java.util.*;

public class DP_ConsonantsCountInSlidingWindow {
    private static boolean isConsonant(char ch){
        ch = Character.toLowerCase(ch);
        return "aeiou".indexOf(ch) == -1;
    }
    public static void main(String[] args) {
        
    Scanner sc = new Scanner(System.in);
        System.out.println("enter the k value:");
        int k = sc.nextInt();
        System.out.println("enter the String:");
        String s =  sc.next();
        int count=0;
        for (int i = 0; i < k; i++) {
            if(isConsonant(s.charAt(i))){
                count++;
            }
                
            }
        System.out.print (count+" ");
        for(int i=k; i< s.length();i++){
            if(isConsonant(s.charAt(i-k))){
                count--;
            }
            if(isConsonant(s.charAt(i))){
                count++;
            }
            System.out.print(count+" ");
        }
        }
}
