package com.example.xhfirstproject.Mapper;

import com.example.xhfirstproject.Demos.User;
import com.example.xhfirstproject.Demos.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    List<User> selectAll();

    List<User> selectById(Integer id);

    List<UserVo> selectAll1();
    List<UserVo> findUserDept(Integer id);

    Integer insertToUser(User user);

    Integer update(User user);

    Integer delete(Integer id);

    void deleteBatchByIds(List<Integer> id);
    void insertUsers(List<User> users);
}
