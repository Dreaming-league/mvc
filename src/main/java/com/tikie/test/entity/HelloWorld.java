package com.tikie.test.entity;

import lombok.*;

/**
 * @targget     HelloWorld实体lei,字段和数据库对应
 *
 * @author      tikie
 * @date        2016-09-29
 * @version     1.0.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HelloWorld {
    private Long id;
    private String message;
}
