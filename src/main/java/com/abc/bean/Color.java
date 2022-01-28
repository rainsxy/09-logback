package com.abc.bean;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author rains
 */
@SPI
public interface Color {

    /**
     * adaptive规范：必须包含url参数
     * @param url
     */
    @Adaptive
    void painting(URL url);
}
