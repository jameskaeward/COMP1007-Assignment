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
 * Last Mod:    16th May 2025
 * <p>
 * @author      Rungpipol Kaew-ard
 */
public interface Utility
{

    /**
     * Combines two string arrays.
     * @param array1 The first array.
     * @param array2 The second string array.
     * @return The combined array, with the first array coming first.
     */
    public static String[] combineStrings(String[] array1, String[] array2)
    {
        int combinedLength = array1.length + array2.length;
        String[] newArray = new String[combinedLength];

        int index = 0; // For the loop
        for (String _ : array1) {
            newArray[index] = array1[index];
            index++;
        }

        int array2Index = 0;
        for (String _ : array2) {
            newArray[index] = array2[array2Index];
            index++;
            array2Index++;
        }
        return newArray;
    }

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