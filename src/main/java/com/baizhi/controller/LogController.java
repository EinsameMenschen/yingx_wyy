package com.baizhi.controller;

import com.baizhi.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName LogController
 * @Author wyy
 * @Date 2020/8/31 22:19
 * @Description TOOO
 */
@Controller
@RequestMapping("log")
public class LogController {
    @Autowired
    private LogService logService;
    @ResponseBody
    @RequestMapping("queryPageLog")
    public HashMap<String,Object> queryPageLog(Integer page,Integer rows){
        HashMap<String, Object> map = logService.queryPageLog(page, rows);
        return map;
    }

}
