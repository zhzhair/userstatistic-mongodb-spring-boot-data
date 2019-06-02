package com.example.flowsystem.datagenerate.dto.request;

public class StartRecordOriginMapperRequest {
    private String appChannel;
    private String deviceId;
    private Integer deviceHash;
    private Integer deviceIdx;

    public String getAppChannel() {
        return appChannel;
    }

    public void setAppChannel(String appChannel) {
        this.appChannel = appChannel;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getDeviceHash() {
        return deviceHash;
    }

    public void setDeviceHash(Integer deviceHash) {
        this.deviceHash = deviceHash;
    }

    public Integer getDeviceIdx() {
        return deviceIdx;
    }

    public void setDeviceIdx(Integer deviceIdx) {
        this.deviceIdx = deviceIdx;
    }
}
