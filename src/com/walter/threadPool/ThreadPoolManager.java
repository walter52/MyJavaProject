package com.walter.threadPool;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author super
 * @date 2019/4/29
 */
 class ThreadPoolManager<T> {

  private static volatile  ThreadPoolManager instance;

  private ExecutorService threadPool = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.MILLISECONDS,
      new LinkedBlockingQueue<Runnable>());

  private ThreadPoolManager() {
  }

 static ThreadPoolManager getInstacne(){
    if (instance == null){
      synchronized (ThreadPoolManager.class){
        if (instance == null){
          instance = new ThreadPoolManager();
        }
      }
    }
    return instance;
 }

 void execute(Runnable r){

    threadPool.submit(r);
 }





}
