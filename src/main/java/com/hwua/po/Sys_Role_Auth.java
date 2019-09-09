package com.hwua.po;

import lombok.*;

/*
*   dbid int(5) primary key auto_increment,
	role_id int(5) references sys_role(role_id),
	auth_id int(5) references sys_auth(auth_id)
* */

//授权

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Sys_Role_Auth {
    private Integer dbid;
    private Integer role_id;
    private Integer auth_id;
}
