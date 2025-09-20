//**Smallest Number Digit Product**
//
//The program must accept an integer **X** and print the smallest integer **N** where the product of the digits of **N** is equal to **X**. **N** must not be a single digit integer. If it is not possible to express **X** as **N** based on the conditions or **N** is a single digit integer, then the program must print **-1** as the output.
//
//**Boundary Condition(s):**
//        2 <= X <= 10^9
//        11 <= N <= 10^20
//
//        **Input Format:**
//The first line contains **X**.
//
//        **Output Format:**
//The first line contains **N** or **-1**.
//
//        **Example Input/Output 1:**
//Input:
//        10
//
//Output:
//        25
//
//Explanation:
//The smallest integer whose product of digits is equal to **10** is **25** (as 2*5=10).
//
//        **Example Input/Output 2:**
//Input:
//        100
//
//Output:
//        455
//
//Explanation:
//The smallest integer whose product of digits is equal to **100** is **455** (as 4*5*5=100).
//
//        **Example Input/Output 3:**
//Input:
//        23
//
//Output:
//        -1
//
//        **Example Input/Output 4:**
//Input:
//        5
//
//Output:
//        -1


package EliteTest;
import java.util.*;
public class SmallestNumberDigitProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter n value:");
        int n = sc.nextInt();
        if(n<10){
            System.out.println("-1");
            return; //very important so that it stop executing and doesnt create a new line
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 9; i >=2 ; i--) {
            while(n%i==0){
                list.add(i);
                n = n/i;
            }
        }
        if(n>1){
            System.out.println("-1");
            return;  //very important so that it stop executing and doesnt create a new line
        }
        Collections.sort(list);
        StringBuilder s = new StringBuilder();
        for(int N : list){
            s.append(N);
        }
        if(s.length()==1){
            System.out.println("-1");
        }
        else{
            System.out.println(s.toString());
        }
    }
}
