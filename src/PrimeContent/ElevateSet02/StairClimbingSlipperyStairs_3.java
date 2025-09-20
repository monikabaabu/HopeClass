//**Stair Climbing - Slippery Stairs**
//
//There are **N** stairs to be climbed in a building.
// A robot can take only **S** different leaps each containing certain distinct steps which are passed as the input.
// But **T** stairs are slippery and hence the robot will slip to the bottom stair if it lands on a slippery stair.
// The slippery stair numbers are passed as the input.
// The program must print the number of ways **C** of steps the robot can take to climb **N** stairs.
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
//The first line contains the value of **C**.
//
//        **Example Input/Output 1:**
//Input:
//        5 2 1
//        2 3
//        2
//
//Output:
//        2
//
//Explanation:
//There are 5 steps. The robot can take **2** or **3** steps at a time.
//So the possible ways are
//3 2
//        1 2 2 (as the robot will slip to step 1 when it lands on step 2 which is slippery)
//
//        **Example Input/Output 2:**
//Input:
//        6 2 1
//        2 3
//        2
//
//Output:
//        3
//
//Explanation:
//The possible ways are
//1 2 3 (as the robot will slip to step 1 when it lands on step 2 which is slippery)
//        1 3 2 (as the robot will slip to step 1 when it lands on step 2 which is slippery)
//        3 3
//        youtube:
//            logic:https://youtu.be/WLHVXn0tlzk
//            code:https://youtu.be/N4nAZmHmFzA

package PrimeContent.ElevateSet02;
import java.util.*;
public class StairClimbingSlipperyStairs_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of stairs");
        int n = sc.nextInt();
        System.out.println("enter the no of leaps");
        int s = sc.nextInt();
        System.out.println("enter the no of slippery stairs :");
        int t = sc.nextInt();
        System.out.println("enter the leaps:");
        int[] leaps = new int[s];
        for (int i = 0; i < s; i++) {
            leaps[i] = sc.nextInt();
        }
        System.out.println("enter the slippery stairs");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            list.add(sc.nextInt());
        }
        long[] ways = new long[n+1];
        ways[0] =1;
        for (int i = 1; i <=n; i++) {
            for (int j = 0; j <s ; j++) {
                if (i >= leaps[j]) {
                    ways[i] += ways[i - leaps[j]];
                }
            }
                if(list.contains(i)){
                    int step = i-1;
                    while(list.contains(step) && step>0){
                        step--;
                    }
                    if(step>0){
                        ways[step] += ways[i];
                    }
                    ways[i]=0;
                }
            }

        System.out.println(ways[n]);
    }
}
