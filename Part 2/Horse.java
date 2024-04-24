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
    private HorseInfo horseInfo;
    private boolean fallen;

    public Horse() {
        super();
        this.distanceTravelled = 0;
        this.horseInfo = HorseInfo.generateRandom();
        this.setBackground(Color.YELLOW);
        this.setForeground(Color.BLACK);
        setBackground(Color.white);

        this.setVisible(true);
    }

    public boolean hasFinished() {
        return this.distanceTravelled+100 >= this.getWidth();
    }

    public void moveHorse() {
        if(this.hasFinished()) return;
        this.horseInfo.setTicksSurvived(this.horseInfo.getTicksSurvived()+1);
        this.horseInfo.setTotalDistanceTravelled(this.horseInfo.getTotalDistanceTravelled() + (int) (5+(5*getHorseInfo().getConfidence())));
        this.distanceTravelled += (int) (5+(5*getHorseInfo().getConfidence()));
        this.paint(this.getGraphics());
    }

    public int getDistanceTravelled() {
        return distanceTravelled;
    }

    public void setDistanceTravelled(int distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public HorseInfo getHorseInfo() {
        return horseInfo;
    }

    public void setHorseInfo(HorseInfo horseInfo) {
        this.horseInfo = horseInfo;
    }

    public boolean isFallen() {
        return fallen;
    }

    public void setFallen(boolean fallen) {
        this.fallen = fallen;
    }

}
