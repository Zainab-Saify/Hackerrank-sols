import java.util.Scanner;

public class demo
{
    int set[];
    int required_sum;
    public static void main(String args[])
    {
        demo d = new demo();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        d.set = new int[n];

        for(int i = 0; i < n; i++)
        {
            d.set[i] = in.nextInt();
        }

        d.required_sum = in.nextInt();

        System.out.println(d.subset_exists_with_sum(0,0));
    }


    boolean subset_exists_with_sum(int index, int cur_sum)
    {
        if(cur_sum == required_sum)
        {
            return true;
        }

        if(index == set.length)
        {
            return false;
        }

        return subset_exists_with_sum(index+1,cur_sum + set[index]) || subset_exists_with_sum(index+1,cur_sum);
    }
}
