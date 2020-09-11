import java.util.Scanner;

public class demo
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        demo d = new demo();

        int arr[] = new int[n +1];
        arr[0] = 0;

        for(int i = 1; i <= n; i++)
        {
            arr[i] = in.nextInt();
        }

        System.out.println(d.d_find_max(arr,n+1));


    }


    int d_find_max(int[] arr,int n)
    {
        int memoization[] = new int[n];
        memoization[0] = 1;

        for(int i = 1; i < n; i++)
        {
            if(arr[i] > arr[i-1])
            {
                memoization[i] = memoization[i-1]+1;
            }
            else
            {
                memoization[i] = memoization[i-1];
            }
        }

        return memoization[n-1];

    }
}
