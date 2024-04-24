import javax.swing.*;
import java.awt.*;

public class Main{
    private static RaceUI UI_INSTANCE;
    public static void main(String[] args) {
        UI_INSTANCE = new RaceUI();
        UI_INSTANCE.initialiseComponents();
    }

    public static RaceUI getRaceUI() {
        return UI_INSTANCE;
    }

}