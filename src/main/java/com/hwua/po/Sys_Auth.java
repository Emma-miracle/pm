package com.hwua.po;

import lombok.*;

/*
*   auth_id int(5) primary key auto_increment,
	auth_name varchar(20) not null,
	auth_code varchar(20),
	auth_desc varchar(20),
	auth_layer int(3), #层级
	auth_url varchar(50), #url
	parent_id int(5), #父编号
	orders int(5),  #排序
	auth_type int(1), #0代表菜单 1代表资源
	is_valid int(1) #0代表可用 1代表禁用
* */
//权限

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Sys_Auth {
    private Integer auth_id;
    private String auth_name;
    private String auth_ico;
    private String auth_code;
    private String auth_desc;
    private Integer auth_layer;
    private String auth_url;
    private Integer parent_id;
    private Integer orders;
    private Integer auth_type;
    private Integer is_valid;
}
