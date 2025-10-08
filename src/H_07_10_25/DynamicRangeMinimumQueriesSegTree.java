package H_07_10_25;
import java.io.*;
import java.util.*;

public class DynamicRangeMinimumQueriesSegTree {
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
        arr[node]=Math.min(arr[node*2],arr[node*2+1]);
        return;
    }
    private static long find(long[] arr, int node, int leftNode, int rightNode, int leftQuery, int rightQuery) {
        if (leftNode > rightQuery || rightNode < leftQuery) {
            return Long.MAX_VALUE;
        }
        if (leftQuery <= leftNode && rightNode <= rightQuery) {
            return arr[node];
        }
        int mid = (leftNode + rightNode) / 2;
        long left = find(arr, node * 2, leftNode, mid, leftQuery, rightQuery);
        long right = find(arr, node * 2 + 1, mid + 1, rightNode, leftQuery, rightQuery);
        return Math.min(left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long q = Long.parseLong(st.nextToken());

        int N = 1;
        while (N < n) N <<= 1;
        long[] arr = new long[2 * N];
        Arrays.fill(arr, Long.MAX_VALUE);
        arr[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i + N] = Long.parseLong(st.nextToken());
        }

        for (int i = N - 1; i >= 1; i--) {
            arr[i] = Math.min(arr[2 * i], arr[2 * i + 1]);
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
