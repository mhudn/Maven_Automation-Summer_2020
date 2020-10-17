package Day4_09122020;

public class Split_in_Java
{
    public static void main(String[] args)
    {
        String message = "My name is Mohiuddin";
        String[] result = message.split(" ");

        System.out.println("\nThe verb in the message is: " + result[2]);
        System.out.println("\nThe name in the message is: " + result[3]);
    }
}
