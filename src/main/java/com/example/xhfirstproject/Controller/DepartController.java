package com.example.xhfirstproject.Controller;

import com.example.xhfirstproject.Demos.Department;
import com.example.xhfirstproject.Demos.User;
import com.example.xhfirstproject.Service.DepartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/departments")
public class DepartController {
    @Autowired
    private DepartService departService;
    private static final Logger logger = Logger.getLogger(DepartController.class);
    @GetMapping("/selectDepartmentAll")
    public List<Department> selectDepartmentAll() {
        return departService.selectDepartmentAll();
    }
    @GetMapping("/selectDepartment/{id}")
    public Department selectDepartment(@PathVariable Integer id) {
        logger.info("前端传来的参数为：" + id);
        return departService.selectDepartment(id);
    }
    @GetMapping("/findUserDepts/{id}")
    public Department findUserDepts(@PathVariable Integer id) {
        logger.info("前端传来的参数为：" + id);
        return departService.findUserDepts(id);
    }
    @GetMapping("/findUserDeptsAll")
    public List<Department> findUserDeptsAll() {
        return departService.findUserDeptsAll();
    }
    @PostMapping("/insertDepartment")
    public String SetDepartment(@RequestBody Department department) {
        if(departService.insertDepartment(department)){
            logger.info("前端传来的参数为：" + department.toString());
            return "插入成功";
        }else{
            logger.info("前端传来的参数为：" + department.toString());
            return "插入失败";
        }
    }
    @PostMapping("/batchInsert")
    public String SetDepartments(@RequestBody List<Department> departments) {
            logger.info("前端传来的参数为：" + departments.toString());
            departService.batchInsert(departments);
            return "批量插入成功";
    }
    @PutMapping("/updateDepartment")
    public String UpdateDepartmentList(@RequestBody Department department) {
        logger.info("前端传来的参数为：" + department.toString());
        departService.updateDepartment(department);
        return "修改成功";
    }
    @DeleteMapping("/deleteDepartment/{id}")
    public String DeleteUserList(@PathVariable Integer id) {
        Department department=new Department();
        logger.info("前端传来的参数为：" + department.toString());
        departService.deleteDepartment(id);
        return "删除成功";
    }
    @DeleteMapping("/batchDelete")
    public String deleteUsers(@RequestBody List<Department> departments) {
        logger.info("前端传来的参数为：" + departments);
        List<Integer> ids = departments.stream().map(Department::getId).collect(Collectors.toList());
        departService.batchDelete(ids);
        return "批量删除成功";
    }
}
