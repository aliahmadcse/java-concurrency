package codes.aliahmad;

import codes.aliahmad.primeutils.PrimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadPrimitive
{


  public static void printThreadState(List<Thread> threads)
  {
    threads.forEach((thread -> System.out.printf("Thread %s has state: %s \n", thread.getName(), thread.getState())));
  }

  public static void main(String[] args)
  {
    List<Thread> threads = new ArrayList<>();

    //      thread states
//      new, runnable, blocked, waiting, timed waiting, terminated
//      we call it runnable state and not running, because it is upto OS to run this thread and schedule it
//      time waiting happens when you sleep on the thread
//      waiting is when you wait for joining of threads
//      blocked is a state of deadlock
    new Thread(() -> {
      try
      {
        while (true)
        {
          Thread.sleep(5000);
          printThreadState(threads);
        }
      }
      catch (InterruptedException e)
      {
        throw new RuntimeException(e);
      }
    }).start();


    while (true)
    {
      Scanner sc = new Scanner(System.in);

      System.out.println("\n I can tell you the nth prime number. Enter n: ");
      int n = sc.nextInt();
      if (n == 0)
      {
        break;
      }


      Thread thread = new Thread(() -> System.out.printf("Value of %s prime number is: %s \n", n, PrimeUtils.calculateNthPrime(n)));

      thread.setName(String.format("prime %s", n));

//      Daemon thread ends as the main thread ends, otherwise it is user thread
//      it you spawn a user thread, it won't end with the main thread exit
      thread.setDaemon(true);
      thread.start();
      threads.add(thread);

      System.out.println("\n-------------------------------------------------\n");

    }
  }
}








