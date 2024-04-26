public class main {
    public static void main(String[] args)
    {

        Horse h1 = new Horse('#', "h1", 1);
        Horse h2 = new Horse('€', "h2", 0.1);
        Horse h3 = new Horse('£', "h3", 1);


        Race race = new Race(8);
        race.addHorse(h1, 1);
        race.addHorse(h2, 2);
        race.addHorse(h3, 3);

        race.startRace();
    }
}
