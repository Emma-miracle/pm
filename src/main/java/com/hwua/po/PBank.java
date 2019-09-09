package com.hwua.po;

/*
    员工银行账户信息
*   pbank_id int(5) primary key auto_increment,#编号
	user_id int(5), #员工编号
	pbank_account varchar(30),#银行账号
	pbank_account_type varchar(30),#银行账号类型
	pbank_account_city varchar(30),#开户行地点
	remarks varchar(100) #备注
*
* */

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PBank {
    private Integer pbank_id;
    private Integer user_id;
    private String pbank_account;
    private String pbank_account_type;
    private String pbank_account_city;
    private String remarks;
}
