package Unit1;
//creating thread by inheriting thread class

class Calculate1 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<10;i++){
            System.out.println("this is thread 1: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Calculate2 extends Thread{
  @Override
  public void run(){
    try {
        for(int i=1; i<10; i++){
          System.out.println("this is thread 2: " + i);
          Thread.sleep(1500);
        }
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
}

public class ThreadClassDemo {
  public static void main(String[] args) {
    Calculate1 c1 = new Calculate1();
    Calculate2 c2 = new Calculate2();
    c1.start();
    c2.start();
  }
}
