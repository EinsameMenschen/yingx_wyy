package com.baizhi;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//org包的mapperscan和tkMapperscan顺序不要错了
@tk.mybatis.spring.annotation.MapperScan("com.baizhi.dao")
@MapperScan("com.baizhi.dao")
@SpringBootApplication
public class YingxWyyApplication {

    public static void main(String[] args) {
        SpringApplication.run(YingxWyyApplication.class, args);

    }
}
