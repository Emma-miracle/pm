package com.hwua.po;

/*
*   出差记录
  * trip_id int(5) primary key auto_increment,
	user_id int(5),
	trip_city varchar(20),#出差地点
	trip_reason varchar(60),#出差事由
	trip_start datetime, #出差开始时间
	trip_end datetime, #出差结束时间
	days int(5), #天数
	trip_money double(10,2) #报销金额
*
* */

import lombok.*;

import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Trip_Record {
    private Integer trip_id;
    private Integer user_id;
    private String trip_city;
    private String trip_reason;
    private Date trip_start;
    private Date trip_end;
    private Integer days;
    private Double trip_money;

}
