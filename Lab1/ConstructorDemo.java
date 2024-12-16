package Lab1;

// Superclass
class Animal {
  String name;

  // Constructor of superclass
  public Animal(String name) {
      this.name = name;
      System.out.println("Animal constructor called: " + name);
  }
}

// Subclass
class Dog extends Animal {
  String breed;

  // Constructor of subclass
  public Dog(String name, String breed) {
      super(name); // Calling the superclass constructor
      this.breed = breed;
      System.out.println("Dog constructor called: Breed is " + breed);
  }
}

// Main class to test
public class ConstructorDemo {
  public static void main(String[] args) {
      Dog dog = new Dog("Buddy", "Golden Retriever");
  }
}
