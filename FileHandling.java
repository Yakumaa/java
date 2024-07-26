//in java file is created by creating object of file class. it is inside java package java.io
//data are passed to and from file using stream
//stream is condier sequence of byte
//1. Byte Stream: data is read and written in form of byte
//a. FileOutputStream: tp write to file using byte stream
//b. FIleInputStream: to read file using bytestream

//2. Character Stream: data is read and written in form of character ie. unicode
//a. FileWriter: to write to file using character stream
//b. FileReader: to read from file using character stream

import java.io.*;
public class FileHandling {
  public static void main(String[] args) {
    try {
      File f1 = new File("csit.txt");
      if(!f1.exists()){
        f1.createNewFile();
      }
      else{
        System.out.println("file already exists");
      }

      System.out.println("does file exist" + f1.exists());
      System.out.println("path of file is " + f1.getPath());
      System.out.println("absolute path of file is " + f1.getAbsolutePath());
      System.out.println("File size is " + f1.getFreeSpace());
      System.out.println("is f1 directory " + f1.isDirectory());
      System.out.println("---reading and writing to " + "file using byte stream---");
      
      //write to file
      FileOutputStream fos = new FileOutputStream(f1);
      String str = "Hello World";
      //change into byte
      byte []data = str.getBytes();
      fos.write(data);
      fos.close();
      
      //reading from file using byte stream
      FileInputStream fis = new FileInputStream(f1);
      int i = 0;
      while ((i=fis.read()) != -1){
        System.out.print((char)i);
      }

    } catch (IOException e) {
      System.out.println(e);
    }
      
  }
}
