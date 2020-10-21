package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName Category
 * @Author wyy
 * @Date 2020/8/26 19:32
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "yx_category")
public class Category implements Serializable {
    @Id
    private String id;
    private String name;
    private String levels;
    @Column(name = "parent_id")
    private String parentId;

}
