package codes.aliahmad;

public class Main
{
  // integers less than 1 are not handled
  public static boolean isPrime(int n)
  {
    if (n == 2) return false;

    for (int i = 2; i < n; i++)
    {
      if (n % i == 0)
      {
        return false;
      }
    }
    return true;
  }


  public static int calculateNthPrime(int n)
  {
    int num = 1;
    int primeCount = 0;

    while (primeCount < n)
    {
      if (isPrime(num))
      {
        primeCount++;
      }
      num++;
    }

    return --num;
  }

  public static void main(String[] args)
  {
    System.out.println(calculateNthPrime(46));
  }
}
