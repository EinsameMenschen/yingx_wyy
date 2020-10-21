package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName Role
 * @Author wyy
 * @Date 2020/9/16 8:42
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private String id;
    private String name;
    private List<Permissions> permissions;
}
