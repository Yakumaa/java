package Unit1;
interface  Calc1{
  void Multiplication(int a, int b);
}

interface Calc2 extends Calc1{
  void Division(int a, int b);
}

class Sol implements Calc2{
  @Override
  public void Multiplication(int a, int b){
    System.out.println("Multiplication is " + (a*b));
  }

  @Override
  public void Division(int a, int b){
    System.out.println("Division is " + (a/b));
  }
}

public class InheritanceInterface {
  public static void main(String[] args) {
    Sol s1 = new Sol();
    s1.Multiplication(10, 20);
    s1.Division(20, 10);
  }
}
