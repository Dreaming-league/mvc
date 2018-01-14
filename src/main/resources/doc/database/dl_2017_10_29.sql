-- MySQL dump 10.13  Distrib 5.7.11, for osx10.9 (x86_64)
--
-- Host: localhost    Database: dl
-- ------------------------------------------------------
-- Server version	5.7.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `helloworld`
--

DROP TABLE IF EXISTS `helloworld`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `helloworld` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT,
  `message` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='测试练习表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `helloworld`
--

LOCK TABLES `helloworld` WRITE;
/*!40000 ALTER TABLE `helloworld` DISABLE KEYS */;
/*!40000 ALTER TABLE `helloworld` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shiro_authorization`
--

DROP TABLE IF EXISTS `shiro_authorization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shiro_authorization`
--

LOCK TABLES `shiro_authorization` WRITE;
/*!40000 ALTER TABLE `shiro_authorization` DISABLE KEYS */;
INSERT INTO `shiro_authorization` VALUES ('0','#','浏览','shiro:look','1',1,0,'xx','xx','2017-10-16 14:19:31','2017-10-16 14:19:31',NULL),('1','0','访问','shiro:view','0',1,0,'xx','xx','2017-10-17 14:50:46','2017-10-17 14:50:46',NULL);
/*!40000 ALTER TABLE `shiro_authorization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shiro_group`
--

DROP TABLE IF EXISTS `shiro_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shiro_group`
--

LOCK TABLES `shiro_group` WRITE;
/*!40000 ALTER TABLE `shiro_group` DISABLE KEYS */;
INSERT INTO `shiro_group` VALUES ('0','公共开发组',0,1,0,'xx','xx','2017-10-16 14:14:11','2017-10-16 14:14:11',NULL),('1','研发一组',1,1,0,'yy','yy','2017-10-18 14:34:34','2017-10-18 14:34:34',NULL);
/*!40000 ALTER TABLE `shiro_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shiro_group_role_relation`
--

DROP TABLE IF EXISTS `shiro_group_role_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shiro_group_role_relation`
--

LOCK TABLES `shiro_group_role_relation` WRITE;
/*!40000 ALTER TABLE `shiro_group_role_relation` DISABLE KEYS */;
INSERT INTO `shiro_group_role_relation` VALUES ('0','0',1,'xx','xx','2017-10-16 14:15:51','2017-10-16 14:15:51',NULL),('1','1',1,'yy','yy','2017-10-18 15:07:13','2017-10-18 15:07:13',NULL);
/*!40000 ALTER TABLE `shiro_group_role_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shiro_menu`
--

DROP TABLE IF EXISTS `shiro_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shiro_menu`
--

LOCK TABLES `shiro_menu` WRITE;
/*!40000 ALTER TABLE `shiro_menu` DISABLE KEYS */;
INSERT INTO `shiro_menu` VALUES ('0','#','菜单管理','0','manager','/m/index.do',NULL,0,1,0,'xx','xx','2017-10-17 15:22:13','2017-10-17 15:22:13',NULL),('1','0','用户管理','1','user icon','/u/index',NULL,0,1,0,'xx','xx','2017-10-21 05:25:55','2017-10-21 05:25:55',NULL),('2','0','云盘','3','pan','/pan/index',NULL,0,1,0,'xx','xx','2017-10-21 05:28:03','2017-10-21 05:28:03',NULL),('3','2','图片管理','4','pic','pic',NULL,0,0,0,'xx','xx','2017-10-21 05:29:28','2017-10-21 05:29:28',NULL);
/*!40000 ALTER TABLE `shiro_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shiro_menu_authorization_relation`
--

DROP TABLE IF EXISTS `shiro_menu_authorization_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shiro_menu_authorization_relation` (
  `menuId` varchar(32) NOT NULL COMMENT '组ID',
  `authId` varchar(32) NOT NULL COMMENT '角色ID',
  `isActive` tinyint(1) DEFAULT '0' COMMENT '是否有效/启用',
  `createdBy` varchar(32) DEFAULT NULL COMMENT 'createdBy',
  `updatedBy` varchar(32) DEFAULT NULL COMMENT 'updatedBy',
  `createdTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `updatedTime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`menuId`,`authId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单权限关联表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shiro_menu_authorization_relation`
--

LOCK TABLES `shiro_menu_authorization_relation` WRITE;
/*!40000 ALTER TABLE `shiro_menu_authorization_relation` DISABLE KEYS */;
INSERT INTO `shiro_menu_authorization_relation` VALUES ('0','0',1,'xx','xx','2017-10-17 15:20:19','2017-10-17 15:20:19',NULL);
/*!40000 ALTER TABLE `shiro_menu_authorization_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shiro_role`
--

DROP TABLE IF EXISTS `shiro_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shiro_role`
--

LOCK TABLES `shiro_role` WRITE;
/*!40000 ALTER TABLE `shiro_role` DISABLE KEYS */;
INSERT INTO `shiro_role` VALUES ('0','普通用户','defaultRole',1,0,'xx','xx','2016-10-09 04:12:12','2016-10-09 04:12:12',NULL),('1','管理员','manager',1,0,'yy','yy','2017-10-18 15:05:40','2017-10-18 15:05:40',NULL);
/*!40000 ALTER TABLE `shiro_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shiro_role_authorization_relation`
--

DROP TABLE IF EXISTS `shiro_role_authorization_relation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shiro_role_authorization_relation`
--

LOCK TABLES `shiro_role_authorization_relation` WRITE;
/*!40000 ALTER TABLE `shiro_role_authorization_relation` DISABLE KEYS */;
INSERT INTO `shiro_role_authorization_relation` VALUES ('0','0',1,'xx','xx','2016-10-09 04:12:12','2016-10-09 10:18:19','n'),('0','1',1,'yy','yy','2017-10-18 16:29:32','2017-10-18 16:29:32',NULL);
/*!40000 ALTER TABLE `shiro_role_authorization_relation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shiro_user`
--

DROP TABLE IF EXISTS `shiro_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shiro_user` (
  `id` varchar(32) NOT NULL,
  `groupId` varchar(32) DEFAULT NULL COMMENT '组ID',
  `account` varchar(32) DEFAULT NULL UNIQUE COMMENT '登录账号',
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shiro_user`
--

LOCK TABLES `shiro_user` WRITE;
/*!40000 ALTER TABLE `shiro_user` DISABLE KEYS */;
INSERT INTO `shiro_user` VALUES ('0','0','290315636@qq.com','DIjVZpTC+zvMQW4SLBBy6w==','tikie','xx','xx','xx',1,'xx','xx','0','1234567890','13621239684','290315636@qq.com','xx','xx','xx','2','w','w','w','w','w','w','w','w','w',1,1,0,'w','w','2016-10-03 16:00:00','2017-10-21 09:01:02','w');
/*!40000 ALTER TABLE `shiro_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-29 11:19:14
