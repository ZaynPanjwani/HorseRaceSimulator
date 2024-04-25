import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.random.*;

public class HorseInfo {
    private String name;
    private double confidence;
    private String breed;
    private int numOfWins;
    private int numOfLoss;
    private int totalDistanceTravelled;

    private int ticksSurvived;

    public double getAverageSpeed() {
        return ((double) this.getTotalDistanceTravelled())/((double) this.getTicksSurvived());
    }

    public int getTicksSurvived() {
        return Math.max(1, this.ticksSurvived);
    }

    public void setTicksSurvived(int ticksSurvived) {
        this.ticksSurvived = ticksSurvived;
    }


    public HorseInfo(String name, double confidence, String breed) {
        this.name = name;
        this.confidence = confidence;
        this.breed = breed;
    }

    public static HorseInfo generateRandom() {
        Random random = new Random();
        String[] firstNames = {"Thunder",  "Shadow", "Spirit", "Midnight", "Whisper", "Starlight", "Storm", "Blaze", "Dusty", "Sunny"};

        String[] lastNames = {"Meadow", "River", "Glen", "Valley", "Hill", "Ridge", "Prairie", "Mist", "Breeze", "Forest"};

        String name = String.format("%s %s", firstNames[random.nextInt(firstNames.length)], lastNames[random.nextInt(lastNames.length)]);
        double confidence = (double) Math.round(random.nextDouble() * 100) /100;

        String[] breeds = {"Mustang", "Haflinger", "Welsh Pony", "Tennessee Walking Horse", "Irish Draught", "Akhal-Teke", "Percheron", "Miniature Horse", "Gypsy Vanner", "Hanoverian"};

        String breed = breeds[random.nextInt(breeds.length)];

        return new HorseInfo(name, confidence, breed);
    }

    public String getName() {
        return this.name;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = Math.min(1, Math.max(0.1, confidence));
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public int getNumOfWins() {
        return numOfWins;
    }

    public void setNumOfWins(int numOfWins) {
        this.numOfWins = numOfWins;
    }

    public int getNumOfLoss() {
        return numOfLoss;
    }

    public void setNumOfLoss(int numOfLoss) {
        this.numOfLoss = numOfLoss;
    }

    public int getTotalDistanceTravelled() {
        return Math.max(totalDistanceTravelled, 1);
    }

    public void setTotalDistanceTravelled(int totalDistanceTravelled) {
        this.totalDistanceTravelled = totalDistanceTravelled;
    }

    public double calculateOdds(ArrayList<Horse> otherHorses) {
        double probabilityOfFalling = this.getConfidence();
        double ownScore = this.getAverageSpeed()/probabilityOfFalling;
        double sum = ownScore;
        for(Horse horse : otherHorses) {
            if(horse.getHorseInfo().getName().equals(this.getName())) continue;
            sum+=(horse.getHorseInfo().getAverageSpeed()/probabilityOfFalling);
        }
        System.out.printf("Probability: %s%nScore: %s%nSum: %s%nAverage speed: %s%n", probabilityOfFalling, ownScore, sum, this.getAverageSpeed());
        return ((double) Math.round((ownScore / sum) * 100) )/100;
    }
}
