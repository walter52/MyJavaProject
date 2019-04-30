package com.walter.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author super
 * @date 2019/4/29
 */
 public class ThreadPoolManager<T> {

  private static volatile  ThreadPoolManager instance;

  private ExecutorService threadPool = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,
      new LinkedBlockingQueue<Runnable>());

  private ThreadPoolManager() {
  }

 public static ThreadPoolManager getInstacne(){
    if (instance == null){
      synchronized (ThreadPoolManager.class){
        if (instance == null){
          instance = new ThreadPoolManager();
        }
      }
    }
    return instance;
 }

 public void execute(Runnable r){

    threadPool.submit(r);
 }




}
