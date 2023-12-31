package codes.aliahmad.demo.locksexecutors;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnstructuredLock
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    new Thread(counter, "1").start();
    new Thread(counter, "2").start();
    new Thread(counter, "3").start();
    new Thread(counter, "4").start();
  }

  private static class Counter implements Runnable
  {
    private final Lock lock = new ReentrantLock();
    private int count = 0;

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
  }
}
