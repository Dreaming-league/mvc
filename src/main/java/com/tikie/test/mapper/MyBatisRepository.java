package com.tikie.test.mapper;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @target  标识MyBatis的DAO,方便{@link org.mybatis.spring.mapper.MapperScannerConfigurer}的扫描。
 *          自定义注解文件
 *
 * @author  tikie
 * @date    2016-09-28
 * @version     1.0.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface MyBatisRepository {
    String value() default "";
}
