public abstract class Dog extends Pet {
    public final static String animal = "Dog";
    private float height;
    private String breed;

    public Dog(String name, Integer age, String colour, float weight, float height, String breed) {
        super(name, age, colour, weight);
        this.setHeight(height);
        this.setBreed(breed);
    }

    public String getBreed() {
        return breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    @Override
    public void animalSound() {
        System.out.println("woof!");
    }

    @Override
    public String toString() { 
        return super.getName() + "\nBreed: " + this.getBreed() + "\nColour: " + super.getColour() + "\nWeight: " + super.getWeight() + "\nHeight: " + this.getHeight();
    }
}