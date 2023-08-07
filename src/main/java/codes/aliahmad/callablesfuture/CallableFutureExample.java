package codes.aliahmad.callablesfuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample
{
  public static void main(String[] args) throws ExecutionException, InterruptedException
  {
//    callable can return a value but runnable cannot
    Callable<String> c = new Callable<String>()
    {
      @Override
      public String call() throws Exception
      {
        System.out.println("printing from callable");
        Thread.sleep(2000);
        return "Hello World";
      }
    };

    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Future<String> future = executorService.submit(c);


    System.out.println("printing from main thread");

//    get method waits for the callable to finish and future is the result of callable
    String result = future.get();
    System.out.println(result);

  }
}
