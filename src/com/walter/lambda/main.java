package com.walter.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author super
 * @date 2019/4/23
 */
public class main {

  public static void main(String[] args) {
    List<String> list1 = Arrays.asList("3","2","1");
    System.out.println("");
    list1.forEach(System.out::println);
    List<Integer> list2 = list1.stream()
        .map(Integer::new)
        .collect(Collectors.toList());
    list2.forEach(System.out::println);

//    list1.sort((x,y)->x.compareTo(y));
    list1.sort(Comparator.comparing(e->e));
    list1.forEach(System.out::println);
  }


}
