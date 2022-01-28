package com.abc.bean;

import org.apache.dubbo.common.extension.SPI;

/**
 * @author rains
 */
@SPI("apple")//表示默认
public interface Fruit {
    void getName();
}
