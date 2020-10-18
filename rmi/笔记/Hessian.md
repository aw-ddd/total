### 一、 Hessian实现远程服务调用（服务端客户端都不使用Spring）

#### 1. 导入依赖

```xml
  <dependency>
      <groupId>com.caucho</groupId>
      <artifactId>hessian</artifactId>
      <version>4.0.38</version>
    </dependency>
```

#### 2.创建Hessian服务端接口以及实现类

```java
public interface DemoApi {

    public void setName(String name);

    public String sayHello();

    public User getUser();
}



public class HessianService implements DemoApi {

    private String name;

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String sayHello() {
        return "hello:"+this.name;
    }

    @Override
    public User getUser() {
        return new User();
    }
}

```

#### 3. 配置web.xml文件

```xml
 <!--在此添加配置即可暴露hessian类型的接口-->
  <servlet>
    <!--该配置是固定配置-->
    <servlet-name>hessian</servlet-name>
    <servlet-class>com.caucho.hessian.server.HessianServlet</servlet-class>
    <init-param>
      <param-name>service-class</param-name>
      <!--该路径是需要启动的服务的地址-->
      <param-value>com.dwj.hessian.HessianService</param-value>
    </init-param>
  </servlet>
  
  <servlet-mapping>
    <servlet-name>hessian</servlet-name>
    <url-pattern>/helloworld</url-pattern>
  </servlet-mapping>
```

#### 4. 创建Hessian客户端

```java
public class HessianClient {
    public static void main(String[] args) throws MalformedURLException {
        //请求路径中的rmi就是当前的项目的包名，helloworld是在服务端中配置的名称
        String url = "http://localhost:8080/rmi/helloworld";
        HessianProxyFactory factory = new HessianProxyFactory();
        //获取到RMI远程调用类，可以执行一些远程操作
        DemoApi demoApi = (DemoApi) factory.create(DemoApi.class, url);
        User user = demoApi.getUser();
        demoApi.setName("张三");
        String s = demoApi.sayHello();
        System.out.println(s);
        System.out.println(user);
    }
}
```

### 二、RPC与RMI的区别

#### 1. 方法调用方式不同

**RMI中是通过在客户端的Stub对象作为远程接口进行远程方法的调用，每个远程方法都具有方法签名。**如果一个方法在服务器上执行，但是**没有相匹配的签名别添加到这个远程接口（stub）上，那么这个新的方法就不能被RMI客户方所调用。**



**RPC中是通过网络服务协议向远程主机发送请求，**请求包含了一个参数集合一个文本值，通常形成“classname.methodname（参数集）”的形式。RPC远程主机就去搜索与之相匹配的类和方法，找到后就执行方法并把结果编码，通过网络协议发回。

#### 2. 使用范围不同

RMI只适用于Java

RPC是网络服务协议，与操作系统无关

#### 3. 调用结果的返回形式不同

Java是面向对象的，所以RMI的调用结果可以是对象类型或者基本类型

RPC的结果统一由外部数据表示，这种语言抽象了字节序列类和数据结构之间的差异