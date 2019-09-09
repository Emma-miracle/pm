package com.hwua.controller;

import com.alibaba.fastjson.JSONObject;
import com.hwua.po.Sys_Auth;
import com.hwua.service.CountService;
import com.hwua.service.SysService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

@Controller
//@RequestMapping("/sys")
public class SysController {
    @Autowired
    private SysService sysService;
    @Autowired
    private CountService countService;


    //用户登录
    @RequestMapping("/userLogin")
    public ModelAndView userLogin(String username, String password, HttpSession session){
        ModelAndView mv = new ModelAndView("forward:/home");
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        Date date = new Date();
        try {
            subject.login(token);
            session.setAttribute("user",username);
            session.setAttribute("date",date);
            //mv.setViewName("index");
        }catch (UnknownAccountException e){
            mv.addObject("status","账户不存在");
            mv.addObject("preName",username);
            mv.setViewName("login");
        }catch (IncorrectCredentialsException e){
            mv.addObject("status","密码不正确");
            mv.addObject("preName",username);
            mv.setViewName("login");
        }
        return mv;

    }

    @RequestMapping(value = "/empLogin",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String login(String username, String password, HttpServletRequest req, HttpServletResponse resp, HttpSession session) throws ServletException, IOException {
        /*req.getRequestDispatcher("/home").forward(req,resp);*/
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        Date date = new Date();

        JSONObject jo = new JSONObject();
        try {
            subject.login(token);
            session.setAttribute("user",username);
            session.setAttribute("date",date);
            jo.put("status","ok");
            System.out.println("----------------登录成功----------------");
        }catch (UnknownAccountException e){
            jo.put("status","no");
            jo.put("preName",username);
            jo.put("msg","此帐号不存在!");
            System.out.println("----------------此帐号不存在----------------");
        }catch (IncorrectCredentialsException e){
            jo.put("status","no");
            jo.put("msg","密码不正确!");
            System.out.println("----------------密码不正确----------------");
        }catch (DisabledAccountException e) {
            jo.put("status","no");
            jo.put("msg","帐号已被禁用!");
            System.out.println("----------------帐号已被禁用!---------------");
        }
        return jo.toJSONString();
    }






    @RequestMapping("/home")
    public ModelAndView toHome(){
        ModelAndView mv = new ModelAndView("home");
        Map<Sys_Auth, List<Sys_Auth>> allAuths = sysService.getAllAuths();
        mv.addObject("menus",allAuths);
        return  mv;
    }

    @RequiresPermissions("系统管理")
    @RequestMapping("/welcome")
    public ModelAndView welcome() throws UnknownHostException {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("console");
        mv.addObject("name","王新凤(luori5201314@outlook.com)");
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME");// 获取用户名
        String computerName = map.get("COMPUTERNAME");// 获取计算机名
        String userDomain = map.get("USERDOMAIN");// 获取计算机域名
        System.out.println("用户名:    " + userName);
        System.out.println("计算机名:    " + computerName);
        System.out.println("计算机域名:    " + userDomain);
        System.out.println("本地ip地址:    " + ip);
        System.out.println("本地主机名:    " + addr.getHostName());
        System.out.println("Java的运行环境版ip本：    " + props.getProperty("java.version"));
        System.out.println("操作系统的名称：    " + props.getProperty("os.name"));
        System.out.println("操作系统的构架：    " + props.getProperty("os.arch"));
        System.out.println("操作系统的版本：    " + props.getProperty("os.version"));
        mv.addObject("userName",userName);
        mv.addObject("computerName",computerName);
        mv.addObject("userDomain",userDomain);
        mv.addObject("ip",ip);
        mv.addObject("HostName",addr.getHostName());
        mv.addObject("javaVersion",props.getProperty("java.version"));
        mv.addObject("osName",props.getProperty("os.name"));
        mv.addObject("osArch",props.getProperty("os.arch"));
        mv.addObject("osVersion",props.getProperty("os.version"));
        Integer empCount = countService.countEmps();
        mv.addObject("empCount",empCount);
        Integer jobCount = countService.countJobs();
        mv.addObject("jobCount",jobCount);
        Integer deptCount = countService.countDepts();
        mv.addObject("deptCount",deptCount);
        Integer authCount = countService.countAuths();
        mv.addObject("authCount",authCount);
        return mv;
    }

    //用户退出
    @RequestMapping("/userLogout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }



    //文件上传
    @RequestMapping("/upload")
    public ModelAndView upload(@RequestParam("files")List<MultipartFile> files, HttpServletRequest request) throws IOException {

        String savePath = request.getServletContext().getRealPath("/WEB-INF/upload/");
        ModelAndView mv = new ModelAndView("welcome");
        List<String> fileNames = new ArrayList<>();
        System.out.println(files.size());
        if(files!=null&&files.size()>0){
            String fileName="";
            File target=null;
            for(MultipartFile file:files){
                if(!file.isEmpty()){
                    fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                    target=new File(savePath+fileName);
                    file.transferTo(target);
                    fileNames.add(fileName);
                }
            }
            mv.addObject("fileNames",fileNames);
        }

        return mv;
    }

    //文件下载
    @RequestMapping("/download")
    public void download(@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String path = request.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(path + File.separator + fileName);
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-disposition","attachment;filename="+new String(fileName.getBytes("UTF-8"),"ISO8859-1"));
        ServletOutputStream os = response.getOutputStream();
        InputStream is= new FileInputStream(file);
        int len=0;
        byte[] bytes = new byte[1024];
        while ((len=is.read(bytes))!=-1){
            os.write(bytes,0,bytes.length);
        }
        os.close();
        is.close();
    }

}
