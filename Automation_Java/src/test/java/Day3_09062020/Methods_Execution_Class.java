package Day3_09062020;

public class Methods_Execution_Class
{
    public static void main(String[] args)
    {
        Reusable_Method_Day3.add(20,99);
        Reusable_Method_Day3.subtraction(200,18);
        Reusable_Method_Day3.division(100,2);
        Reusable_Method_Day3.multiplication(10,20);



        int number = Reusable_Method_Day3.returnAdd(100, 200);
        System.out.println("\nNew result is: " + (number+50));
    }
}
