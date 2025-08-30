//
//Boy Chocolate IceCream Third Day - P1
//There are N days and a boy can have chocolate on any day.
// But he can have ice-cream only on days divisible by 3.
// The boy's mom is strict that he can only have either a chocolate or ice-cream on a day.
// The program must print the total number of ways the boy can eat in these N days.
//Boundary Condition(s):
//        1 <= N <= 100
//Example Input/Output 1:
//Input:
//        4
//Output:
//        2
//Explanation:
//The ways are CCCC
//             CCIC
//Example Input/Output 2: Input:
//        6
//Output:
//        4
//Explanation:
//The ways are C C C C C C
//             C C I C C C
//             C C C C C I
//             C C I C C I

package PrimeSet02;
import java.util.*;

public class BoyChocolateIceCreamThirdDay {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int count =0;
        for(int i=1;i<=n;i++){
            if(i%3==0){
                count++;
            }
        }
        System.out.println((long)Math.pow(2,count));
    }
}
