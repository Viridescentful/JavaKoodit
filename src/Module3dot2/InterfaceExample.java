package Module3dot2;

interface Animal {
    void eat();
    void sleep();
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("Dog is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping.");
    }
}

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("Cat is eating.");
    }

    @Override
    public void sleep() {
        System.out.println("Cat is sleeping.");
    }
}

public class InterfaceExample {
    private static void feedAnimal(Animal animal) {
        animal.eat();
        animal.sleep();
    }

    public static void main(String[] args) {
        // Create instances of Dog and Cat
        Animal dog = new Dog();
        dog.eat();   // Output: Dog is eating.
        dog.sleep(); // Output: Dog is sleeping.

        Animal cat = new Cat();
        cat.eat();   // Output: Cat is eating.
        cat.sleep(); // Output: Cat is sleeping.

        // Using the feedAnimal method (polymorphism)
        feedAnimal(new Dog()); // Output: Dog is eating. Dog is sleeping.
        feedAnimal(new Cat()); // Output: Cat is eating. Cat is sleeping.
    }
}