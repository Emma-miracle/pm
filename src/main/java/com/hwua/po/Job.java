package com.hwua.po;
/*
*   job_id int(5) primary key auto_increment,
	job_name varchar(20) not null,
	job_code varchar(20),
	job_desc varchar(60),
	job_salary double(10,2)
*   职务表
*
* */
import lombok.*;

//职位

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Job {
    private Integer job_id;
    private String job_type;
    private String job_name;
    private String job_code;
    private String job_desc;
    private String job_salary;

}
