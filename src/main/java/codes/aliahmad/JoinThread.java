package codes.aliahmad;


import codes.aliahmad.primeutils.PrimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoinThread
{

  public static void joinThreads(List<Thread> threads)
  {
    threads.forEach((thread -> {
      try
      {
        thread.join();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }));
  }

  public static void main(String[] args)
  {
    List<Thread> threads = new ArrayList<>();

    Thread thread1 = new Thread(new PrimeRunnable());
    thread1.setDaemon(true);
    thread1.start();

    Thread thread2 = new Thread(new PrimeRunnable());
    thread2.setDaemon(true);
    thread2.start();


    threads.add(thread1);
    threads.add(thread2);

//    joinThreads(threads);

//    a sleeping thread would be interrupted by interrupt method
//    but a thread which has joined would not be interrupted
//    interrupt method is a request to interrupt the thread, it is upto the thread to decide whether to interrupt or not
    thread2.interrupt();

    int n = new Scanner(System.in).nextInt();



  }


  private static class PrimeRunnable implements Runnable {

    @Override
    public void run()
    {
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
      System.out.println("10000 prime number is: " + PrimeUtils.calculateNthPrime(10000) + " " + Thread.currentThread().getState());
    }
  }
}
