package com.langonggong.learn.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.langonggong.learn.domain.Employees;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2018年02月18 16:06
 **/
@Controller
@RequestMapping(value = "post-test")
public class PostTestController {

  @RequestMapping("")
  public String page() {
    return "post-test";
  }

  @RequestMapping(value = "jsonValue", method = RequestMethod.POST)
  @ResponseBody
  public String jsonValue(
      @RequestParam("empNo") long empNo,
      @RequestParam("firstName") String firstName,
      @RequestParam("lastName") String lastName,
      Employees employees) throws Exception {
    Map<String, Object> result = new HashMap<String, Object>();
    result.put("empNo", empNo);
    result.put("firstName", firstName);
    result.put("lastName", lastName);
    result.put("employees", employees);

    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(result);
//    return JSONObject.toJSONString(result);
  }

  @RequestMapping(value = "json2str", method = RequestMethod.POST,
      consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public String json2str(@RequestBody Employees employees) throws Exception {
    Map<String, Object> result = new HashMap<>();
    result.put("employees", employees);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(result);
//    return JSONObject.toJSONString(result);
  }
}