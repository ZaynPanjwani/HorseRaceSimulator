import java.util.Random;
import java.util.random.*;

public class HorseInfo {
    private String name;
    private double confidence;
    private String breed;
    private int numOfWins;
    private int numOfLoss;
    private int totalDistanceTravelled;

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
        this.confidence = confidence;
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
        return totalDistanceTravelled;
    }

    public void setTotalDistanceTravelled(int totalDistanceTravelled) {
        this.totalDistanceTravelled = totalDistanceTravelled;
    }
}
