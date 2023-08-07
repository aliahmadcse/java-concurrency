package codes.aliahmad.executorandlocks;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter implements Runnable
{
  private int count = 0;
  private final Lock lock = new ReentrantLock();

  @Override
  public void run()
  {
    lock.lock();
    try
    {
      increment();
      System.out.println("Thread " + Thread.currentThread().getName() + " increments: " + count);
      decrement();
      System.out.println("Thread " + Thread.currentThread().getName() + " decrements: " + count);
    }
    finally
    {
      lock.unlock();
    }
  }

  public void increment()
  {
    count++;
  }

  public void decrement()
  {
    count--;
  }

  public int getCount()
  {
    return count;
  }
}

public class UnstructuredLocking
{
  public static void main(String[] args)
  {
//      Structured locking is when your lock is implicitly acquired and released by the language or framework.
//      Unstructured locking is when you explicitly acquire and release the lock.

    Counter counter = new Counter();
    new Thread(counter, "1").start();
    new Thread(counter, "2").start();
    new Thread(counter, "3").start();
    new Thread(counter, "4").start();

    Counter counter2 = new Counter();
    new Thread(counter2, "5").start();

  }

}
