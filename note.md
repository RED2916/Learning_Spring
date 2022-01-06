# 注解：笔记
##常用配置：允许注解
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">
    <context:component-scan base-package="classes"/>
    <!--注解驱动-->
    <context:annotation-config/>
    ...
</beans>
```
Ps：
1.使用Spring特定的注解要指定要扫描的Package，可以多个包：<br>
- <context:component-scan base-package="classes"/>
## 注解:
1. @Nullable:允许set输入null
2. @Autowired 自动装填，“ByType”。实际上“ByName”优先级更高。<br>
可配合@Qualifier("id")使用。
3. @Resource 这个不是spring的。自动装填，优先“ByName”，可以用@Resource(name="id")
进行指定操作（疑似效率低于@Autowired）
4. @Component 相当于去xml配置文件里去注册了，没有赋值，光写了个<bean id="类名(全小写)“ .../>
   <br>
- 在Dao层喜欢用@Repository代替@Component（两者等价）
- 在Service，@Service
- 在Servlet，@Controller
5. @Value(值) 写于属性上，相当于<property...>赋值,复杂的情况这种写法意义不大，不如写xml
6. @Scope 就是定scope属性，写在@Component下就行，@Scope("...")

### 与xml对比：
1. xml：易于维护，更加万能
2. 注解：只能在自己的类内使用，维护较困难
3. 最佳实现：<br>
- xml用来管理bean
- 注解完成属性注入
- 注意：注解生效需要开启**注解的支持**