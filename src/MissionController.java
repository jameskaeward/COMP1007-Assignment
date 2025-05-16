import java.util.Scanner;

import Errors.InvalidIdentifierError;
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
 * Last Mod:    15th May 2025
 * <p>
 * @author      Rungpipol Kaew-ard
 */
public class MissionController
{
    private Scanner scanner;

    private Mission currentMission;
    private Mission[] missions;

    private String[] currentMenuArray;
    private Menu.Types currentMenu;
    private boolean menuActive;

    // For staging a mission
    private Astronaut[] astronautsToAdd;

    enum Filter
    {
        AllMissions,
        MannedMissions,
        UnmannedMissiions
    }

    // Constructor contains build events
    public MissionController()
    {
        // Initiliase the scanner
        this.scanner = new Scanner(System.in);

        // The menu loop
        this.setMenu(Menu.Types.MainMenu);
        this.showCurrentMenu();
    }

    public void viewMission(int missionIndex)
    {
        this.currentMission = missions[missionIndex];
    }

    /**
     * Shows a menu to the user.
     */
    public void setMenu(Menu.Types menuId)
    {
        this.menuActive = true;
        switch (menuId) {
            case MainMenu:
                this.currentMenuArray = Menu.MAIN_MENU;
                break;
        
            case MissionMenuAll:
                this.currentMenuArray = Menu.MISSION_MENU;
                break;

            default:
                throw new InvalidIdentifierError("Invalid menu id, or no id specified.");
        }
    }

    public void showCurrentMenu()
    {
        // Print the menu
        Utility.printLines(this.currentMenuArray, true, true);

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

    public void mainMenu(String choice)
    {
        int choiceIndex;
        try {
            choiceIndex = Integer.parseInt(choice);
        } catch (Exception e) {
            // Rethrow any errors
            throw e;
        }
    }

    public void missionMenu(String choice, Filter filter)
    {

    }
}


// MissionController: Responsible for managing all interactions, such as adding, viewing,
// or editing mission data, as well as reading from and writing to a file.
