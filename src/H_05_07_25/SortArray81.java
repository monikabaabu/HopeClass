package H_05_07_25;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
//Sort the array elements in descending order according to their frequency of occurrence
//
//Input Format
//
//11
//        2 2 3 4 5 12 2 3 3 3 12
//
//Constraints
//
//5<=n<=20 -100<=a[i]<=100
//
//Output Format
//
//3 3 3 3 2 2 2 12 12 4 5
//
//Sample Input 0
//
//        10
//        3 3 2 2 2 5 5 5 8 7
//Sample Output 0
//
//        2 2 2 5 5 5 3 3 7 8
public class SortArray81 {
        public static void main(String args[] ) throws Exception {
            Scanner sc=new Scanner(System.in);
            int size=sc.nextInt();
            int arr[]=new int[size];
            int max=Integer.MIN_VALUE;
            int min=Integer.MAX_VALUE;
            for(int i=0;i<size;i++){
                arr[i]=sc.nextInt();
                max=Math.max(max,arr[i]);
                min=Math.min(min,arr[i]);
            }
            if(min<0){
                min*=-1;
            }
            int freq[]=new int[max+min+1];
            for(int i=0;i<size;i++){
                freq[arr[i]+min]++;
            }
            while(true){
                int maxfreq=0;
                int maxind=0;
                for(int j=0;j<freq.length;j++){
                    if(freq[j]>maxfreq){
                        maxfreq=freq[j];
                        maxind=j;
                    }
                }
                for(int j=0;j<maxfreq;j++){
                    System.out.print(maxind-min+" ");
                }
                freq[maxind]=0;
                if(maxfreq==0){
                    break;
                }
            }
        }
    }

