//Sebastian Jose
//1923070

public abstract class Pet {
    private String name;
    private String colour;
    private float weight;

    public Pet(String name, String colour, float weight) {
        this.setName(name);
        this.setColour(colour);
        this.setWeight(weight);
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public abstract void animalSound();
}