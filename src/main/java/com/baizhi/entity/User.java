package com.baizhi.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName User
 * @Author wyy
 * @Date 2020/8/25 17:23
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="yx_user")
public class User implements Serializable {
    @Id
    @Excel(name = "ID")
    private String id;
    @Excel(name = "用户名")
    private String username;
    @Excel(name = "手机号")
    private String phone;
    @Excel(name = "头像",type = 2,width = 50,height = 25)
    @Column(name="head_img")
    private String headImg;
    @Excel(name = "简介")
    private String sign;
    @Excel(name = "微信")
    private String wechat;
    @Excel(name = "状态")
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name="create_date")
    @Excel(name = "注册时间",format = "yyyy-MM-dd")
    private Date createDate;

}
