package codes.aliahmad.demo.semaphors;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class SemaphorExam
{
  public static void main(String[] args)
  {
    Semaphore semaphore = new Semaphore(3);

    while (true)
    {
      Scanner sc = new Scanner(System.in);

      System.out.println("\n I can tell you the nth prime number. Enter n: ");
      int n = sc.nextInt();
      if (n == 0)
      {
        break;
      }


      Thread thread = new Thread(() -> {
        try
        {
          semaphore.acquire();
          System.out.println("Now calculating for " + n);
          System.out.printf("Value of %s prime number is: %s \n", n, PrimeUtils.calculateNthPrime(n));
        }
        catch (InterruptedException e)
        {
          throw new RuntimeException(e);
        }
        finally
        {
          semaphore.release();
        }
      });

      thread.setName(String.format("prime %s", n));


      thread.start();
    }
  }
}
