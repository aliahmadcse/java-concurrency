package codes.aliahmad;


class Counter implements Runnable
{
  private int count = 0;

  @Override
  public void run()
  {
//    monitors -> object based locking
//    synchronization achieves mutual exclusion also known as mutex -> only one thread can access the member variables at a time
//    synchronization also achieves visibility -> if one thread changes the value of a variable, other threads can see the change
//    synchronization ensures that the changes are flushed to the main memory and not just the cache
//    this is also known as structured locking
    synchronized (this)
    {
      increment();
      System.out.println("Thread " + Thread.currentThread().getName() + " increments: " + count);
      decrement();
      System.out.println("Thread " + Thread.currentThread().getName() + " decrements: " + count);
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

public class Locking
{
  public static void main(String[] args)
  {
    Counter counter = new Counter();
    new Thread(counter, "1").start();
    new Thread(counter, "2").start();
    new Thread(counter, "3").start();
    new Thread(counter, "4").start();
  }
}
