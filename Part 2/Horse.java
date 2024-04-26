import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Horse extends Canvas {


    private boolean broadcast = false;
    private int amountBet;
    private int distanceTravelled = 0;
    private HorseInfo horseInfo;
    private boolean fallen;
    private double odds;

    private double oddsAtStart;
    private Image sprite;

    private Image fence;

    public Horse(HorseInfo info) {
        super();
        try {
            this.sprite = ImageIO.read(new File("/Users/zaynpanjwani/Desktop/HorseRace Starter/Part 2/sprites/horse/beige-lightbrown-horse.png"));
            this.fence = ImageIO.read(new File("/Users/zaynpanjwani/Desktop/HorseRace Starter/Part 2/sprites/fences/green_fence.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.distanceTravelled = 0;
        if(info == null) {
            this.horseInfo = HorseInfo.generateRandom();
            Main.getRaceUI().getGameState().horses.add(this.horseInfo);
        }
        else this.horseInfo = info;
        this.setBackground(Color.YELLOW);
        this.setForeground(Color.BLACK);
        setBackground(Color.white);

        this.setVisible(true);
    }

    public static ArrayList<Horse> getPregeneratedHorses(int num) {
        ArrayList<HorseInfo> horseInfos = (ArrayList<HorseInfo>) Main.getRaceUI().getGameState().horses.clone();
        ArrayList<Horse> horses = new ArrayList<>();
        Random r = new Random();
        for(int i = 0; i<num; i++) {
            if(horseInfos.isEmpty()) {
                horses.add(new Horse(null));
            } else {
                HorseInfo info = horseInfos.remove(r.nextInt(horseInfos.size()));
                horses.add(new Horse(info));
            }
        }
        return horses;
    }

    public double getOdds() {
        return odds;
    }

    public void setOdds(double odds) {
        this.odds = odds;
        if(!Main.getRaceUI().isRaceRunning()) {
            this.oddsAtStart = odds;
        }
    }

    public boolean hasFinished() {

        if(this.distanceTravelled+100 >= this.getWidth()) {
            if(!broadcast) {
                broadcast=true;
                if(Main.getRaceUI().getLeaderboard().addEntry(this) == 1) {
                    this.getHorseInfo().setConfidence(this.getHorseInfo().getConfidence()+0.1);
                    double multiplier = 2-getOdds();
                    int moneyToCredit = (int) (this.getAmountBet()*multiplier);
                    Main.getRaceUI().getGameState().balance+=moneyToCredit;
                }
                this.amountBet = 0;
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
        this.paint(this.getGraphics());
    }

    public int getAmountBet() {
        return amountBet;
    }

    public void setAmountBet(int amountBet) {
        this.amountBet = amountBet;
    }

    public void paint(Graphics g) {
        g.clearRect(distanceTravelled-20, 10, distanceTravelled, 80);

        for(int i = 0; i<this.getWidth(); i+=(fence.getWidth(null)-15)) {
            g.drawImage(fence, i, 50, null);
        }

        if(!this.fallen) {
            g.drawImage(sprite, distanceTravelled, 10, null);

        }else {
            g.setColor(Color.RED);
            g.fillRect(distanceTravelled, 10, 100, 80);
        }
    }

    public void fall() {
        this.fallen = true;
        this.getHorseInfo().setNumOfLoss(this.getHorseInfo().getNumOfLoss()+1);
        this.getHorseInfo().setConfidence(this.getHorseInfo().getConfidence()-0.1);
        Main.getRaceUI().getLeaderboard().addFallenEntry(this);
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

    public void setSprite(Image sprite) {
        this.sprite = sprite;
        this.paint(this.getGraphics());
    }

    public void setFence(Image fence) {
        this.fence = fence;
        this.paint(this.getGraphics());
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
