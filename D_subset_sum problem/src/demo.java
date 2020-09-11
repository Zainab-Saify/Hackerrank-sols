import java.util.Scanner;

public class demo
{
    boolean memoization[][];
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int set[] = new int[n +1];

        for(int i = 1; i <= n; i++)
        {
            set[i] = in.nextInt();
        }

        int required_sum = in.nextInt();

        d.memoization = new boolean[n+1][required_sum+1];
        d.find_subset(set,required_sum);

        System.out.println(d.memoization[n][required_sum]);
    }

    void find_subset(int[] set, int req_sum)
    {
        int sum = 0;
        for(int i = 0; i < set.length; i++)
        {
            sum = sum + set[i];
            for(int j = 0; j <= req_sum; j++)
            {
                if(j == 0)
                {
                    memoization[i][j] = true;
                }
                else {
                if(i == 0)
                {
                    memoization[i][j] = false;
                }
                else
                {
                  if(j >= set[i] && j <= sum)
                  {
                      memoization[i][j] = memoization[i-1][j] || memoization[i][j - set[i]];
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
