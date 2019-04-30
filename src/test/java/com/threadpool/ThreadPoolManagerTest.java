package com.threadpool;

import com.BaseTest;
import com.walter.threadpool.ThreadPoolManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author super
 * @date 2019/4/30
 */
@Slf4j
public class ThreadPoolManagerTest extends BaseTest {


  @Test
  public void test(){
      ThreadPoolManager threadPoolManager = ThreadPoolManager.getInstacne();
      for(int i=4;i>0;i--){
        threadPoolManager.execute(() ->
            log.info(Thread.currentThread().getName()));
      }
  }

}
