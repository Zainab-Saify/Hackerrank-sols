import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import static java.lang.Integer.max;
import static java.lang.Integer.min;


public class demo
{
    int total_eggs;
    int total_floors;
    int memoization[][];
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        d.total_eggs = in.nextInt();
        d.total_floors = in.nextInt();
        d.memoization = new int[d.total_eggs + 1][d.total_floors + 1];

        for(int i = 0; i <= d.total_eggs; i++)
        {
            for(int j = 0; j <= d.total_floors; j++)
            {
                d.memoization[i][j] = -1;
            }
        }

        int ans = d.min_drop(d.total_eggs, d.total_floors);


        System.out.println(ans);

    }


    int min_drop(int eggs, int floor)
    {
        int ans ;

        if(memoization[eggs][floor] != -1)
        {
            return memoization[eggs][floor];
        }
        if(eggs == 1 || floor == 0 || floor == 1)
        {
            return floor;
        }
        else
        {
            int x = 1;
            int min = Integer.MAX_VALUE;
            while(x < floor)
            {
               ans = Math.max(min_drop(eggs-1,x-1),min_drop(eggs,floor-x));

               if(ans < min)
               {
                   min = ans;
               }
               x++;

            }

            memoization[eggs][floor] = min+1;
            return min + 1;
        }
    }

}
