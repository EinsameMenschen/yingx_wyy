package com.baizhi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test1
 * @Author wyy
 * @Date 2020/9/5 22:41
 * @Description TOOO
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRedis {
    @Resource
    RedisTemplate redisTemplate;
    @Resource
    StringRedisTemplate stringRedisTemplate;
    @Test
    public void test1() {
        System.out.println(stringRedisTemplate + "哈哈哈");
        /*Set<String> keys = stringRedisTemplate.keys("*");
        System.out.println(keys.size());
         */
        //redisTemplate.opsForValue().set("student","张三");
        /*ValueOperations valueOperations = redisTemplate.opsForValue();
        Object student = valueOperations.get("student");
        System.out.println("student"+student);
         */
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        //stringStringValueOperations.set("admin","admin");

//        String admin = stringStringValueOperations.get("admin");
//        System.out.println("admin="+admin);

        //stringRedisTemplate.delete("admin");
        //存储手机验证码
        //stringStringValueOperations.set("code","123456",60, TimeUnit.SECONDS);
        String s = stringStringValueOperations.get("com.baizhi.service.impl.UserServiceImplqueryPageUser12");
        System.out.println(s);
    }

}
