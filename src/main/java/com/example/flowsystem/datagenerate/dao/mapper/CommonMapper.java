package com.example.flowsystem.datagenerate.dao.mapper;

import com.example.flowsystem.datagenerate.dto.request.StartRecordMapperRequest;
import com.example.flowsystem.datagenerate.dto.request.StartRecordOriginMapperRequest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonMapper {

    void truncateTable(@Param("tableName") String tableName);

    void insertStartDataOrigin(@Param("tableName") String tableName, @Param("list") List<StartRecordOriginMapperRequest> list);

    void insertStartDataBefore(@Param("begin") Integer begin, @Param("tableName") String tableName);

    List<StartRecordMapperRequest> getStartDataByRem(@Param("tableName") String tableName, @Param("rem") Integer rem);

    void dropTableIfExists(@Param("tableName") String tableName);

    void createAppStartTable(@Param("tableName") String tableName);

    void insertTables(@Param("list") List<StartRecordMapperRequest> list, @Param("tableName") String tableName);
}