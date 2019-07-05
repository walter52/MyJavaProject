package com.function;

import com.BaseTest;
import com.walter.function.MyFunction;
import java.util.function.Function;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author super
 * @date 2019/7/5
 */
@Slf4j
public class MyFunctionTest extends BaseTest {

  @Test
  public void computeTest(){
    log.info(MyFunction.compute(2,var->String.valueOf(var*2)));
  }

  @Test
  public void computeBiTest(){
    log.info(MyFunction.compute(2,3,(a,b)->String.valueOf(a+b)));
  }
}
