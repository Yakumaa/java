public class ExceptionHandling {
  public static void main(String[] args) {
    try {
      int a = 10;
      int b = 0;
      int c = a/b;
      System.out.println("Division is " + c);
    } catch (ArithmeticException e) {
      System.out.println("Division by zero is not allowed");
    } catch (Exception e) {
      System.out.println("Some other exception");
    } finally {
      System.out.println("This is finally block");
    }
  }
}
