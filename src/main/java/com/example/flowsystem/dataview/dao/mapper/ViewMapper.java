package com.example.flowsystem.dataview.dao.mapper;

import com.example.flowsystem.dataview.dto.response.ActiveChannelCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewMapper {

    List<ActiveChannelCount> getActiveCount(@Param("tableName") String tableName);

}