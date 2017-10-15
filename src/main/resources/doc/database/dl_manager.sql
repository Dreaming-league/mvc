/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/10/13 9:48:15                           */
/*==============================================================*/

DROP DATABASE IF EXISTS dl_manager;

CREATE DATABASE dl_manager DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE dl_manager;


drop table if exists blog_user;

drop table if exists info_user;

drop table if exists mai_attachement;

drop table if exists mail;

drop table if exists mail_address;

drop table if exists mail_address_group;

drop table if exists mail_address_group_manager;

drop table if exists mail_contactor;

drop table if exists mail_content;

drop table if exists mail_folder;

drop table if exists mail_user_folder;

drop table if exists mail_user_setting;

drop table if exists message;

drop table if exists news_user;

drop table if exists postal;

drop table if exists postal_user;

drop table if exists shiro_authorition;

drop table if exists shiro_group;

drop table if exists shiro_menu;

drop table if exists shiro_menu_authorization;

drop table if exists shiro_role;

drop table if exists shiro_role_authorization;

drop table if exists shiro_role_group;

drop table if exists shiro_user;

drop table if exists sys_user_detail;

drop table if exists sys_user_system;

drop table if exists system;

drop table if exists yun_file;

drop table if exists yun_folder;

drop table if exists yun_share;

drop table if exists yun_virtual_file;

drop table if exists yun_virtual_file_folder_user;

/*==============================================================*/
/* Table: blog_user                                             */
/*==============================================================*/
create table blog_user
(
   userId               varchar(32),
   blogId               varchar(32)
);


/*==============================================================*/
/* Table: info_user                                             */
/*==============================================================*/
create table info_user
(
   id                   varchar(32),
   userId               varchar(32),
   title                varchar(64),
   content              varchar(256),
   type                 varchar(8),
   position             varchar(32)
);

/*==============================================================*/
/* Table: mai_attachement                                       */
/*==============================================================*/
create table mai_attachement
(
   id                   varchar(32),
   mailId               varchar(32),
   fileName             varchar(64),
   size                 decimal,
   path                 varchar(128),
   status               tinyint
);

/*==============================================================*/
/* Table: mail                                                  */
/*==============================================================*/
create table mail
(
   id                   varchar(32),
   sender               varchar(64),
   sendName             varchar(64),
   subject              varchar(256),
   sendType             varchar(16),
   sendDate             datetime,
   attachmentCount      int,
   replyMailId          varchar(32),
   ip                   varchar(32),
   rewardId             varchar(32),
   isUrgent             varchar(8),
   isText               varchar(8),
   status               varchar(8),
   receiver             text,
   mailKey              varchar(128)
);

/*==============================================================*/
/* Table: mail_address                                          */
/*==============================================================*/
create table mail_address
(
   id                   varchar(32),
   userId               varchar(32),
   name                 varchar(32),
   email                varchar(64)
);

/*==============================================================*/
/* Table: mail_address_group                                    */
/*==============================================================*/
create table mail_address_group
(
   id                   varchar(32),
   name                 varchar(32),
   userId               varchar(32),
   `order`              tinyint
);

/*==============================================================*/
/* Table: mail_address_group_manager                            */
/*==============================================================*/
create table mail_address_group_manager
(
   addrId               varchar(32),
   groupId              varchar(32),
   `order`              tinyint
);

/*==============================================================*/
/* Table: mail_contactor                                        */
/*==============================================================*/
create table mail_contactor
(
   id                   varchar(32),
   userId               varchar(32),
   name                 varchar(32),
   contactor            varchar(32),
   type                 varchar(8),
   time                 datetime
);

/*==============================================================*/
/* Table: mail_content                                          */
/*==============================================================*/
create table mail_content
(
   mailId               varchar(32),
   mailContent          text
);

/*==============================================================*/
/* Table: mail_folder                                           */
/*==============================================================*/
create table mail_folder
(
   id                   varchar(32),
   mailId               varchar(32),
   userId               varchar(32),
   name                 varchar(16),
   readTime             char(10),
   isReaded             tinyint,
   isdeleted            tinyint,
   isStar               tinyint,
   isReceipt            tinyint,
   receiptTime          datetime,
   isForward            tinyint,
   autoId               bigint,
   `label`              varchar(128)
);

/*==============================================================*/
/* Table: mail_user_folder                                      */
/*==============================================================*/
create table mail_user_folder
(
   id                   varchar(32),
   name                 varchar(32),
   userId               varchar(32)
);

/*==============================================================*/
/* Table: mail_user_setting                                     */
/*==============================================================*/
create table mail_user_setting
(
   userId               varchar(32),
   setting              text,
   blackList            text,
   autoReply            text
);

/*==============================================================*/
/* Table: message                                               */
/*==============================================================*/
create table message
(
   id                   varchar(32)
);


/*==============================================================*/
/* Table: news_user                                             */
/*==============================================================*/
create table news_user
(
   userId               char(10),
   newsId               char(10)
);


/*==============================================================*/
/* Table: postal                                                */
/*==============================================================*/
create table postal
(
   id                   varchar(32)
);


/*==============================================================*/
/* Table: postal_user                                           */
/*==============================================================*/
create table postal_user
(
   postalId             varchar(32),
   userId               varchar(32)
);

/*==============================================================*/
/* Table: shiro_authorition                                       */
/*==============================================================*/
create table shiro_authorition
(
   id                   varchar(32) not null,
   pId                  varchar(32),
   name                 varchar(16),
   permission           varchar(32),
   `order`              int,
   primary key (id)
);

/*==============================================================*/
/* Table: shiro_group                                             */
/*==============================================================*/
create table shiro_group
(
   id                   varchar(32) not null,
   userId               varchar(32),
   name                 varchar(32),
   `order`              varchar(32),
   isActive             Boolean,
   primary key (id)
);


/*==============================================================*/
/* Table: shiro_menu                                              */
/*==============================================================*/
create table shiro_menu
(
   id                   varchar(32) not null,
   pId                  varchar(32),
   type                 varchar(8),
   `order`              int,
   icon                 varchar(32),
   url                  varchar(64),
   accessCode           varchar(64),
   sysId                varchar(32),
   isActive             Boolean,
   primary key (id)
);


/*==============================================================*/
/* Table: shiro_menu_authorization                                */
/*==============================================================*/
create table shiro_menu_authorization
(
   menuId               varchar(32),
   authId               varchar(32)
);

/*==============================================================*/
/* Table: shiro_role                                              */
/*==============================================================*/
create table shiro_role
(
   id                   varchar(32) not null,
   name                 varchar(32),
   primary key (id)
);

/*==============================================================*/
/* Table: shiro_role_authorization                                */
/*==============================================================*/
create table shiro_role_authorization
(
   authId               varchar(32),
   roleId               varchar(32)
);

/*==============================================================*/
/* Table: shiro_group_role                                        */
/*==============================================================*/
create table shiro_group_role
(
   roleId               varchar(32),
   groupId              int,
   isActive             Boolean
);

/*==============================================================*/
/* Table: shiro_user                                              */
/*==============================================================*/
create table shiro_user
(
   id                   varchar(32) not null,
   account              varchar(32) not null,
   pwd                  varchar(32) not null,
   name                 varchar(32),
   type                 varchar(8),
   img                  varchar(64),
   qq                   varchar(32),
   wechat               varchar(32),
   mblog                varchar(32),
   primary key (id)
);


/*==============================================================*/
/* Table: sys_user_detail                                       */
/*==============================================================*/
create table sys_user_detail
(
   id                   varchar(32) not null,
   name                 varchar(16),
   IDnumber             varchar(32),
   address              varchar(32),
   zipCode              varchar(16),
   primary key (id)
);


/*==============================================================*/
/* Table: sys_user_system                                       */
/*==============================================================*/
create table sys_user_system
(
   userId               varchar(32),
   systemId             varchar(32)
);

/*==============================================================*/
/* Table: system                                                */
/*==============================================================*/
create table system
(
   id                   varchar(32) not null,
   logo                 varchar(32),
   bgImages             varchar(256),
   company              varchar(32),
   poweredBy            varchar(64),
   theme                varchar(32),
   primary key (id)
);


/*==============================================================*/
/* Table: yun_file                                              */
/*==============================================================*/
create table yun_file
(
   id                   varchar(32) not null,
   name                 varchar(64),
   size                 varchar(32),
   suffix               varchar(8),
   type                 varchar(8),
   creatName            varchar(32),
   path                 varchar(128),
   quoteCount           bigint,
   shareCount           int,
   useCount             bigint,
   accessCode           varchar(128),
   netUrl               varchar(128),
   primary key (id)
);


/*==============================================================*/
/* Table: yun_folder                                            */
/*==============================================================*/
create table yun_folder
(
   id                   varchar(32) not null,
   userId               varchar(32),
   name                 varchar(32),
   primary key (id)
);

/*==============================================================*/
/* Table: yun_share                                             */
/*==============================================================*/
create table yun_share
(
   id                   varchar(32),
   type                 varchar(8),
   url                  varchar(64),
   endDate              timestamp,
   accessCode           varchar(8)
);

/*==============================================================*/
/* Table: yun_virtual_file                                      */
/*==============================================================*/
create table yun_virtual_file
(
   id                   varchar(32) not null,
   realId               varchar(32) not null,
   name                 varchar(64),
   size                 varchar(32),
   suffix               varchar(8),
   type                 varchar(8),
   creatName            varchar(32),
   path                 varchar(128),
   primary key (id)
);


/*==============================================================*/
/* Table: yun_virtual_file_folder_user                          */
/*==============================================================*/
create table yun_virtual_file_folder_user
(
   vrId                 varchar(32),
   vrFolderId           varchar(32),
   userId               varchar(32),
   shareId              varchar(32)
);

