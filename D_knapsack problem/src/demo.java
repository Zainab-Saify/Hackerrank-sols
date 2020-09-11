import java.util.Scanner;

public class demo
{
    int memoization[][];
    int n;
    int selected[];
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        d.n = in.nextInt();
        int weight_value[][] = new int[d.n + 1][2];
        d.selected = new int[d.n+1];


        for(int i = 1; i <= d.n; i++)
        {
            weight_value[i][0] = in.nextInt();
            weight_value[i][1] = in.nextInt();
        }

        int limit = in.nextInt();

        d.memoization = new int[d.n+1][limit+1];
        d.sort(weight_value,0,d.n);
        d.solve_knapsack(weight_value,limit);
        d.identify_selected_items(weight_value,limit);

        for(int i = 0; i < d.n; i++)
        {
            if(d.selected[i] == 1)
            System.out.println(weight_value[i][0] + " " + weight_value[i][1]);
        }
    }

    void solve_knapsack(int[][] w_v, int limit)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= limit; j++)
            {
                if(i == 0 || j== 0)
                {
                    memoization[i][j] = 0;
                }

                if( w_v[i][0] <= j)
                memoization[i][j] = Math.max(memoization[i-1][j], memoization[i-1][j-w_v[i][0]] + w_v[i][1]);
                else
                    memoization[i][j] = memoization[i-1][j];
            }
        }
    }


    void identify_selected_items(int[][] w_v,int limit)
    {
        int i = n;
        int flag;
        int final_value = memoization[n][limit];
        int temp = final_value;
        while (i > 0)
        {
            flag = 0;
            for(int j = 0; j <=limit; j++)
            {
                if(memoization[i-1][j] == temp)
                {
                    flag = 1;
                    break;
                }

            }

            if(flag == 0)
            {
                selected[i] = 1;
                temp = temp - w_v[i][1];
            }

            i--;
        }
    }

    int partition(int arr[][] ,int low, int high)
    {
        int pivot = arr[high][0];
        int j = low;
        int temp1;
        int temp2;

        for(int i = low; i <= high-1; i++)
        {
           if(arr[i][0] < pivot)
           {
               temp1 = arr[j][0];
               temp2 = arr[j][1];
               arr[j][0] = arr[i][0];
               arr[j][1] = arr[i][1];
               arr[i][0] = temp1;
               arr[i][1] = temp2;
               j++;
           }
        }

        temp1 = arr[j][0];
        temp2 = arr[j][1];
        arr[j][0] = arr[high][0];
        arr[j][1] = arr[high][1];
        arr[high][0] = temp1;
        arr[high][1] = temp2;
        return j;

    }

    void sort(int arr[][], int low, int high)
    {
        if (low < high)
        {
            int pi = partition(arr,low,high);

            sort(arr,low,pi - 1);
            sort(arr,pi+1,high);
        }
    }

}
