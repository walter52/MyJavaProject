package com.walter.reflect;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author super
 * @date 2019/7/4
 */
@Setter
@Getter
public class People {

  private String name;
  private String age;

  public People() {
  }

  public People(String name, String age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return "name:"+name+",age:"+age;
  }
}
