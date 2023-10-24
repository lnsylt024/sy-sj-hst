package com.app.hst.test.service;

import com.app.hst.test.entity.TestEntity;
import com.app.hst.test.repository.TestRepository;
import com.app.hst.test.vo.TestVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {

    @Autowired
    private TestRepository repository;

    public Long createTest(TestVo vo){
        TestEntity entity = repository.save(this.voToObj(vo));
        return entity.getId();
    }

    public List<TestVo> getAllData(){
        List<TestEntity> lst =repository.findAll();
        return this.objToVo(lst);
    }

    private List<TestVo> objToVo(List<TestEntity> lst){
        List<TestVo> vos = new ArrayList<>(lst.size());

        lst.forEach(entity -> {
            TestVo vo = new TestVo();
            BeanUtils.copyProperties(entity,vo);
            vos.add(vo);
        });

        return vos;
    }

    private TestEntity voToObj(TestVo vo){
        TestEntity entity = new TestEntity();
        BeanUtils.copyProperties(vo,entity);
        entity.setUpdateUser("bbb");
        entity.setCreateUser("aaa");
        return entity;
    }

}
