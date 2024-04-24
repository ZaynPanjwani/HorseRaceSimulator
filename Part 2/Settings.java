import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel {
    public Settings() {
        super();
        GridLayout mainGridLayout = new GridLayout(4, 5);
        mainGridLayout.setHgap(10);
        this.setLayout(mainGridLayout);
        this.setBackground(new Color(238,238,238));
        this.setPreferredSize(new Dimension(Main.getRaceUI().getWidth(), (int) (Main.getRaceUI().getHeight()*0.3)));
        this.setForeground(Color.BLACK);

        this.setAlignmentX(Component.CENTER_ALIGNMENT);


        JComboBox<Integer> numberOfLanes = new JComboBox<>(new Integer[]{2,3,4,5});


        JButton startButton = new JButton("Start");


        this.add(startButton); // (1,4)


        this.add(new JLabel("Track conditions")); // (2,4)
        this.add(new JLabel("Track color")); // (3,4)





        this.add(new JLabel("Horse Color")); // (4,4)

        JPanel lanesSelectionPanel = new JPanel();

        lanesSelectionPanel.setLayout(new BorderLayout());

        lanesSelectionPanel.add(new JLabel("Number of lanes: "), BorderLayout.NORTH);
        lanesSelectionPanel.add(numberOfLanes, BorderLayout.SOUTH);

        this.add(lanesSelectionPanel); // (5,4)

        this.setVisible(true);

    }
}
