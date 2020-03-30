public abstract class Pet {
    private String name;
    private Integer age;
    private String colour;
    private float weight;

    public Pet(String name, Integer age, String colour, float weight) {
        this.setName(name);
        this.setAge(age);
        this.setColour(colour);
        this.setWeight(weight);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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