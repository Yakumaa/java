package Unit1;
//multithreading is a mechanism by which one program can do mulitple work at a same time. 
//in java multithreading can be acheive using two ways:
//1. by implementing runnable interface
//2. by extending (inheriting) thread calls 
// one thread is always runnign when program is created . this thread is knwn as main thread
//to execute thread run() method is used

public class ThreadDemo {
  public static void main(String[] args){
    //main thread
    //extracting current thread
    Thread t1 = Thread.currentThread();
    t1.setName("CSIT thread");
    System.out.println("name of thread is" + t1.getName());
    System.out.println("priority is" + t1.getPriority());
    t1.getPriority();
    t1.setPriority(2);
    System.out.println("New priority is " + t1.getPriority());
    System.out.println("state is " + t1.getState());

    //suspending thread
    //displaying data 10 time by suspending half sec
    try {
      for (int i = 0; i < 10; i++) {
        System.out.println("this is main thread");
        Thread.sleep(500);  //halfsecond
    }
    } catch (InterruptedException e) {
      System.out.println(e);
    } 
    
  }
}