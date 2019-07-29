package com.optional;

import com.walter.reflect.Company;
import com.walter.reflect.People;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author super
 * @date 2019/7/11
 */
@Slf4j
public class MyOptionalTest {

  @Test
  public void optionalTest() {
    //传统
    String str = "hello";
    if (str != null) {
      log.info("传统:{}", str);
    }

    //普通
    Optional<String> optional1 = Optional.of(str);
    if (optional1.isPresent()) {
      log.info("普通:{}", optional1.get());
    }

    //推荐
    Optional<String> optional2 = Optional.of(str);
    optional2.ifPresent(s -> log.info("推荐:{}", s));

    //默认值
    Optional<String> optional3 = Optional.empty();
    log.info("默认值:{}", optional3.orElseGet(() -> "qq"));
    optional3 = Optional.of(str);
    log.info("默认值:{}", optional3.orElseGet(() -> "qq"));
  }

  @Test
  public void optionalTest2() {
    List<People> peoples = Arrays.asList(new People("walter", "19"), new People("jack", "23"));
    Company company1 = new Company(peoples);
    Company company2 = new Company();
    Optional<Company> companyOpt = Optional.ofNullable(company1);
    System.out.println(companyOpt.map(Company::getPeoples).orElse(Collections.emptyList()));

}

}
