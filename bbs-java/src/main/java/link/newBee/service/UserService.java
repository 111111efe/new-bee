package link.newBee.service;

import link.newBee.Entity.User;
import link.newBee.util.Result;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * data 2018-06-28   22:05
 * E-mail   sis.nonacosa@gmail.com
 *
 * @author sis.nonacosa
 */

public interface UserService  {


      Result<User> getUserById(Long id);

      User saveUser(User user);

      Result<User> register(User user);

      Result<User> login(User user);


      Result<User> loginUser(String token);
}
