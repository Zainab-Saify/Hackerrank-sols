import java.util.Scanner;

public class demo
{
    int memoization[][];
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        String s1 = " " + in.next();
        String s2 = " " + in.next();
        d.memoization = new int[s1.length()][s2.length()];

        d.find_min_cost(s1,s2);
        System.out.println(d.memoization[s1.length()-1][s2.length()-1]);

        for(int i = 0; i < s1.length(); i++)
        {
            for(int j = 0; j < s2.length(); j++)
            {
                System.out.print(d.memoization[i][j] + " ");
            }
            System.out.println();
        }

    }

    void find_min_cost(String s1, String s2)
    {
        for(int i = 0; i < s1.length(); i++)
        {
            for(int j = 0; j < s2.length(); j++)
            {
                if(i == 0)
                {
                    memoization[i][j] = j;
                }
                else
                {
                    if(j == 0)
                    {
                        memoization[i][j] = i;
                    }
                    else
                    {
                        if(s1.charAt(i) == s2.charAt(j))
                        {
                            memoization[i][j] = memoization[i-1][j-1];
                        }
                        else
                        {
                            memoization[i][j] = Math.min(Math.min(memoization[i-1][j], memoization[i][j-1]), Math.min(memoization[i][j-1],memoization[i-1][j-1])) + 1;
                        }
                    }
                }
            }
        }
    }



}
