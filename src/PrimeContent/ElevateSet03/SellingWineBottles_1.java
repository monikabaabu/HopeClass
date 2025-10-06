//
//Selling Wine Bottles
//There are N wine bottles packed and arranged in a row from left to right. The wine bottles can be sold only one per year with a condition that only the leftmost or the rightmost wine bottle can be sold. The price of a wine bottle P(i) where 1≤i≤N (which has not been sold yet) increases by its initial price P(i) every year. Find the maximum revenue that can be obtained by selling the wine bottles based on the above conditions.
//
//Boundary Condition(s):
//        1≤N≤1000
//        1≤P(i)≤100
//
//Input Format:
//The first line contains N.
//The second line contains N integers representing the price of the wine bottles separated by a space.
//
//Output Format:
//The first line contains the maximum revenue that can be obtained by selling the wine bottles based on the above conditions.
//
//Example Input/Output 1:
//Input:
//        4
//        1 4 2 3
//
//Output:
//        29
//
//Explanation:
//Max revenue = 1∗1+3∗2+2∗3+4∗4=29
//
//Example Input/Output 2:
//Input:
//        5
//        3 5 7 3 6
//
//Output:
//        79
//        youtube:
//        logic: https://youtu.be/EEU6QV3tQ5k
//        code: https://youtu.be/6SADv2EaoIw

package PrimeContent.ElevateSet03;
import  java.util.*;
public class SellingWineBottles_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int j = 0; j <n ; j++) {
            arr[j] = sc.nextInt();
        }
        int max[][] = new int[n][n];
        System.out.println(maxrevenue(arr,max,0,n-1,1));
    }

    private static int maxrevenue(int[] arr, int[][] max, int left, int right, int year) {

        if(max[left][right] !=0){
            return max[left][right];
        }
        if(left==right){
            return arr[left]*year;
        }
        int leftrev = arr[left]*year + maxrevenue(arr, max, left+1, right, year+1);
        int rightrev = arr[right]*year + maxrevenue(arr, max, left, right-1, year+1);
        max[left][right]= Math.max(leftrev,rightrev);
        return max[left][right];
    }
}
