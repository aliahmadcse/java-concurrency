package codes.aliahmad.doc.synchronization;

public class MutualExclusionProblems
{

//    Synchronization block or mutual exclusion block issue:
//    Performance issue - choose the right lock or the right portion of code to lock
//    synchronize the bare minimum possible
//    extreme synchronization makes code non-concurrent
//
//    Thing which can effect the liveness of a program
//    1. Deadlock - circular dependency, thread A is waiting for thread B to release a lock and thread B is waiting for thread A to release a lock
//    2. Livelock - thread 1 tries to acquire a lock A, thread 2 tries to acquire a lock B, and they get it, and now they are waiting to acquire each other's lock
//       as they don't get each other locks, they release their own acquired locks, and tries the same again and keep doing it and this is a deadlock situation
//    3. Starvation - thread is ready to run but is never given a chance to run - it is never scheduled by the OS


  public static void main(String[] args)
  {
//  an example of deadlock
    Object lock1 = new Object();
    Object lock2 = new Object();

    new Thread(() -> {
      synchronized (lock1)
      {
        synchronized (lock2)
        {
          System.out.println("Thread 1 has lock 2");
        }
      }
    }).start();

    new Thread(() -> {
      synchronized (lock2)
      {
        synchronized (lock1)
        {
          System.out.println("Thread 2 has lock 1");
        }
      }
    }).start();

//    an example of livelock


  }


}
