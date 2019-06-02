# userstatistic-mongodb-spring-boot-data
spring boot集成mongodb实现活跃用户数统计。
用mongodb和mysql分表实现1000w级的活跃用户数查询：
    1.新建64个分表-->用多线程添加1000w条测试数据到四个原始表-->添加测试数据到分表;
    2.将分表数据汇总到mongodb，再从mongodb查询活跃用户数。
