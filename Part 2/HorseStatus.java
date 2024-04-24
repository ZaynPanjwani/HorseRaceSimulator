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
    public void updateLanes(ArrayList<Horse> horses) {
        if(this.horses == null) this.horses = horses;
        this.removeAll();
        for(Horse horse : this.horses) {
            JPanel horseStatus = new JPanel();
            horseStatus.setLayout(new GridLayout(3, 2));
            horseStatus.add(new JLabel("Name: " + horse.getName()));
            horseStatus.add(new JLabel("Confidence: " + horse.getConfidence()));
            horseStatus.add(new JLabel("Odds: 0.1"));
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
                    amountBetLabel.setText(String.format("Bet: $%s", amountBet));
                } catch(NumberFormatException ignored) {
                    System.out.println("exception found, handle it by showing in a dialogue");
                }
            });


            horseStatus.add(bettingAmount);

            horseStatus.add(betOnHorse);

            this.add(horseStatus);
        }
    }
}
