package All_Practices;

public class AI1_Prac {
    public static void main(String[] args) {
        int grade = 50;
        //is 90 to 100
        if(grade >= 90 && grade <=100)

        {
            System.out.println("Your grade is: A");
        }
        //is to 80 to less than 90
        else if(grade >= 80 && grade < 90)
        {
            System.out.println("Your grade is: B");
        }

        //
        else if(grade >= 80 && grade < 90)
        {
            System.out.println("Your grade is: B");
        }
        else if(grade < 60)
        {
            System.out.println("Your grade is: F");
        }
        else {
            System.out.println("Invalid Input!! Try again!");
        }
    }

}
