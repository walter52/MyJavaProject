package com.walter.threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/**
 * @author super
 * @date 2019/4/29
 */
public class ThreadPoolManager<T> {

  private static volatile ThreadPoolManager instance;

  /**
   * 采用手动创建线程池
   */
  private ExecutorService threadPool = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,
      new LinkedBlockingQueue<Runnable>(),
      new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build(), new AbortPolicy());

  private ThreadPoolManager() {
  }

  public static ThreadPoolManager getInstacne() {
    if (instance == null) {
      synchronized (ThreadPoolManager.class) {
        if (instance == null) {
          instance = new ThreadPoolManager();
        }
      }
    }
    return instance;
  }

  /**
   * 开启无返回结果的线程
   *
   * @param r Runnable
   */
  public void execute(Runnable r) {

    threadPool.execute(r);
  }

  /**
   * 开启有返回结果的线程
   *
   * @param c Callable
   * @return 多线程返回结果
   */
  public Future<T> submit(Callable<T> c){
    return threadPool.submit(c);
  }

  /**
   * 等待线程执行结束
   *
   * @param
   * @return
   */
  public void awaitForShutdown(){
    threadPool.shutdown();
    try {
      if (!threadPool.awaitTermination(60, TimeUnit.SECONDS)) {
        threadPool.shutdownNow();
      }
    } catch (InterruptedException ex) {
      threadPool.shutdownNow();
      Thread.currentThread().interrupt();
    }
  }

}
