package codes.aliahmad.doc.semaphors;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class SemaphorsExample
{
  public static void main(String[] args)
  {
//    Semaphores lets you control the number of threads that can access a resource (block of code) at a time
//    used for managing limited resources in a concurrent environment - like you want a certain number of threads
//    to utilize a resource concurrently - for example you want to limit the number of connections to a database or
//    limit the number of threads that can access a file


//    on the other hand, locks only allow one thread to access a resource
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
