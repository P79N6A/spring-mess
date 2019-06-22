package com.langonggong.learn.service.impl;

import com.langonggong.learn.service.DemoService;
import org.springframework.stereotype.Service;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年08月30 18:27
 **/
@Service
public class DemoServiceImpl implements DemoService {
  public String getName(String name) {
    return "hello " + name;
  }
}