//**Stair Climbing - Damaged Stairs**
//
//There are **N** stairs to be climbed in a building.
// A robot can take only **S** different leaps each containing certain distinct steps which are passed as the input.
// But **T** stairs are damaged and hence the robot cannot land on those stairs.
// The damaged stair numbers are passed as the input.
// The program must print the number of way **C** of steps the robot can take to climb **N** stairs.
//
//**Boundary Condition(s):**
//        1 <= N <= 50
//        1 <= S <= 10
//        1 <= T <= N
//
//**Input Format:**
//The first line contains **N**, **S** and **T** separated by a space.
//The second line contains **S** integer values separated by a space.
//The third line contains **T** integer values separated by a space.
//
//        **Output Format:**
//The first line contains the **C**.
//
//        **Example Input/Output 1:**
//Input:
//        5 2 1
//        2 3
//        2
//
//Output:
//        1
//
//Explanation:
//There are 5 steps. The robot can take 2 or 3 steps at a time.
//So the possible way is
//3 2
//        (2 3 is not possible as step 2 is damaged.)
//
//        **Example Input/Output 2:**
//Input:
//        10 2 3
//        2 3
//        2 4 6
//
//Output:
//        2
//
//Explanation:
//The possible ways are
//3 5 7 10
//        3 5 8 10
//
//        youtube:
//            code:https://youtu.be/xXn-rTWzpHs

package PrimeContent.ElevateSet02;
import java.util.*;
public class StairClimbingDamagedStairs_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of stairs:");
        int n = sc.nextInt();
        System.out.println("enter the no of leaps");
        int l = sc.nextInt();
        System.out.println("enter the no of damaged stairs");
        int d = sc.nextInt();
        int[] leaps = new int[l];
        System.out.println("enter the leaps");
        for (int i = 0; i <l ; i++) {
            leaps[i] = sc.nextInt();
        }
        int[] damaged = new int[d+1];

        System.out.println("enter the damaged stairs");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <d ; i++) {
            list.add(sc.nextInt());
        }
        long[] ways = new long[n+1];
        ways[0] = 1;
        for (int i = 1; i <=n; i++) {
                for (int j = 0; j < l; j++) {
                    if (!list.contains(i) && i >= leaps[j]) {
                        ways[i] += ways[i - leaps[j]];
                    }
                }
            }


        System.out.println(ways[n]);
    }
}
