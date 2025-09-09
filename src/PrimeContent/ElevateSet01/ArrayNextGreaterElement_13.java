//The program must accept an integer array of size N as the output.
// The program must print the next greater element for every element in the array.
// If there is no next greater element for an element,
// the program must print the same element as they are.
//
//        Boundary Condition(s):
//        1 <= N <= 10^5
//
//Input Format:
//The first line contains N.
//The second line contains N integers separated by a space.
//
//Output Format:
//The first line contains the N integers which represent the next greater elements.
//
//Example Input/Output 1:
//Input:
//        7
//        2 1 5 15 10 6 20
//Output:
//        5 5 15 20 20 20 20
//
//Example Input/Output 2:
//Input:
//        10
//        7 5 3 15 100 60 200 15 999 1
//Output:
//        15 15 15 100 200 200 999 999 999 1
// youtbe:
//   logic: https://youtu.be/0CuD-TV7cvw
//   code: https://youtu.be/gWEDQFPwYJc?si=BiqGTTaTBdrM-vkg
package PrimeContent.ElevateSet01;
import java.util.*;
public class ArrayNextGreaterElement_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size");
        int n = sc.nextInt();
        System.out.println("enter array elements:");
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i]= sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for (int i = n-1; i>=0; i--) {
            while(!stack.isEmpty() && stack.peek()<= arr[i]){
                stack.pop();
            }
            ans[i] = stack.isEmpty()? arr[i] : stack.peek();
            stack.push(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i]+" ");
        }
    }
}
