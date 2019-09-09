package com.hwua.po;
/*
*   leave_id int(5) primary key auto_increment,
	user_id int(5),
	leave_type int(1),
	start_date datetime,
	end_date datetime,
	times int(5),
	reason varchar(100),
	status int(1)
*
* */

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Leave_Record {
    private Integer leave_id;
    private Integer user_id;     //员工编号
    private Integer leave_type;  //请假类型
    private Date start_date;
    private Date end_date;
    private Integer times;   //请假天数
    private String reason;   //请假是由
    private Integer status;  //0代表 未审核 //1 代表 审核 通过 //2代表 审核未过
}
