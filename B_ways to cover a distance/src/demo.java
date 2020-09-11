import java.util.Scanner;

public class demo
{
    int dist;
    int steps[];
    int ways;
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);

        d.dist = in.nextInt();
        int n = in.nextInt();
        d.steps = new int[n];

        for(int i = 0; i < n; i++)
        {
            d.steps[i] = in.nextInt();
        }

        d.find_ways(0);
        System.out.println(d.ways);
    }


    void find_ways(int dist_covered)
    {
        if(dist_covered == dist )
        {
            ways++;
        }
        else
        {
            for(int i = 0; i < steps.length; i++)
            {
                if(dist_covered + steps[i] <= dist)
                {
                    find_ways(dist_covered + steps[i]);
                }
            }
        }
    }
}
