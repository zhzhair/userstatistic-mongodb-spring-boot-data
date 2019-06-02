package com.example.flowsystem.dataview.service;

import org.bson.Document;

import java.util.List;

public interface ViewService {
    List<Document> getActiveCount(int tableCount);
}
