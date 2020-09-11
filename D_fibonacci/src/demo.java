import java.util.HashMap;
import java.util.Scanner;

public class demo
{
     HashMap<Integer,Long> m_fibb = new HashMap<Integer, Long>();
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        demo d = new demo();
        int t = in.nextInt();
        int num;
        d.m_fibb.put(0, (long)0);
        d.m_fibb.put(1, (long) 1);

        while(t != 0)
        {
            num = in.nextInt();
            System.out.println(d.fibb(num -1));
            t--;

        }
    }

    long fibb(int i)
    {
        if(m_fibb.containsKey(i))
        {
            return m_fibb.get(i);
        }
        else
        {
            Long ans = fibb(i -1) + fibb(i - 2);
            m_fibb.put(i,ans);
            return ans;

        }

    }
}
