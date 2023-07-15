package codes.aliahmad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadPrimitive
{
  // integers less than 1 are not handled
  public static boolean isPrime(int n)
  {
    if (n == 2)
    {
      return false;
    }

    for (int i = 2; i < n; i++)
    {
      if (n % i == 0)
      {
        return false;
      }
    }
    return true;
  }


  public static int calculateNthPrime(int n)
  {
    int num = 1;
    int primeCount = 0;

    while (primeCount < n)
    {
      if (isPrime(num))
      {
        primeCount++;
      }
      num++;
    }

    return --num;
  }


  public static void printThreadState(List<Thread> threads)
  {
    threads.forEach((thread -> System.out.printf("Thread %s has state: %s \n", thread.getName(), thread.getState())));
  }

  public static void main(String[] args)
  {
    List<Thread> threads = new ArrayList<>();

    while (true)
    {
      Scanner sc = new Scanner(System.in);

      System.out.println("\n I can tell you the nth prime number. Enter n: ");
      int n = sc.nextInt();
      if (n == 0)
      {
        break;
      }


      Thread thread = new Thread(() -> System.out.printf("Value of %s prime number is: %s \n", n, calculateNthPrime(n)));

      thread.setName(String.format("prime %s", n));

//      Daemon thread ends as the main thread ends, otherwise it is user thread
//      it you spawn a user thread, it won't end with the main thread exit
      thread.setDaemon(true);
      thread.start();

//      thread states
//      new, runnable, blocked, waiting, timed waiting, terminated
//      we call it runnable state and not running, because it is upto OS to run this thread and schedule it
//      time waiting happens when you sleep on the thread
//      waiting is when you wait for joining of threads
//      blocked is a state of deadlock
      threads.add(thread);
      new Thread(() -> printThreadState(threads)).start();
      System.out.println("\n-------------------------------------------------\n");

    }
  }
}








