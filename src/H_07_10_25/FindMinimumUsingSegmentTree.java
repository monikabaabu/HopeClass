package H_07_10_25;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinimumUsingSegmentTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int N=0;
        while((1<<N)<n){
            N++;
        }
        N = (1<<N);
        int arr[] = new int[2*N];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[0]=0;
        for (int i =0; i < n; i++) {
            arr[i+N] = sc.nextInt();
        }
        for (int i = N-1; i>=1; i--) {
            arr[i]=Math.min(arr[2*i],arr[2*i+1]);
        }
        for (int i = 0; i <2*N ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println(arr[1]);

    }
}
