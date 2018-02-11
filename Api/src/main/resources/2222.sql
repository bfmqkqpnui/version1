-- --------------------------------------------------------
-- 主机:                           47.98.49.235
-- 服务器版本:                        5.7.21 - MySQL Community Server (GPL)
-- 服务器操作系统:                      Linux
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 sleepingbag 的数据库结构
DROP DATABASE IF EXISTS `sleepingbag`;
CREATE DATABASE IF NOT EXISTS `sleepingbag` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sleepingbag`;

-- 导出  表 sleepingbag.t_admin 结构
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE IF NOT EXISTS `t_admin` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `userName` varchar(255) NOT NULL DEFAULT '' COMMENT '登录账户',
  `passWord` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `nickName` varchar(255) NOT NULL DEFAULT '' COMMENT '管理员昵称',
  `roleId` varchar(255) NOT NULL DEFAULT '' COMMENT '角色主键',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '管理员名字',
  `phone` varchar(255) NOT NULL DEFAULT '' COMMENT '管理员手机号',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态(0禁用，1启用)',
  `token` varchar(255) NOT NULL DEFAULT '' COMMENT '登录验证令牌',
  `headImg` varchar(255) NOT NULL DEFAULT '' COMMENT '管理员头像地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- 正在导出表  sleepingbag.t_admin 的数据：~2 rows (大约)
DELETE FROM `t_admin`;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` (`id`, `userName`, `passWord`, `nickName`, `roleId`, `name`, `phone`, `status`, `token`, `headImg`) VALUES
	('1', 'admin', '21232f297a57a5a743894a0e4a801fc3', '管理员', '1', '管理员', '13366668888', 1, 'eyJhZG1pbklkIjoiMSIsImVuZFRpbWUiOjE1MTgyNDI4MzA4MDAsImlwIjoiIiwic3RhcnRUaW1lIjoxNTE4MjQxMDMwODAwfQ==', ''),
	('8dd54815-bdd9-4621-9e73-cdd215641c36', 'jacky', '9661fd65249b026ebea0f49927e82f0e', '测试员一', '2', 'Jacky Wang', '18068334585', 1, 'eyJhZG1pbklkIjoiOGRkNTQ4MTUtYmRkOS00NjIxLTllNzMtY2RkMjE1NjQxYzM2IiwiZW5kVGltZSI6MTUxNzc1MzA0MzE5MCwiaXAiOiIiLCJzdGFydFRpbWUiOjE1MTc3NTEyNDMxOTB9', '');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_baby 结构
DROP TABLE IF EXISTS `t_baby`;
CREATE TABLE IF NOT EXISTS `t_baby` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `nickName` varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
  `sex` varchar(255) NOT NULL DEFAULT '' COMMENT '性别',
  `birthDate` varchar(255) NOT NULL DEFAULT '' COMMENT '出生日期',
  `stature` varchar(255) NOT NULL DEFAULT '' COMMENT '身高',
  `weight` varchar(255) NOT NULL DEFAULT '' COMMENT '体重',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户宝贝详情表';

-- 正在导出表  sleepingbag.t_baby 的数据：~0 rows (大约)
DELETE FROM `t_baby`;
/*!40000 ALTER TABLE `t_baby` DISABLE KEYS */;
INSERT INTO `t_baby` (`id`, `nickName`, `sex`, `birthDate`, `stature`, `weight`) VALUES
	('1', '小杰克', '女', '2018-01-01', '15', '4');
/*!40000 ALTER TABLE `t_baby` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_babybag 结构
DROP TABLE IF EXISTS `t_babybag`;
CREATE TABLE IF NOT EXISTS `t_babybag` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `babyId` varchar(255) NOT NULL DEFAULT '' COMMENT '宝贝主键',
  `bagId` varchar(255) NOT NULL DEFAULT '' COMMENT '设备主键',
  `bindingStatus` int(11) NOT NULL DEFAULT '0' COMMENT '绑定状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='宝贝，睡袋关系表';

-- 正在导出表  sleepingbag.t_babybag 的数据：~4 rows (大约)
DELETE FROM `t_babybag`;
/*!40000 ALTER TABLE `t_babybag` DISABLE KEYS */;
INSERT INTO `t_babybag` (`id`, `babyId`, `bagId`, `bindingStatus`) VALUES
	('1', '1', '1', 1),
	('2', '', '2', 0),
	('3', '', '3', 0),
	('4', '', '4', 0);
/*!40000 ALTER TABLE `t_babybag` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_bag 结构
DROP TABLE IF EXISTS `t_bag`;
CREATE TABLE IF NOT EXISTS `t_bag` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `deviceCode` varchar(255) NOT NULL DEFAULT '' COMMENT '设备唯一码',
  `firmwareVersion` varchar(255) NOT NULL DEFAULT '' COMMENT '固件版本',
  `electricQuantity` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT '电量',
  `posture` int(11) NOT NULL DEFAULT '0' COMMENT '睡姿',
  `temperature` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT '温度',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '状态(0禁用,1启用)',
  `bindingStatus` int(11) NOT NULL DEFAULT '0' COMMENT '绑定状态(0未绑定,1已绑定)',
  `lastUpdateTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `d1` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D1',
  `d2` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D2',
  `d3` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D3',
  `d4` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D4',
  `d5` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D5',
  `d6` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D6',
  `d7` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D7',
  `d8` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D8',
  `d9` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D9',
  `d10` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D10',
  `d11` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D11',
  `d12` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D12',
  `d13` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D13',
  `d14` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D14',
  `d15` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT 'D15',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='设备现状表';

-- 正在导出表  sleepingbag.t_bag 的数据：~4 rows (大约)
DELETE FROM `t_bag`;
/*!40000 ALTER TABLE `t_bag` DISABLE KEYS */;
INSERT INTO `t_bag` (`id`, `deviceCode`, `firmwareVersion`, `electricQuantity`, `posture`, `temperature`, `status`, `bindingStatus`, `lastUpdateTime`, `d1`, `d2`, `d3`, `d4`, `d5`, `d6`, `d7`, `d8`, `d9`, `d10`, `d11`, `d12`, `d13`, `d14`, `d15`) VALUES
	('1', '0000001', '1.0.0.1', 75.00, 1, 27.00, 1, 0, '2018-02-09 18:33:51', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00),
	('2', '0000002', '1.0.0.1', 0.00, 0, 0.00, 1, 0, '2018-02-07 22:17:40', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00),
	('3', '0000003', '1.0.0.1', 0.00, 0, 0.00, 1, 0, '2018-02-07 22:18:00', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00),
	('4', '0000004', '1.0.0.1', 0.00, 0, 0.00, 1, 0, '2018-02-07 22:18:40', 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00, 0.00);
/*!40000 ALTER TABLE `t_bag` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_bagrecord 结构
DROP TABLE IF EXISTS `t_bagrecord`;
CREATE TABLE IF NOT EXISTS `t_bagrecord` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `bagId` varchar(255) NOT NULL DEFAULT '' COMMENT '设备主键',
  `date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '提交时间',
  `deviceCode` varchar(255) NOT NULL DEFAULT '' COMMENT '设备唯一码',
  `firmwareVersion` varchar(255) NOT NULL DEFAULT '' COMMENT '固件版本',
  `electricQuantity` decimal(15,2) NOT NULL DEFAULT '0.00' COMMENT '电量',
  `posture` int(11) NOT NULL DEFAULT '0' COMMENT '睡姿',
  `temperature` decimal(15,1) NOT NULL DEFAULT '0.0' COMMENT '温度',
  `d1` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D1',
  `d2` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D2',
  `d3` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D3',
  `d4` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D4',
  `d5` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D5',
  `d6` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D6',
  `d7` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D7',
  `d8` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D8',
  `d9` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D9',
  `d10` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D10',
  `d11` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D11',
  `d12` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D12',
  `d13` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D13',
  `d14` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D14',
  `d15` decimal(15,4) NOT NULL DEFAULT '0.0000' COMMENT 'D15',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='睡袋提交记录表';

-- 正在导出表  sleepingbag.t_bagrecord 的数据：~11 rows (大约)
DELETE FROM `t_bagrecord`;
/*!40000 ALTER TABLE `t_bagrecord` DISABLE KEYS */;
INSERT INTO `t_bagrecord` (`id`, `bagId`, `date`, `deviceCode`, `firmwareVersion`, `electricQuantity`, `posture`, `temperature`, `d1`, `d2`, `d3`, `d4`, `d5`, `d6`, `d7`, `d8`, `d9`, `d10`, `d11`, `d12`, `d13`, `d14`, `d15`) VALUES
	('1', '1', '2018-02-06 18:29:09', '0000001', '1.0.0.1', 100.00, 1, 27.0, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
	('10', '1', '2018-02-07 18:33:37', '0000001', '1.0.0.1', 97.50, 2, 27.0, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
	('11', '1', '2018-02-09 18:33:51', '0000001', '1.0.0.1', 97.00, 1, 27.0, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
	('2', '1', '2018-02-05 18:29:44', '0000001', '1.0.0.1', 100.00, 2, 26.5, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
	('3', '1', '2018-02-04 18:31:03', '0000001', '1.0.0.1', 99.50, 1, 27.0, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
	('4', '1', '2018-02-07 18:31:29', '0000001', '1.0.0.1', 99.50, 2, 26.5, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
	('5', '1', '2018-02-07 18:31:44', '0000001', '1.0.0.1', 99.00, 3, 26.5, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
	('6', '1', '2018-02-07 18:32:11', '0000001', '1.0.0.1', 99.00, 4, 26.5, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
	('7', '1', '2018-02-07 18:32:34', '0000001', '1.0.0.1', 98.50, 3, 27.0, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
	('8', '1', '2018-02-07 18:32:57', '0000001', '1.0.0.1', 98.00, 3, 27.0, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000),
	('9', '1', '2018-02-07 18:33:13', '0000001', '1.0.0.1', 97.50, 3, 27.0, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000, 0.0000);
/*!40000 ALTER TABLE `t_bagrecord` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_feedback 结构
DROP TABLE IF EXISTS `t_feedback`;
CREATE TABLE IF NOT EXISTS `t_feedback` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `userId` varchar(255) NOT NULL DEFAULT '' COMMENT '发问人主键',
  `userNickName` varchar(255) NOT NULL DEFAULT '' COMMENT '发问人昵称',
  `askBody` varchar(255) NOT NULL DEFAULT '' COMMENT '发问内容',
  `askTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发问时间',
  `adminId` varchar(255) NOT NULL DEFAULT '' COMMENT '回复反馈的管理员主键',
  `adminNickName` varchar(255) NOT NULL DEFAULT '' COMMENT '回复反馈的管理员昵称',
  `replyBody` varchar(255) NOT NULL DEFAULT '' COMMENT '回复内容',
  `replyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '回复时间',
  `replyFlag` int(11) NOT NULL DEFAULT '0' COMMENT '回复状态（0未回复，1已回复）',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户反馈表';

-- 正在导出表  sleepingbag.t_feedback 的数据：~0 rows (大约)
DELETE FROM `t_feedback`;
/*!40000 ALTER TABLE `t_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_feedback` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_phonehelp 结构
DROP TABLE IF EXISTS `t_phonehelp`;
CREATE TABLE IF NOT EXISTS `t_phonehelp` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `body` varchar(255) NOT NULL DEFAULT '' COMMENT '内容',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='手机帮助';

-- 正在导出表  sleepingbag.t_phonehelp 的数据：~0 rows (大约)
DELETE FROM `t_phonehelp`;
/*!40000 ALTER TABLE `t_phonehelp` DISABLE KEYS */;
INSERT INTO `t_phonehelp` (`id`, `body`) VALUES
	('1', '<p>测试数据<img src="HTTP://47.98.49.235/static/pic/1517646293169.png" style="max-width: 100%;">asd 哈哈哈</p>');
/*!40000 ALTER TABLE `t_phonehelp` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_role 结构
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE IF NOT EXISTS `t_role` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `roleName` varchar(255) NOT NULL DEFAULT '' COMMENT '角色名',
  `roleOptionIds` text NOT NULL COMMENT '角色权限主键列表用，连接',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员角色';

-- 正在导出表  sleepingbag.t_role 的数据：~3 rows (大约)
DELETE FROM `t_role`;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` (`id`, `roleName`, `roleOptionIds`) VALUES
	('1', '系统管理员', '1,2,3,4,5,6,8,7'),
	('2', '客服', '3,4,5,6'),
	('3', '总部报表', '7');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_roleoption 结构
DROP TABLE IF EXISTS `t_roleoption`;
CREATE TABLE IF NOT EXISTS `t_roleoption` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `optionName` varchar(255) NOT NULL DEFAULT '' COMMENT '权限名',
  `correlation` int(11) NOT NULL DEFAULT '0' COMMENT '关联功能',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限';

-- 正在导出表  sleepingbag.t_roleoption 的数据：~8 rows (大约)
DELETE FROM `t_roleoption`;
/*!40000 ALTER TABLE `t_roleoption` DISABLE KEYS */;
INSERT INTO `t_roleoption` (`id`, `optionName`, `correlation`) VALUES
	('1', '系统设置', 1),
	('2', '账户管理', 2),
	('3', '用户管理', 3),
	('4', '设备管理', 4),
	('5', '用户反馈', 5),
	('6', '帮助文档', 6),
	('7', '数据报表', 7),
	('8', '权限类目', 8);
/*!40000 ALTER TABLE `t_roleoption` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_user 结构
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE IF NOT EXISTS `t_user` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `userName` varchar(255) NOT NULL DEFAULT '' COMMENT '账户',
  `passWord` varchar(255) NOT NULL DEFAULT '' COMMENT '密码',
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '姓名',
  `nickname` varchar(255) NOT NULL DEFAULT '' COMMENT '昵称',
  `sex` varchar(255) NOT NULL DEFAULT '' COMMENT '性别',
  `verificationCode` varchar(255) NOT NULL DEFAULT '' COMMENT '验证码',
  `grade` int(11) NOT NULL DEFAULT '0' COMMENT '用户评分',
  `identity` varchar(255) NOT NULL DEFAULT '' COMMENT '身份',
  `bagDeviceCode` varchar(255) NOT NULL DEFAULT '' COMMENT '最近绑定设备号',
  `bagId` varchar(255) NOT NULL DEFAULT '' COMMENT '最近绑定设备主键',
  `firmwareVersion` varchar(255) NOT NULL DEFAULT '' COMMENT '最近绑定设备固件版本',
  `babyName` varchar(255) NOT NULL DEFAULT '' COMMENT '最近绑定设备的宝贝名字',
  `bindingStatus` int(11) NOT NULL DEFAULT '0' COMMENT '绑定状态(0未绑定，1已绑定)',
  `lastUpdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后使用时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='App用户表';

-- 正在导出表  sleepingbag.t_user 的数据：~2 rows (大约)
DELETE FROM `t_user`;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` (`id`, `userName`, `passWord`, `name`, `nickname`, `sex`, `verificationCode`, `grade`, `identity`, `bagDeviceCode`, `bagId`, `firmwareVersion`, `babyName`, `bindingStatus`, `lastUpdate`) VALUES
	('1', '18068334585', 'e10adc3949ba59abbe56e057f20f883e', '王孙勇', '测试', '男', '123456', 5, '父亲', '0000001', '1', '1.0.0.1', '小杰克', 1, '2018-02-03 15:11:39'),
	('6e82adfa-4038-4837-80fa-f99f054976e2', '', 'd41d8cd98f00b204e9800998ecf8427e', '', '', '', '', 5, '', '', '', '', '', 0, '2018-02-05 11:13:24');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_userbaby 结构
DROP TABLE IF EXISTS `t_userbaby`;
CREATE TABLE IF NOT EXISTS `t_userbaby` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `userId` varchar(255) NOT NULL DEFAULT '' COMMENT '用户主键',
  `babyId` varchar(255) NOT NULL DEFAULT '' COMMENT '宝贝主键',
  `bindingStatus` int(11) NOT NULL DEFAULT '0' COMMENT '绑定状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户，宝贝关系表';

-- 正在导出表  sleepingbag.t_userbaby 的数据：~0 rows (大约)
DELETE FROM `t_userbaby`;
/*!40000 ALTER TABLE `t_userbaby` DISABLE KEYS */;
INSERT INTO `t_userbaby` (`id`, `userId`, `babyId`, `bindingStatus`) VALUES
	('1', '1', '1', 1);
/*!40000 ALTER TABLE `t_userbaby` ENABLE KEYS */;

-- 导出  表 sleepingbag.t_userbag 结构
DROP TABLE IF EXISTS `t_userbag`;
CREATE TABLE IF NOT EXISTS `t_userbag` (
  `id` varchar(255) NOT NULL DEFAULT '' COMMENT '主键',
  `userId` varchar(255) NOT NULL DEFAULT '' COMMENT '用户主键',
  `bagId` varchar(255) NOT NULL DEFAULT '' COMMENT '睡袋主键',
  `bindingStatus` int(11) NOT NULL DEFAULT '0' COMMENT '绑定状态',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户，睡袋关系表';

-- 正在导出表  sleepingbag.t_userbag 的数据：~4 rows (大约)
DELETE FROM `t_userbag`;
/*!40000 ALTER TABLE `t_userbag` DISABLE KEYS */;
INSERT INTO `t_userbag` (`id`, `userId`, `bagId`, `bindingStatus`) VALUES
	('1', '1', '1', 1),
	('2', '', '2', 0),
	('3', '', '3', 0),
	('4', '', '4', 0);
/*!40000 ALTER TABLE `t_userbag` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
