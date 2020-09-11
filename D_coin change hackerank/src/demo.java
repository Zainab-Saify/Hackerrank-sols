import java.util.Scanner;

public class demo
{
    long memoization[][];
    int coins[];
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        d.coins = new int[m +1];
        d.coins[0] = 0;

        for(int i = 1; i <= m; i++)
        {
            d.coins[i] = in.nextInt();
        }

        d.memoization = new long[m+1][n+1];
        d.sort(1,m);
        d.find_ways(m,n);
        System.out.println(d.memoization[m][n]);

    }

    void find_ways(int m, int n)
    {
        for(int i = 0; i <=m; i++)
        {
            for(int j = 0; j<=n; j++)
            {
                if(j == 0)
                    memoization[i][j] = 1;
                else
                {
                    if(i == 0)
                        memoization[i][j] = 0;
                    else
                    {
                        if(j < coins[i])
                        {
                            memoization[i][j] = memoization[i-1][j];
                        }
                        else
                        {
                            memoization[i][j] = memoization[i-1][j] + memoization[i][j-coins[i]];
                        }
                    }
                }
            }
        }
    }



    int partition(int low, int high)
    {
        int pivot = coins[high];
        int j = low;
        int temp;

        for(int i = low; i < high; i++)
        {
            if(coins[i] < pivot)
            {
                temp = coins[j];
                coins[j] = coins[i];
                coins[i] = temp;
                j++;

            }
        }

        coins[high] = coins[j];
        coins[j] = pivot;
        return j;
    }

    void sort(int low, int high)
    {
        if(low < high)
        {
            int p = partition(low,high);

            sort(low,p-1);
            sort(p+1,high);
        }
    }
}
