import java.util.*;
import java.util.concurrent.TimeUnit;

public class OldMenu
{
    public static void main(String[] args)
    {
        int integerOne;
        int integerTwo;
        int result;
        boolean programActive = true;
        boolean startup = true;
        String conversionMode;

        Scanner input = new Scanner(System.in);

        while (programActive) {

            // This part only runs after the first loop
            // It's simply a small pause to allow the user to read the output
            if (!startup) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch ( Exception e )
                {
                    System.out.println("Don't press anything right now!");
                }
            }
            // This bit resets the output
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.print("What would you like to do?"
                             + "\n    > (S)um of 2 integers"
                             + "\n    > (P)roduct of 2 Integers"
                             + "\n    > (D)etermine if 2 Integers are Divisible"
                             + "\n    > (E)xit\n\nYour choice: ");
            // Gets the first character the user inputs
            conversionMode = input.next();


            // switch (conversionMode) {
            //     case "S", "s":
                    
            //         break;
            
            //     default:
            //         break;
            // }
            
            if ( (conversionMode.equals("S"))
            || (conversionMode.equals("s")) ) // Sum of 2 Integers
            {
                try {
                    System.out.print("\nEnter the first integer: ");
                    integerOne = input.nextInt();
                    System.out.print("Enter the second integer: ");
                    integerTwo = input.nextInt();

                    result = integerOne + integerTwo;
                    System.out.println("\nThe sum of "
                                       + integerOne
                                       + " and "
                                       + integerTwo
                                       + " is "
                                       + result);

                } catch ( Exception e )
                {
                    System.out.println("You need to enter an integer: " + e);
                }
            } else if ( (conversionMode.equals("P"))
            || (conversionMode.equals("p")) ) // Product of 2 Integers
            {
                try {
                    System.out.print("\nEnter the first integer: ");
                    integerOne = input.nextInt();
                    System.out.print("Enter the second integer: ");
                    integerTwo = input.nextInt();

                    result = integerOne * integerTwo;
                    System.out.println("\nThe product of "
                                       + integerOne
                                       + " and "
                                       + integerTwo
                                       + " is "
                                       + result);

                } catch (Exception e)
                {
                    System.out.println("You need to enter an integer: " + e);
                }
            } else if ((conversionMode.equals("D"))
            || (conversionMode.equals("d"))) // Divisibility of 2 Integers
            {
                try
                {
                    System.out.print("\nEnter the first integer: ");
                    integerOne = input.nextInt();
                    System.out.print("Enter the second integer: ");
                    integerTwo = input.nextInt();
                    if (integerOne % integerTwo == 0)
                    {
                        System.out.println("\n"
                                           + integerOne
                                           + " is divisible by "
                                           + integerTwo);
                    }
                    else
                    {
                        System.out.println("\n"
                                           + integerOne
                                           + " is not divisible by "
                                           + integerTwo);
                    }
                } catch ( Exception e )
                {
                    System.out.println("You need to enter an integer: " + e);
                }
            } else if ((conversionMode.equals("E")) 
                        || (conversionMode.equals("e"))
                        || (conversionMode.equals("quit"))
                        || (conversionMode.equals("exit"))) // Sum of 2 Integers
            {
                System.out.println("\nGoodbye.");
                programActive = false;
                input.close();
            } else
            {
                System.out.println("\nPlease enter a valid input.");
            }
            startup = false;
        }
    }
}