package com.tikie.easyeson.enums;

/**
 * @author zcs
 * @desc 使用枚举表示常量数据字段
 * @date 2017/2/25
 */
public enum ProductEnum {
    SOLD_OUT(0,"已售罄"),
    SUCCESS(1,"购买成功"),
    INNER_ERROR(-1,"系统异常"),
    DATA_ERROR(-2,"数据篡改");

    private int state;
    private String stateInfo;

    ProductEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public static ProductEnum stateOf(int index){
        for (ProductEnum state:
             values()) {
            if(state.getState() == index){
                return state;
            }
        }
        return null;
    }
}
