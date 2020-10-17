package All_Practices;

public class Practice
{
    public static void main(String[] args) {


        // on day 2 we array and loop.

        // *******array

        // linear and dynamic

        //**********loop

        // for and while


        //array

        //linear String array example


        //int number = 5;

        int number; //it can hold only one number
        number = 5;



        String name = "ken";

        //to difine an array

        String[] names = new String[] {"mohi", "ken", "Mahmud",};

        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);



        /*int i = 0;
        while (i < names.length) //
        {
            System.out.println(names[i]);
            //
            //first attempt i = 0; so names[i] should print which is names[0] = "mohi"
            //i = 0;

            //second attempt i = 1; so names[i] should print which is names[1] = "ken"
            //i = 1;

            //third attempt i = 2 so names[i] should print which is names[2] = "Mahmud"
            //i = 2;

            i++;

            //first attempt: i = i + 1 where i is previously assigned value was 0
            //i = 0 + 1 = 1
            // now our i = 1;

            //second attempt: i = i + 1; where i is previously assigned value was 1
            //i = 1 + 1 = 2
            //now our i = 2;

            //third attempt: i = i + 1; where i is previously assigned value was 2
            //i = 2 + 1 = 3
            // now our i is = 3


        }*/


        for (int i = 0; i < names.length; i++)
        {
            System.out.println(names[i]);
        }

        // it hold multiple  numbers in single variable




    }
}





