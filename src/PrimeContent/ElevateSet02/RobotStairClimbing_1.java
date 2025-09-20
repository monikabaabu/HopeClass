//Robot - Stair Climbing
//
//        There are N stairs to be climbed in a building. A robot can take only S different leaps each containing certain distinct steps which are passed as the input. The program must print the number of ways C of steps the robot can take to climb exactly N stairs.
//
//        Boundary Condition(s):1 <= N <= 501 <= S <= 10
//
//        Input Format:The first line contains N and S separated by a space.The second line contains S integer values separated by a space.
//
//        Output Format:The first line contains the C.
//
//        Example Input/Output 1:Input:
//        5 2
//        2 3
//
//        Output:2
//
//        Explanation:There are 5 steps. The robot can take 2 or 3 steps at a time.So the possible ways are2 3 and 3 2
//
//        Example Input/Output 2:Input:6 21 5
//
//        Output:3
//
//        Explanation:The possible ways are
//        1 1 1 1 1 1
//        5 1
//        1 5
//        youtube:
//                logic: https://youtu.be/oE-QLYhhaRc
//                code: https://youtu.be/KO79BUc4tMg

package PrimeContent.ElevateSet02;
import java.util.*;
public class RobotStairClimbing_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of stairs:");
        int N = sc.nextInt();
        System.out.println("enter no of leaps:");
        int L = sc.nextInt();
        int[] leaps = new int[L];
        for (int i = 0; i < L; i++) {
            leaps[i] = sc.nextInt();
        }
        long[] ways = new long[N+1];
        ways[0] =1;
        for (int i = 1; i <=N ; i++) {
            for (int j = 0; j < L; j++) {
                if(i>= leaps[j]){
                    ways[i] += ways[i-leaps[j]];
                }
            }
        }
        System.out.println(ways[N]);
    }
}
