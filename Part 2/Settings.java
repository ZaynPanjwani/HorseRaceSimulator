import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;

public class Settings extends JPanel {

    private JComboBox<Integer> numberOfLanes;

    private String chosenFenceColor = "green";

    private String chosenBreedColor = "beige";

    private String chosenHorseManeColor = "maroon";


    public Settings() {
        super();
        GridLayout mainGridLayout = new GridLayout(4, 3);
        mainGridLayout.setHgap(10);
        this.setLayout(mainGridLayout);
        this.setBackground(new Color(238,238,238));
        this.setPreferredSize(new Dimension((int) (Main.getRaceUI().getWidth()*0.8), Main.getRaceUI().getHeight()));
        this.setForeground(Color.BLACK);

        this.setAlignmentX(Component.CENTER_ALIGNMENT);


        numberOfLanes = new JComboBox<>(new Integer[]{2,3,4,5});

        numberOfLanes.setSelectedIndex(1);

        numberOfLanes.addActionListener(e -> Main.getRaceUI().getHorseLanes().updateLanes(numberOfLanes.getSelectedIndex()+2));

        JButton startButton = new JButton("Start");

        startButton.addActionListener(e -> {
            Main.getRaceUI().startRace();
        });


        this.add(startButton); // (1,4)




        this.add(new JLabel("Track color")); // (3,4)





        this.add(new JLabel("Horse Color")); // (4,4)

        JPanel lanesSelectionPanel = new JPanel();

        lanesSelectionPanel.setLayout(new BorderLayout());

        lanesSelectionPanel.add(new JLabel("Number of lanes: "), BorderLayout.NORTH);
        lanesSelectionPanel.add(numberOfLanes, BorderLayout.SOUTH);

        this.add(lanesSelectionPanel); // (5,4)




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
        for(int i = 0; i< breedColors.length; i++){
            Color breedColor = breedColors[i];
            JButton breedColorButton = new JButton();

            int index = i;
            breedColorButton.addActionListener(e -> {
                switch(index) {
                    case 0:
                        chosenBreedColor = "beige";
                        break;
                    case 1:
                        chosenBreedColor = "cream";
                        break;
                    case 2:
                        chosenBreedColor = "darkbrown";
                        break;
                    case 3:
                        chosenBreedColor = "white";
                        break;
                }
                Main.getRaceUI().getHorseLanes().updateAllColors();
            });
            breedColorButton.setBackground(breedColor);
            breedColorButton.setForeground(breedColor);
            breedColorButton.setOpaque(true);
            breedColorGrid.add(breedColorButton);
        }

        this.add(breedColorGrid); // (4,3)

        //replacing with the save/load btns
        JPanel saveLoadButtons = new JPanel();
        saveLoadButtons.setLayout(new GridLayout(2,1));

        JButton save = new JButton("save");
        save.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
            fileChooser.showSaveDialog(this);

            File chosenFile = fileChooser.getSelectedFile();
            if(chosenFile != null) {
                //save here
            }
        });

        JButton load = new JButton("load");
        load.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
            fileChooser.showOpenDialog(this);

            File chosenFile = fileChooser.getSelectedFile();
            if(chosenFile != null && chosenFile.exists() && chosenFile.canRead()) {
                //load here
            }
        });

        saveLoadButtons.add(save);
        saveLoadButtons.add(load);
        this.add(saveLoadButtons);


        this.add(new JLabel("Fence Color")); // (3,2)
        this.add(new JLabel("Horse Mane Color"));

        JButton reset = new JButton("Reset");

        reset.addActionListener(e -> Main.getRaceUI().resetRace());

        this.add(reset);

        JPanel fenceColorGrid = new JPanel();
        fenceColorGrid.setLayout((new GridLayout(2,3)));
        Color[] fenceColors = new Color[] {
                new Color(0,0,0),
                new Color(0, 115, 255),
                new Color(0, 255, 0),
                new Color(200,255,0),
                new Color(255,0,180),
                new Color(150,0,255)
        };
        for(int i = 0; i<fenceColors.length; i++){
            Color fenceColor = fenceColors[i];
            JButton fenceColorButton = new JButton();
            int index = i;
            fenceColorButton.addActionListener(e -> {
                switch(index) {
                    case 0:
                        chosenFenceColor = "blue";
                        break;
                    case 1:
                        chosenFenceColor = "green";
                        break;
                    case 2:
                        chosenFenceColor = "orange";
                        break;
                    case 3:
                        chosenFenceColor = "pink";
                        break;
                    case 4:
                        chosenFenceColor = "purple";
                        break;
                    case 5:
                        chosenFenceColor = "yellow";
                        break;
                }
                Main.getRaceUI().getHorseLanes().updateAllColors();
            });
            fenceColorButton.setBackground(fenceColor);
            fenceColorButton.setForeground(fenceColor);
            fenceColorButton.setOpaque(true);
            fenceColorGrid.add(fenceColorButton);
        }

        this.add(fenceColorGrid); // (4,3)
        // (4,2)

        // horse color here
        JPanel horseManeColorGrid = new JPanel();
        horseManeColorGrid.setLayout((new GridLayout(2,2)));
        Color[] horseManeColors = new Color[] {
                new Color(255,0,0),
                new Color(0, 115, 255),
                new Color(0, 255, 0),
                new Color(200,255,0)
        };
        for(int i = 0; i< horseManeColors.length; i++) {
            Color horseManeColor = horseManeColors[i];
            JButton horseManeColorButton = new JButton();
            int chosenColorIndex = i;
            horseManeColorButton.addActionListener(e -> {
                switch(chosenColorIndex) {
                    case 0:
                        chosenHorseManeColor = "darkbrown";
                        break;
                    case 1:
                        chosenHorseManeColor = "grey";
                        break;
                    case 2:
                        chosenHorseManeColor = "lightbrown";
                        break;
                    case 3:
                        chosenHorseManeColor = "maroon";
                }
                Main.getRaceUI().getHorseLanes().updateAllColors();
            });
            horseManeColorButton.setBackground(horseManeColor);
            horseManeColorButton.setForeground(horseManeColor);
            horseManeColorButton.setOpaque(true);
            horseManeColorGrid.add(horseManeColorButton);
        }
        this.add(horseManeColorGrid);

    }

    public void disableAllComponents() {
        numberOfLanes.setEnabled(false);
        Arrays.stream(this.getComponents()).forEach(c -> c.setEnabled(false));
    }
    public void enableAllComponents() {
        numberOfLanes.setEnabled(true);
        Arrays.stream(this.getComponents()).forEach(c -> c.setEnabled(true));
    }

    public String getChosenFenceColor() {
        return chosenFenceColor;
    }

    public String getChosenBreedColor() {
        return chosenBreedColor;
    }

    public String getChosenHorseManeColor() {
        return chosenHorseManeColor;
    }
}
