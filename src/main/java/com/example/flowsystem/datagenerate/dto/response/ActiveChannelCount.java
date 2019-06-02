package com.example.flowsystem.datagenerate.dto.response;

public class ActiveChannelCount {
    private String appChannel;
    private Integer activeCount;

    public String getAppChannel() {
        return appChannel;
    }

    public void setAppChannel(String appChannel) {
        this.appChannel = appChannel;
    }

    public Integer getActiveCount() {
        return activeCount;
    }

    public void setActiveCount(Integer activeCount) {
        this.activeCount = activeCount;
    }
}
