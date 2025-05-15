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

    private String[] currentMenu;
    private boolean menuActive;

    // For staging a mission
    private Astronaut[] astronautsToAdd;

    // Constructor contains build events
    public MissionController()
    {
        showMenu(Menus.Types.MainMenu);
    }

    public void viewMission(int missionIndex)
    {
        this.currentMission = missions[missionIndex];
    }

    /**
     * Shows a menu to the user.
     */
    public void showMenu(Menus.Types menuId)
    {
        this.menuActive = true;
        switch (menuId) {
            case MainMenu:
                this.currentMenu = Menus.MAIN_MENU;
                break;
        
            case MissionMenu:
                this.currentMenu = Menus.MISSION_MENU;
                break;

            default:
                throw new InvalidIdentifierError("Invalid menu id, or no id specified.");
        }

        this.showCurrentMenu();
    }

    public void showCurrentMenu()
    {
        Utility.printLines(this.currentMenu);
    }
}


// MissionController: Responsible for managing all interactions, such as adding, viewing,
// or editing mission data, as well as reading from and writing to a file.
