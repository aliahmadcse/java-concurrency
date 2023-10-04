package codes.aliahmad.demo.synchronization;

public class ThreadLocalVariable
{
  private static final ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);



  public static void main(String[] args)
  {
    Thread thread1 = new Thread(() -> {
      threadLocalValue.set(42);

      System.out.println("Thread 1: " + threadLocalValue.get());
    });

    Thread thread2 = new Thread(() -> {
      threadLocalValue.set(99);

      System.out.println("Thread 2: " + threadLocalValue.get());
    });


    thread1.start();
    thread2.start();

    // Wait for the threads to finish
    try {
      thread1.join();
      thread2.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Main thread has its own copy of the thread local variable
    System.out.println("Main Thread: " + threadLocalValue.get());
  }
}
