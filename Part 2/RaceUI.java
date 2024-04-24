import javax.swing.*;
import java.awt.*;

public class RaceUI extends JFrame {
    public RaceUI() {
        super("Main");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());

        this.setVisible(true);
    }

    public void initialiseComponents() {
        HorseLanes horseLanes = new HorseLanes(3);

        JPanel horseInfo = new JPanel();
        horseInfo.setPreferredSize(new Dimension((int) (this.getWidth()*0.2), (int) (this.getHeight()*0.7)));
        horseInfo.setBackground(Color.BLUE);

        JPanel customization =  new JPanel();
        customization.setBackground(Color.GREEN);
        customization.setPreferredSize(new Dimension((int) this.getWidth(), (int) (this.getHeight()*0.3)));


        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                horseLanes.setPreferredSize(new Dimension((int) (RaceUI.super.getWidth()*0.8), (int) (RaceUI.super.getHeight()*0.7)));
                horseInfo.setPreferredSize(new Dimension((int) (RaceUI.super.getWidth()*0.2), (int) (RaceUI.super.getHeight()*0.7)));
                customization.setPreferredSize(new Dimension((int) RaceUI.super.getWidth(), (int) (RaceUI.super.getHeight()*0.3)));
                horseInfo.revalidate();
                horseLanes.revalidate();
                customization.revalidate();
                horseInfo.repaint();
                horseLanes.repaint();
                customization.repaint();
            }
        });

        this.add(horseInfo, BorderLayout.EAST);
        this.add(horseLanes, BorderLayout.WEST);
        this.add(customization, BorderLayout.SOUTH);
    }
}
