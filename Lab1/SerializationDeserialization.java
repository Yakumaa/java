package Lab1;

import java.io.*;

// Define a class that implements Serializable
class Student implements Serializable {
    private static final long serialVersionUID = 1L; // Add serialVersionUID for compatibility
    private int id;
    private String name;
    private transient int age; // 'transient' fields are not serialized

    // Constructor
    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // toString method for displaying object data
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + "}";
    }
}

public class SerializationDeserialization {
  public static void main(String[] args) {
        // File where the serialized object will be stored
        String filename = "student.txt";

        // Create a Student object
        Student student = new Student(101, "John Doe", 22);

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            System.out.println("Serializing object: " + student);
            oos.writeObject(student); // Write object to file
            System.out.println("Serialization complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Student deserializedStudent = (Student) ois.readObject(); // Read object from file
            System.out.println("Deserialized object: " + deserializedStudent);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
