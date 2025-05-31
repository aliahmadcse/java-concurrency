package codes.aliahmad.demo.threadprimitive;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoiningThreads
{
  public static void waitForThreads(List<Thread> threads) throws InterruptedException
  {
    for (Thread thread : threads)
    {
      thread.join();
    }
  }

  public static void main(String[] args)
  {
    List<Thread> threads = new ArrayList<>();

    while (true)
    {
      Scanner sc = new Scanner(System.in);

      System.out.print("\n I can tell you the nth prime number. Enter n: ");
      int n = sc.nextInt();

      if (n == 0)
      {
        System.out.println("Waiting for all threads to finish...");
        try
        {
          waitForThreads(threads);
          System.out.printf("Done! %d primes calculated%n", threads.size());
        }
        catch (InterruptedException e)
        {
          System.out.println("Interrupted while waiting for threads to finish");
        }

        break;
      }

      Runnable r = () -> System.out.printf("%n Value of  %dth prime number is %d%n", n ,PrimeUtils.calculateNthPrime(n));

      Thread thread = new Thread(r);
      thread.setName(String.format("prime %s", n));

      thread.setDaemon(true);
      thread.start();

      threads.add(thread);

    }
  }
}
