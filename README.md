## Java Concurrency

Code in the `codes.aliahmad.demo` package is more organized and is ideal to look into.

### Thread

```java
class Main
{
  public static void main(String[] args)
  {
    new Thread(() -> System.out.println("Hello from Thread!"))
            .start();
  }
}
```



