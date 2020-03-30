public class test {
    public static void main(String[] args) {

        //Dog dog = new Dog("dog1", "red", 20f, 1f, "dave");
        //Fish fish = new Fish("fish1", "red", 1f, 0.3f);
        SpringerSpaniel springerSpaniel = new SpringerSpaniel("Springer Doggo", "red", 20f, 1f);
        Guppy guppy = new Guppy("Guppy Fisho", "red", 1f, 0.3f);
        Tetra tetra = new Tetra("Tetra Fisho", "red", 1f, 0.3f);
        Boxer boxer = new Boxer("Boxer Doggo", "red", 20f, 1f);

        //System.out.println(dog);
        //System.out.println(fish);
        System.out.println(springerSpaniel);
        System.out.println(guppy);
        System.out.println(tetra);
        System.out.println(boxer);
    }
}