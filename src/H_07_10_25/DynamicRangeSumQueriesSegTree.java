//Time limit: 1.00 s
//        Memory limit: 512 MB
//
//        Given an array of n integers, your task is to process q queries of the following types:
//
//        update the value at position k to u
//        what is the sum of values in range [a,b]?
//
//        Input
//        The first input line has two integers n and q: the number of values and queries.
//        The second line has n integers x_1,x_2,\dots,x_n: the array values.
//        Finally, there are q lines describing the queries. Each line has three integers: either "1 k u" or "2 a b".
//        Output
//        Print the result of each query of type 2.
//        Constraints
//
//        1 \le n,q \le 2 \cdot 10^5
//        1 \le x_i, u \le 10^9
//        1 \le k \le n
//        1 \le a \le b \le n
//
//        Example
//        Input:
//        8 4
//        3 2 4 5 1 1 5 3
//        2 1 4
//        2 5 6
//        1 3 1
//        2 1 4
//
//        Output:
//        14
//        2
//        11

package H_07_10_25;
import java.io.*;
import java.util.*;

public class DynamicRangeSumQueriesSegTree {
    private static void update(long[] arr, int node, int leftNode, int rightNode, int leftQuery, int rightQuery,int val) {
        if (leftNode > rightQuery || rightNode < leftQuery) {
            return;
        }
        if (leftQuery <= leftNode && rightNode <= rightQuery) {
            arr[node] = val;
            return;
        }
        int mid = (leftNode+rightNode)/2;
        update(arr, node*2, leftNode, mid, leftQuery, rightQuery, val);
        update(arr, node*2+1, mid+1, rightNode, leftQuery, rightQuery, val);
        arr[node]=arr[node*2]+arr[node*2+1];
        return;
    }
    private static long find(long[] arr, int node, int leftNode, int rightNode , int leftQuery , int rightQuery){
        if(leftNode>rightQuery || rightNode <leftQuery){
            return 0;
        }
        if(leftQuery<= leftNode && rightNode <= rightQuery){
            return arr[node];
        }
        int mid = (leftNode + rightNode) / 2;
        long left = find(arr, node * 2, leftNode, mid, leftQuery, rightQuery);
        long right = find(arr, node * 2 + 1, mid + 1, rightNode, leftQuery, rightQuery);
        return left+right;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int N =1;
        while(N<n){
            N<<=1;
        }
        long[] arr = new long[2*N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n ; i++) {
            arr[i+N] = Long.parseLong(st.nextToken());
        }
        for (int i = N-1; i >=1 ; i--) {
            arr[i] = arr[2*i]+arr[(2*i)+1];
        }
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(op==1){
                update(arr,1,0,N-1,x-1,x-1,y);
            }
            else {
                long res = find(arr, 1, 0, N - 1, x - 1, y - 1);
                list.add(res);
            }
        }

        for (long val : list) {
            bw.write(val + "\n");
        }
        bw.flush();
    }
}
