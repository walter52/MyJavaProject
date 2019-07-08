package com.function;

import com.BaseTest;
import com.walter.function.MyFunction;
import com.walter.reflect.People;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;

/**
 * @author super
 * @date 2019/7/5
 */
@Slf4j
public class MyFunctionTest extends BaseTest {

  @Test
  public void computeTest() {
    log.info(MyFunction.compute(2, var -> String.valueOf(var * 2)));
  }

  @Test
  public void computeBiTest() {
    log.info(MyFunction.compute(2, 3, (a, b) -> String.valueOf(a + b)));
  }

  /**
   * 静态方法推导
   */
  @Test
  public void staticMethodRefer() {
    Consumer<String> consumer2 = System.out::println;
    consumer2.accept("aa");

    Function<Integer, String> function1 = String::valueOf;
    log.info(function1.apply(1));

  }

  /**
   * 实例类型推导
   */
  @Test
  public void instanceTypeRefer() {
    //普通
    String var = "hello";
    log.info("" + var.charAt(1));

    //lambda
    BiFunction<String, Integer, Character> biFunction1 = (a, b) -> a.charAt(b);
    log.info("" + biFunction1.apply(var, 1));

    //推导
    BiFunction<String, Integer, Character> biFunction2 = String::charAt;
    log.info("" + biFunction2.apply(var, 1));

    //运用实例
    List<People> peoples = Arrays
        .asList(new People("waler", "12"), new People("jack", "10"), new People("sun", "18"));
    log.info(peoples.toString());

    //常规
//    peoples.sort(new Comparator<People>() {
////      @Override
////      public int compare(People o1, People o2) {
////          return o1.getAge().compareTo(o2.getAge());
////      }
////    });
    //lambda
//    peoples.sort((o1,o2)-> o1.getAge().compareTo(o2.getAge()));
    //方法推导
    peoples.sort(Comparator.comparing(People::getAge));
    log.info(peoples.toString());

  }

  /**
   * 存在的对象实例推导
   */
  @Test
  public void objRefer() {
    //普通
    String var = "hello";
    log.info("" + var.charAt(1));

    //推导
    Function<Integer, Character> function = var::charAt;
    log.info("" + function.apply(1));
  }

  /**
   * 构造函数推导
   */
  @Test
  public void constructorRefer() {
    //无参数
    Supplier<String> s = String::new;
    log.info(s.get().getClass().toString());

    //有参数
    BiFunction<String, String, People> biFunction = People::new;
    People people = biFunction.apply("walter", "18");
    log.info("class:{},name:{},age{}", people.getClass().toString(), people.getName(),
        people.getAge());


  }
}
