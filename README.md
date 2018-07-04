# spring-cloud

# 1.简介
> 尝试使用了spring cloud的几个微服务组件，包括Actuator、Eureka、Ribbon、Hystrix、Zuul.
# 2.小组成员
| 姓名 | 学号 |
|-|:-:|-:|
|张政童|516030910024|
|方俊杰|516030910006|
|王子阳|516030910016|
|李青弈|516030910008|
|罗一淏|516030910038|

# 2.使用   
### Ⅰ. clone 到本地后并构建项目后，依次运行 run as Spring Boot App
> eureka-server -> eureka-client -> ribbon -> zuul
### Ⅱ. 访问  http://localhost:1111/ 以查看eureka服务注册中心
### Ⅲ. 访问  http://localhost:2222/hello?name=xxx 以查看一个服务提供者
### Ⅳ. 访问 http://localhost:3333/consumer?name=xxx 以查看一个服务消费者
### Ⅴ. 访问 http://localhost:4444/zuul-a/from?token=22 以查看路由网关
### Ⅵ. 停止 eureka-client项目后再次访问消费者返回失败信息，以验证熔断器(Hystrix)功能
### Ⅶ. 在任一可用端口后加上 /actuator/health 等端口，如 http://localhost:1111/actuator/health 监控服务运行状态

