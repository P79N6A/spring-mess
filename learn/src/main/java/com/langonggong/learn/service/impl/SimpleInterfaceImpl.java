package com.langonggong.learn.service.impl;

import com.langonggong.learn.service.SimpleInterface;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 18:06
 **/
public class SimpleInterfaceImpl implements SimpleInterface {
  public String getCityName() {
    return "default city";
  }

  public String getAreaName() {
    return "default area";
  }
}