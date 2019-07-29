package com.walter.reflect;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * @author super
 * @date 2019/7/11
 */
@Setter
@Getter
public class Company {

  private List<People> peoples;

  public Company() {
  }

  public Company(List<People> peoples) {
    this.peoples = peoples;
  }
}
