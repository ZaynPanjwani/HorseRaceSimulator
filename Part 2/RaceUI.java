import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RaceUI extends JFrame {

    private HorseLanes horseLanes;
    private HorseStatus horseStatus;
    private Settings customization;

    private Leaderboard leaderboard;

    private JPanel bottom;

    private int horsesInRace;

    private ScheduledExecutorService executor;

    public RaceUI() {
        super("Main");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        this.setVisible(true);
    }

    public void initialiseComponents() {

        horseStatus = new HorseStatus();


        HorseLanes horseLanes = new HorseLanes(3);
        this.horseLanes = horseLanes;


        bottom = new JPanel();
        bottom.setSize(new Dimension(this.getWidth(), (int) (this.getHeight()*0.3)));
        bottom.setLayout(new BorderLayout());
        customization =  new Settings();




        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                handleResize();
            }
        });

        this.add(horseStatus, BorderLayout.EAST);
        this.add(horseLanes, BorderLayout.WEST);
        bottom.add(customization, BorderLayout.WEST);
        leaderboard = new Leaderboard();

        bottom.add(leaderboard, BorderLayout.EAST);
        this.add(bottom, BorderLayout.SOUTH);


        handleResize();

    }


    public void handleResize() {
        horseLanes.setPreferredSize(new Dimension((int) (RaceUI.super.getWidth()*0.8), (int) (RaceUI.super.getHeight()*0.7)));
        horseStatus.setPreferredSize(new Dimension((int) (RaceUI.super.getWidth()*0.2), (int) (RaceUI.super.getHeight()*0.7)));
        bottom.setPreferredSize(new Dimension(RaceUI.super.getWidth(), (int) (RaceUI.super.getHeight()*0.3)));
        customization.setPreferredSize(new Dimension((int) (RaceUI.super.getWidth() *0.8), RaceUI.super.getHeight()));
        leaderboard.setPreferredSize(new Dimension((int) (RaceUI.super.getWidth() *0.2), RaceUI.super.getHeight()));
        customization.revalidate();
        leaderboard.revalidate();
        horseStatus.revalidate();
        horseLanes.revalidate();
        bottom.revalidate();
        customization.repaint();
        leaderboard.repaint();
        horseStatus.repaint();
        horseLanes.repaint();
        bottom.repaint();
    }

    public void resetRace() {
        this.horseLanes.resetHorses();
        this.getLeaderboard().reset();

    }

    public void startRace() {
        this.resetRace();
        this.customization.disableAllComponents();
        executor = Executors.newSingleThreadScheduledExecutor();

        horsesInRace = getHorseLanes().getHorses().size();

        executor.scheduleAtFixedRate(horseLanes::tickAllHorses, 100, 16, TimeUnit.MILLISECONDS);
    }

    public void stopRace() {
        executor.shutdown();
        horseStatus.updateOdds();
        this.customization.enableAllComponents();
    }

    public void horseFinished() {
        horsesInRace-=1;
        if(horsesInRace == 0) this.stopRace();
    }

    public Leaderboard getLeaderboard() {
        return this.leaderboard;
    }

    public HorseLanes getHorseLanes() {
        return horseLanes;
    }

    public HorseStatus getHorseStatus() {
        return horseStatus;
    }

    public Settings getCustomization() {
        return customization;
    }
}
