package com.example.xhfirstproject.Demos;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class User implements Serializable {
    Integer id;
    String userName;
    String password;
    Integer gender;
    String birthday;
    Integer deptId;


    public User(Integer id, String userName, String password, Integer gender, String birthday, Integer deptId) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.birthday = birthday;
        this.deptId = deptId;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", dept_id=" + deptId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId()) && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getGender(), user.getGender()) && Objects.equals(getBirthday(), user.getBirthday()) && Objects.equals(getDeptId(), user.getDeptId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUserName(), getPassword(), getGender(), getBirthday(), getDeptId());
    }
}
