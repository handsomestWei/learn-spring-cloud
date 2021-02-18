
# learn-spring-cloud
spring cloud各组件使用。包括zuul，spring cloud gateway，eureka，nacos，openfeign，ribbon，hystrix，sentinel等

## spring cloud各组件
<div align=center><img width="1055" height="351" src="https://github.com/handsomestWei/learn-spring-cloud/blob/main/doc/spring-cloud-components.png" /></div>

## Usage

### IntelliJ IDEA配置
#### 源加速
创建spring boot应用，选择模板工程的源地址时，替换为国内的地址加速
```
https://start.spring.io
替换为https://start.aliyun.com
```
#### 热启动
spring boot项目修改配置文件后的热启动设置
```
1）maven添加spring-boot-devtools
2）idea设置自动编译：File->Settings->Compiler勾选Build Project automatically
3）快捷键ctrl + shift + alt + /，选择Registry，勾选Compiler autoMake allow when app running
```

### Eureka
[官方文档](https://github.com/Netflix/eureka/wiki)
#### 自我保护机制
网络抖动时，不应移除服务。但部署在k8s集群时，服务被调度到其他节点，则需要下线旧服务重新注册。

#### 与zk区别
```
zk保证CP。虽然保证C数据一致性，但选举时整个集群不可用，不保障A可用性。
eureka保证AP。客户端遍历集群内可用的节点保障A可用性，但不保障集群各节点C数据一致。
```

### Nacos
[官方文档](https://nacos.io/zh-cn/docs/what-is-nacos.html)
#### 单机版部署
```
cmd /nacos/bin/startup.cmd -m standalone
```

#### 集群版部署
```
1）mysql新建库nacos
2）执行/nacos/conf/nacos-mysql.sql
3）配置/nacos/conf/application.properties
4）将/nacos/target/nacos-server.jar解压到nacos/bin/work/Tomcat/localhost下
```

#### 控制台登录
```
http://<ip>:8848/nacos/index.html
默认账号密码nacos/nacos
```

### Zuul
[官方文档](https://github.com/Netflix/zuul/wiki)   
内部已集成Ribbon负载均衡和Hystix熔断。如果注册中心上注册有多个相同serviceId的服务时，会自动完成负载均衡。

### Sentinel
[官方文档](https://github.com/alibaba/Sentinel/wiki/%E4%BB%8B%E7%BB%8D)
#### 仪表盘部署
```
java -Dserver.port=<port> -Dcsp.sentinel.dashboard.server=localhost:<port> -Dproject.name=sentinel-dashboard -jar sentinel-dashboard.jar
默认账号密码sentinel/sentinel
```
#### 规则数据源配置
规则可以来自Sentinel控制台的页面配置推送，也可来自本地文件、redis、zk等。


## 参考
[spring-cloud-alibaba版本说明](https://github.com/alibaba/spring-cloud-alibaba/wiki/%E7%89%88%E6%9C%AC%E8%AF%B4%E6%98%8E)