package com.example.flowsystem.datagenerate.service.impl;

import com.example.flowsystem.datagenerate.dao.mapper.CommonMapper;
import com.example.flowsystem.datagenerate.dto.request.StartRecordMapperRequest;
import com.example.flowsystem.datagenerate.dto.request.StartRecordOriginMapperRequest;
import com.example.flowsystem.datagenerate.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 添加测试数据
 */
@Service
public class TestServiceImpl implements TestService {

    private String tableName = "appstart_record";
    @Resource
    private CommonMapper commonMapper;

    @Override
    public void insertTables(int tableCount) {
        IntStream.range(0, tableCount).parallel().forEach(i -> this.insertOneTable(i, tableCount));
    }

    @Override
    public void insertStartDataOrigin(int rem) {
        for (int i = 0; i < 4; i++) {
            commonMapper.truncateTable(tableName + i);
        }
        IntStream.range(0, 25).parallel().forEach(i -> insertStartNewDataOne(rem));
        IntStream.range(0, 475).parallel().forEach(i -> insertStartDataBefore());
    }

    @Override
    public void createAppStartTable(int tableCount) {
        IntStream.range(0, tableCount).parallel().forEach(this::dropAppStartTableOne);
        IntStream.range(0, tableCount).parallel().forEach(this::createAppStartTableOne);
    }

    private void insertOneTable(int i, int tableCount) {
        commonMapper.truncateTable(tableName + "_" + i);
        for (int k = 0; k < 4; k++) {
            List<StartRecordMapperRequest> list0 = new ArrayList<>(1000_0000 / tableCount / 4);
            for (int j = i; j < 16384; j += tableCount) {
                List<StartRecordMapperRequest> list = commonMapper.getStartDataByRem(tableName + k, j);
                list0.addAll(list);
            }
            int size = list0.size();
            for (int j = 0; j < size / 10000 + 1; j++) {
                List<StartRecordMapperRequest> list = list0.subList(j * 10000, Math.min(j * 10000 + 10000, size));
                commonMapper.insertTables(list, tableName + "_" + i);
            }
        }
        System.out.println(i + " =================");
    }

    private void createAppStartTableOne(int i) {
        commonMapper.createAppStartTable(tableName + "_" + i);
    }

    private void dropAppStartTableOne(int i) {
        commonMapper.dropTableIfExists(tableName + "_" + i);
    }

    private void insertStartNewDataOne(int rem) {
        for (int i = 0; i < 4; i++) {
            List<StartRecordOriginMapperRequest> list = AppInfos.getNewDevice(rem);
            commonMapper.insertStartDataOrigin(tableName + i, list);
        }
    }

    private void insertStartDataBefore() {
        for (int i = 0; i < 4; i++) {
            int begin = new Random().nextInt(12_0000);
            commonMapper.insertStartDataBefore(begin, tableName + i);
        }
    }
}
