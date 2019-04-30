package com.threadpool;

import com.BaseTest;
import com.walter.threadpool.ThreadPoolManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author super
 * @date 2019/4/30
 */
@Slf4j
public class ThreadPoolManagerTest extends BaseTest {


  @Test
  public void executeTest(){
      ThreadPoolManager threadPoolManager = ThreadPoolManager.getInstacne();
      for(int i=4;i>0;i--){
        threadPoolManager.execute(() ->
            log.info(Thread.currentThread().getName()));
      }
  }

  @Test
  @SuppressWarnings("unchecked")
  public void submitTest(){
    ThreadPoolManager threadPoolManager = ThreadPoolManager.getInstacne();
    List<String> list = new ArrayList<>();
    try{
      for(int i=4;i>0;i--){
        Future<String> future = threadPoolManager.submit(()->Thread.currentThread().getName());
        String str = future.get();
        list.add(str+":success");
      }
    }catch (Exception e){
      log.error("线程异常",e);
    }

    threadPoolManager.awaitForShutdown();
    list.forEach(log::info);

  }


}
