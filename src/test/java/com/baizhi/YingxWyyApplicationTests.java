package com.baizhi;

import com.baizhi.dao.AdminDao;
import com.baizhi.dao.VideoDao;
import com.baizhi.entity.Admin;
import com.baizhi.entity.Video;
import com.baizhi.po.VideoPo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YingxWyyApplicationTests {
    @Resource
    AdminDao adminDao;
    @Resource
    VideoDao videoDao;
    @Test
    public void contextLoads() {
        //Admin admin = adminDao.queryByUsername("admin");
        //System.out.println(admin);
        List<VideoPo> videoPos = videoDao.queryFirst();
        videoPos.forEach(videoPo -> System.out.println(videoPo));
    }
    @Test
    public void testSelect1(){
        Admin admin=new Admin();
        admin.setUsername("admin");
        Admin admin1 = (Admin) adminDao.selectOne(admin);
        System.out.println(admin1);
    }

}
