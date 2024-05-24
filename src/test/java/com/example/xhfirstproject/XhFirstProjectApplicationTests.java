package com.example.xhfirstproject;

import com.example.xhfirstproject.Demos.Department;
import com.example.xhfirstproject.Demos.User;
import com.example.xhfirstproject.Demos.UserVo;
import com.example.xhfirstproject.Mapper.DepartMapper;
import com.example.xhfirstproject.Mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class XhFirstProjectApplicationTests {

    private static SqlSession getSqlSession() {
        //读取MyBaits的核心配置文件
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //创建SqlSessionFactory对象(通过创建SqlSessionFactoryBuilder来进行获取)
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        //创建sqlSession对象（MyBatis的操作数据库的会话对象，通过此对象可以获取SQL语句，并执行）
        //注意：openSession对象默认是不会进行自动的事务提交的,所以我们如果想做DML操作并且自动事务提交，需要加上true参数，默认为false
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        return sqlSession;
    }
    @Test
    public void selectAllTest(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        users.forEach(user-> System.out.println(user));
    }

    @Test
    public void selectByIdTest(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = userMapper.selectById(3);
        System.out.println(user);
    }

    @Test
    public void insertToUserTest(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(13,"zz","zz",0,"1991-10-17",1);
        Integer num = userMapper.insertToUser(user);
        System.out.println(num);
    }
    @Test
    public void insertUsersTest(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = new ArrayList<>();
        users.add(new User(15, "user1", "xxx", 0, "1991-10-17", 1));
        users.add(new User(16, "user2", "xxxx", 0, "1991-10-17", 2));
        userMapper.insertUsers(users);
    }

    @Test
    public void updateTest(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(13,"zz","zzzz",0,"1991-10-17",1);
        Integer num = userMapper.update(user);
        System.out.println(num);
    }

    @Test
    public void deleteTest(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Integer num = userMapper.delete(13);
        System.out.println(num);
    }
    @Test
    public void deleteTests(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> id = new ArrayList<>();
        id.add(15);
        id.add(16);
        userMapper.deleteBatchByIds(id);
    }

    @Test
    public void selectAllTest1(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        DepartMapper departMapper = sqlSession.getMapper(DepartMapper.class);
        List<Department> departments = departMapper.selectAll();
        departments.forEach(department-> System.out.println(department));
    }

    @Test
    public void selectByIdTest1(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        DepartMapper departMapper = sqlSession.getMapper(DepartMapper.class);
        Department departments = departMapper.selectById(1);
        System.out.println(departments);
    }

    @Test
    public void insertToDepartment(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        DepartMapper departMapper = sqlSession.getMapper(DepartMapper.class);
        Department department = new Department(5,"yy","yy","205",null);
        Integer num = departMapper.insertToDepartment(department);
        System.out.println(num);
    }
    @Test
    public void insertDepartmentsTest(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        DepartMapper departMapper = sqlSession.getMapper(DepartMapper.class);
        List<Department> departments = new ArrayList<>();
        departments.add(new Department(6, "user1", "xxx","101",null));
        departments.add(new Department(7, "user2", "xxxx"," 102",null));
        departMapper.insertDepartments(departments);
    }

    @Test
    public void updateTest1(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        DepartMapper departMapper = sqlSession.getMapper(DepartMapper.class);
        Department department = new Department(5,"yy","yyy","205",null);
        Integer num = departMapper.update(department);
        System.out.println(num);
    }

    @Test
    public void deleteTest1(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        DepartMapper departMapper = sqlSession.getMapper(DepartMapper.class);
        Integer num = departMapper.delete(5);
        System.out.println(num);
    }
    @Test
    public void deleteTests1(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        DepartMapper departMapper = sqlSession.getMapper(DepartMapper.class);
        List<Integer> id = new ArrayList<>();
        id.add(6);
        id.add(7);
        departMapper.deleteBatchByIds(id);
    }
    @Test
    public void findUserDeptTest(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserVo> list = userMapper.selectAll1();
        list.forEach(userVo-> System.out.println(userVo));
    }
    @Test
    public void findUserDeptAll(){
        SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserVo> list = userMapper.findUserDept(1);
        list.forEach(userVo-> System.out.println(userVo));
    }
    @Test
    public void findUserDepts(){
        try {
            SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
            DepartMapper departMapper = sqlSession.getMapper(DepartMapper.class);
            Department department = departMapper.findDeptUsers(1);
            System.out.println(department);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void findUserDeptsAll(){
        try {
            SqlSession sqlSession = XhFirstProjectApplicationTests.getSqlSession();
            DepartMapper departMapper = sqlSession.getMapper(DepartMapper.class);
            List<Department> list = departMapper.findUserDeptsAll();
            list.forEach(department-> System.out.println(department));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
