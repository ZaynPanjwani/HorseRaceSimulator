import javax.swing.*;
import java.awt.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class RaceUI extends JFrame {

    private HorseLanes horseLanes;
    private JPanel horseInfo;
    private Settings customization;
    public RaceUI() {
        super("Main");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 400);
        this.setLayout(new BorderLayout());

        this.setVisible(true);
    }

    public void initialiseComponents() {
        HorseLanes horseLanes = new HorseLanes(3);
        this.horseLanes = horseLanes;

        horseInfo = new JPanel();
        horseInfo.setPreferredSize(new Dimension((int) (this.getWidth()*0.2), (int) (this.getHeight()*0.7)));
        horseInfo.setBackground(Color.BLUE);

        customization =  new Settings();



        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                handleResize();
            }
        });

        this.add(horseInfo, BorderLayout.EAST);
        this.add(horseLanes, BorderLayout.WEST);
        this.add(customization, BorderLayout.SOUTH);


        handleResize();

    }


    public void handleResize() {
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

    public void startRace() {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

        executor.scheduleAtFixedRate(horseLanes::tickAllHorses, 100, 16, TimeUnit.MILLISECONDS);
    }

    public HorseLanes getHorseLanes() {
        return horseLanes;
    }
}
