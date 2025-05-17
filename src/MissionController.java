import java.io.File;
import java.util.Scanner;

import Errors.InvalidStateError;

/**
 * FILE:        MissionController.java
 * <p>
 * UNIT:        COMP1007
 * <p>
 * COMMENTS:    The mission controller.
 * <p>
 * REQUIRES:    None.
 * <p>
 * Last Mod:    16th May 2025
 * <p>
 * @author      Rungpipol Kaew-ard
 */
public class MissionController
{
    private Scanner scanner;

    private int currentMission;
    private Mission[] missions;

    private Menu.Types currentMenu;
    private boolean menuActive;

    // For staging a mission
    private Astronaut[] astronautsToAdd;

    // The file reader
    // This isn't neccessary, but it could be used if we wanted to read more files.
    private FileReadWrite reader;
    private String dataFilePath;

    enum Filter
    {
        AllMissions,
        MannedMissions,
        UnmannedMissiions
    }

    // Constructor contains build events
    public MissionController(String inputFilePath)
    {
        // Initiliase the scanner
        this.scanner = new Scanner(System.in);

        // Set the data file path
        this.dataFilePath = inputFilePath;

        // First initiliase missions as empty array
        Mission[] missions = {};
        this.missions = missions;

        // Reading the mission data
        String[] missionsData = FileReadWrite.readFile(this.dataFilePath);
        int numberMissions = missionsData.length;
        for (int i = 1; i < numberMissions; i++) // Starting at 1 to exlude header
        {
            Mission mission = FileReadWrite.parseMission(missionsData[i]);
            this.addMission(mission);
        }

        // Testing if missions are read
        // for (Mission mission : this.missions) {
        //     System.out.println(mission.getMissionName());
        // }
        // file[1] = "testing!!!";
        // FileReadWrite.writeFile(this.dataFilePath, file);

        // Utility.printLines(file, false, false);

        

        // The menu loop
        this.setMenu(Menu.Types.MainMenu);
        this.showCurrentMenu();
    }

    /**
     * Adds a mission to the controller.
     * @param mission The mission.
     */
    public void addMission(Mission mission)
    {
        int missionsNumber = this.missions.length;
        Mission[] newMissions = new Mission[missionsNumber + 1];

        // Copy the mission info
        newMissions = Utility.copyMissions(this.missions, newMissions);

        // Now add the new mission at the end
        newMissions[missionsNumber] = mission;

        // Set it to the controller's array
        this.missions = newMissions;
    }

    /**
     * Gets the mission the controller currently is scoped on.
     * @return The current mission.
     */
    @SuppressWarnings("unused")
    private Mission getCurrentMission()
    {
        Mission mission = missions[this.currentMission];
        return mission;
    }

    /**
     * Shows a menu to the user.
     */
    private void setMenu(Menu.Types menuId)
    {
        this.menuActive = true;
        this.currentMenu = menuId;

        // Debug
        // System.err.println(menuId.toString());
    }

    /**
     * Extracts infomation from a mission array
     * @param missions The missions to extract from
     * @return A string array with mission data formatted as "x) CODE NAME"
     */
    private String[] getMissionInfo(Mission[] missions)
    {
        int index = 0;
        String[] infoArray = new String[missions.length];

        for (Mission mission : missions) {
            // Get the mission info and combine it with a prefix
            String missionInfoPart = mission.toString();
            int counter = (index + 1);
            String prefix = Integer.toString(counter) + ") ";
            String fullString = prefix + missionInfoPart;

            // Now put that into the array
            String[] missionInfo = { fullString };

            infoArray = Utility.combineStrings(infoArray, missionInfo);
        }
        return infoArray;
    }

    public void showCurrentMenu()
    {

        // Debug
        // System.err.println(this.currentMenu.toString());

        // Print the menu
        String[] menuStrings = Menu.getMenu(this.currentMenu);

        // Get the menu info too
        if (this.currentMenu == Menu.Types.MissionMenuAll)
        {
            String[] info = getMissionInfo(this.missions);
            menuStrings = Utility.combineStrings(menuStrings, info);
        }

        Utility.printLines(menuStrings, true, true);

        // Get the input
        String input = scanner.next();

        // We have the input, now we verify it
        try {
            switch (this.currentMenu) {
                case MainMenu:
                    this.mainMenu(input);
                    break;

                case MissionMenuAll:
                    this.missionMenu(input, Filter.AllMissions);
                    break;
            
                default:
                    throw new InvalidStateError("Current menu isn't defined.");
            }
        } catch (Exception e) {
            // Reset the menu if there was an error
            this.showError();
        }
    }

    public void showError()
    {
        Utility.printLines(Menu.ERROR_NOTIFICATION, false, false);
        this.showCurrentMenu();
    }

    /**
     * Main menu handler.
     * @param choice
     */
    public void mainMenu(String choice)
    {
        int choiceIndex;
        try {
            choiceIndex = Integer.parseInt(choice);
        } catch (Exception e) {
            // Rethrow any errors
            throw e;
        }

        switch (choiceIndex) {
            case 1:
                this.setMenu(Menu.Types.MissionMenuAll);
                break;
        
            case 2:
                this.setMenu(Menu.Types.MissionMenuManned);
                break;

            case 3:
                this.setMenu(Menu.Types.MissionMenuUnmanned);
                break;

            case 4:
                this.setMenu(Menu.Types.MissionSeeAstronauts);
                break;

            case 5:
                this.setMenu(Menu.Types.MissionAdd);
                break;

            case 6:
                this.setMenu(Menu.Types.MissionEdit);
                break;

            case 7:
                this.setMenu(Menu.Types.MissionSummary);
                break;

            case 8:
                this.setMenu(Menu.Types.AstronautList);
                break;

            case 9:
                this.menuActive = false;
                this.exit();
                break;

            default:
                break;
        }
        if (menuActive) this.showCurrentMenu(); // So it doesn't show a menu on exit
    }

    public void missionMenu(String choice, Filter filter)
    {
        
    }

    public void exit()
    {
        scanner.close();
        String[] exit = {"Bye."};
        Utility.printLines(exit, true, false);
    }
}


// MissionController: Responsible for managing all interactions, such as adding, viewing,
// or editing mission data, as well as reading from and writing to a file.
