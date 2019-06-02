package com.example.flowsystem.datagenerate.service.impl;

import com.example.flowsystem.common.constant.AppInfoDetail;
import com.example.flowsystem.datagenerate.dto.request.StartRecordOriginMapperRequest;

import java.util.*;

class AppInfos {

    private static String getRandomStr(String[] str) {
        int n = new Random().nextInt(str.length);
        return str[n];
    }

    /**
     * 这里在真实项目中还会有版本号，日期等字段，这里为了测试方便只保留下载渠道和手机标识码两个字段
     */
    static List<StartRecordOriginMapperRequest> getNewDevice(int rem) {
        List<StartRecordOriginMapperRequest> list = new ArrayList<>(5000);
        for (int i = 0; i < 5000; i++) {
            StartRecordOriginMapperRequest mapperRequest = new StartRecordOriginMapperRequest();
            String deviceId = UUID.randomUUID().toString().substring(0, 10);
            Integer deviceHash = Math.abs(deviceId.hashCode());
            Integer deviceIdx = deviceHash % rem;
            String appChannel = getRandomStr(AppInfoDetail.appChannel);
            mapperRequest.setAppChannel(appChannel);
            mapperRequest.setDeviceId(deviceId);
            mapperRequest.setDeviceHash(deviceHash);
            mapperRequest.setDeviceIdx(deviceIdx);
            list.add(mapperRequest);
        }
        return list;
    }

}
