package codes.aliahmad.demo.callablesFuture;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureExam
{
  public static void main(String[] args) throws ExecutionException, InterruptedException
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
              .thenAccept(System.out::println);

    }

//    some async tasks and joining
    CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> PrimeUtils.calculateNthPrime(1000),
            executorService);
    CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(() -> PrimeUtils.calculateNthPrime(5000),
            executorService);
    CompletableFuture<Integer> future3 = CompletableFuture.supplyAsync(() -> PrimeUtils.calculateNthPrime(6000),
            executorService);

    CompletableFuture<Void> futures = CompletableFuture.allOf(future1, future2, future3);

    futures.join();

//    getting the results ...
    future1.get();

    executorService.shutdown();
  }
}
