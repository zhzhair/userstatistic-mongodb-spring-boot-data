package com.example.flowsystem.dataview.document;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mongo_start_record")
public class ActiveChannelCountMongo {
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
