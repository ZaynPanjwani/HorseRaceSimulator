import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class HorseLanes extends JPanel {
    private ArrayList<Horse> horses;


    public HorseLanes(int numOfLanes)
    {
        super();
        this.horses = new ArrayList<>();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.setBackground(Color.RED);

        this.setPreferredSize(new Dimension((int) (Main.getRaceUI().getWidth()*0.8), (int) (Main.getRaceUI().getHeight()*0.7)));

        this.setVisible(true);

        this.updateLanes(numOfLanes);

    }

    public void tickAllHorses() {
        this.horses.forEach(Horse::moveHorse);
    }

    public void updateLanes(int numOfLanes) {
        this.horses.clear();
        this.removeAll();
        this.revalidate();
        this.repaint();

        for (int i = 0; i < numOfLanes; i++)
        {
            Horse horse = new Horse();
            this.horses.add(horse);
            this.add(horse);
        }
    }
}
