package com.example.flowsystem.datagenerate.controller;

import com.example.flowsystem.common.controller.BaseController;
import com.example.flowsystem.common.dto.BaseResponse;
import com.example.flowsystem.datagenerate.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 添加测试数据
 */
@RestController
@RequestMapping("/test")
@Api(description = "添加测试数据")
public class TestDataController extends BaseController {

    @Resource
    private TestService testService;

    @RequestMapping(value = "/insertData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "添加数据", notes = "新建分表>--添加原始表启动测试数据1000w条-->添加测试数据到分表，大概需要3到5分钟，请耐心等待！")
    public BaseResponse<Object> insertData(int rem, int tableCount) {
        BaseResponse<Object> baseResponse = new BaseResponse<>();
        testService.createAppStartTable(tableCount);
        testService.insertStartDataOrigin(rem);
        testService.insertTables(tableCount);
        baseResponse.setCode(0);
        baseResponse.setMsg("添加测试数据成功");
        return baseResponse;
    }

}
