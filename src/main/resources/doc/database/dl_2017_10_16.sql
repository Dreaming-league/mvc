/*
 Navicat MySQL Data Transfer

 Source Server         : local
 Source Server Version : 50711
 Source Host           : localhost
 Source Database       : dl

 Target Server Version : 50711
 File Encoding         : utf-8

 Date: 10/16/2017 23:41:56 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `helloworld`
-- ----------------------------
DROP TABLE IF EXISTS `helloworld`;
CREATE TABLE `helloworld` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `message` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试练习表';

-- ----------------------------
--  Table structure for `shiro_authorization`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_authorization`;
CREATE TABLE `shiro_authorization` (
  `id` varchar(32) NOT NULL,
  `parentId` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL COMMENT '权限名称',
  `permission` varchar(32) DEFAULT NULL COMMENT '权限标识',
  `type` varchar(32) DEFAULT NULL COMMENT '权限类型',
  `isActive` tinyint(1) DEFAULT '0' COMMENT '是否有效/启用',
  `isDelete` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除',
  `createdBy` varchar(32) DEFAULT NULL COMMENT 'createdBy',
  `updatedBy` varchar(32) DEFAULT NULL COMMENT 'updatedBy',
  `createdTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
--  Records of `shiro_authorization`
-- ----------------------------
BEGIN;
INSERT INTO `shiro_authorization` VALUES ('0', '0', '浏览', 'shiro:view', '1', '1', '0', 'xx', 'xx', '2017-10-16 22:19:31', '2017-10-16 22:19:31', null);
COMMIT;

-- ----------------------------
--  Table structure for `shiro_group`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_group`;
CREATE TABLE `shiro_group` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `order` int(32) DEFAULT '0' COMMENT '排序',
  `isActive` tinyint(1) DEFAULT '0' COMMENT '是否有效/启用',
  `isDelete` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除',
  `createdBy` varchar(32) DEFAULT NULL COMMENT 'createdBy',
  `updatedBy` varchar(32) DEFAULT NULL COMMENT 'updatedBy',
  `createdTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组表';

-- ----------------------------
--  Records of `shiro_group`
-- ----------------------------
BEGIN;
INSERT INTO `shiro_group` VALUES ('0', '公共开发组', '0', '1', '0', 'xx', 'xx', '2017-10-16 22:14:11', '2017-10-16 22:14:11', null);
COMMIT;

-- ----------------------------
--  Table structure for `shiro_group_role_relation`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_group_role_relation`;
CREATE TABLE `shiro_group_role_relation` (
  `groupId` varchar(32) NOT NULL COMMENT '组ID',
  `roleId` varchar(32) NOT NULL COMMENT '角色ID',
  `isActive` tinyint(1) DEFAULT '0' COMMENT '是否有效/启用',
  `createdBy` varchar(32) DEFAULT NULL COMMENT 'createdBy',
  `updatedBy` varchar(32) DEFAULT NULL COMMENT 'updatedBy',
  `createdTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`groupId`,`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组角色关联表';

-- ----------------------------
--  Records of `shiro_group_role_relation`
-- ----------------------------
BEGIN;
INSERT INTO `shiro_group_role_relation` VALUES ('0', '0', '1', 'xx', 'xx', '2017-10-16 22:15:51', '2017-10-16 22:15:51', null);
COMMIT;

-- ----------------------------
--  Table structure for `shiro_menu`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_menu`;
CREATE TABLE `shiro_menu` (
  `id` varchar(32) NOT NULL,
  `parentId` varchar(32) NOT NULL COMMENT '父级ID',
  `name` varchar(32) DEFAULT NULL COMMENT '菜单名称',
  `type` varchar(32) DEFAULT NULL COMMENT '类型',
  `icon` varchar(32) DEFAULT NULL COMMENT '图标',
  `url` varchar(32) DEFAULT NULL COMMENT 'URL',
  `accessCode` varchar(32) DEFAULT NULL COMMENT '访问码',
  `order` int(32) DEFAULT '0' COMMENT '顺序',
  `isActive` tinyint(1) DEFAULT '0' COMMENT '是否有效/启用',
  `isDelete` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除',
  `createdBy` varchar(32) DEFAULT NULL COMMENT 'createdBy',
  `updatedBy` varchar(32) DEFAULT NULL COMMENT 'updatedBy',
  `createdTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `e` varchar(32) DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
--  Table structure for `shiro_menu_authorization_relation`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_menu_authorization_relation`;
CREATE TABLE `shiro_menu_authorization_relation` (
  `menuId` varchar(32) NOT NULL COMMENT '组ID',
  `authId` varchar(32) NOT NULL COMMENT '角色ID',
  `isActive` tinyint(1) DEFAULT '0' COMMENT '是否有效/启用',
  `isDelete` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除',
  `createdBy` varchar(32) DEFAULT NULL COMMENT 'createdBy',
  `updatedBy` varchar(32) DEFAULT NULL COMMENT 'updatedBy',
  `createdTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`menuId`,`authId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限关联表';

-- ----------------------------
--  Table structure for `shiro_role`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role`;
CREATE TABLE `shiro_role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(32) DEFAULT NULL,
  `permission` varchar(32) DEFAULT NULL COMMENT '角色标识',
  `isActive` tinyint(1) DEFAULT '0' COMMENT '是否有效/启用',
  `isDelete` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除',
  `createdBy` varchar(32) DEFAULT NULL COMMENT 'createdBy',
  `updatedBy` varchar(32) DEFAULT NULL COMMENT 'updatedBy',
  `createdTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `e` varchar(32) DEFAULT NULL COMMENT '扩展字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
--  Records of `shiro_role`
-- ----------------------------
BEGIN;
INSERT INTO `shiro_role` VALUES ('0', '普通用户', 'defaultRole', '1', '0', 'xx', 'xx', '2016-10-09 12:12:12', '2016-10-09 12:12:12', null, null);
COMMIT;

-- ----------------------------
--  Table structure for `shiro_role_authorization_relation`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_role_authorization_relation`;
CREATE TABLE `shiro_role_authorization_relation` (
  `roleId` varchar(32) NOT NULL COMMENT '角色ID',
  `authId` varchar(32) NOT NULL COMMENT '权限ID',
  `isActive` tinyint(1) DEFAULT '0' COMMENT '是否有效/启用',
  `createdBy` varchar(32) DEFAULT NULL COMMENT 'createdBy',
  `updatedBy` varchar(32) DEFAULT NULL COMMENT 'updatedBy',
  `createdTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`roleId`,`authId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
--  Records of `shiro_role_authorization_relation`
-- ----------------------------
BEGIN;
INSERT INTO `shiro_role_authorization_relation` VALUES ('0', '0', '1', 'xx', 'xx', '2016-10-09 12:12:12', '2016-10-09 18:18:19', 'n');
COMMIT;

-- ----------------------------
--  Table structure for `shiro_user`
-- ----------------------------
DROP TABLE IF EXISTS `shiro_user`;
CREATE TABLE `shiro_user` (
  `id` varchar(32) NOT NULL,
  `groupId` varchar(32) DEFAULT NULL COMMENT '组ID',
  `account` varchar(32) DEFAULT NULL COMMENT '登录账号',
  `pwd` varchar(32) DEFAULT NULL COMMENT '登录密码',
  `nickName` varchar(32) DEFAULT NULL COMMENT '昵称',
  `photo` varchar(32) DEFAULT NULL COMMENT '头像',
  `sign` varchar(32) DEFAULT NULL COMMENT '签名',
  `skin` varchar(32) DEFAULT NULL COMMENT '皮肤',
  `score` int(11) DEFAULT NULL COMMENT '分数',
  `honor` varchar(32) DEFAULT NULL COMMENT '荣誉称号',
  `realName` varchar(32) DEFAULT NULL COMMENT '真实姓名',
  `sex` varchar(32) DEFAULT NULL COMMENT '性别',
  `NID` varchar(32) DEFAULT NULL COMMENT '身份证号:National ID number',
  `phone` varchar(32) DEFAULT NULL COMMENT '手机号',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `company` varchar(32) DEFAULT NULL COMMENT '所在的公司',
  `title` varchar(32) DEFAULT NULL COMMENT '职称',
  `position` varchar(32) DEFAULT NULL COMMENT '职位',
  `QQ` varchar(32) DEFAULT NULL COMMENT 'QQ',
  `weChat` varchar(32) DEFAULT NULL COMMENT '微信号',
  `QRCode` varchar(32) DEFAULT NULL COMMENT '微信二维码',
  `microBlog` varchar(32) DEFAULT NULL COMMENT '新浪微博账号',
  `renRen` varchar(32) DEFAULT NULL COMMENT '人人网账号',
  `twitter` varchar(32) DEFAULT NULL COMMENT 'twitter',
  `facebook` varchar(32) DEFAULT NULL COMMENT 'facebook',
  `postcode` varchar(32) DEFAULT NULL COMMENT '邮政编码',
  `nowAddress` varchar(32) DEFAULT NULL COMMENT '现地址',
  `homeland` varchar(32) DEFAULT NULL COMMENT '故乡',
  `isActive` tinyint(1) DEFAULT '0' COMMENT '是否有效/启用',
  `isSys` tinyint(1) DEFAULT '1' COMMENT '是否系统用户',
  `isDelete` tinyint(1) DEFAULT '0' COMMENT '是否逻辑删除',
  `createdBy` varchar(32) DEFAULT NULL COMMENT 'createdBy',
  `updatedBy` varchar(32) DEFAULT NULL COMMENT 'updatedBy',
  `createdTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Records of `shiro_user`
-- ----------------------------
BEGIN;
INSERT INTO `shiro_user` VALUES ('0', '0', '290315636@qq.com', 'DIjVZpTC+zvMQW4SLBBy6w==', 'tikie', 'xx', 'xx', 'xx', '1', 'xx', 'xx', null, '1234567890', '13621239684', '290315636@qq.com', 'xx', 'xx', 'xx', '2', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w', '1', '1', '0', 'w', 'w', '2016-10-04 00:00:00', '2017-10-16 23:39:21', 'w');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
