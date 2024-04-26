import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class Leaderboard extends JPanel {
    private int position;
    public Leaderboard() {
        super();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setLayout(boxLayout);
        this.setSize(new Dimension((int) (Main.getRaceUI().getWidth()*0.2), (int) (Main.getRaceUI().getHeight()*0.3)));
        this.setForeground(Color.BLACK);

        JLabel positions = new JLabel("Leaderboard");

        positions.setFont(new Font("Serif", Font.PLAIN, 26));
        positions.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(positions);

        this.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.reset();
    }

    public void reset() {
        this.position = 0;
        Arrays.stream(this.getComponents()).forEach(e -> {
            if (!(((JLabel) e).getText().equals("Leaderboard"))) {
                this.remove(e);
            }
        });

        this.revalidate();
        this.repaint();


    }

    public int addEntry(Horse horse) {
        this.add(new JLabel(String.format("%s. %s", position+1, horse.getHorseInfo().getName())), position+1);
        this.repaint();
        return ++position;
    }
    public void addFallenEntry(Horse horse) {
        this.add(new JLabel(String.format("DNF. %s", horse.getHorseInfo().getName())));
        this.repaint();
    }
}
