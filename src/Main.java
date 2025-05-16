import java.io.File;
import java.io.FileDescriptor;

public class Main
{
    public static void main(String[] args)
    {
        // Utility.printLines(Menus.MAIN_MENU);
        String filePath = "data.csv"; // Relative paths are annoying

        // We startup the mission controller through construction events.
        @SuppressWarnings("unused") // We don't use this, we're just using the construction event.
        MissionController controller = new MissionController(filePath);
    }
}
