import java.util.Scanner;

public class demo
{
    int memoization[][];
    int steps[] = {0,1,2,5};
    int arr[];
    int biggest_ele = Integer.MIN_VALUE;

    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n;

        while(t > 0)
        {
            n = in.nextInt();
            d.arr = new int[n];
            for(int i = 0; i < n; i++)
            {
                d.arr[i] = in.nextInt();
                if(d.arr[i] > d.biggest_ele)
                    d.biggest_ele = d.arr[i];
            }


            d.memoization = new int[4][d.biggest_ele + 1];
            d.find_solution();

            System.out.println(d.actual_solution());
            t--;

        }
    }

    void find_solution()
    {
        for(int i = 1; i <=3; i++)
        {
            for(int j = 0; j <= biggest_ele; j++)
            {
                if(j == 0)
                    memoization[i][j] = 0;
                else
                {
                    if(j < steps[i])
                    {
                        memoization[i][j] = memoization[i-1][j];
                    }
                    else
                    {
                        memoization[i][j] = memoization[i][j-steps[i]] + 1;
                    }
                }
            }
        }
    }

    int actual_solution()
    {
        int ans;
        int n = arr.length;
        sort(0, n - 1);
        int diff = arr[n - 1] - arr[0];
        ans = memoization[3][diff];
        int pre = arr[n - 1];
        int i = n - 2;

        while (i > 0) {
            // if(arr[i] == pre)
            // {
            //     ans = ans + 1;
            //     arr[i] = 0;
            //     i--;
            // }
            // else
            {
                diff = arr[i] - arr[0];
                arr[i] = 0;
                ans = ans + memoization[3][diff];
                pre = arr[i];
                i--;
            }

        }
        return ans;
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

    int partition(int low,int high)
    {
        int pivot = arr[high];
        int j = low;
        int temp;

        for(int i = low; i < high; i++)
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
