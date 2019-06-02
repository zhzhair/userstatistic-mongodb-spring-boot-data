package com.example.flowsystem.datagenerate.service;

/**
 * 添加测试数据
 */
public interface TestService {

    void insertTables(int tableCount);

    void insertStartDataOrigin(int rem);

    void createAppStartTable(int tableCount);

}
