package icewine.study.Controller;

import icewine.study.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.catalina.Group;
import org.apache.catalina.Role;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;


@RestController
@Api(value = "用户管理业务逻辑", description = "User Controller")
public class HelloController {


    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    //只要我们的接口中返回值中存在实体类，他就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }


    //Operation接口，不是放在类上的，是在方法上
    @ApiOperation("hello控制类")
    @GetMapping(value = "/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

    @ApiOperation("post测试类")
    @PostMapping(value = "/postt")
    public User hello2(@ApiParam("用户名") User user){
//        int a =5/0;
        return user;
    }

}
