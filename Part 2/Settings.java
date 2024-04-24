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

        numberOfLanes.addActionListener(e -> Main.getRaceUI().getHorseLanes().updateLanes(numberOfLanes.getSelectedIndex()+2));

        JButton startButton = new JButton("Start");

        startButton.addActionListener(e -> {
            Main.getRaceUI().startRace();
        });


        this.add(startButton); // (1,4)


        this.add(new JLabel("Track conditions")); // (2,4)
        this.add(new JLabel("Track color")); // (3,4)





        this.add(new JLabel("Horse Color")); // (4,4)

        JPanel lanesSelectionPanel = new JPanel();

        lanesSelectionPanel.setLayout(new BorderLayout());

        lanesSelectionPanel.add(new JLabel("Number of lanes: "), BorderLayout.NORTH);
        lanesSelectionPanel.add(numberOfLanes, BorderLayout.SOUTH);

        this.add(lanesSelectionPanel); // (5,4)


        this.add(new JLabel("")); // (1,3)
        this.add(new JLabel("")); // (2,3)


        JPanel trackColorsGrid = new JPanel();
        trackColorsGrid.setLayout(new GridLayout(2,2));
        Color[] trackColors = new Color[] {
                new Color(255, 255, 255),
                new Color(54, 54, 54),
                new Color(120, 172, 255),
                new Color(180, 196, 63)
        };
        for(Color trackColor : trackColors) {
            JButton trackColorButton = new JButton();
            trackColorButton.addActionListener(e -> {
                //set color from here
            });
            trackColorButton.setBackground(trackColor);
            trackColorButton.setForeground(trackColor);
            trackColorButton.setOpaque(true);
            trackColorsGrid.add(trackColorButton);
        }

        this.add(trackColorsGrid); // (3,3)


        JPanel breedColorGrid = new JPanel();
        breedColorGrid.setLayout((new GridLayout(2,2)));
        Color[] breedColors = new Color[] {
                new Color(105, 40, 20),
                new Color(204, 203, 190),
                new Color(107, 11, 11),
                new Color(0,0,0)
        };
        for(Color breedColor : breedColors){
            JButton breedColorButton = new JButton();
            breedColorButton.addActionListener(e -> {
                //set color from here
            });
            breedColorButton.setBackground(breedColor);
            breedColorButton.setForeground(breedColor);
            breedColorButton.setOpaque(true);
            breedColorGrid.add(breedColorButton);
        }

        this.add(breedColorGrid); // (4,3)


        this.add(new JLabel("")); // (3.1)
        this.add(new JLabel("")); // (4,1)
        this.add(new JLabel("")); // (5,1)
        this.add(new JLabel("Uniform Color")); // (3,2)
        this.add(new JLabel("Horse Equipment Color"));//
        this.add(new JLabel("")); // (1,1)
        this.add(new JLabel("")); // (2,1)
        this.add(new JLabel("")); // (2,1)

        JPanel uniformColorGrid = new JPanel();
        uniformColorGrid.setLayout((new GridLayout(2,3)));
        Color[] uniformColors = new Color[] {
                new Color(255,0,0),
                new Color(0, 115, 255),
                new Color(0, 255, 0),
                new Color(200,255,0),
                new Color(255,0,180),
                new Color(150,0,255)
        };
        for(Color uniformColor : uniformColors){
            JButton uniformColorButton = new JButton();
            uniformColorButton.addActionListener(e -> {
                //set color from here
            });
            uniformColorButton.setBackground(uniformColor);
            uniformColorButton.setForeground(uniformColor);
            uniformColorButton.setOpaque(true);
            uniformColorGrid.add(uniformColorButton);
        }

        this.add(uniformColorGrid); // (4,3)
        // (4,2)

        // horse color here
        JPanel horseManeColorGrid = new JPanel();
        horseManeColorGrid.setLayout((new GridLayout(2,2)));
        Color[] horseManeColors = new Color[] {
                new Color(255,0,0),
                new Color(0, 115, 255),
                new Color(0, 255, 0),
                new Color(200,255,0),
                new Color(255,0,180),
                new Color(150,0,255)
        };
        for(Color horseManeColor : horseManeColors) {
            JButton horseManeColorButton = new JButton();
            horseManeColorButton.addActionListener(e -> {
                //set color from here
            });
            horseManeColorButton.setBackground(horseManeColor);
            horseManeColorButton.setForeground(horseManeColor);
            horseManeColorButton.setOpaque(true);
            horseManeColorGrid.add(horseManeColorButton);
        }
        this.add(horseManeColorGrid);

    }
}
