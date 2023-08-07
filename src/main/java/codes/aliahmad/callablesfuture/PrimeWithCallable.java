package codes.aliahmad.callablesfuture;

import codes.aliahmad.primeutils.PrimeUtils;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class PrimeWithCallable
{
  public static void main(String[] args) throws ExecutionException, InterruptedException
  {

    ExecutorService executorService = Executors.newCachedThreadPool();

    List<Future<Integer>> futures = new ArrayList<>();

    while (true)
    {
      Scanner sc = new Scanner(System.in);

      System.out.print("\n I can tell you the nth prime number. Enter n: ");
      int n = sc.nextInt();
      if (n == 0)
      {
        break;
      }

      Callable<Integer> callable = () -> {
        System.out.println("\ncalculating prime number for " + n);
        return PrimeUtils.calculateNthPrime(n);
      };

      Future<Integer> primeNumberFuture = executorService.submit(callable);
      futures.add(primeNumberFuture);

      Iterator<Future<Integer>> iterator = futures.iterator();

      while (iterator.hasNext())
      {
        Future<Integer> f = iterator.next();
        if (f.isDone())
        {
          System.out.println(f.get());
          iterator.remove();
        }
      }

    }

    executorService.close();

  }
}
