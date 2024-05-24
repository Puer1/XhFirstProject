package com.example.xhfirstproject.Demos;

import java.io.Serializable;

public class UserVo implements Serializable {
    String userName;
    Integer gender;
    String birthday;
    Integer deptId;
    String deptName;
    String description;
    String address;

    public UserVo() {
    }

    public UserVo(String userName, Integer gender, String birthday, Integer deptId, String deptName, String description, String address) {
        this.userName = userName;
        this.gender = gender;
        this.birthday = birthday;
        this.deptId = deptId;
        this.deptName = deptName;
        this.description = description;
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
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

    @Override
    public String toString() {
        return "UserVo{" +
                "userName='" + userName + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", description='" + description + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
