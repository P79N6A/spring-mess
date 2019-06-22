package com.langonggong.learn.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author xufeng.zhang@renren-inc.com on 2016-12-26.
 */
public final class StringUtil extends StringUtils {
  public static final String NA = "N/A";
  private static final String COMMA_SPACE = ", ";
  private static final Log LOGGER = LogFactory.getLog(StringUtil.class);

  private StringUtil() {
  }

  public static boolean isBlank(Object o) {
    return o == null || isBlank(o.toString());
  }

  public static String encode(String s) {
    if (s == null) {
      return s;
    }
    try {
      return URLEncoder.encode(s, "utf-8");
    } catch (UnsupportedEncodingException e) {
      LOGGER.warn("Encode error:" + s, e);
      return s;
    }
  }

  public static boolean isDouble(String s) {
    if (StringUtil.isBlank(s)) {
      return false;
    }
    s = s.trim();
    return !"-".equals(s) && !"+".equals(s) && s.matches("[-+]?[0-9]*\\.?[0-9]*([eE][-+]?[0-9]+)?");
  }

  public static boolean isNotBlankWithNA(final CharSequence cs) {
    if (isBlank(cs)) {
      return false;
    }

    for (int i = 0; i < NA.length(); i++) {
      if (NA.charAt(i) != cs.charAt(i)) {
        return isNotBlank(cs);
      }
    }

    return false;
  }

  public static boolean isBlankWithNA(final CharSequence cs) {
    return !isNotBlankWithNA(cs);
  }

  /**
   * 将字符串中第一个字符转换为大写，其余转换为小写，如：
   * abc -> Abc
   * abc bad -> Abc Bad
   *
   * @param str 需要转换的字符串
   * @return 转换后的字符串
   */
  public static String upperFirst(String str) {
    if (isBlank(str)) {
      return EMPTY;
    }

    boolean transferred = false;
    String strTmp = str.toLowerCase();
    StringBuilder result = new StringBuilder(strTmp.length());
    for (int i = 0; i < strTmp.length(); i++) {
      if (!Character.isLetter(strTmp.charAt(i))) {
        transferred = false;
        result.append(strTmp.charAt(i));
        continue;
      }

      if (!transferred) {
        result.append(Character.toUpperCase(strTmp.charAt(i)));
        transferred = true;
        continue;
      }
      result.append(strTmp.charAt(i));
    }
    return result.toString();
  }

  public static String randomNumeric(int length) {
    return RandomStringUtils.randomNumeric(length);
  }


  public static boolean startsWithLeftBracket(String values) {
    if (isBlank(values)) {
      return false;
    }
    char c = values.trim().charAt(0);
    return c == '[' || c == '{' || c == '(' || c == '<';
  }

  public static String trim(String str, char trimmer) {
    int from = 0, to = str.length();
    for (int i = from; i < to; i++) {
      if (trimmer != str.charAt(i)) {
        break;
      }

      from++;
    }

    for (int j = to; j > from; j--) {
      if (trimmer != str.charAt(j - 1)) {
        break;
      }

      to--;
    }

    return str.substring(from, to);
  }

  public static boolean isEqual(Object obj1, Object obj2) {
    if (obj1 == null) {
      return obj2 == null;
    }
    return obj2 != null && obj1.toString().equals(obj2.toString());
  }

  public static void printObjectExcludeNull(Object o) {
    printObject(o, true);
  }

  public static void printObject(Object o) {
    printObject(o, false);
  }

  private static void printObject(Object o, boolean excludeNull) {
    ObjectMapper mapper = new ObjectMapper();
    if (excludeNull) {
      mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }
    try {
      String s = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
      LOGGER.info("\n\n" + s);
    } catch (JsonProcessingException e) {
      throw new IllegalArgumentException("error while print:" + o, e);
    }
  }

  public static String toString(Throwable e) {
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw, true);
    e.printStackTrace(pw);
    pw.flush();
    sw.flush();
    return sw.toString();
  }

}
