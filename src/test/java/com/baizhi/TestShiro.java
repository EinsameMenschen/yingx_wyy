package com.baizhi;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * @ClassName TestShiro
 * @Author wyy
 * @Date 2020/9/14 22:34
 * @Description TOOO
 */
public class TestShiro {
    @Test
    public void  test1(){
        //获取安全管理器工厂
        IniSecurityManagerFactory factory=new IniSecurityManagerFactory("classpath:shiro.ini");
        //创建安全管理器
        SecurityManager instance = factory.createInstance();
        //将安全管理器交由工具类管理
        SecurityUtils.setSecurityManager(instance);
        //获取主题
        Subject subject = SecurityUtils.getSubject();
        //创建令牌
        UsernamePasswordToken token=new UsernamePasswordToken("yy","123456");
        //进行认证
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            System.out.println("当前身份信息输入错误");
            e.printStackTrace();
        }
        catch (IncorrectCredentialsException e) {
            System.out.println("当前密码输入错误");
            e.printStackTrace();
        }
        //当前主题是否认证通过
        boolean authenticated = subject.isAuthenticated();
        System.out.println("当前认证是否通过=="+authenticated);



        //org.apache.shiro.authc.UnknownAccountException   未知的用户异常（用户名错误）
        //org.apache.shiro.authc.IncorrectCredentialsException  凭证信息匹配异常（密码错误）

    }


}
