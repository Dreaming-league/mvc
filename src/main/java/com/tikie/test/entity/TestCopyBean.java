package com.tikie.test.entity;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author TiKie
 * @desc
 * @date 2017/12/14
 */
public class TestCopyBean {
    public static void main(String[] args){
        List list = new ArrayList();
        list.add("thanks");
        Bean helloWorld = new Bean(1,"hello",list);
        System.out.println("id:"+helloWorld.getId());
        System.out.println("message:"+helloWorld.getMessage());
        System.out.println("list:"+helloWorld.getList().toString()+"\n");

        // copy1
        Bean helloWorld1 = helloWorld;
        helloWorld1.setId(2);
        helloWorld1.setMessage("world");
        List list1 = new ArrayList();
        list1.add("you");
        helloWorld1.setList(list1);

        System.out.println("*id:"+helloWorld.getId());
        System.out.println("*message:"+helloWorld.getMessage());
        System.out.println("*list:"+helloWorld.getList().toString());
        System.out.println("*id1:"+helloWorld1.getId());
        System.out.println("*message1:"+helloWorld1.getMessage());
        System.out.println("*list1:"+helloWorld1.getList().toString()+"\n");

        // copy2
        Bean helloWorld2 = new Bean();
        try {
            BeanUtils.copyProperties(helloWorld2,helloWorld);
            helloWorld2.setId(3);
            helloWorld2.setMessage("beanUtils");
            List list2 = new ArrayList();
            list2.add("he");
            helloWorld2.setList(list2);

            System.out.println("#id:"+helloWorld.getId());
            System.out.println("#message:"+helloWorld.getMessage());
            System.out.println("#list:"+helloWorld.getList().toString());
            System.out.println("#id1:"+helloWorld1.getId());
            System.out.println("#message1:"+helloWorld1.getMessage());
            System.out.println("#list1:"+helloWorld1.getList().toString());
            System.out.println("#id2:"+helloWorld2.getId());
            System.out.println("#message2:"+helloWorld2.getMessage());
            System.out.println("#list2:"+helloWorld2.getList().toString());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
