/**
 * FILE:        Menu.java
 * <p>
 * UNIT:        COMP1007
 * <p>
 * REFERENCE:   https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 * <p>
 * COMMENTS:    Contains all the menus, and gets them for you.
 * <p>
 * REQUIRES:    None.
 * <p>
 * Last Mod:    16th May 2025
 * <p>
 * @author      Rungpipol Kaew-ard
 */
public interface Menu
{

    public enum Types
    {
        MainMenu,
        MissionMenuAll,
        MissionMenuManned,
        MissionMenuUnmanned,
        MissionSeeAstronauts,
        MissionAdd,
        MissionEdit,
        MissionSummary,
        AstronautList
    }

    public static String[] getMenu(Types menuId)
    {
        String[] menuArray;

        switch (menuId) {
            case MissionMenuAll:
                menuArray = Utility.combineStrings(MISSION_MENU, MISSION_ALL);
                break;

            case MissionMenuManned:
                menuArray = Utility.combineStrings(MISSION_MENU, MISSION_MANNED);
                break;

            case MissionMenuUnmanned:
                menuArray = Utility.combineStrings(MISSION_MENU, MISSION_UNMANNED);
                break;

            // case AstronautList:

            // Main Menu is the default case
            case MainMenu:
            default:
                menuArray = MAIN_MENU;
                break;
        }
        return menuArray;
    }

    static String[] ASTRONAUT_VIEW =
    {
        "=============================================",
        "               Astronaut View",
        "============================================="
    };

    static String[] ASTRONAUT_NATIONALITIES =
    {
        "Astronauts for the chosen nationality are shown below."
    };

    static String[] MAIN_MENU =
    {
        "=============================================",
        "   Welcome to Mission Command and Control",
        "=============================================",
        "Your options for this system are listed below",
        "",
        "1) View all missions",
        "2) View all manned missions",
        "3) View all unmanned missions.",
        "4) View a mission's astronauts.",
        "5) Add a new mission.",
        "6) Edit an existing mission.",
        "7) Summary of missions' success rates (average, highest, lowest).",
        "8) List astronauts for a given nationality.",
        "9) Exit Mission Command and Control",
    };

    static String[] MISSION_MENU =
    {
        "=============================================",
        "               Mission View",
        "============================================="
    };

    static String[] MISSION_ALL =
    {
        "All missions are listed below"
    };

    static String[] MISSION_MANNED =
    {
        "All manned missions are listed below"
    };

    static String[] MISSION_UNMANNED =
    {
        "All unmanned missions are listed below"
    };

    static String[] ERROR_NOTIFICATION =
    {
        "Please input a number."
    };
}