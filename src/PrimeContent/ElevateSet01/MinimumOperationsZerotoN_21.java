//Minimum Operations - Zero to N
//
//        The program must accept an integer N as the input.
//        The program must print the minimum number of operations required to reach N from 0.
//        There are two types of operations which are given below.
//        - Double the integer
//        - Add one to the integer
//
//        Boundary Condition(s):
//        1 <= N <= 10^8
//
//        Input Format:
//        The first line contains N.
//
//        Output Format:
//        The first line contains the minimum number of operations required to reach N from 0.
//
//        Example Input/Output 1:
//        Input:
//        8
//
//        Output:
//        4
//
//        Explanation:
//        Here N = 8
//        1st operation = 0 + 1 = 1
//        2nd operation = 1 + 1 = 2
//        3rd operation = 2 * 2 = 4
//        4th operation = 4 * 2 = 8
//
//        Example Input/Output 2:
//        Input:
//        43
//
//        Output:
//        9
// youtube:
//         logic:https://youtu.be/4yx56XLZeHc
//         code:https://youtu.be/5ODK6muM04k

package PrimeContent.ElevateSet01;
import java.util.*;
public class MinimumOperationsZerotoN_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count =0;

        while(n>0){
            if(n%2==0){
                n = n/2;
                count++;
            }
            else{
                n--;
                count++;
            }
        }
        System.out.println(count);
    }
}

