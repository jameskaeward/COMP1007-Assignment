import Errors.EmptyNameError;
import Errors.NumberOutOfRangeError;
import Errors.TooManyAstronautsError;

/**
 * FILE:        Mission.java
 * <p>
 * UNIT:        COMP1007
 * <p>
 * COMMENTS:    Represents a mission.
 * <p>
 * REQUIRES:    None.
 * <p>
 * Last Mod:    13th May 2025
 * <p>
 * @author      Rungpipol Kaew-ard
 */
public class Mission
{
    private String missionName;
    private String missionCode;
    private String destinationPlanet;
    private int launchYear;
    private double successRate;
    private boolean isManned;

    private Astronaut[] astronauts;

    /**
     * Creates a new mission.
     * @param name
     * @param code
     * @param destinationPlanet
     * @param launchYear
     * @param successRate
     * @param mannedMission
     */
    public Mission(
        String name,
        String code,
        String destinationPlanet,
        int launchYear,
        double successRate,
        boolean mannedMission
        )
    {

        // Check if the code, name, and planet are actually there
        if (
            name == "" ||
            code == "" ||
            destinationPlanet == ""
            )
        {
            throw new EmptyNameError("Name, code, or destination planet empty.");
        }

        // The launch year has to be between 1900 and 2100
        if (launchYear < 1900 || launchYear > 2100)
        {
            throw new NumberOutOfRangeError("Launch year must be between 1900 and 2100.");
        }

        // Success rate has to be a percentage
        if (successRate < 0 || successRate > 100)
        {
            throw new NumberOutOfRangeError("Success rate must be a percentage.");
        }

        // All good? Then create the mission
        this.missionName = name;
        this.missionCode = code;
        this.destinationPlanet = destinationPlanet;
        this.launchYear = launchYear;
        this.successRate = successRate;
        this.isManned = mannedMission;

        // It will create the astronaut as an empty array
        Astronaut[] astronauts = {};
        // System.out.println("Length: " + astronauts.length);
        this.astronauts = astronauts;
    }

    public String toString()
    {
        String string = this.missionCode + " " + this.missionName;
        return string;
    }

    public void setMissionCode(String newMissionCode)
    {
        if (newMissionCode == "")
        {
            throw new EmptyNameError("Mission code cannot be empty.");
        }
        this.missionCode = newMissionCode;
    }

    public String getMissionCode()
    {
        return this.missionCode;
    }

    public void setMissionName(String newMissionName)
    {
        if (newMissionName == "")
        {
            throw new EmptyNameError("Mission name cannot be empty.");
        }
    }

    public String getMissionName()
    {
        return this.missionName;
    }

    /**
     * Gets the astronauts on this mission.
     * @return An array of astronauts.
     */
    public Astronaut[] getAstronauts()
    {
        return this.astronauts;
    }

    /**
     * Adds an astronaut to a mission.
     * @param newAstronaut The new astronaut.
     */
    public void addAstronaut(Astronaut newAstronaut) throws TooManyAstronautsError
    {
        // See how many astronauts we have
        Astronaut[] currentAstronauts = this.astronauts;
        int numberAstronauts = currentAstronauts.length;
        int newNumberAstronauts = numberAstronauts + 1;

        // We cannot have more than 5 astronauts
        if ((newNumberAstronauts) >= 5)
        {
            throw new TooManyAstronautsError("More than 5 astronauts are being added to mission " + this.missionName);
        }

        Astronaut[] updatedAstronauts = new Astronaut[newNumberAstronauts];

        // Makes a new array and adds the new astronaut to it
        updatedAstronauts = copyAstronauts(currentAstronauts, updatedAstronauts);
        updatedAstronauts[numberAstronauts] = newAstronaut; // The index starts at 0, so use number of astronauts
        this.astronauts = updatedAstronauts;
    }

    public void removeAstronaut(int indexAstronaut)
    {
        
    }

    /**
     * Copies the information from the old array into the new one.
     * @param oldArray Old array.
     * @param newArray New array.
     * @return The new array with the copied information.
     */
    private Astronaut[] copyAstronauts(Astronaut[] oldArray, Astronaut[] newArray)
    {
        int length = oldArray.length;

        for (int i = 0; i < length; i++)
        {
            newArray[i] = oldArray[i];
        }
        return newArray;
    }

    // Wait for searching and sorting lab
    // public void removeAstronaut(Astronaut referenceAstronaut)
    // {
    //     for (Astronaut astronaut : astronauts)
    //     {
    //         if (astronaut.equals(referenceAstronaut))
    //         {
    //             // Remove the matching astronaut.
    //         }
    //     }
    // }



    
}


// Mission: Contains fields such as mission name, mission code, destination planet,
// launch year, success rate (percentage), and whether it’s a manned mission or not.