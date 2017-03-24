package com.walter.run;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Set;

public class AboutCharset {
  private Charset cset;

  public AboutCharset() {
    cset = Charset.forName("utf-8");
  }

  public AboutCharset(String charsetString) {
    cset = Charset.forName(charsetString);
  }

  // 查看字符集的别名
  public void showCharset() {
    Set<String> aliases = cset.aliases();
    for (String aliase : aliases) {
      System.out.println(aliase);
    }
  }

  // 编码字符串
  public byte[] enCodeString(String str) {
    ByteBuffer byteBuff = cset.encode(str);
    byte[] bytes = byteBuff.array();
    return bytes;
  }
}
