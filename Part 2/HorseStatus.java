import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
            horseStatus.add(new JLabel(String.format("Confidence: %.2f", horse.getHorseInfo().getConfidence())));
            horseStatus.add(new JLabel(String.format("Odds: %.2f", horse.getOdds())));
            AtomicInteger amountBet = new AtomicInteger();
            horseStatus.putClientProperty("bet", amountBet);
            JLabel amountBetLabel = new JLabel("Bet: $0");
            horseStatus.add(amountBetLabel);

            JTextField bettingAmount = new JTextField();

            JButton betOnHorse = new JButton("Bet");


            JLabel message = new JLabel();

            betOnHorse.addActionListener(e -> {
                try {
                    Integer bet = Integer.parseInt(bettingAmount.getText());
                    if(bet <= 0 || bet > Main.getRaceUI().getGameState().balance) throw new InputMismatchException();
                    amountBet.getAndAdd(bet);
                    horse.setAmountBet(amountBet.get());
                    amountBetLabel.setText(String.format("Bet: $%s", amountBet));
                    bettingAmount.setText("");
                    Main.getRaceUI().getGameState().balance-= bet;
                    Main.getRaceUI().updateBalance();

                } catch(InputMismatchException | NumberFormatException ignored) {

                    if(ignored instanceof InputMismatchException) {
                        message.setText("<html>Amount entered negative or more than what you have!</html>");
                    } else {
                        message.setText("Invalid input!");
                    }
                }
            });
            horseStatus.add(bettingAmount);

            horseStatus.add(betOnHorse);

            horseStatus.add(message);

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
        ((AtomicInteger) horseStats.getClientProperty("bet")).set(0);
        ( (JLabel) horseStats.getComponent(3)).setText(String.format("Bet: $%s", horse.getAmountBet())); //Amount bet
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
