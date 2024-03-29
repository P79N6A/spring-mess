package com.langonggong.learn.service.impl;

import com.langonggong.learn.pojo.User;
import com.langonggong.learn.service.UserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author lanxu
 * @email xu.lan@renren-inc.com
 * @create 2017年09月17 14:47
 **/
@Service
public class UserServiceImpl implements UserService {

  @Cacheable(value = "common", key = "'id_'+#id")
  public User selectByPrimaryKey(Integer id) {
    User user = new User(id + "", "lanxu");
    return user;
  }

  @CachePut(value = "common", key = "#user.getName()")
  public User insertSelective(User user) {
    return user;
  }

  @CacheEvict(value = "common", key = "'id_'+#id")
  public void deleteByPrimaryKey(Integer id) {
//		userDao.deleteByPrimaryKey(id);
  }
}