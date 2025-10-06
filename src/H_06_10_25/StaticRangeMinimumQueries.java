//Time limit: 1.00 s
//Memory limit: 512 MB
//
//Given an array of n integers, your task is to process q queries of the form: what is the minimum value in range [a,b]?
//Input
//The first input line has two integers n and q: the number of values and queries.
//The second line has n integers x_1,x_2,\dots,x_n: the array values.
//        Finally, there are q lines describing the queries. Each line has two integers a and b: what is the minimum value in range [a,b]?
//Output
//Print the result of each query.
//Constraints
//
//1 \le n,q \le 2 \cdot 10^5
//        1 \le x_i \le 10^9
//        1 \le a \le b \le n
//
//Example
//Input:
//        8 4
//        3 2 4 5 1 1 5 3
//        2 4
//        5 6
//        1 8
//        3 3
//
//Output:
//        2
//        1
//        1
//        4

package H_06_10_25;

import java.util.Scanner;

public class StaticRangeMinimumQueries {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int Q=in.nextInt();
        int[] logr=new int[N+1];
        logr[1]=1;
        for(int val=2;val<=N;val++){
            logr[val]=logr[val/2]+1;
        }
        int[][] stbl=new int[logr[N]][N];
        for(int c=0;c<N;c++){
            stbl[0][c]=in.nextInt();
        }
        for(int r=1;r<logr[N];r++){
            for(int c=0;c<=N-(1<<r);c++){
                stbl[r][c]=Math.min(stbl[r-1][c],stbl[r-1][c+(1<<r-1)]);
            }
        }
        while(Q-- >0){
            int left=in.nextInt();
            int right=in.nextInt();
            left--; right--;
            int range=right-left+1;
            int pow=logr[range]-1;
            System.out.println(Math.min(stbl[pow][left],stbl[pow][right+1-(1<<pow)]));

        }
    }
}
