import java.util.Scanner;

public class demo
{
    int max = Integer.MIN_VALUE;
    int prices[];
    int rod_length;

    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        d.prices = new int[n+1];

        for(int i = 1; i <= n; i++)
        {
            d.prices[i] = in.nextInt();
        }
        d.rod_length = in.nextInt();

        d.find_max(1,0,0);

        System.out.println(d.max);
    }

    void find_max(int index, int value, int length)
    {
        if(length == rod_length )
        {
            if(value > max)
            {
                max = value;
            }
        }
        else

            {
            for (int i = index; i < prices.length; i++)
            {
                if(length + i <= rod_length)
                {
                    value = value + prices[i];
                    find_max(i + 1, value, length + i);
                    value = value - prices[i];
                }
            }
        }
    }
}
