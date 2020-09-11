import java.util.Scanner;

public class demo
{
    int memoization[][];
    int dist;
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);

        d.dist = in.nextInt();
        d.memoization = new int[4][d.dist+1];

        d.find_ways();

        System.out.println(d.memoization[3][d.dist]);
    }


    void find_ways()
    {
        for(int i = 0; i <=3; i++)
        {
            for(int j = 0; j <=dist; j++)
            {
                if(j == 0)
                    memoization[i][j] = 1;
                else
                {
                    if (i == 0)
                        memoization[i][j] = 0;
                    else
                    {
                        if(j < i)
                            memoization[i][j] = memoization[i][j-1];
                        else
                        {
                            if(j == i)
                            {
                                for(int k = i; k > 0; k--)
                                {
                                    memoization[i][j] = memoization[i][j] + memoization[i][j-k];
                                }
                                memoization[i][j] = memoization[i][j] + 1;
                            }

                            else
                            {
                                for(int k = i+1; k > 0; k--)
                                {
                                    memoization[i][j] = memoization[i][j] + memoization[i][j-k];
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
