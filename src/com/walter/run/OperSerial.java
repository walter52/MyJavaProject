package com.walter.run;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class OperSerial {

  // 写入对象到文件
  public void toSerial(String str) {

    try {
      ObjectOutputStream ooStream = new ObjectOutputStream(new FileOutputStream(str));

      Employee e1 = new Employee("walter", 1000);
      Employee e2 = new Employee("wuyonggang", 2000);
      ooStream.writeObject(e1);
      ooStream.writeObject(e2);

    } catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }

  // 从文件读取对象

}
