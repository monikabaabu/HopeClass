//Minimum Operations - X to Y
//
//        The program must accept two integers X and Y as the input. The program must print the minimum number of operations required to convert the integer X to Y. There are two types of operations which are given below.
//        - Double the integer
//        - Subtract one from the integer
//
//        Boundary Condition(s):
//        1 <= X, Y <= 10^8
//
//        Input Format:
//        The first line contains X and Y separated by a space.
//
//        Output Format:
//        The first line contains the minimum number of operations required to convert the integer X to Y.
//
//        Example Input/Output 1:
//        Input:
//        5 8
//
//        Output:
//        2
//
//        Explanation:
//        Here X = 5 and Y = 8.
//        1st operation = 5 - 1 = 4
//        2nd operation = 4 * 2 = 8
//
//        Example Input/Output 2:
//        Input:
//        10 1
//
//        Output:
//        9
//
//        Example Input/Output 3:
//        Input:
//        4 35
//
//        Output:
//        8
//        youtube:
//                logic:https://youtu.be/PuZxIcD_74A
//                code:https://youtu.be/2c-7zQE2iQU

package PrimeContent.ElevateSet01;
import java.util.*;
public class MinimumOperationsXtoY_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int count = 0;
        while(n2>n1){
            if(n2%2==0){
                n2/=2;
            }
            else{
                n2++;
            }
            count++;
        }
        count = count+ n1-n2;
        System.out.println(count);
    }
}
