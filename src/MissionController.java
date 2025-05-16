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

    public void showCurrentMenu()
    {

        // Debug
        // System.err.println(this.currentMenu.toString());

        // Print the menu
        String[] menuStrings = Menu.getMenu(this.currentMenu);
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
