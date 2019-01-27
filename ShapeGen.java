import java.util.*;
public class ShapeGen
{
    Random rand = new Random();
    public ShapeGen()
    {
        refillBag();
    }
    public void refillBag()
    {
        bag = new String[] {"o","o","i","i","s","s","z","z","l","l","j","j","t","t"};
    }
    public Shape pickShape()
    {
        if(bag.length == 0)
        {
            refillBag();
        }
        int index = rand.nextInt(bag.length);
        Shape output = new Shape(bag[index]);
        String[] tempBag = new String[bag.length - 1];
        int j = 0;
        for(int i = 0;i < bag.length;i++)
        {
            if(i != index)
            {
                tempBag[j] = bag[i];
                j++;
            }
        }
        bag = tempBag;
        return output;
    }
    public String[] bag;
}
