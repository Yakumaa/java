class Calculate3 implements Runnable{
  @Override
  public void run(){
    try{
      for(int i=0; i<10; i++){
        System.out.println("this is thread 3: " + i);
        Thread.sleep(1000);
      }
    } catch (InterruptedException e) {
      System.out.println(e);
    }
  }
  
}

public class RunnableDemo {
  public static void main(String[] args) {
    Calculate3 c3 = new Calculate3();
    Thread t1 = new Thread(c3);
    t1.start();
  }
}
