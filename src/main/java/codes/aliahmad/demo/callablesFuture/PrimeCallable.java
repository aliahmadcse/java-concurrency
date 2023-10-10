package codes.aliahmad.demo.callablesFuture;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeCallable
{
  public static void main(String[] args) throws ExecutionException, InterruptedException
  {
    List<Future<Integer>> futures = new ArrayList<>();

    ExecutorService executorService = Executors.newCachedThreadPool();

    while (true)
    {
      Scanner s = new Scanner(System.in);
      System.out.println("I can tell you the next prime number. Enter a number: ");
      int n = s.nextInt();

      if (n == 0)
      {
        break;
      }

      Callable<Integer> c = () -> PrimeUtils.calculateNthPrime(n);
      Future<Integer> result = executorService.submit(c);
      futures.add(result);

      for (Future<Integer> future : futures)
      {
        if (future.isDone())
        {
          System.out.println(future.get());
          futures.remove(future);
        }
      }

    }
  }
}
