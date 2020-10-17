package Day2_09052020;

public class for_loop
{
    public static void main(String[] args)
    {
        String[] zipCode = new String[5];
        zipCode[0] = "11230";
        zipCode[1] = "11231";
        zipCode[2] = "11232";
        zipCode[3] = "11233";
        zipCode[4] = "11234";
        //System.out.println(zipCode.length);
        //iterate through all of the zipCode data and print each one
        for(int i = 0; i < zipCode.length; i++)
        {
            System.out.println("\nMy  zip code is: " + zipCode[i]);
        }
    }
}
