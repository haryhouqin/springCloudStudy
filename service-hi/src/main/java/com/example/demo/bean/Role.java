package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Role extends BaseEntity{
    @Id
    @GeneratedValue
    private long id;
    private String roleName;


    public long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
