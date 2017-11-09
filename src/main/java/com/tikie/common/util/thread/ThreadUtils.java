package com.tikie.common.util.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author zcs
 * 线程类
 * 2017/1/3
 */
public class ThreadUtils {
    private ExecutorService executorService ;//线程池类
    private List<Future> resultList = new ArrayList<Future>();//执行的结果

    public void init(){
        this.executorService = Executors.newCachedThreadPool();
        this.resultList = null;
    }

    public void submit(Callable task){
        Future future = executorService.submit(task);
        this.resultList.add(future);
    }

    public void shutdown(){
        this.executorService.shutdown();
    }

    public List<Future> getResultList(){
        return this.resultList;
    }

    public static void main(String[] args){
        ThreadUtils utils = new ThreadUtils();
        utils.init();
        for(int i=0;i<10;i++){
            utils.submit(new Task());
        }

        List<Future> resultList = utils.getResultList();

        // 遍历任务的结果
        for (Future fs : resultList) {
            try {
                System.out.println(fs.get()); // 打印各个线程（任务）执行的结果
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        utils.shutdown();
    }
}
