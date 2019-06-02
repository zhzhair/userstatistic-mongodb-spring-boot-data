package com.example.flowsystem.datagenerate.dto.request;

public class StartRecordMapperRequest {
    private String appChannel;
    private String deviceId;

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

}
