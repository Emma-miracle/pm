package com.hwua.po;

import lombok.*;

/*
*   dept_id int(5) primary key auto_increment, #部门编号
	dept_name varchar(20) not null, #部门名称
	dept_desc varchar(255) #部门描述
* */

//部门

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Dept {
    private Integer dept_id;
    private String dept_name;
    private String dept_code;
    private String dept_desc;
    private Integer user_id;  //经理编号
}
