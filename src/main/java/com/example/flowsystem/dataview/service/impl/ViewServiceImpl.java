package com.example.flowsystem.dataview.service.impl;

import com.example.flowsystem.dataview.document.ActiveChannelCountMongo;
import com.example.flowsystem.dataview.dto.response.ActiveChannelCount;
import com.example.flowsystem.dataview.dao.mapper.ViewMapper;
import com.example.flowsystem.dataview.service.ViewService;
import org.bson.Document;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.IntStream;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;

@Service
public class ViewServiceImpl implements ViewService {

    @Resource
    private ViewMapper viewMapper;
    @Resource
    private MongoTemplate mongoTemplate;

    private final String tableName = "appstart_record_";

    @Override
    public List<Document> getActiveCount(int tableCount) {
        mongoTemplate.dropCollection(ActiveChannelCountMongo.class);
        if (!mongoTemplate.collectionExists(ActiveChannelCountMongo.class))
            IntStream.range(0, tableCount).parallel().forEach(this::getActiveCountOne);
        TypedAggregation<ActiveChannelCountMongo> aggregation = Aggregation.newAggregation(
                ActiveChannelCountMongo.class,
                project("appChannel", "activeCount"),//查询用到的字段
//                match(Criteria.where("dateTime").lte(Date.valueOf(todayZero).getTime()).gte(Date.valueOf(yesterday).getTime())),
                group("appChannel").sum("activeCount").as("activeCount"),
                sort(Sort.Direction.DESC, "activeCount"),
                project("appChannel", "activeCount").and("appChannel").previousOperation()//输出字段,后面是取别名
        ).withOptions(newAggregationOptions().allowDiskUse(true).build());
        AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, ActiveChannelCountMongo.class, Document.class);
        return results.getMappedResults();
    }

    private void getActiveCountOne(int i) {
        List<ActiveChannelCount> list = viewMapper.getActiveCount(tableName + i);
        mongoTemplate.insert(list, ActiveChannelCountMongo.class);
    }

}
