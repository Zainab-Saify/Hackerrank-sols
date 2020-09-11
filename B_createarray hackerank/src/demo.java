import java.util.Scanner;
public class demo
{
    int arr[];
    int ways = 0;
    int n;
    int k;
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        d.n = in.nextInt();
        d.arr = new int[d.n];
        d.k = in.nextInt();
        int x = in.nextInt();

        d.arr[0] = 1;
        d.arr[d.n-1] = x;

        d.find_ways(1);
        System.out.println(d.ways);
    }

    void find_ways(int index)
    {
        if(index == n-1)
        {
                ways++;
        }
        else
        {
            for(int i = 1; i <= k; i++)
            {
                if(arr[index-1] != i && arr[index+1] != i)
                {
                    arr[index] = i;
                    find_ways(index+1);
                    arr[index] = 0;
                }
            }
        }
    }

}
