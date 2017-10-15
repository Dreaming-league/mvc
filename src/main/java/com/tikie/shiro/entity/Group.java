package com.tikie.shiro.entity;

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
public class Group implements Serializable {
    private String id;

    private String userId;          //用户ID
    private String name;            //名称
    private Integer order;          //顺序

    private Boolean isActive;        //是否有效/启用
}
