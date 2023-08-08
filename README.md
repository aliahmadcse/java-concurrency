## Java Concurrency

### Thread

```java
class Main {
  public static void main(String[] args)
  {
    new Thread(() -> System.out.println("Hello Thread!"))
            .start();
  }
}
```


