## Java Concurrency

Code in the `codes.aliahmad.demo` package is more organized and is ideal to look into.

### Coverage

- Primitive Thread API
- Thread Operations (Join, Sleep, Interruptions)
- Daemon Threads
- Threads Lifecycle and states
- Locks and Synchronization
- Thread Locals and Volatile Keyword
- Executor Service
- Callables and Future
- Completable Futures
- Semaphores
- Fork Join Framework

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



