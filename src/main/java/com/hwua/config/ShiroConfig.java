package com.hwua.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;
@Configuration
public class ShiroConfig {
    @Bean(name = "shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getBean(@Autowired SecurityManager manager){
        System.err.println("-------------------------------shiro已经加载---------------------------");
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设定安全管理器
        bean.setSecurityManager(manager);
        bean.setLoginUrl("/login");
        bean.setSuccessUrl("/index");
        Map<String, String> filterChainDefinition = new LinkedHashMap<>();
        filterChainDefinition.put("/login","anon");
        filterChainDefinition.put("/forget","anon");
        filterChainDefinition.put("/userLogin","anon");
        filterChainDefinition.put("/empLogin","anon");
        //filterChainDefinition.put("/userLogout","anon");
        filterChainDefinition.put("/static/**","anon");
        filterChainDefinition.put("/**","authc");
        filterChainDefinition.put("/*.*","authc");
        bean.setFilterChainDefinitionMap(filterChainDefinition);

        return bean;
    }

    @Bean(name="securityManager")
    public SecurityManager getManager(@Autowired MyRe0aml myReaml,
                                      @Autowired MyCredentialMatcher myCredentialMatcher){
        myReaml.setCredentialsMatcher(myCredentialMatcher);
        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(myReaml);
        return manager;
    }
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }

    /*权限配置*/
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return  new LifecycleBeanPostProcessor();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator creator = new DefaultAdvisorAutoProxyCreator();
        creator.setProxyTargetClass(true);
        return creator;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager manager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(manager);
        return advisor;
    }
}
