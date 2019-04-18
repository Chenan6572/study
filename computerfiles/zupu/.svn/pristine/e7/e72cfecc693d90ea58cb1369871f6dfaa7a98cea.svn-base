# Host: 192.168.199.149  (Version: 5.6.26)
# Date: 2019-01-18 18:29:34
# Generator: MySQL-Front 5.3  (Build 4.234)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "family"
#

DROP TABLE IF EXISTS `family`;
CREATE TABLE `family` (
  `ID` int(11) NOT NULL COMMENT '标识对应用户 ID',
  `familyCode` varchar(10) NOT NULL COMMENT '族谱 ID',
  `familyName` varchar(20) NOT NULL COMMENT '族谱名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "family"
#

INSERT INTO `family` VALUES (1,'100000','管理员之家');

#
# Structure for table "familymember"
#

DROP TABLE IF EXISTS `familymember`;
CREATE TABLE `familymember` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '标识',
  `familyCode` varchar(10) NOT NULL COMMENT '所属族谱',
  `memberName` varchar(20) DEFAULT NULL COMMENT '显示名称',
  `memberphone` varchar(11) DEFAULT NULL COMMENT '成员电话',
  `memberidcard` varchar(18) DEFAULT NULL COMMENT '身份证',
  `parentmember` int(11) NOT NULL COMMENT '上级成员',
  `parentrelation` varchar(2) DEFAULT NULL,
  `membersex` char(2) DEFAULT NULL COMMENT '性别',
  `memberliving` tinyint(4) NOT NULL DEFAULT '0' COMMENT '健在',
  `memberstate` tinyint(4) NOT NULL DEFAULT '0' COMMENT '成员状态',
  `memberPhoto` varchar(45) DEFAULT NULL COMMENT '亲人照片',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

#
# Data for table "familymember"
#

INSERT INTO `familymember` VALUES (1,'100000','我','15944229500','22021119890213',0,'自己','男',1,0,NULL);

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `Loginname` varchar(32) DEFAULT NULL COMMENT '登录名称',
  `Username` varchar(20) DEFAULT NULL COMMENT '用户姓名',
  `Password` varchar(32) DEFAULT NULL COMMENT '用户密码',
  `Nickname` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `Token` varchar(32) DEFAULT NULL COMMENT '登录令牌',
  `familyCode` varchar(10) DEFAULT NULL COMMENT '注册用户族谱编码',
  `Photo` varchar(50) DEFAULT NULL COMMENT '用户照片',
  KEY `ID` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'admin','管理员','123456','管理员',NULL,'100000',NULL),(2,'15944229500','姚忠吉','123456','超越梦想',NULL,'100001',NULL);
