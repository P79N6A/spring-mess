package com.langonggong.learn.study.jvm.jdkProxy;

import com.langonggong.learn.util.Log4jUtil;

import org.slf4j.Logger;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年12月24 17:23
 **/
public class BServiceImpl implements Service {

  private final Logger logger = Log4jUtil.getLogger(Log4jUtil.LOG_TEST_FILE,
      BServiceImpl.class);

  @Override
  public void add() {
    logger.debug("BService add");
  }

  @Override
  public void update() {
    logger.debug("BService update");
  }
}