package com.example.xhfirstproject.Demos;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Department implements Serializable {
    Integer id;
    String deptName;
    String description;
    String address;
    private List<User> users;

    public Department(Integer id, String deptName, String description, String address,List<User> users) {
        this.id = id;
        this.deptName = deptName;
        this.description = description;
        this.address = address;
        this.users = users;
    }

    public Department() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Department)) return false;
        Department that = (Department) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getDeptName(), that.getDeptName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getAddress(), that.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDeptName(), getDescription(), getAddress());
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                ", users='" + users + '\'' +
                '}';
    }
}
