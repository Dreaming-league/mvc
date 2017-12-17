package com.tikie.test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author TiKie
 * @desc    测试对象属性复制
 * @date 2017/12/17
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bean {
    private int id;
    private String message;
    private List<String> list;

}
