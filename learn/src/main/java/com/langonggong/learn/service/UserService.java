package com.langonggong.learn.service;

import com.langonggong.learn.pojo.User;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月17 14:46
 **/
public interface UserService {
  public User selectByPrimaryKey(Integer id);

  public User insertSelective(User user);

  public void deleteByPrimaryKey(Integer id);

}