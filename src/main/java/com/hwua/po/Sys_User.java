package com.hwua.po;

import lombok.*;

import java.util.Date;

/*
*   user_id int(5) primary key auto_increment,
	username varchar(36) not null,
	password varchar(36) not null,
	sex varchar(20),
	age int(3),
	email varchar(50),
	phone varchar(20),
	dept_id int(5) references dept(dept_id),
	register_date datetime,
	is_valid int(1) #0标识正常 1表示停用的
*
* */

//员工

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Sys_User {
    private Integer user_id;
    private String username;
    private String password;
    private String emp_name;
    private Integer sex;
    private Integer age;
    private Integer job_id;
    private String idcard;
    private String email;
    private String phone;
    private Integer dept_id;
    private Double salary;
    private Double bonus;  //奖金
    private Date hiredate;  //入职日期
    private Integer seniority; //入职工龄
    private Integer is_valid;
}
