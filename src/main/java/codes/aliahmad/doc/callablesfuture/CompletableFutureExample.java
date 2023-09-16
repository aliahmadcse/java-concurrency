package codes.aliahmad.doc.callablesfuture;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExample
{
  public static void main(String[] args)
  {
    ExecutorService executorService = Executors.newFixedThreadPool(2);

    while (true)
    {
      Scanner sc = new Scanner(System.in);

      System.out.print("\n I can tell you the nth prime number. Enter n: ");
      int n = sc.nextInt();
      if (n == 0)
      {
        break;
      }


      CompletableFuture.supplyAsync(() -> PrimeUtils.calculateNthPrime(n), executorService)
              .thenAccept(primeNumber -> System.out.println(primeNumber));


    }


  }
}
