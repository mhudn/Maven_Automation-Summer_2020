package Action_Items;

import java.util.*;

public class Assignment_1
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in); //System.in is a standard input stream
        System.out.print("\nEnter your numeric grade: "); //not using "ln" to print the user provided input on the same line
        int numericGrade = userInput.nextInt(); //takes in user provided input and stores it in the variable numericGrade

        //int numericGrade = 88;

        String letterGrade;

        if(numericGrade >= 90 && numericGrade <= 100)
        {
            letterGrade = "A";
            //System.out.println("\nYour letter grade is: A");
        }
        else if(numericGrade >= 80 && numericGrade < 90)
        {
            letterGrade = "B";
            //System.out.println("\nYour letter grade is: B");
        }
        else if(numericGrade >= 70 && numericGrade < 80)
        {
            letterGrade = "C";
            //System.out.println("\nYour letter grade is: C");
        }
        else if(numericGrade >= 60 && numericGrade < 70)
        {
            letterGrade = "D";
            //System.out.println("\nYour letter grade is: D");
        }
        else if(numericGrade < 60)
        {
            letterGrade = "F";
            //System.out.println("\nYour letter grade is: F");
        }
        else
        {
            letterGrade = "\nInvalid input!!! Try again. \nHint: The numeric grade should be in between 0 to 100";
            //System.out.println("\nInvalid input!!! Try again."); //when user inputs any value above 100
        }

        System.out.println("\nYou grade is: " + letterGrade);
    }

}
