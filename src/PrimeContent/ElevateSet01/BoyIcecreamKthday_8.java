//Boy Ice-cream Kth day
//
//        A boy can have either a chocolate(C) or an ice-cream(I) on a given day.
//        But to avoid catching cold, his mom has prevented him from having ice-cream on consecutive days.
//        As the boy was adamant, his mom gave a relaxation that on every Kth day,
//        the boy can have ice-cream even if he ate ice-cream the previous day.
//        The program must print the number of ways W in which the boy can have chocolate or ice-cream over the period of N days.
//
//        Boundary Condition(s):
//        1 <= N <= 50
//        2 <= K <= 100
//
//        Input Format:
//        The first line contains N and K separated by a space.
//
//        Output Format:
//        The first line contains W.
//
//        Example Input/Output 1:
//        Input:
//        3 2
//        Output:
//        6
//        Explanation:
//        The 6 ways to have over three days are
//        CCC
//        CCI
//        CIC
//        ICC
//        ICI
//        IIC (as K=2, on the second day ice-cream can be had even on successive days)

package PrimeContent.ElevateSet01;
import java.util.*;
public class BoyIcecreamKthday_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of days");
        int n = sc.nextInt();
        System.out.println("enter k value");
        int k = sc.nextInt();

        long[] choco = new long[ n+1];
        long[] ice = new long[ n+1];
        choco[1]=ice[1]=1;
        for(int i=2; i<=n;i++){
            choco[i] = choco[i-1]+ice[i-1];
            ice[i]= choco[i-1];
            if(i%k==0){
                ice[i]+= ice[i-1];
            }
        }


        long result = choco[n]+ice[n];
        System.out.println(result);
    }
}
