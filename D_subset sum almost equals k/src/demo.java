import java.util.Scanner;

public class demo
{
    boolean memoization[][];
    int arr[];
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        d.arr = new int[n +1];
        int total_sum = 0;
        int m;

        for(int i = 1; i <= n; i++)
        {
            d.arr[i] = in.nextInt();
            total_sum = total_sum + d.arr[i];
        }

        if(total_sum%2 == 0)
            m = total_sum/2;
        else
            m = total_sum/2 + 1;

        d.memoization = new boolean[n+1][m + 1];

        d.sort(0, d.arr.length-1);
        d.find_sum1(n,m);
        int sum1 = 0;

        for(int j = m; j >=0; j--)
        {
            if(d.memoization[n][j] == true)
            {
                sum1 = j;
                break;
            }

        }

        int sum2 = total_sum - sum1;
        int diff = Math.abs(sum1 - sum2);

        System.out.println(diff);
    }


    void find_sum1(int n, int m)
    {
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= m; j++)
            {
                if(i == 0)
                {
                    memoization[i][j] = true;
                }else
                {
                    if(j == 0)
                    {
                        memoization[i][j] = false;
                    }
                    else
                    {
                        if(arr[i] == j)
                        {
                            memoization[i][j] = true;
                        }
                        else
                        {
                            if(arr[i] > j)
                            {
                                memoization[i][j] = memoization[i-1][j];
                            }
                            else
                            {
                                memoization[i][j] = memoization[i-1][j-arr[i]];
                            }
                        }
                    }
                }
            }
        }
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
    int partition(int low, int high)
    {
        int pivot = arr[high];
        int j = low;
        int temp;

        for(int i = low ; i < high; i++)
        {
            if(arr[i] < pivot)
            {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                j++;
            }
        }

        arr[high] = arr[j];
        arr[j] = pivot;

        return j;

    }
}
