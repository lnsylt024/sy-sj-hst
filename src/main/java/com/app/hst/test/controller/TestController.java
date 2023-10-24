package com.app.hst.test.controller;

import com.app.hst.common.base.controller.BaseController;
import com.app.hst.test.service.TestService;
import com.app.hst.test.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "[Test]",value = "测试")
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {

    @Autowired
    TestService service;

    @ApiOperation(value ="获取模拟数据",response = List.class,notes = "获取所有模拟数据")
    @RequestMapping(value = "/getList",produces = "application/json",method = RequestMethod.GET)
    public List<String> getList(){
        List<String> stringList = new ArrayList<>();
        for(int i=0;i<100;i++){
            stringList.add("ABC"+i);
        }
        return stringList;
    }

    @ApiOperation(value ="获取所有数据",response = List.class,notes = "获取所有集合数据")
    @RequestMapping(value = "/getVos",produces = "application/json", method = RequestMethod.GET)
    public List<TestVo> getVos(){
        List<TestVo> vos = service.getAllData();
        return vos;
    }

    @ApiOperation(value = "",response = TestVo.class, notes = "追加数据")
    @RequestMapping(value = "/save", produces = "application/json", method = RequestMethod.POST)
    public Long save(@RequestBody TestVo vo){
        return service.createTest(vo);
    }


}
