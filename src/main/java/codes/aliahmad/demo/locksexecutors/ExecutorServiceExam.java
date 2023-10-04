package codes.aliahmad.demo.locksexecutors;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExam
{
  public static void main(String[] args)
  {
    ExecutorService executorService = Executors.newFixedThreadPool(3);


    Runnable r = () -> System.out.printf("Value of %s prime number is: %s \n", 100, PrimeUtils.calculateNthPrime(100));

    executorService.execute(r);


    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    Runnable r1 = () -> System.out.println("I am scheduled...");

    scheduledExecutorService.scheduleAtFixedRate(r1, 1L, 2L, TimeUnit.SECONDS);


  }
}
