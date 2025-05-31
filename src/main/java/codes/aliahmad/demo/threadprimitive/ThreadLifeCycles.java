package codes.aliahmad.demo.threadprimitive;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadLifeCycles
{
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

      System.out.print("\n I can tell you the nth prime number. Enter n: ");
      int n = sc.nextInt();

      if (n == 0)
      {
        break;
      }

      Runnable r = () -> System.out.println(String.format(
              "\n Value of %dth prime number is %d\n",
              n, PrimeUtils.calculateNthPrime(n)
      ));

      Thread thread = new Thread(r);
      thread.setName(String.format("prime %s", n));

      thread.setDaemon(true);
      thread.start();

      threads.add(thread);
      printThreadState(threads);

    }
  }
}
