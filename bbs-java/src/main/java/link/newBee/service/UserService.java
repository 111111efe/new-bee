package link.newBee.service;

import link.newBee.Entity.User;
import link.newBee.util.Result;

import java.util.Map;

/**
 * data 2018-06-28   22:05
 * E-mail   sis.nonacosa@gmail.com
 * 规则：**ById save** del** 不能用Result<T>包装，保障代码复用
 * @author sis.nonacosa
 */

public interface UserService  {


      Result<User> getUserById(String id);

      Result<User> getUserByUserName(String userName);

      User getUserByGithubNodeId(String nodeId);


      User saveUser(User user);

      Result<User> register(User user);

      Result<User> login(Map<String,String> param);

      Result<User> loginUser(User user);
}
