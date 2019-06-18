#引入jar包、plugin

# 将mabatis整合到spring
- applicationContext.xml
- 自动扫描所有package，自动注入，配置数据库 

# 将整合springmvc到spring
- springmvc.xml,
- SpringMVC的配置文件单独放，然后在web.xml中配置整合
- 主要是自动扫描控制器，视图模式，注解的启动这三个
# 将shiro整合到spring
- springshiro.xml
- 配置realm
# 集成验证码

# 配置web.xml
这里面对applicationContext.xml的引入以及配置的springmvc.xml的Servlet就是为了完成SSM整合，
之前2框架整合不需要在此处进行任何配置。配置一样有详细注释，不多解释了。

# 注意
## idea不会编译类目录下的xml文件，需要在pom中加入一下代码，才会打包金classes目录
```
<build>  
  <resources>  
    <!-- mapper.xml文件在java目录下 -->
    <resource>  
      <directory>src/main/java</directory>  
        <includes>  
          <include>**/*.xml</include>  
        </includes>  
    </resource>  
    <!-- mapper.xml文件在resources目录下-->
    <--<resource>
        <directory>src/main/resources</directory> 
    </resource>-->
  </resources>  
</build>
```

## 无法通过test测试自动扫描包的service层，因为无法引用配置文件

## json传值错误
1、$.ajax()中---contentType : 'application/json',

2、不能缺：<mvc:annotation-driven />

3、缺jackson-databind-2.9.3.jar和jackson-annotations-2.9.3.jar，jackson-core-2.9.3.jar，这三个jar不能少！

## 解决数据库下划线映射失败
<configuration>
	<!--解决数据库下划线映射失败-->
	<settings>
		<setting name="mapUnderscoreToCamelCase" value="true" />
	</settings>