package com.abc.bean;

import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.ExtensionLoader;

/**
 *
 * @author rains
 */
@Adaptive
/* @Adaptive必须指定：否则报错：
 * java.lang.IllegalStateException: Failed to create adaptive instance: java.lang.IllegalStateException:
 * Can't create adaptive extension interface com.abc.bean.Fruit, cause: No adaptive method exist on extension com.abc.bean.Fruit,
 * refuse to create the adaptive class!
 */
public class AdaptiveFruit implements Fruit{

    //用于指定使用的extension,其实策略模式
    private String adaptivePolicy;

    @Override
    public void getName() {
        ExtensionLoader<Fruit> loader = ExtensionLoader.getExtensionLoader(Fruit.class);

        if (adaptivePolicy == null || adaptivePolicy.isEmpty()) {
            Fruit extension = loader.getDefaultExtension();
            extension.getName();
        } else  if (adaptivePolicy.equals("apple")) {
            Fruit extension = loader.getExtension("apple");
            extension.getName();
        } else {
            Fruit extension = loader.getDefaultExtension();
            extension.getName();
        }


    }

    public String getAdaptivePolicy() {
        return adaptivePolicy;
    }

    public void setAdaptivePolicy(String adaptivePolicy) {
        this.adaptivePolicy = adaptivePolicy;
    }
}
