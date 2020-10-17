package Day2_09052020;

public class Linear_Array
{
    public static void main(String[] args)
    {
        //linear String array example
        String[] username =  new String[] {"John", "Kenneth", "Milad","Naim"};

        //linear integer array example
        int[] numbers =  new int[] {1,100,300,500};

        System.out.println("\nSecond user name is " + username[1] + "\nThe Second number is " + numbers[1]);

        //sum of two array elements
        System.out.println("Sum of " + numbers[1] + " and " + numbers[3] + " is: " + (numbers[1] + numbers[3]));
    }
}
