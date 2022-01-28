# 09-logback
springboot + logback
1、mysql驱动版本升级:
  本地安装了mysql8.0.25，需要使用mysql-connector-java-8.0.21.jar，
  低版本驱动报错：“Failed to configure a DataSource: 'url' attribute is not specified and no embedded datasource could be configured.”
    <!--低版本驱动-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>5.1.47</version>
    </dependency>
    
2、No active profile set, falling back to default profiles: default
 pom文件修改，新增:
 <dependency>
     <groupId>org.apache.tomcat.embed</groupId>
     <artifactId>tomcat-embed-jasper</artifactId>
 </dependency>

3、spring.datasource.url=jdbc:mysql://localhost:3306/mysql?serverTimezone=UTC
?serverTimezone=UTC 不能缺少

4、