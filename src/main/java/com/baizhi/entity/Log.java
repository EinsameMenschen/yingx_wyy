package com.baizhi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Log
 * @Author wyy
 * @Date 2020/8/31 19:59
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "yx_log")
public class Log implements Serializable {
    private  String id;
    private String username;
    private String options;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    private String status;



}
