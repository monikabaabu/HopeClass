//Sub-Array Sum
//
//The program must accept an integer array of size N and an integer S as the input.
// The program must print Yes if any of the sub-arrays is having the sum of their elements as S.
// Else the program must print No as the output.
//
//        Boundary Condition(s):
//
//        2<=N<=10
//        5
//
//        1<= Each integer value <=1000
//
//Input Format:
//
//The first line contains N.
//The second line contains N integers separated by a space.
//The third line contains S.
//
//Output Format:
//
//The first line contains Yes or No.
//
//Example Input/Output 1:
//
//Input:
//        5
//        5 10 50 20 25
//        45
//
//Output:
//Yes
//
//Explanation:
//The integers in the sub-array which is having the sum of their elements as 45 are given below.
//20 25
//
//Example Input/Output 2:
//
//Input:
//        6
//        4 7 1 5 4 6
//        14
//
//Output:
//No
// youtube:
//    logic: https://youtu.be/OpJmdGwzsAM
//    code: https://youtu.be/c6007z_2oj4

package PrimeContent.ElevateSet01;
import java.util.*;
public class SubArraySum_16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array size:");
        int n = sc.nextInt();
        System.out.println("enter the elements");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();

        }
        System.out.println("enter s");
        int s = sc.nextInt();
        int curr = 0;
        boolean found = false;
        int j=0;
        for(int i=0; i<n;i++){
            curr+=arr[i];
            while(curr>s){
                curr-=arr[j];
                j++;
            }

            if( curr == s){
                found = true;
                break;
            }
        }
        if(found){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
    }
}
