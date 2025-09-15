//Social Media Leader
//
//There are N people in a facebook group. The group follows the following three rules.
//1) The group leader does not follow, anyone.
//        2) Everyone in the group follows the group leader.
//        3) No more than one group leader is allowed.
//The N people are numbered from 1 to N. The program must accept the integer N and R relationships.
// Each relationship contains two integers representing who follows whom.
//The program must print an integer denoting the group leader.
// If the group leader can not be found, the program must print -1 as the output.
//
//        Boundary Condition(s):
//        2 <= N <= 10^5
//        1 <= R <= 10^5
//
//Input Format:
//The first line contains N and R separated by a space.
//The next R lines, each containing 2 integers separated by a space.
//
//Output Format:
//The first line contains an integer denoting the group leader or -1.
//
//Example Input/Output 1:
//Input:
//        5 7
//        1 3
//        2 3
//        3 4
//        5 3
//        1 4
//        5 4
//        2 4
//
//Output:
//        4
//
//Explanation:
//Here the group leader is 4 as everyone follows 4 in the group and the 4 has not followed anyone.
//
//Example Input/Output 2:
//Input:
//        5 9
//        1 2
//        2 4
//        3 4
//        1 5
//        1 4
//        4 2
//        5 4
//        2 5
//        4 2
//
//Output:
//        -1
//        youtube:
//        logic:https://youtu.be/Nafe075kYT8
//        code:https://youtu.be/bkaB6fCXj14

package PrimeContent.ElevateSet01;
import java.util.*;
public class SocialMediaLeader_25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int[][] grid = new int[r][2];
        int[] arr = new int[n+1];
        for (int i = 0; i < r ; i++) {
            for (int j = 0; j <2; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < r ; i++) {
            arr[grid[i][0]]--;
        }
        for (int i = 0; i <r ; i++) {
            arr[grid[i][1]]++;
        }
        int count =-1;
        for (int i = 0; i < n+1; i++) {
            if(arr[i] == n-1){
                count = i;
            }
        }
        System.out.println(count);
    }
}
