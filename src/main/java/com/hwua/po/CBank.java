package com.hwua.po;

import lombok.*;

/*
*   公司银行账户
*   cbank_id int(5) primary key auto_increment,#编号
	cbank_account varchar(30),#银行账号
	cbank_account_type varchar(30),#银行账号类型
	cbank_account_city varchar(30),#开户行地点
	remarks varchar(100) #备注
*
* */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class CBank {
    private Integer cbank_id;
    private String cbank_account;
    private String cbank_account_type;
    private String cbank_account_city;
    private String remarks;

}
