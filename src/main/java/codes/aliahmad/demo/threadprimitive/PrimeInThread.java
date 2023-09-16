package codes.aliahmad.demo.threadprimitive;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.Scanner;

import static java.lang.StringTemplate.STR;

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

      Runnable r = () -> System.out.println(STR."\n Value of \{n}th prime number is \{PrimeUtils.calculateNthPrime(n)}\n");

      Thread thread = new Thread(r);
      thread.start();

    }
  }
}
