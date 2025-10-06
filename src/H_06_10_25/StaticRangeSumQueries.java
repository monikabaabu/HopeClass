//Time limit: 1.00 s
//Memory limit: 512 MB
//
//Given an array of n integers, your task is to process q queries of the form: what is the sum of values in range [a,b]?
//Input
//The first input line has two integers n and q: the number of values and queries.
//The second line has n integers x_1,x_2,\dots,x_n: the array values.
//        Finally, there are q lines describing the queries. Each line has two integers a and b: what is the sum of values in range [a,b]?
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
//        11
//        2
//        24
//        4

//package H_06_10_25;
import java.util.*;
public class StaticRangeSumQueries {
    public static void main(String[] args) {
            List<Long> list = new ArrayList<>();
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int q = sc.nextInt();
            long[] arr = new long[n + 1];
            long[] prefix = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextLong();
                prefix[i] = prefix[i - 1] + arr[i];
            }
            for (int i = 0; i < q; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                long sum = prefix[b] - prefix[a - 1];
                list.add(sum);
            }
            for (int i = 0; i <list.size() ; i++) {
            System.out.println(list.get(i));
        }

    }
}
