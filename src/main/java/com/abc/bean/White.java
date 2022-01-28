package com.abc.bean;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;

/**
 * @author rains
 */

public class White implements Color {

    @Override
    public void painting(URL url) {
        System.out.println("it is white");
    }
}
