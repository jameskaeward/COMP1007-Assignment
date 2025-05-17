import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import Errors.BadFileDataError;

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
public class FileReadWrite
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
            // lineIndex = 0;
            line = bufferedReader.readLine();
            while (line != null)
            {
                // lineIndex++;
                // Create the new array and it adds to the file bit by bit
                String[] newLine = {line};
                // System.out.println(line);
                file = Utility.combineStrings(file, newLine);

                // Go to next line
                line = bufferedReader.readLine();
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

    /**
     * Writes into a text file.
     * @param filename The text file's name.
     * @param input The string array to write to the file.
     * @remarks Each array element represents a single line.
     */
    public static void writeFile(String filename, String[] input)
    {
        FileOutputStream output = null;
        PrintWriter writer;
        try
        {
            output = new FileOutputStream(filename);
            writer = new PrintWriter(output);
            for (String string : input) {
                writer.println(string);
            }
            writer.close();
        }
        catch (IOException e) {
            System.err.println("File write error: " + e.getMessage());
        }
    }

    /**
     * Parses a csv line into a mission
     * @param missionString
     * @return The mission object the string represented.
     */
    public static Mission parseMission(String missionString) throws BadFileDataError, NumberFormatException
    {
        // Example data: Neptune Research,NR104,Neptune,2045,64.5,true,Kofi Mensah:Engineer:40:Ghana
        // Missionname , Code , Destination , Year , Success Rate , isManned? , Astronauts
        // This needs to become a mission

        // Split by comma, it's a csv file!
        String[] missionParts = missionString.split(",");

        if (missionParts.length < 6)
        {
            throw new BadFileDataError("Line does not have correct data.");
        }

        String missionName = missionParts[0];
        String missionCode = missionParts[1];
        String destination = missionParts[2];
        String yearString = missionParts[3];
        String successRateString = missionParts[4];
        String isMannedString = missionParts[5];
        String astronautData = null;

        // Not having astronauts will mean the array is only 6 long
        boolean hasAstronauts = false; // This is a double check on isManned
        if (missionParts.length >= 7)
        {
            hasAstronauts = true;
            astronautData = missionParts[6];
        }

        int missionYear = Integer.parseInt(yearString);
        int successRate = Integer.parseInt(successRateString);
        // boolean isManned = Boolean.getBoolean(isMannedString);
        boolean isManned;
        if (isMannedString == "true" && hasAstronauts)
        {
            isManned = true;
        }
        else if (isMannedString == "false" && !hasAstronauts)
        {
            isManned = false;
        }
        else
        {
            // This will be thrown if isManned isn't defined
            // But it will also be thrown if there are astronauts, but isManned is false (and vice versa)
            throw new BadFileDataError("isManned is not defined correctly.");
        }


        Mission mission = new Mission(missionName, missionCode, destination, missionYear, successRate, isManned);

        // We add the astronauts if nothing is wrong
        if (isManned)
        {
            Astronaut[] astronauts = parseAstronauts(astronautData);
            for (Astronaut astronaut : astronauts) {
                mission.addAstronaut(astronaut);
            }
        }

        return mission;
    }

    public static Astronaut[] parseAstronauts(String astronautData)
    {
        // Astronauts are separated by a pipe |
        String[] astronautsString = astronautData.split("|");
        // We make an array which'll contain the astronauts
        Astronaut[] astronauts = new Astronaut[astronautsString.length];

        // Now get each astronaut
        int index = 0;
        for (String astronautString : astronautsString)
        {
            Astronaut astronaut = parseAstronaut(astronautString);
            astronauts[index] = astronaut;
            index++;
        }
        return astronauts;
    }

    /**
     * Parses a single astronaut.
     * @param astronautString The astronaut's string representation.
     * @return The astronaut as an object.
     * @throws NumberFormatException
     */
    public static Astronaut parseAstronaut(String astronautString) throws NumberFormatException
    {
        // Example data:  Kofi Mensah:Engineer:40:Ghana
        // Name : Rank : Nationality
        String[] astronautParts = astronautString.split(":");
        String name = astronautParts[0];
        String rank = astronautParts[1];
        int age = Integer.parseInt(astronautParts[2]);
        String nationality = astronautParts[3];

        Astronaut astronaut = new Astronaut(name, age, rank, nationality);
        return astronaut;
    }
}
