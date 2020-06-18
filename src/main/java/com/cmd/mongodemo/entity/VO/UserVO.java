package com.cmd.mongodemo.entity.VO;


import com.cmd.mongodemo.entity.User;

public class UserVO extends User{



    private String roleName;
    private Integer rNum;

    public Integer getrNum() {
        return rNum;
    }

    public void setrNum(Integer rNum) {
        this.rNum = rNum;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
