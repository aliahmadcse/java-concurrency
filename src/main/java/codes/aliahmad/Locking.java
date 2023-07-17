package codes.aliahmad;


class Counter implements Runnable
{
  private int count = 0;

  @Override
  public void run()
  {
//    monitors -> object based locking
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
