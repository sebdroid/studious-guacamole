import java.util.Random;

public class SpringerSpaniel extends Dog {
    public final static String breed = "Springer Spaniel";

    public SpringerSpaniel(String name, Integer age, String colour, float weight, float height){
        super(name, age, colour, weight, height, breed);
    }

    public void tips(){
        String tips[] = {"Springer Spaniels need plenty of daily exercise.", "1.5 - 2 cups of dry food is recommended to keep your dog healthy.", "Brush your Springer at least three times a week to keep them looking their best."};
        System.out.println(tips[new Random().nextInt(tips.length)]);
    }

}