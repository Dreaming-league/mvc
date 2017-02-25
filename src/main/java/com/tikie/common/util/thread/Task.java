package com.tikie.common.util.thread;

import java.util.concurrent.Callable;

/**
 * @author zcs
 * @desc 目的
 * @date 2017/1/3
 */
public class Task  implements Callable{
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    public Object call() throws Exception {
        System.out.println("call()方法被自动调用,执行任务!" + Thread.currentThread().getName());

        return true;
    }
}
