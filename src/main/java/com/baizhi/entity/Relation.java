package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @ClassName Relation
 * @Author wyy
 * @Date 2020/9/6 0:01
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Relation implements Serializable {
    private String month ;
    private Integer number ;

}
