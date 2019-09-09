package com.hwua.po;

import lombok.*;

/*
    公司基本信息表
*   cid int(5) primary key auto_increment,
	cname varchar(30),#公司名称
	cnature varchar(30),#公司性质
	clegalperson varchar(20),#法人代表
	caddress varchar(100),#公司地址
	ctel varchar(20),#公司电话
	cemail varchar(40)#公司邮箱
*
* */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Company {
    private Integer cid;
    private String cname;
    private String cnature;
    private String clegalperson;
    private String caddress;
    private String ctel;
    private String cemail;
}
