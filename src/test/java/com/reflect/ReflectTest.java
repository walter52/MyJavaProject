package com.reflect;

import com.BaseTest;
import com.walter.reflect.People;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import lombok.extern.slf4j.Slf4j;
import org.joor.Reflect;
import org.junit.Test;

/**
 * @author super
 * @date 2019/7/4
 */
@Slf4j
public class ReflectTest extends BaseTest {

  @Test
  public void joorTest() {
    //构建
    //无参数
    People people1 = Reflect.on(People.class).create().get();
    //有参数
    People people2 = Reflect.on(People.class).create("walter", "16").get();
    log.info("构造->people1:{}  people2:{}", people1.toString(), people2.toString());

    //调用方法
    Reflect.on(people1).call("setName","jack").call("setAge","20");
//    String people2Str = Reflect.on(people2).toString();
    String people2Str = Reflect.on(people2).call("toString").get();
    log.info("调用->people1:{}  people2:{}", people1.toString(), people2Str);

    //获取变量
    String name1 = Reflect.on(people1).field("name").get();
    String name2 = Reflect.on(people2).get("name");
    log.info("获取变量->name1:{} name2:{}",name1,name2);

    //设置变量
    String nameVar1 = Reflect.on(people1).set("name","coffee").get("name");
    log.info("获取变量->nameVar1:{}",nameVar1);
  }

  @Test
  @SuppressWarnings("unchecked")
  public void javaTest() throws Exception {
    //构建
//    Class clazz = Class.forName("com.walter.reflect.People");
    Class clazz = People.class;
    //无参数
    People people1 = (People) clazz.newInstance();
    //有参数
    People people2 = (People) clazz.getDeclaredConstructor(String.class, String.class)
        .newInstance("walter", "16");
    log.info("构造->people1:{}  people2:{}", people1.toString(), people2.toString());

    //调用
    Method method11 = people1.getClass().getDeclaredMethod("setName", String.class);
    Method method12 = people1.getClass().getDeclaredMethod("setAge", String.class);
    method11.setAccessible(true);
    method12.setAccessible(true);
    method11.invoke(people1,"jack");
    method12.invoke(people1,"20");

    Method method2 = people2.getClass().getDeclaredMethod("toString");
    String people2Str = (String)method2.invoke(people2);
    log.info("调用->people1:{}  people2:{}", people1.toString(), people2Str);

    //获取变量
    Field field1 = people1.getClass().getDeclaredField("name");
    field1.setAccessible(true);
    String name1 = (String) field1.get(people1);
    log.info("获取变量->name1:{}",name1);

    //设置变量
    Field field2 = people2.getClass().getDeclaredField("name");
    field2.setAccessible(true);
    field2.set(people2,"coffee");
    String nameVar2 = (String) field2.get(people2);
    log.info("获取变量->nameVar2:{}",nameVar2);
  }

}
