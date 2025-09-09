//The program must accept an integer array of size N as the input.
//The program must remove the adjacent values in the array if they are equal.
//The program must repeat the process till there are no more equal adjacent values in the array.
// Finally, the program must print the integers in the array as the output.
// If there is no integer in the array, the program must print -1 as the output.
//
//        Boundary Condition(s):
//
//        1<=N<=10
//        5
//
//
//Input Format:
//
//The first line contains N.
//The second line contains N integers separated by a space.
//
//Output Format:
//
//The first line contains the integers in the modified array or -1.
//
//Example Input/Output 1:
//
//Input:
//        9
//        20 15 10 30 30 10 15 50 90
//
//Output:
//        20 50 90
//
//Example Input/Output 2:
//
//Input:
//        6
//        10 20 30 30 20 10
//
//Output:
//        -1
// youtube:
//     logic:https://youtu.be/s9sVtzW97Ek
//    code: https://youtu.be/E_NoLTyWXYQ
package PrimeContent.ElevateSet01;
import java.util.*;
public class RemoveAdjacentEqualValues_14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("enter elements");
        for (int i = 0; i <n ; i++) {
           arr[i] = sc.nextInt();

        }
        Stack<Integer> stack = new Stack<>();
        for (int i = n-1; i >=0; i--) {

            if(!stack.isEmpty() && stack.peek() == arr[i]){
                stack.pop();
            }
            else {
                stack.push(arr[i]);
            }

        }
        if(stack.isEmpty()){
            System.out.println("-1");
        }
        else {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }
}
