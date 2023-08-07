package codes.aliahmad.executorandlocks;

import codes.aliahmad.primeutils.PrimeUtils;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsExample
{
  public static void main(String[] args)
  {
    ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    Runnable r1 = () -> {
      System.out.println("Running Repeated");
      System.out.println("Active Thread: " + executorService.getActiveCount());
      System.out.println("Threads completed: " + executorService.getCompletedTaskCount());
    };

    scheduledExecutorService.scheduleAtFixedRate(r1, 1, 5, TimeUnit.SECONDS);


    while (true)
    {
      Scanner sc = new Scanner(System.in);

      System.out.println("\n I can tell you the nth prime number. Enter n: ");
      int n = sc.nextInt();
      if (n == 0)
      {
        break;
      }

      Runnable r = () -> System.out.printf("Value of %s prime number is: %s \n", n, PrimeUtils.calculateNthPrime(n));

      executorService.execute(r);
    }
  }

}
