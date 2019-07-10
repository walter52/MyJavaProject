package com.walter.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author super
 * @date 2019/7/5
 */
public class MyFunction {

  /**
   * 普通
   */
  public static String compute(int a, Function<Integer, String> function) {
    return function.apply(a);
  }

  public static String compute(int a, int b, BiFunction<Integer, Integer, String> biFunction) {
    return biFunction.apply(a, b);
  }

  /**
   * compose
   */
  public static Integer composeCompute(int a, Function<Integer, Integer> function1,
      Function<Integer, Integer> function2) {
    return function1.compose(function2).apply(a);
  }

}
