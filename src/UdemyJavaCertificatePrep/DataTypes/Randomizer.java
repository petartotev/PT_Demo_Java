package DataTypes;

import java.util.Random;

public class Randomizer {
    public int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(100);
    }
}