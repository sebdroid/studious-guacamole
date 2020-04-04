//Sebastian Jose
//1923070

import java.util.Random;

public class Boxer extends Dog {
    public final static String breed = "Boxer";

    public Boxer(String name, String colour, float weight, float height){
        super(name, colour, weight, height, breed);
    }

    public void tips(){
        String tips[] = {"Boxers are housedogs however daily exercise remains essential.", "2 - 3 cups of food is recommended to keep your dog healthy.", "Weekly brushing will help keep their hair under control."};
        System.out.println(tips[new Random().nextInt(tips.length)]);
    }

}