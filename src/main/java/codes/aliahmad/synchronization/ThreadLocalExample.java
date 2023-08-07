package codes.aliahmad.synchronization;

public class ThreadLocalExample
{
  private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

  public static void main(String[] args)
  {
//    give me a thread local example
//    thread local is used to create a variable that is local to a thread
//    each thread has its own copy of the variable
//    this way, each thread can use the variable without worrying about the changes made by other threads
//    thread local is used to create thread safe variables

    threadLocal.set(10);
    System.out.println(threadLocal.get());

    Thread thread = new Thread(() -> {
      threadLocal.set(20);
      System.out.println(threadLocal.get());
    });

    thread.start();

    System.out.println(threadLocal.get());

  }
}
