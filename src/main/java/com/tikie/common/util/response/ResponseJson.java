package com.tikie.common.util.response;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *               前端异步请求返回数据
 *
 * @author       TiKie
 * @since        2016-10-22
 */
public class ResponseJson {
    private static final String RESPONSE_STATUS = "status";
    private static final String RESPONSE_MESSAGE = "message";
    private static final String RESPONSE_PAGE = "page";
    private static final String RESPONSE_SIZE = "size";
    private static final String RESPONSE_TOTAL = "total";
    private static final String RESPONSE_DATA = "data";

    private static final String RESPONSE_DATE_PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
    private static final String RESPONSE_DATE_PATTERN_DAY = "yyyy-MM-dd";
    private static final String RESPONSE_DATE_PATTERN_HOUR = "HH:mm:ss";

    public static final int RESPONSE_DEFAULT_PAGE = 0;
    public static final int RESPONSE_DEFAULT_SIZE = 10;
    public static final int RESPONSE_DEFAULT_TOTAL = 0;

    public static final String RESPONSE_SUCCESS_MESSAGE = "成功返回数据";
    public static final String RESPONSE_FAILED_MESSAGE = "返回数据失败";

    private boolean status = true;      //请求数据返回状态
    private String message = "";        //请求的提示信息
    private int page = RESPONSE_DEFAULT_PAGE;               //当前页从0开始，代表第一页
    private int size = RESPONSE_DEFAULT_SIZE;               //每页多少条，默认10条
    private long total = RESPONSE_DEFAULT_TOTAL;            //总纪录数
    private Map data = new HashMap();
    private Map jsonData = new HashMap();
    private static ResponseJson instance = null ;
    private static Gson gson = null ;
    private ResponseJson(){
    }
    //单例模式，方便全局调用

    /**
     * 返回数据中的日期各式化为年月日 时分秒
     * @return ResponseJson
     */
    public static ResponseJson getInstance(){
        if(instance==null){
            instance = new ResponseJson();
        }
        gson = new GsonBuilder().setDateFormat(RESPONSE_DATE_PATTERN_FULL).create();
        return instance;
    }

    /**
     * 返回数据中的日期各式化为年月日
     * @return ResponseJson
     */
    public static ResponseJson getDayInstance(){
        if(instance==null){
            instance = new ResponseJson();
        }
        gson = new GsonBuilder().setDateFormat(RESPONSE_DATE_PATTERN_DAY).create();
        return instance;
    }
    /**
     * 返回数据中的日期各式化为时分秒
     * @return ResponseJson
     */
    public static ResponseJson getHourInstance(){
        if(instance==null){
            instance = new ResponseJson();
        }
        gson = new GsonBuilder().setDateFormat(RESPONSE_DATE_PATTERN_HOUR).create();
        return instance;
    }

    /**
     * 重置为默认设置
     * @param status    true:成功;false:失败
     * @return ResponseJson
     */
    public ResponseJson set2Default(Boolean status){
        this.page = ResponseJson.RESPONSE_DEFAULT_PAGE;
        this.size = ResponseJson.RESPONSE_DEFAULT_SIZE;
        this.total = ResponseJson.RESPONSE_DEFAULT_TOTAL;
        this.setData(null);
        this.setStatus(status);
        if(status){
            this.setMessage(ResponseJson.RESPONSE_SUCCESS_MESSAGE);
        }else{
            this.setMessage(ResponseJson.RESPONSE_FAILED_MESSAGE);
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
    public Map getJSONData(){
        this.jsonData.put(RESPONSE_STATUS, status);
        this.jsonData.put(RESPONSE_MESSAGE, message);
        this.jsonData.put(RESPONSE_PAGE, page);
        this.jsonData.put(RESPONSE_SIZE, size);
        this.jsonData.put(RESPONSE_TOTAL, total);
        this.jsonData.put(RESPONSE_DATA, data.get("data"));
        return this.jsonData;
    }
    public String toString(){
        return gson.toJson(getJSONData());
    }
}
