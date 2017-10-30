package com.tikie.shiro.entity;

import com.tikie.base.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author TiKie
 * 用户分组
 * 2017/10/14
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group extends Entity{
    private String name;            //名称
    private Integer order;          //顺序

    private List<User> userList;    //拥有哪些用户
}
