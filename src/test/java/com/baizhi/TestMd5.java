package com.baizhi;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha1Hash;
import org.junit.Test;

/**
 * @ClassName TestNd5
 * @Author wyy
 * @Date 2020/9/15 8:31
 * @Description TOOO
 */
public class TestMd5 {
    //使用shiro进行用户认证
    @Test
    public void testMd5(){
        //进行密码加密   明文密码：123456
        //Md5Hash md5Hash = new Md5Hash("123456");

        //进行加盐加密
        //Md5Hash md5Hash = new Md5Hash("123456","abcd");

        //进行加盐加密  并散列
        Md5Hash md5Hash = new Md5Hash("123456", "abcd", 1024);
        String s = md5Hash.toHex();
        System.out.println("s==="+s);
        //明文加密   e10adc3949ba59abbe56e057f20f883e
        //加盐加密    da3177cbd9f064004b6a0d59a3a484bb
        //加盐加密并散列   68609b8b64988c0f4def093eaa025e05

    }

    @Test
    public void sha1(){
        Sha1Hash sha1Hash = new Sha1Hash("123456", "abcd", 1024);
        String s = sha1Hash.toHex();
        System.out.println("s:"+s);
        //829ba4364e49929d1a6989a6b1ad0e212a5fb280
    }




}
