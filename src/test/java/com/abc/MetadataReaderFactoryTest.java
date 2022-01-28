package com.abc;

import com.alibaba.fastjson.JSON;
import org.springframework.core.io.Resource;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.IOException;

/**
 * @author rains
 */
public class MetadataReaderFactoryTest {
    public static void main(String[] args) throws IOException {
        MetadataReaderFactory factory = new SimpleMetadataReaderFactory() ;
        MetadataReader reader = factory.getMetadataReader(MyFirstConfig.class.getName());
        System.out.println(JSON.toJSONString(reader));
    }
}
