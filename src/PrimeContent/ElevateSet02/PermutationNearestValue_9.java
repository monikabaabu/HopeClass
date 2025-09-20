//Permutation Nearest Value
//
//The program must accept two integers N and X as the input.
// The program must print the integer value nearest to X with all the digits in N as the output.
//
//        Boundary Condition(s):
//        10<=N,X<=10
//        8
//
//
//Input Format:
//The first lines contains N.
//
//Output Format:
//The first lines contains the integer value nearest to X with all the digits in N as the output.
//
//Example Input/Output 1:
//Input:
//        123 200
//
//Output:
//        213
//
//Explanation:
//The integer value nearest to the 200 with all the digits in 123 is 213.
//
//Example Input/Output 2:
//Input:
//        48871 88555
//
//Output:
//        88471
//        youtube:
//        logic:https://youtu.be/W04c2M5h5hI
//        code:https://youtu.be/x0kCwTkeTG0

package PrimeContent.ElevateSet02;
import java.util.*;
public class PermutationNearestValue_9 {
    static int n;
    static int closest;
    private static void swap(char s[], int x, int y){
        char temp = s[x];
        s[x]=s[y];
        s[y]=temp;
    }
    private static int abs(int a,int b){
        return a>b? a-b:b-a;
    }
    private static void permute(char[] s, int left, int right){
        if(left == right){
            int curr = Integer.parseInt(new String(s));
            if(abs(n,curr)<abs(n,closest)){
                closest = curr;
            }
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
        n = sc.nextInt();
        closest = Integer.parseInt(s);
        permute(str,0,s.length()-1);
        System.out.println(closest);
    }
}
