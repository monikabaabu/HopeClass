//A super market company is paying the delivery boys on a daily basis. Mr.A works on certain consecutive days and then may take rest for 1 or more days. The program must print the maximum amount earned by Mr.A working consecutively given the wages over a period of N days. The rest days for Mr.A are indicated by 0.
//
//Boundary Condition(s):
//
//        1 <= N <= 1000
//
//Example Input/Output 1:
//
//Input:
//
//        7
//
//        5 10 0 0 25 10 0
//
//Output:
//
//        35


package EliteTest;
import java.util.*;
public class SuperMarket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array size:");
        int n = sc.nextInt();
        System.out.println("enter elements");
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();

        }
        int curr =0;
        int max =0;
        for (int i = 0; i < n; i++) {
            if(array[i] ==0){
                curr =0;
            }
            else{
                curr += array[i];
                if(curr> max){
                    max = curr;
                }
            }
        }
        System.out.println(max);
    }
}
