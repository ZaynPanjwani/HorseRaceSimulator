import java.util.ArrayList;

public class OddsCalculator {
    public static void calculateOdds(ArrayList<Horse> horses) {
        final double MOST_LIKELY_WINNER_CONFIDENCE = 0.5; // confidence of the most likely winner
        double sum = 0;

        for(Horse horse : horses) {
            double weight = horse.getHorseInfo().getConfidence() + horse.getHorseInfo().getWinRate();
            if(horse.getHorseInfo().getConfidence() > MOST_LIKELY_WINNER_CONFIDENCE)
                weight = (MOST_LIKELY_WINNER_CONFIDENCE*2)-horse.getHorseInfo().getConfidence();
            sum += Math.abs(weight);
        }
        for(Horse horse : horses) {
            double weight = horse.getHorseInfo().getConfidence() + horse.getHorseInfo().getWinRate();
            if(horse.getHorseInfo().getConfidence() > MOST_LIKELY_WINNER_CONFIDENCE)
                weight = (MOST_LIKELY_WINNER_CONFIDENCE*2)-horse.getHorseInfo().getConfidence();
            horse.setOdds(Math.abs(weight)/sum);
        }
    }
}
