public abstract class Fish extends Pet {
    public final static String animal = "Fish";
    private float length;
    private String species;

    public Fish(String name, Integer age, String colour, float weight, float length, String species) {
        super(name, age, colour, weight);
        this.setLength(length);
        this.setSpecies(species);
    }

    public String getSpecies() {
        return species;
    }

    private void setSpecies(String species) {
        this.species = species;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public void animalSound() {
        System.out.println("blub!");
    }

    @Override
    public String toString() { 
        return super.getName() + "\nSpecies: " + this.getSpecies() + "\nColour: " + super.getColour() + "\nWeight: " + super.getWeight() + "\nLength: " + this.getLength();
    }

    public abstract void tips();
}