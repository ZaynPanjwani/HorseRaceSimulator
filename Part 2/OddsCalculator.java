import java.util.ArrayList;

public class OddsCalculator {
    public static void calculateOdds(ArrayList<Horse> horses) {
        final double MOST_LIKELY_WINNER = 0.5; // confidence of the most likely winner
        double sum = 0;
        for(Horse horse : horses) {
            double weight = horse.getHorseInfo().getConfidence();
            if(weight > MOST_LIKELY_WINNER) weight = (MOST_LIKELY_WINNER*2)-weight;
            sum += Math.abs(weight);
        }
        for(Horse horse : horses) {
            double weight = horse.getHorseInfo().getConfidence();
            if(weight > MOST_LIKELY_WINNER) weight = (MOST_LIKELY_WINNER*2)-weight;
            horse.setOdds(Math.abs(weight)/sum);
        }
    }
}
