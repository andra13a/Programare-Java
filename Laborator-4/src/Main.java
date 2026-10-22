import java.util.*;
public class Main
{
    public static void main(String[] args)
    {
        java.util.Random rand = new java.util.Random();
        rand.nextInt(11);
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for(int i = 0; i < 5; i++)
        {
            x.add(rand.nextInt(11));
        }
        for(int i = 0; i < 7; i++)
        {
            y.add(rand.nextInt(11));
        }

        Collections.sort(x);
        Collections.sort(y);

        System.out.println("Lista x este: " + x);
        System.out.println("Lista y este: " + y);

        // Punctul a. xPlusY contine toate elementele sirurilor x si y

        List<Integer> xPlusY = new ArrayList();
        x.addAll(y);
        Collections.sort(xPlusY);
        System.out.println("Lista xPlusY este: " + xPlusY);

        //Punctul b. zSet contine numai valorile comune din ambele siruri, luate o singura data

        Set<Integer> zSet = new TreeSet();
        for (int num : x)
        {
            if (y.contains(num))
            {
                zSet.add(num);
            }
        }
        System.out.println("Set zSet: " + zSet);

        // Punctul c. xMinusY contine valorile din sirul x care nu se afla in sirul y

        List<Integer> xMinusY = new ArrayList();
        for (int num : x)
        {
            if (!y.contains(num))
            {
                xMinusY.add(num);
            }
        }
        System.out.println("Lista xMinusY: " + xMinusY);

        // Punctul d. xPlusYLimitedByP

        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList();
        for (int num : x)
        {
            if (num <= p)
            {
                xPlusYLimitedByP.add(num);
            }
        }
        for (int num : y)
        {
            if (num <= p) {
                
                xPlusYLimitedByP.add(num);
            }
        }
        Collections.sort(xPlusYLimitedByP);
        System.out.println("Lista xPlusYLimitedByP: " + xPlusYLimitedByP);

    }
}