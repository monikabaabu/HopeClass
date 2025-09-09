//
//Reverse Numbers using Stack
//        The program must accept N integers and print them in reverse order using stack. Please fill in the missing lines of code so that the program runs successfully.
//        Example Input/Output 1:
//        Input:
//        5
//        10 20 30 50 40
//        Output:
//        40 50 30 20 10
//        Example Input/Output 2:
//        Input:
//        10
//        1919 89 50 21 72 41 28 58
//        Output:
//        58 28 41 72 21 50 89 9 1 19
// youtube:  https://youtu.be/daHp_G7eDS8?si=Wl9pVdX08d3DRB6n
package PrimeContent.ElevateSet01;
import java.util.*;
public class ReverseNumbersUsingStack_12 {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        System.out.println("enter array size:");
        int n = sc.nextInt();
        System.out.println("enter elements:");
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }
}
// c code
// ```c
//#include <stdio.h>
//#include <stdlib.h>
//
//int arr[10000];
//int top = -1;
//
//int peek() {
//  return arr[top];
//}
//
//int pop() {
//  return arr[top--];
//}
//
//int isEmpty() {
//  return top == -1 ? 1 : 0;
//}
//
//void push(int val) {
//  arr[++top] = val;
//}
//
//int main() {
//  int N, currVal;
//  scanf("%d", &N);
//  for(int ctr=1; ctr <= N; ctr++)
//  {
//    scanf("%d",&currVal);
//    push(currVal);
//  }
//
//  while(!isEmpty())
//  {
//    printf("%d ",pop());
//  }
//
//  return 0;
//} // end of main function
//```
