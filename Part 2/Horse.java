import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Horse extends Canvas {


    private boolean broadcast = false;
    private int distanceTravelled = 0;
    private HorseInfo horseInfo;
    private boolean fallen;
    private double odds;
    private Image sprite;

    public Horse() {
        super();
        try {
            this.sprite = ImageIO.read(new File("/Users/zaynpanjwani/Desktop/HorseRace Starter/Part 2/pixil-frame-0.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.distanceTravelled = 0;
        this.horseInfo = HorseInfo.generateRandom();
        this.setBackground(Color.YELLOW);
        this.setForeground(Color.BLACK);
        setBackground(Color.white);

        this.setVisible(true);
    }

    public double getOdds() {
        return odds;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }

    public boolean hasFinished() {

        if(this.distanceTravelled+100 >= this.getWidth()) {
            if(!broadcast) {
                broadcast=true;
                if(!Main.getRaceUI().isAwardedWinner()) {
                    this.getHorseInfo().setConfidence(this.getHorseInfo().getConfidence()+0.1);
                    Main.getRaceUI().setAwardedWinner(true);
                }
                Main.getRaceUI().getHorseStatus().updateHorse(this);
                Main.getRaceUI().horseFinished();
            }
            return true;
        }
        return false;
    }

    public void resetHorse() {
        Graphics g = this.getGraphics();
        g.clearRect(0, 0, this.getWidth(), this.getHeight());

        this.distanceTravelled = 0;
        this.fallen = false;
        this.broadcast = false;
    }

    public void paint(Graphics g) {
        g.clearRect(distanceTravelled-20, 10, distanceTravelled, 100);
        if(!this.fallen) {
            g.drawImage(sprite, distanceTravelled, 10, null);
        }else {
            g.setColor(Color.RED);
            g.fillRect(distanceTravelled, 10, 100, 100);
        }
    }

    public void fall() {
        this.fallen = true;
        this.getHorseInfo().setNumOfLoss(this.getHorseInfo().getNumOfLoss()+1);
        this.getHorseInfo().setConfidence(this.getHorseInfo().getConfidence()-0.1);
        Main.getRaceUI().getHorseStatus().updateHorse(this);
        Main.getRaceUI().horseFinished();
        broadcast = true;

    }

    public void tryFall() {
        if(Math.random() < (this.getHorseInfo().getConfidence()/75)) {
            fall();
            this.paint(this.getGraphics());
        }
    }

    public void moveHorse() {
        if(this.hasFinished() || this.fallen) return;
        this.tryFall();
        if(this.fallen) return;
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
