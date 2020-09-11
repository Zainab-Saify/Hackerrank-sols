import java.util.Scanner;

public class demo
{
    int memoization[][];
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int coins[] = new int[n + 1];
        for(int i = 1; i <= n; i++)
        {
            coins[i] = in.nextInt();
        }
        int m = in.nextInt();
        d.memoization = new int[n+1][m+1];


        d.find_ways(coins,m);
        System.out.println(d.memoization[coins.length-1][m]);
    }


    void find_ways(int[] coins, int m)
    {
        for(int i = 0; i < coins.length; i++)
        {
            for(int j = 0; j <= m; j++)
            {
                if(i == 0)
                {
                    memoization[i][j] = 0;
                }
                else
                {
                    if(j == 0)
                    {
                        memoization[i][j] = 1;
                    }
                    else
                    {
                        if(j >= coins[i])
                        {
                            memoization[i][j] = memoization[i-1][j] + memoization[i][j-coins[i]];
                        }
                        else
                        {
                            memoization[i][j] = memoization[i-1][j];
                        }
                    }
                }
            }
        }
    }
}
