import java.util.Scanner;

public class demo {

    int memoization[][];
    int n;
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);

        d.n = in.nextInt();
        int prices[] = new int[d.n+1];
        for(int i = 1; i <= d.n; i++)
        {
            prices[i] = in.nextInt();
        }
        int rod_length = in.nextInt();
        d.memoization = new int[d.n+1][rod_length+1];
        d.find_max_profit(prices,rod_length);
        System.out.println(d.memoization[d.n][rod_length]);
    }

    void find_max_profit(int[] p, int l)
    {
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= l; j++)
            {
                if(i == 0 || j == 0)
                {
                    memoization[i][j] = 0;
                }
                else
                {
                    if(j >= i)
                    {
                        memoization[i][j] = Math.max(memoization[i-1][j] , memoization[i][j - i] + p[i]);
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
