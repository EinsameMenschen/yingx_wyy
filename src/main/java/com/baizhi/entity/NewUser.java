package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import sun.tools.tree.BitAndExpression;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Users
 * @Author wyy
 * @Date 2020/9/3 21:30
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "new_user")
public class NewUser implements Serializable {
    @Id
    private String id;
    private String name;
    private String phone;
    private String sex;
    private String city;
    @Column(name = "create_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

}
