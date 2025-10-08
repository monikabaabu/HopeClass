//Time limit: 1.00 s
//Memory limit: 512 MB
//
//Given an array of n integers, your task is to process q queries of the following types:
//
//increase each value in range [a,b] by u
//what is the value at position k?
//
//Input
//The first input line has two integers n and q: the number of values and queries.
//The second line has n integers x_1,x_2,\dots,x_n: the array values.
//        Finally, there are q lines describing the queries. Each line has three integers: either "1 a b u" or "2 k".
//Output
//Print the result of each query of type 2.
//Constraints
//
//1 \le n,q \le 2 \cdot 10^5
//        1 \le x_i, u \le 10^9
//        1 \le k \le n
//1 \le a \le b \le n
//
//Example
//Input:
//        8 3
//        3 2 4 5 1 1 5 3
//        2 4
//        1 2 5 1
//        2 4
//
//Output:
//        5
//        6

package H_08_10_25;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class RangeUpdateQueries {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;
        FastScanner(InputStream in) { br = new BufferedReader(new InputStreamReader(in)); }
        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
        int nextInt() throws IOException { return Integer.parseInt(next()); }
        long nextLong() throws IOException { return Long.parseLong(next()); }
    };
    public static void main(String[] args) throws IOException{
        FastScanner fs=new FastScanner(System.in);
        int n=fs.nextInt();
        int q=fs.nextInt();
        int lg=0;
        while((1<<lg)<n) {
            lg++;
        }
        int pow=1<<lg;
        long[] tbl=new long[pow*2];
        for(int i=0;i<n;i++) {
            tbl[pow+i]=fs.nextLong();
        }
        StringBuilder sb=new StringBuilder();
        while(q-->0) {
            int type=fs.nextInt();
            if(type==1) {
                int left=fs.nextInt();
                int right=fs.nextInt();
                left--;right--;
                int val=fs.nextInt();
                update(tbl,1,0,pow-1,left,right,val);
            }
            else {
                int left=fs.nextInt();
                left--;
                sb.append(range(tbl,1,0,pow-1,left,left)).append('\n');
            }
        }
        System.out.println(sb);
    }
    private static long range(long[] tbl, int idx, int nl, int nr, int ql, int qr) {
        if(nl>qr||nr<ql) {
            return 0L;
        }
        if(nl==ql&&nr==qr) {
            return tbl[idx];
        }
        int mid=(nl+nr)>>>1;

        long left= range(tbl,idx<<1,nl,mid,ql,qr);
        long right= range(tbl,(idx<<1)|1,mid+1,nr,ql,qr);
        return left+right+tbl[idx];

    }
    private static void update(long[] tbl, int idx, int nl, int nr, int ql, int qr, int val) {
        if(nl>qr||nr<ql) {
            return;
        }
        if(ql<=nl&&qr>=nr) {
            tbl[idx]+=val;
            return;
        }
        int mid=(nl+nr)>>>1;
        update(tbl,(idx<<1),nl,mid,ql,qr,val);
        update(tbl,(idx<<1)|1,mid+1,nr,ql,qr,val);
    }


}