package com.tikie.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @author TiKie
 * @desc 基础实体类属性
 * @date 2017/10/15
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Entity implements Serializable {
    private String id;               //唯一ID：用UUID填充

    private Boolean isActive;        //是否有效/启用
    private Boolean isDelete;        //是否逻辑删除

    private String createdBy;        //创建者
    private String updatedBy;        //更新者
    private Date   createdTime;      //创建时间
    private Date   updatedTime;      //更新时间

    private String note;             //备注
}
