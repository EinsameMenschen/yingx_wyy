package com.baizhi.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName UserVo
 * @Author wyy
 * @Date 2020/9/2 23:55
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private String id;
    private String username;
    private String picImg;
    private String phone;
    private String password;
    private String introduction;
    private String sat;
    private String status;
    private String wechat;
    private String registerDate;
    private Integer credit;

}
