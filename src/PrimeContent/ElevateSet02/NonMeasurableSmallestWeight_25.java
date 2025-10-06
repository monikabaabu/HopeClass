//Non-Measurable Smallest Weight
//A shop-keeper is having N integer values representing the measurement weights. He wishes to find the smallest integer value of weight that cannot be measured using these N weights. Please help the shop keeper by completing the program.
//
//        Boundary Condition(s):
//        1≤N≤1000
//        1≤ Each weight value ≤500
//
//Input Format:
//The first line contains N.
//The second line contains the N integer values separated by a space.
//
//Output Format:
//The first line contains an integer value.
//
//Example Input/Output 1:
//Input:
//
//        4
//        2 4 1 10
//Output:
//
//        8
//Explanation:
//        1, 2, 4 and 10 can be measured using the given single measurement.
//        3 - 1 and 2
//        5 - 1 and 4
//        6 - 2 and 4
//        7 - 1, 2 and 4
//        8 - cannot be measured and hence is printed as the output.
//
//Example Input/Output 2:
//Input:
//
//        5
//        1 4 2 4 3
//Output:
//
//        15
//        youtube:
//        logic:https://youtu.be/xhUaf69VB9Y
//        code:https://youtu.be/4sBI8lhJzXw


package PrimeContent.ElevateSet02;
import java.util.*;
public class NonMeasurableSmallestWeight_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i <n ; i++) {
            arr[i] = sc.nextInt();
        }
        int m =1;
        Arrays.sort(arr);
        for (int i = 0; i <n ; i++) {
            if(arr[i]<=m){
                m+=arr[i];
            }
            else{
                break;
            }
        }
        System.out.println(m);
    }
}
