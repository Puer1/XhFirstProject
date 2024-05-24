package com.example.xhfirstproject.Service;

import com.example.xhfirstproject.Demos.User;
import com.example.xhfirstproject.Demos.UserVo;
import com.example.xhfirstproject.Mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserMapper userMapper;
    public  UserService(UserMapper userMapper){
        this.userMapper=userMapper;
    }
    public List<User> findUserAll(){
        return userMapper.selectAll();
    }
    public List<User> findUser(int deptId) {
        return userMapper.selectById(deptId);
    }
    public List<UserVo> findUserDeptAll() {
        return userMapper.selectAll1();
    }
    public List<UserVo> findUserDept(Integer id) {
        return userMapper.findUserDept(id);
    }
    public boolean insertUser(User user){
        userMapper.insertToUser(user);
        return true;
    }
    public void batchInsert(List<User> users){
        userMapper.insertUsers(users);
    }
    public void updateUser(User user){
        userMapper.update(user);
    }
    public void deleteUser(int id){
        userMapper.delete(id);
    }
    public void batchDelete(List<Integer> userIds) {
        userMapper.deleteBatchByIds(userIds);
    }
}
