package com.tikie.common.util.response;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *               前端异步请求返回数据
 *
 * @author       zcs
 * @since        2016-10-22
 */
public class ResponseJson {
    private static final String STATUS = "status";
    private static final String MESSAGE = "message";
    private static final String PAGE = "page";
    private static final String SIZE = "size";
    private static final String TOTAL = "total";
    private static final String DATA = "data";

    private boolean status = true;      //请求数据返回状态
    private String message = "";        //请求的提示信息
    private int page = 0;               //当前页从0开始，代表第一页
    private int size = 10;              //每页多少条，默认10条
    private long total = 0;             //总纪录数
    private Map data = new HashMap();
    private JSONObject jsonData = new JSONObject();
    private static ResponseJson instance = null ;
    private ResponseJson(){
    }
    //单例模式，方便全局调用
    public static ResponseJson getInstance(){
        if(instance==null){
            instance = new ResponseJson();
        }
        return instance;
    }
    public ResponseJson setStatus(boolean status){
        this.status= status;
        return instance;
    }
    public ResponseJson setMessage(String msg){
        this.message= msg;
        return instance;
    }
    public ResponseJson setPage(int page){
        this.page= page;
        return instance;
    }
    public ResponseJson setSize(int size){
        this.size=size;
        return instance;
    }
    public ResponseJson setTotal(long total){
        this.total=total;
        return instance;
    }
    public ResponseJson setData(Object o){
        if(o!=null){
            this.data.put("data",o);
        }

        return instance;
    }
    public ResponseJson setData(List list){
        if(list!=null){
            this.data.put("data",list);
        }
        return instance;
    }
    public ResponseJson setData(JSONArray data)
    {
        this.data.put("data",data);
        return instance;
    }
    public boolean getStatus(){
        return this.status;
    }
    public String getMessage(){
        return this.message;
    }
    public int getPage(){
        return this.page;
    }
    public int getSize(){
        return this.size;
    }
    public long getTotal(){
        return this.total;
    }
    public Map getData(){
        return this.data;
    }
    public JSONObject getJSONData(){
        this.jsonData.put(STATUS, status);
        this.jsonData.put(MESSAGE, message);
        this.jsonData.put(PAGE, page);
        this.jsonData.put(SIZE, size);
        this.jsonData.put(TOTAL, total);
        this.jsonData.put(DATA, data.get("data"));
        return this.jsonData;
    }
    public String toString(){
        return getJSONData().toString();
    }
}
