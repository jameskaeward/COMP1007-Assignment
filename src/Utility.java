/**
 * FILE:        Utility.java
 * <p>
 * UNIT:        COMP1007
 * <p>
 * REFERENCE:   https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 * <p>
 * COMMENTS:    A bunch of helpful methods.
 * <p>
 * REQUIRES:    None.
 * <p>
 * Last Mod:    15th May 2025
 * <p>
 * @author      Rungpipol Kaew-ard
 */
public interface Utility
{
    static String[] isInputString =
    {
        "\nYour Choice: "
    };

    /**
     * Prints out an array of strings.
     * @param stringArray The string array to print.
     * @param isInput Whether more lines should be printed to indicate an input is needed.
     * @remarks Clears the terminal before printing.
     */
    static void printLines(String[] stringArray, boolean flushLines, boolean isInput)
    {
        // Clear the terminal
        if (flushLines)
        {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        

        // Now print the strings
        for (String string : stringArray)
        {

            System.out.println(string);
        }

        if (isInput)
        {
            for (String string : isInputString)
            {
                System.out.print(string);
            }
        }
    }
}