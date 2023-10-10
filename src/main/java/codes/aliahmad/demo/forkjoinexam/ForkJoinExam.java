package codes.aliahmad.demo.forkjoinexam;

import codes.aliahmad.doc.forkjoin.ForkJoinExample;
import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinExam
{

//    Accept in input array of number
//    calculate the n'th prime (where n is value of i in that array arr[i])
//    add all the nth primes

  public static void runForkJoinExample()
  {
    int[] inputNumbers = {23, 35, 46, 500, 1000, 7000, 8212, 9321, 10313};

    ForkJoinExam.CalculatePrimeTask calculatePrimeTask =
            new ForkJoinExam.CalculatePrimeTask(inputNumbers, 0, inputNumbers.length - 1);

    ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

    int result = forkJoinPool.invoke(calculatePrimeTask);

    System.out.println("Result: " + result);

  }

  public static void main(String[] args)
  {
//    Accept in input array of number
//    calculate the n'th prime (where n is value of i in that array arr[i])
//    add all the nth primes

    runForkJoinExample();

  }

  private static class CalculatePrimeTask extends RecursiveTask<Integer>
  {
    private final int[] inputNumbers;
    private final int start;
    private final int end;

    public CalculatePrimeTask(int[] inputNumbers, int start, int end)
    {
      this.inputNumbers = inputNumbers;
      this.start = start;
      this.end = end;
    }

    @Override
    protected Integer compute()
    {
      if (start == end)
      {
        int result = PrimeUtils.calculateNthPrime(inputNumbers[start]);
        System.out.println("Result for " + inputNumbers[start] + " is " + result);
        return result;
      }
//      if (end - start == 1)
//      {
//        int result1 = PrimeUtils.calculateNthPrime(inputNumbers[start]);
//        int result2 = PrimeUtils.calculateNthPrime(inputNumbers[end]);
//
//        System.out.println("Result for " + inputNumbers[start] + " is " + result1);
//        System.out.println("Result for " + inputNumbers[end] + " is " + result2);
//        return result1 + result2;
//      }

      int mid = (start + end) / 2;
      ForkJoinExam.CalculatePrimeTask subTask1 = new ForkJoinExam.CalculatePrimeTask(inputNumbers, start, mid);
      ForkJoinExam.CalculatePrimeTask subTask2 = new ForkJoinExam.CalculatePrimeTask(inputNumbers, mid + 1, end);
      invokeAll(subTask1, subTask2);

      return subTask1.join() + subTask2.join();
    }
  }
}
