package com.tikie.test.entity;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * @author TiKie
 * @desc
 * @date 2017/12/14
 */
public class TestCopyBean {
    public static void main(String[] args){
        HelloWorld helloWorld = new HelloWorld(1L,"hello");
        System.out.println("id:"+helloWorld.getId());
        System.out.println("message:"+helloWorld.getMessage());

        // copy1
        HelloWorld helloWorld1 = helloWorld;
        helloWorld1.setId(2L);
        helloWorld1.setMessage("world");
        System.out.println("*id:"+helloWorld.getId());
        System.out.println("*message:"+helloWorld.getMessage());
        System.out.println("*id1:"+helloWorld1.getId());
        System.out.println("*message1:"+helloWorld1.getMessage());

        // copy2
        HelloWorld helloWorld2 = new HelloWorld();
        try {
            BeanUtils.copyProperties(helloWorld2,helloWorld);
            helloWorld2.setId(3L);
            helloWorld2.setMessage("beanUtils");

            System.out.println("#id:"+helloWorld.getId());
            System.out.println("#message:"+helloWorld.getMessage());
            System.out.println("#id1:"+helloWorld1.getId());
            System.out.println("#message1:"+helloWorld1.getMessage());
            System.out.println("#id2:"+helloWorld2.getId());
            System.out.println("#message2:"+helloWorld2.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
