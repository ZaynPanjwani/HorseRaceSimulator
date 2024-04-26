import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class HorseStatus extends JPanel {
    private ArrayList<Horse> horses;
    public HorseStatus() {
        super();
        this.setPreferredSize(new Dimension((int) (this.getWidth()*0.2), (int) (this.getHeight()*0.7)));
        this.setBackground(Color.BLUE);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    public void updateLanes() {
        this.updateLanes(null);
    }

    public void updateLanes(ArrayList<Horse> horses) {
        if(this.horses == null) this.horses = horses;
        this.removeAll();
        OddsCalculator.calculateOdds(this.horses);
        for(Horse horse : this.horses) {
            JPanel horseStatus = new JPanel();
            horseStatus.setLayout(new GridLayout(4, 2));
            horseStatus.add(new JLabel("Name: " + horse.getHorseInfo().getName()));
            horseStatus.add(new JLabel("Confidence: " + horse.getHorseInfo().getConfidence()));
            horseStatus.add(new JLabel(String.format("Odds: %.2f", horse.getOdds())));
            AtomicInteger amountBet = new AtomicInteger();
            JLabel amountBetLabel = new JLabel("Bet: $0");
            horseStatus.add(amountBetLabel);

            JTextField bettingAmount = new JTextField();

            JButton betOnHorse = new JButton("Bet");
            betOnHorse.addActionListener(e -> {
                try {
                    Integer bet = Integer.parseInt(bettingAmount.getText());
                    if(bet <= 0) throw new NumberFormatException();
                    amountBet.addAndGet(bet);
                    horse.setAmountBet(amountBet.get());
                    amountBetLabel.setText(String.format("Bet: $%s", amountBet));
                } catch(NumberFormatException ignored) {
                    System.out.println("exception found, handle it by showing in a dialogue");
                }
            });


            horseStatus.add(bettingAmount);

            horseStatus.add(betOnHorse);

            JButton viewStats = new JButton("View horse stats");

            viewStats.addActionListener(e -> new HorseStats(horse.getHorseInfo()));


            horseStatus.add(viewStats);

            this.add(horseStatus);


        }
        this.repaint();
    }

    public void updateHorse(Horse horse) {
        int idx = this.horses.indexOf(horse);

        JPanel horseStats = (JPanel) this.getComponent(idx);

        ( (JLabel) horseStats.getComponent(1)).setText(String.format("Confidence: %.2f", horse.getHorseInfo().getConfidence())); //confidence
        this.repaint();
    }

    public void updateOdds() {
        OddsCalculator.calculateOdds(horses);
        for(int i = 0; i < horses.size(); i++) {
            JPanel stats = (JPanel) this.getComponent(i);
            JLabel odds = (JLabel) stats.getComponent(2);
            odds.setText(String.format("Odds: %.2f", horses.get(i).getOdds()));
        }
    }
}
