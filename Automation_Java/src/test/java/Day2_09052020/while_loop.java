package Day2_09052020;

public class while_loop
{
    public static void main(String[] args)
    {
        String[] zipCode = new String[5];
        zipCode[0] = "11230";
        zipCode[1] = "11231";
        zipCode[2] = "11232";
        zipCode[3] = "11233";
        zipCode[4] = "11234";

        int i = 0;

        while(i < zipCode.length)
        {
            System.out.println("My zip code is: " + zipCode[i]);
            i++; // i = i + 1
        }
    }
}
