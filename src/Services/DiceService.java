package Services;

import java.util.Random;

public class DiceService {

    public static int roll(){
        return new Random().nextInt(7);
    }
}
