/**
 * FILE:        Menus.java
 * <p>
 * UNIT:        COMP1007
 * <p>
 * REFERENCE:   https://docs.oracle.com/javase/tutorial/java/IandI/abstract.html
 * <p>
 * COMMENTS:    A bit like a bookshelf.
 * <p>
 * REQUIRES:    None.
 * <p>
 * Last Mod:    15th April 2025
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

    static String[] MAIN_MENU =
    {
        "=============================================",
        "Welcome to Mission Command and Control",
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