import Errors.InvalidIdentifierError;

/**
 * FILE:        MissionController.java
 * <p>
 * UNIT:        COMP1007
 * <p>
 * COMMENTS:    The mission controller.
 * <p>
 * REQUIRES:    None.
 * <p>
 * Last Mod:    14th April 2025
 * <p>
 * @author      Rungpipol Kaew-ard
 */
public class MissionController
{
    private Mission currentMission;
    private Mission[] missions;

    private String[] currentMenuArray;
    private Menu.Types currentMenu;
    private boolean menuActive;

    // For staging a mission
    private Astronaut[] astronautsToAdd;

    // Constructor contains build events
    public MissionController()
    {
        showMenu(Menu.Types.MainMenu);
    }

    public void viewMission(int missionIndex)
    {
        this.currentMission = missions[missionIndex];
    }

    /**
     * Shows a menu to the user.
     */
    public void showMenu(Menu.Types menuId)
    {
        this.menuActive = true;
        switch (menuId) {
            case MainMenu:
                this.currentMenuArray = Menu.MAIN_MENU;
                break;
        
            case MissionMenu:
                this.currentMenuArray = Menu.MISSION_MENU;
                break;

            default:
                throw new InvalidIdentifierError("Invalid menu id, or no id specified.");
        }

        this.showCurrentMenu();
    }

    public void showCurrentMenu()
    {
        Utility.printLines(this.currentMenuArray);
    }
}


// MissionController: Responsible for managing all interactions, such as adding, viewing,
// or editing mission data, as well as reading from and writing to a file.
