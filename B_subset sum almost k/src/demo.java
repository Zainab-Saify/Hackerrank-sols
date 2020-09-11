import java.util.Scanner;

public class demo
{
    int arr[];
    int total_sum;
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        d.arr = new int[n];
        for(int i = 0; i < n; i++)
        {
            d.arr[i] = in.nextInt();
            d.total_sum = d.total_sum + d.arr[i];
        }

        int sum1 = d.total_sum - d.total_sum/2 + d.find_min_diff(0,d.total_sum/2);
        int sum2 = d.total_sum - sum1;
        int diff = Math.abs(sum1 - sum2);
        System.out.println(diff);
    }

    int find_min_diff(int index,int diff)
    {
        if(index == arr.length)
        {
            return diff;
        }
        else
        {
            return Math.min(Math.abs(find_min_diff(index + 1, diff - arr[index])), Math.abs(find_min_diff(index+1,diff)));
        }
    }
}
