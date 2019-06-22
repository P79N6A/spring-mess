package com.langonggong.learn.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年10月09 17:00
 **/
@Component()
public class EnvironmentAwareTest implements EnvironmentAware {

  Environment environment = null;

  @Override
  public void setEnvironment(Environment environment) {
    this.environment = environment;
    System.out.println(1);
  }
}