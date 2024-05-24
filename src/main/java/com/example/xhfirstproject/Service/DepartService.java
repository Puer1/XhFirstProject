package com.example.xhfirstproject.Service;

import com.example.xhfirstproject.Demos.Department;
import com.example.xhfirstproject.Demos.User;
import com.example.xhfirstproject.Mapper.DepartMapper;
import com.example.xhfirstproject.Mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartService {
    private DepartMapper departMapper;

    public DepartService(DepartMapper departMapper) {
        this.departMapper = departMapper;
    }

    public List<Department> selectDepartmentAll() {
        return departMapper.selectAll();
    }

    public Department selectDepartment(int deptId) {
        return departMapper.selectById(deptId);
    }

    public boolean insertDepartment(Department department) {
        departMapper.insertToDepartment(department);
        return true;
    }

    public Department findUserDepts(Integer id) {
        return departMapper.findDeptUsers(id);
    }
    public List<Department> findUserDeptsAll() {
        return departMapper.findUserDeptsAll();
    }
    public void updateDepartment(Department department) {
        departMapper.update(department);
    }

    public void deleteDepartment(int id) {
        departMapper.delete(id);
    }

    public void batchDelete(List<Integer> ids) {
        departMapper.deleteBatchByIds(ids);
    }

    public void batchInsert(List<Department> departments) {
        departMapper.insertDepartments(departments);
    }
}