package Unit1;

// Abstract class
abstract class Animal {
  // Abstract method (no body)
  public abstract void sound();

  // Concrete method (with body)
  public void eat() {
      System.out.println("This animal eats food.");
  }
}

// Subclass inheriting the abstract class
class Dog extends Animal {
  // Providing implementation for the abstract method
  @Override
  public void sound() {
      System.out.println("Dog barks.");
  }
}

// Subclass inheriting the abstract class
class Cat extends Animal {
  // Providing implementation for the abstract method
  @Override
  public void sound() {
      System.out.println("Cat meows.");
  }
}

// Main class
public class AbstractClassExample {
  public static void main(String[] args) {
      // Using polymorphism to refer to subclass objects
      Animal myDog = new Dog();
      Animal myCat = new Cat();

      // Calling methods
      myDog.sound(); // Calls Dog's implementation
      myDog.eat();   // Calls inherited concrete method

      myCat.sound(); // Calls Cat's implementation
      myCat.eat();   // Calls inherited concrete method

      // Animal myAnimal = new Animal(); // Compilation error: Cannot instantiate abstract class
      // myAnimal.sound();
  }
}
