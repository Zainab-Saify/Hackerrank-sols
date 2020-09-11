import java.util.Scanner;

public class demo
{
    int memoization[][];
    int b[];
    int n;
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t > 0)
        {
            d.n = in.nextInt();
            d.b = new int[d.n + 1];
            for (int i = 1; i <= d.n; i++) {
                d.b[i] = in.nextInt();
            }

            d.memoization = new int[d.n + 1][2];
            d.solution(0);

            System.out.println(Math.max(d.memoization[d.n][0], d.memoization[d.n][1]));
            t--;
        }
    }


    void solution(int call)
    {
        for(int i = 2; i <= n; i++)
        {
            if(i == 0)
            {
                continue;
            }
            else
            {
               memoization[i][0] = Math.max(memoization[i-1][0], memoization[i-1][1] + Math.abs(b[i-1] -1));
               memoization[i][1] = Math.max(memoization[i-1][0] + Math.abs(b[i] - 1), memoization[i-1][1] + Math.abs(b[i-1] - b[i]));

            }
        }


    }
}
