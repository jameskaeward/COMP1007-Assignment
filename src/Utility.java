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
 * Last Mod:    15th April 2025
 * <p>
 * @author      Rungpipol Kaew-ard
 */
public interface Utility
{
    /**
     * Prints out an array of strings.
     * @param stringArray
     */
    static void printLines(String[] stringArray)
    {
        for (String string : stringArray)
        {
            System.out.println(string);
        }
    }
}