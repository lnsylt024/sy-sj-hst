package com.app.hst.test.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "[Test]",value = "测试")
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value ="获取数据",response = List.class,notes = "获取所有集合数据")
    @RequestMapping(value = "getList",method = RequestMethod.GET)
    public List<String> getListString(){
        List<String> stringList = new ArrayList<>();
        for(int i=0;i<100;i++){
            stringList.add("ABC"+i);
        }
        return stringList;
    }
}
