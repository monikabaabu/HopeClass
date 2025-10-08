package H_07_10_25;

import java.util.*;
public class Singleton {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        System.out.println(College.getInstance().getName());
    }
}
class College
{
    private static College coll = new College();
    private College(){}
    private String name = "ABC College";
    public static College getInstance()
    {
        return coll;
    }
    public String getName()
    {
        return this.name;
    }
}
