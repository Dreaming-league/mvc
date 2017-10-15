package com.tikie.shiro.entity;

import com.tikie.base.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author TiKie
 * @desc 用户分组
 * @date 2017/10/14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Group extends Entity{
    private String userId;          //用户ID
    private String name;            //名称
    private Integer order;          //顺序

}
