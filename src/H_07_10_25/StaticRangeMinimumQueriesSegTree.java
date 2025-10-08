//Time limit: 1.00 s
//        Memory limit: 512 MB
//
//        Given an array of n integers, your task is to process q queries of the form: what is the minimum value in range [a,b]?
//        Input
//        The first input line has two integers n and q: the number of values and queries.
//        The second line has n integers x_1,x_2,\dots,x_n: the array values.
//        Finally, there are q lines describing the queries. Each line has two integers a and b: what is the minimum value in range [a,b]?
//        Output
//        Print the result of each query.
//        Constraints
//
//        1 \le n,q \le 2 \cdot 10^5
//        1 \le x_i \le 10^9
//        1 \le a \le b \le n
//
//        Example
//        Input:
//        8 4
//        3 2 4 5 1 1 5 3
//        2 4
//        5 6
//        1 8
//        3 3
//
//        Output:
//        2
//        1
//        1
//        4

package H_07_10_25;
import java.io.*;
import java.util.*;

public class StaticRangeMinimumQueriesSegTree {
    private static int find(int[] arr, int node, int leftNode, int rightNode, int leftQuery, int rightQuery) {
        if (leftNode > rightQuery || rightNode < leftQuery) {
            return Integer.MAX_VALUE;
        }
        if (leftQuery <= leftNode && rightNode <= rightQuery) {
            return arr[node];
        }
        int mid = (leftNode + rightNode) / 2;
        int left = find(arr, node * 2, leftNode, mid, leftQuery, rightQuery);
        int right = find(arr, node * 2 + 1, mid + 1, rightNode, leftQuery, rightQuery);
        return Math.min(left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int N = 1;
        while (N < n) N <<= 1;
        int[] arr = new int[2 * N];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i + N] = Integer.parseInt(st.nextToken());
        }

        for (int i = N - 1; i >= 1; i--) {
            arr[i] = Math.min(arr[2 * i], arr[2 * i + 1]);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int res = find(arr, 1, 0, N - 1, x - 1, y - 1);
            list.add(res);
        }

        for (int val : list) {
            bw.write(val + "\n");
        }
        bw.flush();
    }
}
