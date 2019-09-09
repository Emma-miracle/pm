/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 50722
Source Host           : 39.96.167.190:3306
Source Database       : pm

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-09-09 12:37:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cbank
-- ----------------------------
DROP TABLE IF EXISTS `cbank`;
CREATE TABLE `cbank` (
  `cbank_id` int(5) NOT NULL AUTO_INCREMENT,
  `cbank_account` varchar(30) DEFAULT NULL,
  `cbank_account_type` varchar(30) DEFAULT NULL,
  `cbank_account_city` varchar(30) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cbank_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cbank
-- ----------------------------

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `cid` int(5) NOT NULL AUTO_INCREMENT,
  `cname` varchar(30) DEFAULT NULL,
  `cnature` varchar(30) DEFAULT NULL,
  `clegalperson` varchar(20) DEFAULT NULL,
  `caddress` varchar(100) DEFAULT NULL,
  `ctel` varchar(20) DEFAULT NULL,
  `cemail` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `dept_id` int(5) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(20) NOT NULL,
  `dept_code` varchar(20) DEFAULT NULL,
  `dept_desc` varchar(255) DEFAULT NULL,
  `user_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '经理室', 'jls', '经理高层部门', '1');
INSERT INTO `dept` VALUES ('2', '技术部门', 'jsbm', '负责研究计算机技术', '2');
INSERT INTO `dept` VALUES ('3', '会议部门', 'hybm', '负责记录会议的大小事务', null);
INSERT INTO `dept` VALUES ('4', '销售部门', 'xsbm', '负责销售公司产品', '6');
INSERT INTO `dept` VALUES ('5', '人事部门', 'rsbm', '负责员工招聘选拔', null);
INSERT INTO `dept` VALUES ('6', '设计部门', 'sjbm', '负责公司各方面的设计', '8');
INSERT INTO `dept` VALUES ('7', '生产部门', 'scbm', '负责公司产品的生产管理', null);

-- ----------------------------
-- Table structure for job
-- ----------------------------
DROP TABLE IF EXISTS `job`;
CREATE TABLE `job` (
  `job_id` int(5) NOT NULL AUTO_INCREMENT,
  `job_type` varchar(20) DEFAULT NULL,
  `job_name` varchar(20) NOT NULL,
  `job_code` varchar(20) DEFAULT NULL,
  `job_desc` varchar(60) DEFAULT NULL,
  `job_salary` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`job_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of job
-- ----------------------------
INSERT INTO `job` VALUES ('1', '经理', '总经理', 'zc', '公司的执行决定者。', '300000.00');
INSERT INTO `job` VALUES ('2', '主管', '技术主管', 'jszg', '处理技术部门的各项事务', '50000.00');
INSERT INTO `job` VALUES ('3', '职员', '文职', 'wz', '负责公司的会议记录', '4000.00');
INSERT INTO `job` VALUES ('4', '经理', '销售经理', 'xsbm', '负责销售部门的管理', '11000.00');
INSERT INTO `job` VALUES ('5', '职员', '设计师', 'sjs', '负责公司的设计工作', '8000.00');
INSERT INTO `job` VALUES ('6', '职员', '销售员', 'xsy', '负责销售公司产品', '5000.00');
INSERT INTO `job` VALUES ('7', '职员', 'java开发师', 'jkfs', '负责java代码程序的开发', '8000.00');
INSERT INTO `job` VALUES ('8', '经理', '人事经理', 'rsjl', '负责公司的员工管理、人才招聘', '11000.00');
INSERT INTO `job` VALUES ('9', '经理', '设计经理', 'sjjl', '负责管理设计部门', '15000.00');
INSERT INTO `job` VALUES ('10', '职员', '软件测试员', 'rjcsy', '负责对软件进行各项测试', '3500.00');

-- ----------------------------
-- Table structure for leave_record
-- ----------------------------
DROP TABLE IF EXISTS `leave_record`;
CREATE TABLE `leave_record` (
  `leave_id` int(5) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) DEFAULT NULL,
  `leave_type` int(1) DEFAULT NULL,
  `start_date` datetime DEFAULT NULL,
  `end_date` datetime DEFAULT NULL,
  `times` int(5) DEFAULT NULL,
  `reason` varchar(100) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`leave_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leave_record
-- ----------------------------

-- ----------------------------
-- Table structure for pbank
-- ----------------------------
DROP TABLE IF EXISTS `pbank`;
CREATE TABLE `pbank` (
  `pbank_id` int(5) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) DEFAULT NULL,
  `pbank_account` varchar(30) DEFAULT NULL,
  `pbank_account_type` varchar(30) DEFAULT NULL,
  `pbank_account_city` varchar(30) DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`pbank_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pbank
-- ----------------------------
INSERT INTO `pbank` VALUES ('1', '9', '358848879799', '华夏银行', '山东', '');
INSERT INTO `pbank` VALUES ('2', '1', '1121111', '华夏银行', '上海', '');

-- ----------------------------
-- Table structure for sys_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_auth`;
CREATE TABLE `sys_auth` (
  `auth_id` int(5) NOT NULL AUTO_INCREMENT,
  `auth_name` varchar(20) NOT NULL,
  `auth_ico` varchar(25) DEFAULT NULL,
  `auth_code` varchar(20) DEFAULT NULL,
  `auth_desc` varchar(20) DEFAULT NULL,
  `auth_layer` int(3) DEFAULT NULL,
  `auth_url` varchar(50) DEFAULT NULL,
  `parent_id` int(5) DEFAULT NULL,
  `orders` int(5) DEFAULT NULL,
  `auth_type` int(1) DEFAULT NULL,
  `is_valid` int(1) DEFAULT NULL,
  PRIMARY KEY (`auth_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_auth
-- ----------------------------
INSERT INTO `sys_auth` VALUES ('1', '公司管理', null, 'gcgl', '管理公司的部门、职位', '1', '', '-1', '10', '0', '0');
INSERT INTO `sys_auth` VALUES ('2', '部门信息', null, 'bmxx', '管理公司的部门', '2', 'dept/list', '1', '10', '0', '0');
INSERT INTO `sys_auth` VALUES ('3', '添加部门', null, 'tjbm', '添加部门', '3', null, '2', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('4', '编辑部门', null, 'bjbm', '编辑部门', '3', null, '2', '20', '1', '0');
INSERT INTO `sys_auth` VALUES ('5', '删除部门', null, 'scbm', '删除部门', '3', null, '2', '30', '1', '0');
INSERT INTO `sys_auth` VALUES ('6', '职务信息', null, 'zwxx', '管理公司的职位', '2', 'job/list', '1', '20', '0', '0');
INSERT INTO `sys_auth` VALUES ('7', '添加职务', null, 'tjzw', '添加职务', '3', '', '6', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('8', '编辑职务', null, 'bjzw', '编辑职务', '3', 'admin_auth_edit', '6', '20', '1', '0');
INSERT INTO `sys_auth` VALUES ('9', '删除职务', null, 'sczw', '删除职务', '3', '', '6', '30', '1', '0');
INSERT INTO `sys_auth` VALUES ('10', '员工管理', null, 'yggl', '管理员工的基本信息、请假与出差记录', '1', null, '-1', '20', '0', '0');
INSERT INTO `sys_auth` VALUES ('11', '员工信息', null, 'ygxx', '管理员工信息', '2', 'emp/list', '10', '10', '0', '0');
INSERT INTO `sys_auth` VALUES ('12', '添加员工', null, 'tjyg', '添加员工', '3', 'emp/add', '11', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('13', '编辑员工', null, 'bjyg', '编辑员工', '3', null, '11', '20', '1', '0');
INSERT INTO `sys_auth` VALUES ('14', '禁用员工', null, 'jyyg', '禁用员工', '3', 'updateEmpStatus', '11', '30', '1', '0');
INSERT INTO `sys_auth` VALUES ('15', '请假记录', null, 'qjjl', '管理请假记录', '2', 'leave/list', '10', '20', '0', '0');
INSERT INTO `sys_auth` VALUES ('16', '添加请假', null, 'tjqj', '添加请假', '3', null, '15', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('17', '编辑请假', null, 'bjqj', '编辑请假', '3', null, '15', '20', '1', '0');
INSERT INTO `sys_auth` VALUES ('18', '删除请假', null, 'scqj', '删除请假', '3', null, '15', '30', '1', '0');
INSERT INTO `sys_auth` VALUES ('19', '出差记录', null, 'ccjl', '管理出差记录', '2', 'trip/list', '10', '30', '0', '0');
INSERT INTO `sys_auth` VALUES ('20', '添加出差', null, 'tjcc', '添加出差', '3', null, '19', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('21', '编辑出差', null, 'bjcc', '编辑出差', '3', null, '19', '20', '1', '0');
INSERT INTO `sys_auth` VALUES ('22', '删除出差', null, 'sccc', '删除出差', '3', null, '19', '30', '1', '0');
INSERT INTO `sys_auth` VALUES ('23', '资产管理', null, 'zcgl', '管理公司账户、个人账户', '1', null, '-1', '30', '0', '0');
INSERT INTO `sys_auth` VALUES ('24', '公司银行账户', null, 'gsyhzh', '管理员工信息', '2', 'cbank/list', '23', '10', '0', '0');
INSERT INTO `sys_auth` VALUES ('25', '添加公司账户', null, 'tjgszh', '添加公司银行账户', '3', null, '24', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('26', '编辑公司账户', null, 'bjgszh', '编辑公司银行账户', '3', null, '24', '20', '1', '0');
INSERT INTO `sys_auth` VALUES ('27', '删除公司账户', null, 'scgszh', '删除公司银行账户', '3', null, '24', '30', '1', '0');
INSERT INTO `sys_auth` VALUES ('28', '个人银行账户', null, 'gryhzh', '管理请假记录', '2', 'pbank/list', '23', '20', '0', '0');
INSERT INTO `sys_auth` VALUES ('29', '添加个人账户', null, 'tjgrzh', '添加个人银行账户', '3', null, '28', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('30', '编辑个人账户', null, 'bjgrzh', '编辑个人银行账户', '3', null, '28', '20', '1', '0');
INSERT INTO `sys_auth` VALUES ('31', '删除个人账户', null, 'scgrzh', '删除个人银行账户', '3', null, '28', '30', '1', '0');
INSERT INTO `sys_auth` VALUES ('32', '系统管理', null, 'xtgl', '对于系统的管理', '1', '', '-1', '40', '0', '0');
INSERT INTO `sys_auth` VALUES ('33', '权限管理', null, 'qxgl', '管理公司员工在系统的权限', '2', 'auth/list', '32', '10', '0', '0');
INSERT INTO `sys_auth` VALUES ('34', '添加权限', null, 'tjqx', '添加权限', '3', 'admin_auth_add', '33', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('35', '编辑权限', null, 'bjqx', '编辑权限', '3', null, '33', '20', '1', '0');
INSERT INTO `sys_auth` VALUES ('36', '禁用权限', null, 'scqx', '禁用权限', '3', '', '33', '30', '1', '0');
INSERT INTO `sys_auth` VALUES ('37', '角色管理', null, 'jsgl', '管理公司员工在系统的角色', '2', 'role/list', '32', '20', '0', '0');
INSERT INTO `sys_auth` VALUES ('38', '添加角色', null, 'tjjs', '添加角色', '3', null, '37', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('39', '编辑角色', null, 'bjjs', '编辑角色', '3', null, '37', '20', '1', '0');
INSERT INTO `sys_auth` VALUES ('40', '禁用角色', null, 'scjs', '禁用角色', '3', 'updateRoleStatus', '37', '30', '1', '0');
INSERT INTO `sys_auth` VALUES ('41', '请假', null, 'qj', '普通职员申请请假', '1', 'emp/leave', '-1', '50', '0', '0');
INSERT INTO `sys_auth` VALUES ('42', '出差', null, 'cc', '普通职员申请出差', '1', 'emp/trip', '-1', '60', '0', '0');
INSERT INTO `sys_auth` VALUES ('43', '赋予角色', null, 'fyjs', '为系统中的用户授予角色', '2', 'userRole/list', '32', '30', '0', '0');
INSERT INTO `sys_auth` VALUES ('44', '考勤管理', null, 'kqgl', '统计员工的考勤', '1', '', '-1', '70', '0', '0');
INSERT INTO `sys_auth` VALUES ('45', '授予权限', null, 'syqx', '为系统中的角色授予权限', '2', 'roleAuth/list', '32', '40', '0', '0');
INSERT INTO `sys_auth` VALUES ('46', '赋角', null, 'fj', '为系统中的员工赋予角色', '3', '', '43', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('47', '授权', null, 'sq', '为系统中的角色授予权限', '3', '', '45', '10', '1', '0');
INSERT INTO `sys_auth` VALUES ('48', '取消授权', null, 'qxsq', '删除角色的权限，取消其权限', '3', '', '45', '20', '1', '0');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(5) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  `role_code` varchar(20) DEFAULT NULL,
  `role_desc` varchar(20) DEFAULT NULL,
  `orders` int(5) DEFAULT NULL,
  `is_valid` int(1) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '高层', 'gc', '公司的最高决策者、负责管理公司', '10', '0');
INSERT INTO `sys_role` VALUES ('2', '主管', 'zg', '负责执行高层发布的工作及管理各自部门员工', '20', '0');
INSERT INTO `sys_role` VALUES ('3', '职员', 'zy', '负责执行上司发布的日常工作', '30', '0');
INSERT INTO `sys_role` VALUES ('4', '中层', 'zc', 'test', '40', '1');

-- ----------------------------
-- Table structure for sys_role_auth
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_auth`;
CREATE TABLE `sys_role_auth` (
  `dbid` int(5) NOT NULL AUTO_INCREMENT,
  `role_id` int(5) DEFAULT NULL,
  `auth_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`dbid`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_auth
-- ----------------------------
INSERT INTO `sys_role_auth` VALUES ('1', '1', '1');
INSERT INTO `sys_role_auth` VALUES ('2', '1', '2');
INSERT INTO `sys_role_auth` VALUES ('3', '1', '3');
INSERT INTO `sys_role_auth` VALUES ('4', '1', '4');
INSERT INTO `sys_role_auth` VALUES ('5', '1', '5');
INSERT INTO `sys_role_auth` VALUES ('6', '1', '6');
INSERT INTO `sys_role_auth` VALUES ('7', '1', '7');
INSERT INTO `sys_role_auth` VALUES ('8', '1', '8');
INSERT INTO `sys_role_auth` VALUES ('9', '1', '9');
INSERT INTO `sys_role_auth` VALUES ('10', '1', '10');
INSERT INTO `sys_role_auth` VALUES ('11', '1', '11');
INSERT INTO `sys_role_auth` VALUES ('12', '1', '12');
INSERT INTO `sys_role_auth` VALUES ('13', '1', '13');
INSERT INTO `sys_role_auth` VALUES ('14', '1', '14');
INSERT INTO `sys_role_auth` VALUES ('15', '1', '15');
INSERT INTO `sys_role_auth` VALUES ('16', '1', '16');
INSERT INTO `sys_role_auth` VALUES ('17', '1', '17');
INSERT INTO `sys_role_auth` VALUES ('18', '1', '18');
INSERT INTO `sys_role_auth` VALUES ('19', '1', '19');
INSERT INTO `sys_role_auth` VALUES ('20', '1', '20');
INSERT INTO `sys_role_auth` VALUES ('21', '1', '21');
INSERT INTO `sys_role_auth` VALUES ('22', '1', '22');
INSERT INTO `sys_role_auth` VALUES ('23', '1', '23');
INSERT INTO `sys_role_auth` VALUES ('24', '1', '24');
INSERT INTO `sys_role_auth` VALUES ('25', '1', '25');
INSERT INTO `sys_role_auth` VALUES ('26', '1', '26');
INSERT INTO `sys_role_auth` VALUES ('27', '1', '27');
INSERT INTO `sys_role_auth` VALUES ('28', '1', '28');
INSERT INTO `sys_role_auth` VALUES ('29', '1', '29');
INSERT INTO `sys_role_auth` VALUES ('30', '1', '30');
INSERT INTO `sys_role_auth` VALUES ('31', '1', '31');
INSERT INTO `sys_role_auth` VALUES ('32', '1', '32');
INSERT INTO `sys_role_auth` VALUES ('33', '1', '33');
INSERT INTO `sys_role_auth` VALUES ('34', '1', '34');
INSERT INTO `sys_role_auth` VALUES ('35', '1', '35');
INSERT INTO `sys_role_auth` VALUES ('36', '1', '36');
INSERT INTO `sys_role_auth` VALUES ('37', '1', '37');
INSERT INTO `sys_role_auth` VALUES ('38', '1', '38');
INSERT INTO `sys_role_auth` VALUES ('39', '1', '39');
INSERT INTO `sys_role_auth` VALUES ('40', '1', '40');
INSERT INTO `sys_role_auth` VALUES ('41', '2', '10');
INSERT INTO `sys_role_auth` VALUES ('42', '3', '41');
INSERT INTO `sys_role_auth` VALUES ('43', '3', '42');
INSERT INTO `sys_role_auth` VALUES ('44', '1', '43');
INSERT INTO `sys_role_auth` VALUES ('45', '1', '45');
INSERT INTO `sys_role_auth` VALUES ('46', '1', '47');
INSERT INTO `sys_role_auth` VALUES ('47', '1', '46');
INSERT INTO `sys_role_auth` VALUES ('53', '1', '48');
INSERT INTO `sys_role_auth` VALUES ('54', '2', '11');
INSERT INTO `sys_role_auth` VALUES ('56', '2', '12');
INSERT INTO `sys_role_auth` VALUES ('57', '2', '1');
INSERT INTO `sys_role_auth` VALUES ('61', '2', '2');
INSERT INTO `sys_role_auth` VALUES ('62', '2', '6');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(36) NOT NULL,
  `password` varchar(36) NOT NULL,
  `emp_name` varchar(36) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `age` int(3) DEFAULT NULL,
  `job_id` int(5) DEFAULT NULL,
  `idcard` varchar(25) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `dept_id` int(5) DEFAULT NULL,
  `salary` double(15,2) DEFAULT NULL,
  `bonus` double(10,2) DEFAULT NULL,
  `hiredate` datetime DEFAULT NULL,
  `seniority` int(5) DEFAULT NULL,
  `is_valid` int(1) DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '9aa75c4d70930277f59d117ce19188b0', '王欣欣', '1', '21', '1', '370112199804102527', '839650334@qq.com', '13245402527', '1', '500000.00', '100000.00', '2019-01-07 10:31:05', '10', '0');
INSERT INTO `sys_user` VALUES ('2', 'zs', 'ee1d6c51d20fbdc2f7d7de3831986f0e', '张世明', '0', '40', '4', '712552537447474444', '487998989@qq.com', '15466444665', '4', null, null, '2019-01-07 10:32:02', null, '0');
INSERT INTO `sys_user` VALUES ('3', 'ls', 'a3e5736f06fbd1a0458afedf9effa083', '李世全', '1', '1', '3', '358456556565788', '8575715@qq.com', '15355544588', '3', null, null, '2019-01-07 10:32:43', null, '0');
INSERT INTO `sys_user` VALUES ('4', 'xx', 'a4df11564c393d7e91dfbe1dc8d2443a', '钱多多', '1', '1', '1', '1', '1', '1', '2', '1.00', '1.00', '2019-01-08 09:37:28', '1', '1');
INSERT INTO `sys_user` VALUES ('5', 'rrsx', 'rrsx', '陈洁洁', '0', '20', '3', '124242425452425', '839650334@qq.com', '15484566658', '3', '4500.00', '200.00', '2019-01-15 16:42:43', '2', '0');
INSERT INTO `sys_user` VALUES ('6', 'wwxx', 'b0d17ce98a532d84a0b0f0a83c28fee1', '王鑫', '0', '25', '3', '370154866686465654', '5556466668@qq.com', '15956486866', null, null, null, '2019-01-16 09:27:30', '0', '0');
INSERT INTO `sys_user` VALUES ('7', 'miaoqing', '4176011c5e1ae55a0db39eb6e2925dcd', '苗青青', '1', '21', '8', '370154413513235', '11516535@qq.com', '16531252333', '5', null, null, '2019-01-20 14:47:45', null, '0');
INSERT INTO `sys_user` VALUES ('8', 'kaili', '1df03ad674b3ea1c831ad61d2e31a5f5', '凯丽丽', '1', '21', '9', '364605446555332851', '214851645@qq.com', '15654666667', null, null, null, '2019-01-20 15:02:15', '0', '0');
INSERT INTO `sys_user` VALUES ('9', 'xiaojuzi', '85766d9703fe7160d05ea9db7ce38a37', '小橘子', '1', '21', '7', '374684466666644411', '18485546@qq.com', '15546666666', '2', null, null, '2019-01-20 15:03:51', null, '0');
INSERT INTO `sys_user` VALUES ('10', 'qingtian', '5bbed2198265f6cd1565e7a262bac456', '晴天', '0', '22', '10', '179644656664666', '84646666@qq.com', '15566955548', '2', '4000.00', null, '2019-01-20 16:30:23', '0', '0');
INSERT INTO `sys_user` VALUES ('11', 'luori', '27a38c5da961c8c1f0a2538b81ce0330', '落日', '1', '23', '7', '354664666464666879', '87415565@qq.com', '15596665898', '2', '4500.00', null, '2019-01-20 16:31:56', '0', '0');
INSERT INTO `sys_user` VALUES ('12', 'mengxiang', 'd4e2af10620032d8ad2ea694d2c87b01', '梦想', '0', '23', '6', '375002113334433352', '589456648@qq.com', '15654666885', '4', '3000.00', null, '2019-01-20 19:07:57', '0', '0');
INSERT INTO `sys_user` VALUES ('20', 'hahaha', '6743d2b5f0a1f7ee4f8b3cbb0066579b', '老李', '0', '30', '1', '140425198705040098', '123@qq.com', '18234576928', null, null, null, '2019-01-14 00:00:00', null, '1');
INSERT INTO `sys_user` VALUES ('21', 'wxx', '8ace881e05906148c57bb00141af2941', '王xx', '1', '31', '4', '371531351531535', '86443536@qq.com', '15645556565', null, null, null, '2019-01-24 16:19:51', null, '0');
INSERT INTO `sys_user` VALUES ('22', 'ddd', '8bcf21dec748c5cf70968b6aef951119', 'd大大', '1', '21', '9', '371546565555353', '8696633653@qq.com', '15455646664', '2', null, null, '2019-01-24 16:20:48', null, '0');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `dbid` int(5) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) DEFAULT NULL,
  `role_id` int(5) DEFAULT NULL,
  PRIMARY KEY (`dbid`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '1', '1');
INSERT INTO `sys_user_role` VALUES ('2', '2', '2');
INSERT INTO `sys_user_role` VALUES ('3', '3', '3');
INSERT INTO `sys_user_role` VALUES ('4', '4', null);
INSERT INTO `sys_user_role` VALUES ('5', '7', '2');
INSERT INTO `sys_user_role` VALUES ('8', '10', '3');
INSERT INTO `sys_user_role` VALUES ('9', '9', null);
INSERT INTO `sys_user_role` VALUES ('13', '8', '2');
INSERT INTO `sys_user_role` VALUES ('14', '5', '3');
INSERT INTO `sys_user_role` VALUES ('15', '6', '3');
INSERT INTO `sys_user_role` VALUES ('16', '11', '3');
INSERT INTO `sys_user_role` VALUES ('17', '12', null);
INSERT INTO `sys_user_role` VALUES ('18', '22', '2');

-- ----------------------------
-- Table structure for trip_record
-- ----------------------------
DROP TABLE IF EXISTS `trip_record`;
CREATE TABLE `trip_record` (
  `trip_id` int(5) NOT NULL AUTO_INCREMENT,
  `user_id` int(5) DEFAULT NULL,
  `trip_city` varchar(20) DEFAULT NULL,
  `trip_reason` varchar(60) DEFAULT NULL,
  `trip_start` datetime DEFAULT NULL,
  `trip_end` datetime DEFAULT NULL,
  `days` int(5) DEFAULT NULL,
  `trip_money` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`trip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of trip_record
-- ----------------------------
