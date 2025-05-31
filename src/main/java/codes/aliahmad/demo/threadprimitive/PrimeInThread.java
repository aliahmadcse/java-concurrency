package codes.aliahmad.demo.threadprimitive;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.Scanner;

public class PrimeInThread
{
  public static void main(String[] args)
  {
    while (true)
    {
      Scanner sc = new Scanner(System.in);

      System.out.print("\n I can tell you the nth prime number. Enter n: ");
      int n = sc.nextInt();

      if (n == 0)
      {
        break;
      }

      Runnable r = () -> System.out.printf("%n Value of %dth prime number is %d%n",
              n, PrimeUtils.calculateNthPrime(n)
      );

      Thread thread = new Thread(r);
      thread.start();
    }
  }
}
