import java.util.Scanner;

public class demo
{
    int max = Integer.MIN_VALUE;

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        demo d = new demo();
        int n = in.nextInt();

        int weight_values[][] = new int[n][2];
        for(int i = 0; i < n; i++)
        {
            weight_values[i][0] = in.nextInt();
            weight_values[i][1] = in.nextInt();
        }
        int limit = in.nextInt();

        d.solve_knapsack(weight_values,limit,0,0,0);

        System.out.println(d.max);
    }


    void solve_knapsack(int w_v[][], int limit, int value, int cur_weight, int index)
    {
        if(cur_weight <= limit)
        {
            if(max < value)
            {
                max = value;
            }
        }
        for(int i = index; i < w_v.length; i++)
        {
            if(cur_weight + w_v[i][0] <= limit)
            {
            cur_weight = cur_weight + w_v[i][0];
            value = value + w_v[i][1];
            solve_knapsack(w_v,limit,value,cur_weight,i + 1);
            cur_weight = cur_weight - w_v[i][0];
            value = value - w_v[i][1];
            }
        }
    }
}
