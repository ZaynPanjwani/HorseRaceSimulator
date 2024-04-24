import javax.swing.*;
import java.awt.*;

public class Horse extends Canvas {
    public void paint(Graphics g) {
        //TODO: replace this placeholder sprite with a proper horse sprite
        g.setColor(Color.black);
        g.fillRect(10, 10, 100, 100);
        g.setColor(Color.white);
        g.fillRect(20, 20, 80, 80);
        g.setColor(Color.black);
        g.fillRect(30, 30, 60, 60);
        g.setColor(Color.white);
        g.fillRect(40, 40, 40, 40);
        g.setColor(Color.black);
        g.fillRect(50, 50, 20, 20);
        g.setColor(Color.white);
        g.fillRect(60, 60, 0, 0);
    }

    private int distanceTravelled = 0;
    private String name;
    private boolean fallen;
    private double confidence;

    public Horse() {
        super();
        this.setBackground(Color.YELLOW);
        this.setForeground(Color.BLACK);
        setBackground(Color.white);




        this.setVisible(true);
    }

    public void moveHorse() {
        //TODO: implement movement
    }
}
