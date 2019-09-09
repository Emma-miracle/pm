package com.hwua.po;
/*
*   role_id int(5) primary key auto_increment,
	role_name varchar(20) not null,
	role_code varchar(20),
	role_desc varchar(20),
	orders int(5),
	is_valid int(1) #0表示正常 1表示停用的
* */

//角色

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Sys_Role {
    private Integer role_id;
    private String role_name;
    private String role_code;
    private String role_desc;
    private Integer orders;
    private Integer is_valid;

}
