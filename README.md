# Spring Cloud 微服务入门配置
本项目是Spring Cloud 微服务搭建
* 注册中心和配置中心使用了 `alibaba` 开源组件 `nacos`。
* 服务消费使用 `feign` 和 `ribbon`。
* 分布式事务使用 `seata`。


# 服务和端口说明

|服务名称|端口|
|:----:|:----:|
|service-provider|8020、8021|
|service-consume|8030|
|service-config|8010|
|nacos-provide-stock|8041|
|nacos-provide-order|8040|
|nacos-consume-seata|8042|

# 搭建教程

## 注册中心 Nacos

* [Spring Cloud 微服务实战——nacos 服务注册中心搭建](https://www.cnblogs.com/jeremylai7/p/15497219.html)
* [Spring Cloud Alibaba 使用 feign 和 rebion 进行服务消费](https://www.cnblogs.com/jeremylai7/p/15515666.html)
* [Nacos 服务注册原理分析](https://github.com/jeremylai7/blog/blob/origin/2023%E5%B9%B42%E6%9C%88/Nacos%E6%9C%8D%E5%8A%A1%E6%B3%A8%E5%86%8C%E5%8E%9F%E7%90%86%E5%88%86%E6%9E%90.md)

## 动态配置中心

* [Spring Cloud 整合 nacos 实现动态配置中心](https://github.com/jeremylai7/blog/blob/origin/2022%E5%B9%B410%E6%9C%88/Spring%20Cloud%20%E6%95%B4%E5%90%88%20nacos%20%E5%AE%9E%E7%8E%B0%E5%8A%A8%E6%80%81%E9%85%8D%E7%BD%AE%E4%B8%AD%E5%BF%83.md)
