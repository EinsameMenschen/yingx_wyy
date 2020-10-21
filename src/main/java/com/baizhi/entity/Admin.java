package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

/**
 * @ClassName Admin
 * @Author wyy
 * @Date 2020/8/24 20:25
 * @Description TOOO
 */
@Table(name="yx_admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    private String id;
    private String username;
    private String password;
    private String salt;
    private List<Role> roles;
    public Admin(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
