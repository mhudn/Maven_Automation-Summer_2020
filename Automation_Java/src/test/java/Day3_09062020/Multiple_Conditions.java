package Day3_09062020;

public class Multiple_Conditions
{
    public static void main(String[] args)
    {
        int a = 2;
        int b = 3;
        int c = 4;

        //print if sum of a & b is either equal, greater, or less than c
        if((a+b) < c) // 5 < 4
        {
            System.out.println("\nsum of a & b is less than c");
        }
        else if((a+b) > c) // 5 > 4
        {
            System.out.println("\nsum of a & b is greater than c");
        }
        else
        {
            System.out.println("\nsum of a & b is equal to c");
        }

    }
}
