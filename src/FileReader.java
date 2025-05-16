import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * FILE:        FileReader.java
 * <p>
 * UNIT:        COMP1007
 * <p>
 * COMMENTS:    Represents a mission.
 * <p>
 * REQUIRES:    None.
 * <p>
 * Last Mod:    16th May 2025
 */
public class FileReader
{
    /**
     * Reads a text file.
     * @param fileName The name of the file.
     * @return The file's text as a string array.
     */
    public static String[] readFile(String fileName)
    {
        FileInputStream input = null;
        InputStreamReader reader;
        BufferedReader bufferedReader;
        int lineIndex;
        String line;
        String[] file = {};
        try
        {
            input = new FileInputStream(fileName);
            reader = new InputStreamReader(input);
            bufferedReader = new BufferedReader(reader);
            lineIndex = 0;
            line = bufferedReader.readLine();
            while (line != null)
            {
                lineIndex++;
                // Create the new array and it adds to the file bit by bit
                String[] newLine = {line};
                Utility.combineStrings(file, newLine);
            }
            // Close the stream at the end
            input.close();
        }
        catch (Exception e)
        {
            System.err.println("File read error: " + e.getMessage());
        }
        return file;
    }
}
