package threadpool;

import com.walter.threadpool.ThreadPoolManager;
import org.junit.Test;

/**
 * @author super
 * @date 2019/4/30
 */
public class ThreadPoolManagerTest {

  @Test
  public void test(){
      ThreadPoolManager threadPoolManager = ThreadPoolManager.getInstacne();
      for(int i=4;i>0;i--){
        threadPoolManager.execute(() ->
            System.out.println(Thread.currentThread().getName()));
      }
  }

}
