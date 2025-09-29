//Largest Possible Odd Integer
//
//The program must accept an integer N as the input. The program must print the largest possible odd integer using all the digits in N as the output. If it is not possible to form such an integer, the program must print no as the output.
//
//        Boundary Condition(s):
//        10 <= N <= 10^17
//
//Input Format:
//The first line contains N.
//
//Output Format:
//The first line contains the largest possible odd integer using all the digits in N or no.
//
//Example Input/Output 1:
//Input:
//        120087460153
//
//Output:
//        876543210001
//
//Explanation:
//The largest possible odd integer using all the digits in 120087460153 is **87654321001**.
//
//Example Input/Output 2:
//Input:
//        246228
//
//Output:
//no
//youtube:
//        logic:https://youtu.be/4bhOb1kgbCM
//        code:https://youtu.be/zRlyOhLxCro

package PrimeContent.ElevateSet02;
import java.util.*;
public class LargestPossibleOddInteger_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextInt();
        int[] digit = new int[10];
        while (n > 0) {
            int rem = (int)(n % 10);
            digit[rem]++;
            n /= 10;
        }
        int unitdigit = -1;
        for (int i = 1; i <=9; i+=2) {
            if ( digit[i] > 0) {
                unitdigit = i;
                digit[i]--;
                break;
            }
        }
        if(unitdigit==-1) {
            System.out.println("no");
        }else{
            boolean leadingzero = true;
            for (int i = 9; i >= 0; i--) {
                while (digit[i] > 0) {
                    if(i==0 && leadingzero){
                        digit[i]--;
                        continue;
                    }
                    leadingzero=false;
                    System.out.print(i);
                    digit[i]--;
                }
            }
            System.out.print(unitdigit);
        }
    }
}
