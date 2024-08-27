package Unit1;
interface Calculations1{
  void findSum(int a, int b);
  void findDifference(int a, int b);
}

interface Calculations2{
  void findMultiplication(int a, int b);
}

class Solution implements Calculations1, Calculations2{
  @Override
  public void findSum(int a, int b){
    System.out.println("Sum is " + (a+b));
  }

  @Override
  public void findDifference(int a, int b){
    System.out.println("Difference is " + (a-b));
  }

  @Override
  public void findMultiplication(int a, int b){
    System.out.println("Multiplication is " + (a*b));
  }
}

public class InterfaceDemo{
  public static void main(String[] args) {
      Solution s1 = new Solution();
      s1.findSum(10, 20);
      s1.findDifference(20, 10);
      s1.findMultiplication(10, 20);

      //dynamic method dispatch -> it is a process of assigning subclass's object to refrence variable of parent class . Now the superclass refrence will call subclass version of overridden method
      Calculations1 c1; //reference variable
      Solution s2 = new Solution(); //object of subclass
      c1 = s2; //dynamic method dispatch

      //c1 can call only that method that it has
      c1.findSum(10, 20);
      c1.findDifference(20, 10);
      //c1.findMultiplication(10, 20); //error
    
  }
}