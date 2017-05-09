/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50628
Source Host           : localhost:3306
Source Database       : health_db

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-05-09 23:54:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for class
-- ----------------------------
DROP TABLE IF EXISTS `class`;
CREATE TABLE `class` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL COMMENT '课程名称',
  `TEACHER_NAME` varchar(255) NOT NULL COMMENT '教师姓名',
  `TEACHER_ID` int(11) NOT NULL COMMENT '教师id',
  `DAYTIME` varchar(222) NOT NULL COMMENT '上课时间  周几',
  `PLACE` varchar(255) NOT NULL COMMENT '上课地点',
  `CLASS_TIME` varchar(255) NOT NULL COMMENT '上课开始时间',
  `END_TIME` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '上课结束时间',
  `LONG_TIME` varchar(255) DEFAULT NULL COMMENT '开课时间段',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class
-- ----------------------------
INSERT INTO `class` VALUES ('1', '222', '1111', '1', '1111', '1111', '2017-05-07 16:19:16', '2017-05-07 16:19:16', '1111');

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL COMMENT '器材名称',
  `PART` varchar(255) NOT NULL COMMENT '锻炼部位',
  `USEWAY` varchar(255) NOT NULL COMMENT '使用方法说明',
  `USEATTENTION` varchar(255) NOT NULL COMMENT '使用注意事项',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('1', '111', '11', '1111', '11111');

-- ----------------------------
-- Table structure for food
-- ----------------------------
DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL COMMENT '食物名称',
  `SORT` varchar(255) NOT NULL COMMENT '食物类别',
  `NUMBER` int(11) NOT NULL COMMENT '食物热量',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of food
-- ----------------------------
INSERT INTO `food` VALUES ('1', '111', '11', '11');

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `PROGRAM_ID` int(11) NOT NULL COMMENT '健身方案编号',
  `NAME` varchar(255) NOT NULL COMMENT '运动项目',
  `LOAD` double NOT NULL COMMENT '负荷',
  `INTERVAL` int(11) NOT NULL COMMENT '时间/间隔',
  `NUMBER` int(11) NOT NULL COMMENT '组次/次数',
  `POINTS` varchar(255) NOT NULL COMMENT '动作要点',
  `MATTER` varchar(255) NOT NULL COMMENT '注意事项',
  `FOOD` varchar(255) NOT NULL COMMENT '食物名称',
  `EAT_DATE` varchar(255) NOT NULL COMMENT '食用时间',
  `EAT_NUMBER` varchar(255) NOT NULL COMMENT '食用量',
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for login
-- ----------------------------
DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USERTYPE` char(1) NOT NULL COMMENT '用户类型',
  `USERNAME` varchar(255) NOT NULL COMMENT '账号',
  `PASSWORD` varchar(255) NOT NULL COMMENT '密码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of login
-- ----------------------------
INSERT INTO `login` VALUES ('1', '1', '111', '1111');
INSERT INTO `login` VALUES ('2', '2', '222', '2222');
INSERT INTO `login` VALUES ('3', '3', '333', '3333');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `no` varchar(25) DEFAULT NULL,
  `date` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', '123321213', '2016-11-22');

-- ----------------------------
-- Table structure for program
-- ----------------------------
DROP TABLE IF EXISTS `program`;
CREATE TABLE `program` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '健身方案编号',
  `CFMD` varchar(255) NOT NULL COMMENT '处方目的',
  `JSZYD` varchar(255) NOT NULL COMMENT '健身注意点',
  `TEACHER_NO` varchar(255) NOT NULL COMMENT '制作者名字',
  `DAYS` int(11) NOT NULL COMMENT '持续天数',
  `CREATE_DATE` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '添加日期',
  `NO` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of program
-- ----------------------------

-- ----------------------------
-- Table structure for standard
-- ----------------------------
DROP TABLE IF EXISTS `standard`;
CREATE TABLE `standard` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL COMMENT '运动项目',
  `SEX` char(1) NOT NULL COMMENT '性别',
  `START_AGE` int(11) NOT NULL COMMENT '开始年龄',
  `END_AGE` int(11) NOT NULL COMMENT '结束年龄',
  `ONE` double NOT NULL,
  `TWO` double NOT NULL,
  `THREE` double NOT NULL,
  `FOUR` double NOT NULL,
  `FIVE` double NOT NULL,
  `NUM` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of standard
-- ----------------------------

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `SEX` char(1) NOT NULL,
  `BIRTHDAY` varchar(22) DEFAULT '0000-00-00 00:00:00',
  `SFID` varchar(30) DEFAULT NULL,
  `PHONE` varchar(255) DEFAULT NULL,
  `JOB` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `JG` varchar(255) DEFAULT NULL,
  `TCDID` int(100) DEFAULT NULL,
  `JSFAID` int(100) DEFAULT NULL,
  `LOGIN_ID` int(11) NOT NULL COMMENT '登录表ID',
  `NO` varchar(10) NOT NULL COMMENT '编号',
  `AGE` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '111', '1', '2017-05-01', '111', '111', '1112', '111', '111', '111', '111', '3', '111', '11');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `SEX` char(1) NOT NULL,
  `BIRTHDAY` varchar(22) NOT NULL DEFAULT '0000-00-00 00:00:00',
  `SFID` varchar(255) NOT NULL,
  `PHONE` varchar(255) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `JG` varchar(255) NOT NULL,
  `LOGIN_ID` int(11) NOT NULL COMMENT '登录表ID',
  `NO` varchar(10) NOT NULL COMMENT '编号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', 'lala', '1', '1992-12-22', '11111111111', '11111111111', '1111111111111', '1111111111', '1', 'ddddd222');

-- ----------------------------
-- Table structure for test_data
-- ----------------------------
DROP TABLE IF EXISTS `test_data`;
CREATE TABLE `test_data` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_ID` int(11) NOT NULL COMMENT '测试人编号',
  `TEST_DATE` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '测试时间',
  `HEIGHT` double NOT NULL COMMENT '身高',
  `WEIGHT` double NOT NULL COMMENT '体重',
  `WAIST` double NOT NULL COMMENT '腰围',
  `HIP` double NOT NULL COMMENT '臀围',
  `PULMONARY` int(11) NOT NULL COMMENT '肺活量',
  `TJSY` double NOT NULL COMMENT '台阶试验',
  `WL` double NOT NULL COMMENT '握力',
  `YWQZ` int(11) NOT NULL COMMENT '仰卧起坐',
  `FWC` int(11) NOT NULL COMMENT '俯卧撑',
  `ZWTQQ` double NOT NULL COMMENT '坐位体前屈',
  `BMR` double NOT NULL COMMENT '基础代谢率',
  `YTB` double NOT NULL COMMENT '腰臀比',
  `BMI` double NOT NULL COMMENT '身高体重指数',
  `SJFXJY` varchar(255) DEFAULT NULL COMMENT '数据分析建议',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test_data
-- ----------------------------
INSERT INTO `test_data` VALUES ('1', '1', '2017-05-03 18:32:56', '100', '100', '100', '100', '100', '100', '100', '100', '100', '100', '1861.2', '1', '0.01', null);
SET FOREIGN_KEY_CHECKS=1;
