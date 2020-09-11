import java.util.Scanner;

public class demo
{
    int steps[] = {1,2,5};
    int arr[];
    int n;
    int min_rounds = Integer.MAX_VALUE;
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while ((t > 0))
        {
            d.n = in.nextInt();
            d.arr = new int[d.n];

            for (int i = 0; i < d.n; i++)
            {
                d.arr[i] = in.nextInt();
            }

            d.find_min_rounds(0);
            System.out.println(d.min_rounds);
            t--;
        }
    }

    void find_min_rounds(int rounds)
    {
        if(allEqual())
        {
            if(rounds < min_rounds)
                min_rounds = rounds;
        }
        else
        {
            sort(0,n-1);

            for(int i = 2; i >= 0; i--)
            {
                if(arr[n-1] - arr[0] >= steps[i])
                {
                    arr[n-1] = arr[n-1] - steps[i];
                    find_min_rounds(rounds+1);
                    arr[n-1] = arr[n-1] + steps[i];
                }
            }
        }
    }

    Boolean allEqual()
    {
        int flag = 0;
        int a = arr[0];
        for(int i = 1; i < arr.length; i++)
        {
            if(arr[i] != a)
            {
                flag = 1;
                break;
            }
        }
        if(flag == 0)
            return true;
        else
            return false;
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
