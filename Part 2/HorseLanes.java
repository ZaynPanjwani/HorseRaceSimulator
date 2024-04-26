import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
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
        Main.getRaceUI().getHorseStatus().updateLanes(this.horses);
    }

    public void resetHorses() {
        this.horses.forEach(Horse::resetHorse);
    }

    public void updateAllColors() {
        this.horses.forEach(horse -> {
            try {

                horse.setFence(ImageIO.read(new File(String.format("./Part 2/sprites/fences/%s_fence.png", Main.getRaceUI().getCustomization().getChosenFenceColor()))));
                horse.setSprite(ImageIO.read(new File(String.format("./Part 2/sprites/horse/%s-%s-horse.png", Main.getRaceUI().getCustomization().getChosenBreedColor(), Main.getRaceUI().getCustomization().getChosenHorseManeColor()))));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public ArrayList<Horse> getHorses() {
        return this.horses;
    }
}
