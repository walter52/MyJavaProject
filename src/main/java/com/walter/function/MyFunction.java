package com.walter.function;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author super
 * @date 2019/7/5
 */
public class MyFunction {

  public static String compute(int a, Function<Integer,String> function){
    return function.apply(a);
  }

  public static String compute(int a,int b, BiFunction<Integer,Integer,String> biFunction){
    return biFunction.apply(a,b);
  }

}
