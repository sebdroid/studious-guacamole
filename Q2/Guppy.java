//Sebastian Jose
//1923070

import java.util.Random;

public class Guppy extends Fish {
    public final static String species = "Guppy";
    
    public Guppy(String name, String colour, float weight, float length){
        super(name, colour, weight, length, species);
    }

    public void tips(){
        String tips[] = {"Guppies are schooling fish so make sure they have company.", "Feed guppies 2-4 times a day.", "Guppies need darkness to be able to rest."};
        System.out.println(tips[new Random().nextInt(tips.length)]);
    }

}