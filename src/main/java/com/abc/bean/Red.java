package com.abc.bean;

import org.apache.dubbo.common.URL;

/**
 * @author rains
 */
public class Red implements Color {

    @Override
    public void painting(URL url) {
        System.out.println("it is red!");
    }
}
