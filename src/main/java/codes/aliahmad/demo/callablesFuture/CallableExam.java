package codes.aliahmad.demo.callablesFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExam
{
  public static void main(String[] args) throws ExecutionException, InterruptedException
  {
    Callable<String> c = () -> {
      System.out.println("Callable is running");
      return "Callable is done";
    };

    try (ExecutorService executorService = Executors.newSingleThreadExecutor())
    {
      Future<String> result = executorService.submit(c);

      String str = result.get();


      System.out.println(str);
    }

  }
}
