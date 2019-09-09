package com.hwua.config;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.stereotype.Component;

@Component
public class MyCredentialMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authenticationToken, AuthenticationInfo authenticationInfo) {
        UsernamePasswordToken token=(UsernamePasswordToken)authenticationToken;
        //用户输入的密码
        String pass = new String(token.getPassword());
        String username = token.getUsername();
        Md5Hash hash = new Md5Hash(pass,username,3);
        String pass1 = hash.toString();
        System.err.println("----原始密码 ："+pass+"-----");
        System.err.println("----加密密码 ："+pass1+"-----");
        //从数据库中根据用户取出来的密码
        Object pass2 =  authenticationInfo.getCredentials();
        System.err.println("----数据库密码 ："+pass2+"-----");
        return this.equals(pass1,pass2);
    }

    public static  void  main(String[] args){
        Md5Hash md5Hash = new Md5Hash("888888","新新",3);
        String s = md5Hash.toString();
        System.out.println(s);
    }
}
