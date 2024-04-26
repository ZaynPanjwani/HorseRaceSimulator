import javax.swing.*;
import java.awt.*;

public class HorseStats extends JFrame {
    public HorseStats(HorseInfo horseInfo) {
        super(String.format("Stats of %s", horseInfo.getName()));
        BoxLayout layout = new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS);
        this.setLayout(layout);
        this.setSize(new Dimension(300, 600));

        this.addStat("Name", horseInfo.getName());
        this.addStat("Breed", horseInfo.getBreed());
        this.addStat("Confidence", String.format("%.2f", horseInfo.getConfidence()));
        this.addStat("Total distance travelled", horseInfo.getTotalDistanceTravelled()/4 + "m.");
        this.addStat("Time on track", horseInfo.getTicksSurvived() / 6 + "s");

        this.setVisible(true);
    }

    private void addStat(String statName, String statValue) {
        JPanel stat = new JPanel();
        stat.setBorder(BorderFactory.createEmptyBorder(0, 30, 0, 30));
        stat.setLayout(new BorderLayout());
        stat.add(new JLabel(statName), BorderLayout.WEST);
        stat.add(new JLabel(statValue), BorderLayout.EAST);
        this.add(stat);
    }
}
