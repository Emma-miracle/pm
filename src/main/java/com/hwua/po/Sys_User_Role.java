package com.hwua.po;

import lombok.*;

/*
*   dbid int(5) primary key auto_increment,
	user_id int(5) references sys_user(user_id),
	role_id int(5) references sys_role(role_id)
* */

//赋角

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Sys_User_Role {
    private Integer dbid;
    private Integer user_id;
    private Integer role_id;
}
