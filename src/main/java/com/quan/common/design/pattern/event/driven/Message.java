package com.quan.common.design.pattern.event.driven;

public interface Message {

    /**
     * 获取Message的类型
     *
     * @return
     */
    Class<? extends Message> getType();
}