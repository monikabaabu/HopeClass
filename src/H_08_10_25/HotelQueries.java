//Time limit: 1.00 s
//        Memory limit: 512 MB
//
//        There are n hotels on a street. For each hotel you know the number of free rooms. Your task is to assign hotel rooms for groups of tourists. All members of a group want to stay in the same hotel.
//        The groups will come to you one after another, and you know for each group the number of rooms it requires. You always assign a group to the first hotel having enough rooms. After this, the number of free rooms in the hotel decreases.
//        Input
//        The first input line contains two integers n and m: the number of hotels and the number of groups. The hotels are numbered 1,2,\ldots,n.
//        The next line contains n integers h_1,h_2,\ldots,h_n: the number of free rooms in each hotel.
//        The last line contains m integers r_1,r_2,\ldots,r_m: the number of rooms each group requires.
//        Output
//        Print the assigned hotel for each group. If a group cannot be assigned a hotel, print 0 instead.
//        Constraints
//
//        1 \le n,m \le 2 \cdot 10^5
//        1 \le h_i \le 10^9
//        1 \le r_i \le 10^9
//
//        Example
//        Input:
//        8 5
//        3 2 4 1 5 5 2 6
//        4 4 7 1 1
//
//        Output:
//        3 5 0 1 1

package H_08_10_25;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
public class HotelQueries {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int lg=0;
        while((1<<lg)<n){
            lg++;
        }
        int N=(1<<lg);
        int[] arr=new int[2*(1<<lg)];
        st = new StringTokenizer(br.readLine());
        for(int i=N;i<N+n;i++){
            arr[i]=Integer.parseInt(st.nextToken());

        }
        for(int i=N-1;i>=1;i--){
            arr[i]=Math.max(arr[i+i],arr[i+i+1]);
        }
        StringBuilder result=new StringBuilder();
        st = new StringTokenizer(br.readLine());
        while(q-->0){
            int x = Integer.parseInt(st.nextToken());
            int res=find(arr,1,0,N-1,x,N)+1;
            result.append(res).append("\t");
        }
        System.out.println(result);
    }
    public static int find(int[] arr,int node,int nl,int nr,int x,int N){
        if(arr[node]<x){
            return -1;
        }
        if(nl==nr){
            arr[node]-=x;
            return node-N;
        }
        int mid=(nl+nr)/2;
        int left=find(arr,2*node,nl,mid,x,N);
        if(left!=-1){
            arr[node]=Math.max(arr[node*2],arr[node*2+1]);
            return left;
        }
        int right=find(arr,2*node+1,mid+1,nr,x,N);
        if(right!=-1){
            arr[node]=Math.max(arr[node*2],arr[node*2+1]);
            return right;
        }
        return -1;
    }
}