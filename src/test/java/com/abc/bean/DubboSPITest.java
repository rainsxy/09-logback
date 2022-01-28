package com.abc.bean;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;

/**
 * 测试dubbo spi
 * @author rains
 */
public class DubboSPITest {

    /**
     *
     * 注意pom.xml修改后需要reimport一下才会生效
     *
     * 如果没有设置**\/  *.*,导致META-INFO/dubbo下的SPI配置文件没有被加载，就会导致报错：
     *             *java.lang.IllegalStateException:   No such extension com. abc.bean.Fruit by name apple
     *     at org.apache.dubbo.common.extension.ExtensionLoader.findException(ExtensionLoader.java:520)
     *     at org.apache.dubbo.common.extension.ExtensionLoader.createExtension(ExtensionLoader.java:527)
     *     at org.apache.dubbo.common.extension.ExtensionLoader.getExtension(ExtensionLoader.java:351)
     * <resource>
     *   <directory>src/main/resources</directory>
     *      <includes>
     *         <include>*.xml</include>
     *         <include>*.properties</include>
     *      <include>**\/*.*</include>
     *  </includes>
     * </resource>
     */

    @Test
    public void extensionLoaderTest() {
        ExtensionLoader<Fruit> loader = ExtensionLoader.getExtensionLoader(Fruit.class);
        System.out.println(loader);
        Fruit apple = loader.getExtension("apple");
        apple.getName();
    }

    /**
     * 测试getDefaultExtension
     */
    @Test
    public void extensionLoaderDefaultTest() {
        ExtensionLoader<Fruit> loader = ExtensionLoader.getExtensionLoader(Fruit.class);
        System.out.println(loader);
        System.out.println(loader.getDefaultExtensionName());

        Fruit defaultExtension = loader.getDefaultExtension();
        defaultExtension.getName();
    }

    /**
     * 测试getDefaultExtension
     */
    @Test
    public void extensionLoaderAdaptiveTest() {
        ExtensionLoader<Fruit> loader = ExtensionLoader.getExtensionLoader(Fruit.class);
        System.out.println(loader);
        System.out.println(loader.getAdaptiveExtension());

        Fruit adaptiveExtension = loader.getAdaptiveExtension();
        adaptiveExtension.getName();
    }

    /**
     * 测试getDefaultExtension
     */
    @Test
    public void extensionLoaderAdaptiveTest1() {
        ExtensionLoader<Fruit> loader = ExtensionLoader.getExtensionLoader(Fruit.class);
        System.out.println(loader);
        System.out.println(loader.getAdaptiveExtension());

        //AdaptiveFruit可以理解为装饰器模式中的装饰器，通过setAdaptivePolicy指定装饰对象是Apple
        AdaptiveFruit adaptiveExtension = (AdaptiveFruit) loader.getAdaptiveExtension();
        adaptiveExtension.setAdaptivePolicy("apple");

        adaptiveExtension.getName();
    }

}
