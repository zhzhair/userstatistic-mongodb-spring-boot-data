package com.example.flowsystem.dataview.controller;

import com.example.flowsystem.common.controller.BaseController;
import com.example.flowsystem.common.dto.BaseResponse;
import com.example.flowsystem.dataview.service.ViewService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bson.Document;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 添加测试数据，对于月活跃，一个月去重后的数据放一个表
 */
@RestController
@RequestMapping("/view")
@Api(description = "查询数据")
public class DataQueryController extends BaseController {

    @Resource
    private ViewService viewService;

    @RequestMapping(value = "/getActiveCount", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "查询活跃设备数", notes = "查询活跃设备数")
    public BaseResponse<Object> getActiveCount(int tableCount) {
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        List<Document> list = viewService.getActiveCount(tableCount);
        baseResponse.setCode(0);
        baseResponse.setMsg("获取数据成功");
        baseResponse.setData(list);
        return baseResponse;
    }

}
