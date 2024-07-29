//serialization is a process of writing objet to a file. for tihs objectOutputStream is used 
//process of reading object from file ins deserialization . for this ObjectInputStream is used
//steps:
//1. create a file and open it in write mode using byte stream
//2. creat object of ObjectOutputStream and pass object of  fileoutput stream as a parameter and call writeObject() method
//3. close the stream
//for serialization a calss whose object is to be write should implement serializable interface

import java.io.*;

class Rectangle implements Serializable{
  private int length;
  private int breadth;
  public void setRectangle(int length, int breadth){
    this.length = length;
    this.breadth = breadth;
  }

  public void calcAreaa(){
    int area = this.length*this.breadth;
    System.out.println("area is " + area);
  }
}

public class SerializableDemo{
  public static void main(String[] args) {
      try {
          File f1 = new File("obj.txt");
          f1.createNewFile();
          System.out.println("--Writing to file--");
          //open file for write
          FileOutputStream fos = new FileOutputStream(f1);
          //creating object of class
          Rectangle r1 = new Rectangle();
          r1.setRectangle(100, 200);
          //to write object
          ObjectOutputStream oos = new ObjectOutputStream(fos);
          oos.writeObject(r1);
          System.out.println("object written into file");
          System.out.println("--reading object from file");
          //open file in read mode
          FileInputStream fis = new FileInputStream(f1);
          //to read object
          ObjectInputStream ois = new ObjectInputStream(fis);

          Rectangle r2 = (Rectangle)ois.readObject();
          r2.calcAreaa();
          //setting properties of r2
          r2.setRectangle(300, 200);
          r2.calcAreaa();
      } catch (IOException e) {
        System.out.println(e);
      } catch(ClassNotFoundException c) {
        System.out.println(c);
      }
  }
}