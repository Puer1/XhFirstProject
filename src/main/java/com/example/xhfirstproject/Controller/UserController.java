package com.example.xhfirstproject.Controller;

import com.example.xhfirstproject.Demos.User;
import com.example.xhfirstproject.Demos.UserVo;
import com.example.xhfirstproject.Service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = Logger.getLogger(UserController.class);

    public UserController(UserService userService){
        this.userService=userService;
    }
    @GetMapping("/findUserAll")
    public List<User> findUserAll(User user) {
        logger.info("前端传来的参数为：" + user.toString());
        return userService.findUserAll();
    }
    @GetMapping("/findUser/{deptId}")
    public List<User> findUser(@PathVariable Integer deptId) {
        logger.info("前端传来的参数为：" + deptId);
        return userService.findUser(deptId);
    }
    @GetMapping("/findUserDeptAll")
    public List<UserVo> findUserDeptAll() {
        return userService.findUserDeptAll();
    }
    @GetMapping("/findUserDept/{deptId}")
    public List<UserVo> findUserDept(@PathVariable Integer deptId) {
        logger.info("前端传来的参数为：" + deptId);
        return userService.findUserDept(deptId);
    }
    @PostMapping("/insertUser")
    public String SetUser(@RequestBody User user) {
        if(userService.insertUser(user)){
            logger.info("前端传来的参数为：" + user.toString());
            return "插入成功";
        }else{
            logger.info("前端传来的参数为：" + user.toString());
            return "插入失败";
        }
    }
    @PostMapping("/batchInsert")
    public String SetUsers(@RequestBody List<User> user) {
            logger.info("前端传来的参数为：" + user.toString());
            userService.batchInsert(user);
            return "批量插入成功";
    }
    @PutMapping("/updateUser")
    public String updateUser(@RequestBody User user) {
        logger.info("前端传来的参数为：" + user.toString());
        userService.updateUser(user);
        return "修改成功";
    }
    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id) {
        User user=new User();
        logger.info("前端传来的参数为：" + id);
        userService.deleteUser(id);
        return "删除成功";
    }
    @DeleteMapping("/batchDelete")
    public String deleteUsers(@RequestBody List<User> users) {
        List<Integer> ids = users.stream().map(User::getId).collect(Collectors.toList());
        userService.batchDelete(ids);
        return "批量删除成功";
    }

}
