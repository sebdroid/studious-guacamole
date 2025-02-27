//Sebastian Jose
//1923070

import java.util.Random;

public class Tetra extends Fish {
    public final static String species = "Tetra";
    
    public Tetra(String name, String colour, float weight, float length){
        super(name, colour, weight, length, species);
    }

    public void tips(){
        String tips[] = {"The larger the tank, the better.", "Feed Tetra once or twice a day.", "Ensure environmental conditions are stable."};
        System.out.println(tips[new Random().nextInt(tips.length)]);
    }

}