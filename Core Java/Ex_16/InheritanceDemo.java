public class InheritanceDemo {

    // Base class
    static class Animal {
        String name;

        Animal(String name) {
            this.name = name;
        }

        void makeSound() {
            System.out.println(name + " makes a generic sound.");
        }
    }

    // Subclass
    static class Dog extends Animal {

        Dog(String name) {
            super(name);
        }

        // Override makeSound
        @Override
        void makeSound() {
            System.out.println(name + " says: Bark! Bark!");
        }
    }

    // Another subclass
    static class Cat extends Animal {

        Cat(String name) {
            super(name);
        }

        @Override
        void makeSound() {
            System.out.println(name + " says: Meow!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Inheritance Example ===\n");

        Animal animal = new Animal("Animal");
        Dog    dog    = new Dog("Buddy");
        Cat    cat    = new Cat("Whiskers");

        animal.makeSound();
        dog.makeSound();
        cat.makeSound();

        System.out.println("\nDog is an Animal : " + (dog instanceof Animal));
        System.out.println("Cat is an Animal : " + (cat instanceof Animal));
    }
}