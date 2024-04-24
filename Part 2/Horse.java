import javax.swing.*;
import java.awt.*;

public class Horse extends Canvas {


    public void paint(Graphics g) {
        //TODO: replace this placeholder sprite with a proper horse sprite
        g.clearRect(distanceTravelled-20, 10, distanceTravelled, 100);
        g.setColor(Color.black);
        g.fillRect(distanceTravelled, 10, 100, 100);
        g.setColor(Color.white);
        g.fillRect(distanceTravelled+10, 20, 80, 80);
        g.setColor(Color.black);
        g.fillRect(distanceTravelled+20, 30, 60, 60);
        g.setColor(Color.white);
        g.fillRect(distanceTravelled+30, 40, 40, 40);
        g.setColor(Color.black);
        g.fillRect(distanceTravelled+40, 50, 20, 20);
        g.setColor(Color.white);
        g.fillRect(distanceTravelled+50, 60, 0, 0);
    }

    private int distanceTravelled = 0;
    private String name;
    private boolean fallen;
    private double confidence;

    public Horse() {
        super();
        this.distanceTravelled = 0;
        this.setBackground(Color.YELLOW);
        this.setForeground(Color.BLACK);
        setBackground(Color.white);




        this.setVisible(true);
    }

    public void moveHorse() {
        this.distanceTravelled +=3;
        this.paint(this.getGraphics());
    }
}
