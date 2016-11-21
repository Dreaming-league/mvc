package com.tikie.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @targget     用户实体类
 *
 * @author      tikie
 * @date        2016-10-02
 * @version     1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable{
    private Integer id;
    private String account;         //账号
    private String pwd;             //密码

    private String nickName;        //昵称:页面显示
    private String photo;           //头像
    private String sign;            //签名

    private String skin;            //皮肤

    private Integer score;          //分数
    private String honor;           //荣誉称号

    private String realName;        //真实姓名
    private String sex;             //性别
    private String NID;             //身份证号
    private String phone;           //手机号
    private String email;

    private String company;         //所在的公司
    private String title;           //职称
    private String position;        //职位

    private String QQ;
    private String weChat;          //微信号
    private String QRCode;          //微信二维码
    private String microBlog;       //新浪微博账号
    private String renRen;          //人人网账号

    private String twitter;
    private String facebook;

    private String postcode;        //邮政编码
    private String nowAddress;      //现地址
    private String homeland;        //故乡

    private List<UserRoleRelation> roleRelationList;    //拥有的角色关系

    private String isActive;        //是否有效/启用
    private String isSys;           //是否系统用户
    private String isDelete;        //是否逻辑删除

    private String createdBy;
    private String updatedBy;
    private Date createdTime;
    private Date updatedTime;

    private String note;            //备注

    private String e;              //扩展字段



}
