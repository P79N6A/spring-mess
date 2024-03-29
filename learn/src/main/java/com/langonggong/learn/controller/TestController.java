package com.langonggong.learn.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langonggong.learn.config.EnvironmentAwareTest;
import com.langonggong.learn.pojo.User;
import com.langonggong.learn.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年07月22 17:22
 **/
@Controller
public class TestController {

  @Autowired
  UserService userService;

  @Autowired
  EnvironmentAwareTest environmentAwareTest;

  //添加一个日志器
  private static final Logger logger = LoggerFactory.getLogger(TestController.class);

  //映射一个action
  @RequestMapping("/index")
  public String index() {
    //输出日志文件
    logger.info("the first jsp pages");
    return "view";
  }

  @RequestMapping(value = "json", method = RequestMethod.GET)
  @ResponseBody
  public String getString() {
    return "hello spring mvc";
  }

  @RequestMapping(value = "select", method = RequestMethod.GET)
  @ResponseBody
  public String selectByPrimaryKey(@RequestParam("id") int id) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(userService.selectByPrimaryKey(id));
  }

  @RequestMapping(value = "insert", method = RequestMethod.GET)
  @ResponseBody
  public String insertSelective(@RequestParam("id") int id, @RequestParam("name") String name) {
    User user = new User(id + "", name);
    userService.insertSelective(user);
    return "success!";
  }

  @RequestMapping(value = "delete", method = RequestMethod.GET)
  @ResponseBody
  public String deleteByPrimaryKey(@RequestParam("id") int id) {
    userService.deleteByPrimaryKey(id);
    return "success!";
  }
}