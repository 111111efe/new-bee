package link.newBee.Controller;

import link.newBee.Entity.User;
import link.newBee.annocation.Log;
import link.newBee.serviceImpl.UserServiceImpl;
import link.newBee.util.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * data 2018-06-28   02:47
 * E-mail   sis.nonacosa@gmail.com
 * @author sis.nonacosa
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST,consumes = "application/json")
    public  Result<User> register(@RequestBody User user){

        return userService.register(user);
    }



    @Log("tocken登录")
    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes = "application/json")
    public  Result<User> login(@RequestBody Map<String,String> param){

        return userService.login(param);
    }

    @Log("根据ID获取用户信息")
    @RequestMapping(value = "/getUserInfo", method = RequestMethod.GET)
    public Result<User> getUserInfo ( ){
        return userService.getUserById(getUserId());
    }







}
