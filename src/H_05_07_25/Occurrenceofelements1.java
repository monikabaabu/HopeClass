package H_05_07_25;

import java.io.*;
import java.util.*;
//Find the occurrence of a number and display the values in ascending order of the given input
//
//Input Format
//
//9
//        3 4 3 4 1 2 3 1 2
//
//Constraints
//
//6<=n<=12
//
//Output Format
//
//2 2 3 2
//
//
//Explanation:
//        1 = 2 times
//2 = 2 times
//3 = 3 times
//4 = 2 times
//so, 2 2 3 2 is the answer.
//
//Sample Input 0
//
//        9
//        3 4 3 4 1 2 3 1 2
//Sample Output 0
//
//        2 2 3 2
public class Occurrenceofelements1 {
        public static void main(String[] args) {
            /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc = new Scanner(System.in);
            int n= sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n;i++){
                arr[i] = sc.nextInt();

            }
            int max = arr[0];
            for(int i=1;i<n;i++){
                if(arr[i]>max){
                    max = arr[i];
                }
            }
            int[] freq = new int[max+1];
            for(int i=0; i< n;i++){
                freq[arr[i]]++;
            }
            for(int i=0;i<freq.length;i++){
                if(freq[i]!=0){
                    System.out.print(freq[i]+" ");
                }
            }
        }

}
