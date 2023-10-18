package com.app.hst.common.utils;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DefaultException extends RuntimeException{
    /**
     * Http请求Code
     */
    private int httpStatusCode;

    /**
     * 消息Key
     */
    private String messageKey;

    /**
     * 消息列表
     */
    private List<String> messageParams;

    /**
     * 直接调用父类的消息
     * @param msg
     */
    public DefaultException(String msg){
        super(msg);
    }

    /**
     * 构造函数
     * @param httpStatusCode 状态Code
     * @param messageKey 消息Key
     */
    public DefaultException(int httpStatusCode, String messageKey){
        this.httpStatusCode = httpStatusCode;
        this.messageKey = messageKey;
    }

    /**
     * 构造函数
     * @param httpStatusCode 状态Code
     * @param messageKey 消息Key
     * @param messageParams 消息列表
     */
    public DefaultException(int httpStatusCode, String messageKey, List<String> messageParams){
        this.httpStatusCode = httpStatusCode;
        this.messageKey = messageKey;
        this.messageParams = messageParams;
    }
}
