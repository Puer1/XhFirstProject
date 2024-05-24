package com.example.xhfirstproject.Mapper;

import com.example.xhfirstproject.Demos.Department;
import com.example.xhfirstproject.Demos.User;
import com.example.xhfirstproject.Demos.UserVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface DepartMapper {
    List<Department> selectAll();

    Department selectById(Integer id);

    Integer insertToDepartment(Department department);

    void insertDepartments(List<Department> departments);

    void deleteBatchByIds(List<Integer> id);

    Integer update(Department department);

    Integer delete(Integer id);

    Department findDeptUsers(Integer id);
    List<Department> findUserDeptsAll();
}
