package com.abc.bean;

import com.abc.bean.Fruit;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试dubbo spi
 * @author rains
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
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
}
