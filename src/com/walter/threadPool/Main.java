package com.walter.threadPool;

/**
 * @author super
 * @date 2019/4/29
 */
public class Main {

  public static void main(String[] args) {
    ThreadPoolManager threadPoolManager = ThreadPoolManager.getInstacne();
    for(int i=4;i>0;i--){
      threadPoolManager.execute(() ->
          System.out.println(Thread.currentThread().getName()));
    }
    int a=0;
  }

}
