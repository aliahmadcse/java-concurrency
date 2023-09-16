package codes.aliahmad.demo.threadprimitive;

import codes.aliahmad.doc.primeutils.PrimeUtils;

import java.util.Scanner;

public class PrimeCal
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

      int number = PrimeUtils.calculateNthPrime(n);
      System.out.printf("Value of %s prime number is: %s \n", n, number);
    }
  }
}
