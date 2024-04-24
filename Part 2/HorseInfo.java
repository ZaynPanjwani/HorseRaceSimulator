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
