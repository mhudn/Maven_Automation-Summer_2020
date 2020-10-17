package Action_Items;
public class Assignment_2
{
    public static void main(String[] args)
    {
        String[] Cities;
        Cities = new String[4];
        Cities[0] = "Brooklyn";
        Cities[1] = "Queens";
        Cities[2] = "Manhattan";
        Cities[3] = "Staten Island";
        //Using while Loop
        System.out.println("\n***While Loop Result***");
        int i = 0;
        while(i < Cities.length)
        {
            if(Cities[i] == "Brooklyn" || Cities[i] == "Manhattan")
            {
                System.out.println("\nMy City is: " + Cities[i]);
            }
            i++; // i = i + 1
        }

        //Using for Loop
        System.out.println("\n\n***For Loop Result***");
        for(int j = 0; j < Cities.length; j++)
        {
            if(Cities[j] == "Brooklyn" || Cities[j] == "Manhattan")
            {
                System.out.println("\nMy City is: " + Cities[j]);
            }
        }
    }
}

