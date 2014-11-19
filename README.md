smiling框架
========================
------------------------
>   smiling框架主要目的是
> * 快速开发
> * 最大限度积累技术、功能模块
> * 扩展灵活


    smiling框架是对springMVC/spring/spirng data jpa简单封装
    smiling框架积累常用功能、插拔式引入项目模块
    smiling框架按照模块分层开发，项目管理工具使用maven

---------
## 模块 
---------
> smiling框架通过以下模块组成框架基础，框架各个模块作用及介绍：

#### smilingframework
    父项目 - 基础项目管理
#### smilingframework-web 
    web模块 - 管理web层，简单封装springMVC框架，提供一些基类和功能
#### smilingframework-service
    service模块 - 管理service层，提供一些基类和通用功能
#### smilingframework-dao
    dao模块 - 管理dao数据层，提供数据存储功能，封装了基本的CRUD操作
#### smilingframework-core
    core模块 - 核心管理模块，提供工具类、设计模式、核心功能模块。
----------
## 框架结构
    模块继承关系：web、service、dao、core都继承于smilingframework
    web模块 - pom.xml中引入service模块、core模块
    service模块 - pom.xml中引入dao模块、core模块
    dao模块 - pom.xml中引入core模块
## 创建新项目
----------
#### WEB项目

#### jar项目

----------

## 基础功能
----------


----------

## API
----------
#### web模块
* 获取contextPath
 
        请求：/context/path
        请求方法：GET/POST
        参数：无
        响应：(字符串)项目路径 （ContextPath）
        示例：项目 police ==> /police
   
 
