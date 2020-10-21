package com.baizhi.common;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @ClassName ResultCommon
 * @Author wyy
 * @Date 2020/9/1 17:29
 * @Description TOOO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultCommon {
    private Object data;
    private String message;
    private String status;

}
