//Minimum Swaps - Descending Order
//
//The program must accept $N$ integers from $1$ to $N$ in any order as the input. The program must print the minimum number of swaps required to order those $N$ integers in descending order as the output.
//
//        Boundary Condition(s):
//$1 \le N \le 1000$
//
//Input Format:
//The first line contains $N$.
//The second line contains $N$ integers separated by a space.
//
//Output Format:
//The first line contains the minimum number of swaps required.
//
//Example Input/Output 1:
//Input:
//        5
//        4 5 1 3 2
//
//Output:
//        3
//
//Explanation:
//The integers 5 and 4 can be swapped.
//Now the integers become 5 4 1 3 2.
//Then the integers 2 and 1 can be swapped.
//Now the integers become 5 4 2 3 1.
//Then the integers 2 and 3 can be swapped.
//Now the integers become 5 4 3 2 1.
//So at least 3 swaps are required.
//        Hence 3 is printed.
//
//Example Input/Output 2:
//Input:
//        7
//        2 7 6 3 5 4 1
//
//Output:
//        5
//        youtube:
//        code:https://youtu.be/ZSAJLor3hSI

package PrimeContent.ElevateSet02;
import java.util.*;
public class MinimumSwaps_DescendingOrder_21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n + 1];
        for (int i = n; i >=1 ; i--) {
            num[i] = sc.nextInt();
        }
        int swap=0;
        boolean[] vis = new boolean[n+1];
        for (int i = 1; i <=n ; i++) {
            if(vis[num[i]]){
                continue;
            }
            if(num[i]==i){
                vis[num[i]]=true;
                continue;
            }
            int edge=0;
            int cycleindex=i;

            while (!vis[num[cycleindex]]){
                edge++;
                vis[num[cycleindex]]=true;
                cycleindex=num[cycleindex];
            }

            swap+=edge-1;
        }
        System.out.println(swap);
    }
}
