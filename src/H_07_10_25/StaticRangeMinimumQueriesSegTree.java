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

    private static long find(long[] arr , int node, int leftNode, int rightNode, int leftQuery, int rightQuery){
        if(leftQuery> rightNode || rightQuery <leftNode){
            return Long.MAX_VALUE;
        }
        if(leftQuery <= leftNode && rightQuery >= rightNode){
            return arr[node];
        }
        int mid = (leftNode+rightNode)/2;
        long left = find(arr, 2*node,leftNode, mid, leftQuery, rightQuery);
        long right = find(arr, 2*node+1,  mid+1,rightNode, leftQuery, rightQuery);
        return  Math.min(left,right);
    }
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int N =0;
        while ((1<<N)<n){
            N++;
        }
        N=1<<N;
        long[] segmentTable = new long[2*N];
        Arrays.fill(segmentTable,Long.MAX_VALUE);
        segmentTable[0] = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            segmentTable[i+N] = Long.parseLong(st.nextToken());
        }
        for (int i = N-1; i >=1 ; i--) {
            segmentTable[i] = Math.min(segmentTable[2*i] , segmentTable[2*i+1]);
        }
        List<Long> list = new ArrayList<>();

        for (int i = 0; i <q ; i++) {
            st = new StringTokenizer(br.readLine());
            int leftQuery = Integer.parseInt(st.nextToken());
            int rightQuery = Integer.parseInt(st.nextToken());
            long res =find(segmentTable,1,0,N-1,leftQuery-1,rightQuery-1);
            list.add(res);
        }
        for (long val: list){
            bw.write(val+"\n");
        }
        bw.flush();
    }
}