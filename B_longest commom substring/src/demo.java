import java.util.Scanner;

public class demo
{
    String subsequence = "";
    int max = Integer.MIN_VALUE;
    String longest_subsequence;
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);

        String s1 = in.next();
        String s2 = in.next();

        d.max = d.find_subsequence(s1,s2,0,0);

        System.out.println(d.max);
    }


    int find_subsequence(String s1, String s2, int index_s1, int index_s2 )
    {
        if(index_s1 == s1.length() || index_s2 == s2.length())
        {
            return  0;
        }
        else
        {
            if(s1.charAt(index_s1) == s2.charAt(index_s2))
            {
                subsequence = subsequence + s1.charAt(index_s1);
                return 1 + find_subsequence(s1,s2,index_s1+1,index_s2+1);
            }
            else
            {
                return Math.max(find_subsequence(s1,s2,index_s1+1,index_s2),find_subsequence(s1,s2,index_s1,index_s2+1));
            }
        }
    }


}
