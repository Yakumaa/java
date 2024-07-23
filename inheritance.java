class Vehicle{
  int reg;
  String name;
  String brand;

  public void setVehicle(int reg, String name, String brand){
    this.reg = reg;
    this.name = name;
    this.brand = brand;
  }

  public void displayVehicle(){
    System.out.println("reg is " + reg);
    System.out.println("name is " + name);
    System.out.println("brand is " + brand);
  }
}

class Bike extends Vehicle{
  int mileage;

  public void setBike(int mileage){
    this.mileage = mileage;
  }

  public void displayBike(){
    System.out.println("mileage is " + mileage);
  }
}

class ElectricBike extends Bike{
  int capacity;
  public void setElectric(int capacity){
    this.capacity = capacity;
  }

  public void displayElectricBike(){
    System.out.println("capacity is " + capacity);
  }
}

public class inheritance{
  public static void main(String[] args){
    Bike b1 = new Bike();

    //accessing parent property
    b1.setVehicle(123, "pulsar", "bajaj");
    b1.displayVehicle();

    //accessing child property
    b1.setBike(50);
    b1.displayBike();

    ElectricBike eb = new ElectricBike();
    //accessing grandparent property
    eb.setVehicle(234, "niu", "miu");
    eb.displayVehicle();

    //accessing parent property
    eb.setBike(60);
    eb.displayBike();

    //accessing own property
    eb.setElectric(300);
    eb.displayElectricBike();
  }
}