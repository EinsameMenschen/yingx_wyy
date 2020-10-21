package com.baizhi;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import com.alibaba.fastjson.JSON;
import com.baizhi.entity.Person;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import com.baizhi.util.AliyunOssUtil;
import io.goeasy.GoEasy;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestGoEasy {
    @Test
    public void testPoiStudent() throws IOException {
        GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-cb91f25ab6b74c61bc3d48b94a90aaa0");
                goEasy.publish("2003_channel", "Hello, GoEasy!");
    }
    @Test
    public void testGoEasy(){
        Random random=new Random();
        for(int i=0;i<5;i++){
            HashMap<String,Object> map=new HashMap<>();
            map.put("month", Arrays.asList("1月","2月","3月","4月","5月","6月"));
            map.put("boys", Arrays.asList(random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100)));
            map.put("girls", Arrays.asList(random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100), random.nextInt(100)));
            //将map转换json格式的数据
            //发布消息的时机  数据库的数据发生改变的时候   增删改
            String s = JSON.toJSONString(map);
            GoEasy goEasy = new GoEasy( "http://rest-hangzhou.goeasy.io", "BC-cb91f25ab6b74c61bc3d48b94a90aaa0");
            goEasy.publish("2003_channel", s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
