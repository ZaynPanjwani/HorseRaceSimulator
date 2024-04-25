import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class RaceUI extends JFrame {

    private HorseLanes horseLanes;
    private HorseStatus horseStatus;
    private Settings customization;

    private int horsesInRace;

    private ScheduledExecutorService executor;

    public RaceUI() {
        super("Main");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());

        this.setVisible(true);
    }

    public void initialiseComponents() {

        horseStatus = new HorseStatus();


        HorseLanes horseLanes = new HorseLanes(3);
        this.horseLanes = horseLanes;



        customization =  new Settings();



        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                handleResize();
            }
        });

        this.add(horseStatus, BorderLayout.EAST);
        this.add(horseLanes, BorderLayout.WEST);
        this.add(customization, BorderLayout.SOUTH);


        handleResize();

    }


    public void handleResize() {
        horseLanes.setPreferredSize(new Dimension((int) (RaceUI.super.getWidth()*0.8), (int) (RaceUI.super.getHeight()*0.7)));
        horseStatus.setPreferredSize(new Dimension((int) (RaceUI.super.getWidth()*0.2), (int) (RaceUI.super.getHeight()*0.7)));
        customization.setPreferredSize(new Dimension((int) RaceUI.super.getWidth(), (int) (RaceUI.super.getHeight()*0.3)));
        horseStatus.revalidate();
        horseLanes.revalidate();
        customization.revalidate();
        horseStatus.repaint();
        horseLanes.repaint();
        customization.repaint();
    }

    public void startRace() {
        this.horseLanes.resetHorses();
        this.customization.disableAllComponents();
        executor = Executors.newSingleThreadScheduledExecutor();

        horsesInRace = getHorseLanes().getHorses().size();

        executor.scheduleAtFixedRate(horseLanes::tickAllHorses, 100, 16, TimeUnit.MILLISECONDS);
    }

    public void stopRace() {
        executor.shutdown();
        this.customization.enableAllComponents();
    }

    public void horseFinished() {
        horsesInRace-=1;
        //getHorseStatus().updateLanes();
        if(horsesInRace == 0) this.stopRace();
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
