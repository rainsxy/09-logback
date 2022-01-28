package com.abc;

import com.abc.bean.Apple;
import com.abc.bean.Fruit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rains
 */
@Configuration
public class MyFirstConfig {
    @Bean(name = "greenApple")//name属性不设置默认beanname是appleBean
    Fruit appleBean(){
        Apple a = new Apple();
        return a;
    }
}
