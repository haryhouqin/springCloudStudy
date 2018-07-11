package com.example.demo.dao;

import com.example.demo.bean.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoleDao extends BaseDao<Role,Long> {
    Role findByRoleName(String roleName);
    @Query(value = "select * from role where id >= ?1",nativeQuery = true)
    List<Role> selectByRoleName(int id);
    @Transactional
    @Modifying
    @Query(value = "delete from role where role_name = ?1",nativeQuery = true)
    void removeJingli(String roleName);
}
