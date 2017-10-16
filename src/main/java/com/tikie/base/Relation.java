package com.tikie.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author TiKie
 * @desc 基础关联类属性
 * @date 2017/10/16
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Relation {
    private Boolean isActive;        //是否有效/启用

    private String createdBy;        //创建者
    private String updatedBy;        //更新者
    private Date   createdTime;      //创建时间
    private Date   updatedTime;      //更新时间

    private String note;             //备注
}
