import java.util.Scanner;

public class demo
{
    String s1;
    String s2;

    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        d.s1 = in.next();
        d.s2 = in.next();

        System.out.println(d.find_cost(d.s1.length()-1, d.s2.length() - 1));
    }


    int find_cost(int index_s1, int index_s2)
    {
        if(index_s1 == 0)
        {
            return index_s2;
        }

        if(index_s2 == 0)
        {
            return index_s1;
        }
        else
        {
            if(s1.charAt(index_s1) == s2.charAt(index_s2))
            {
                return find_cost(index_s1-1,index_s2-1);
            }
            else
            {
                int x = find_cost(index_s1,index_s2-1) + 1; //insert;
                int y = find_cost(index_s1-1,index_s2-1) + 1; //replace
                int z = find_cost(index_s1-1,index_s2) +1; //delete

                return Math.min(Math.min(x,y), Math.min(y,z));
            }
        }
    }
}
