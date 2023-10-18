package com.app.hst.common.base.service;

import com.app.hst.common.config.DefaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseService {

    @Autowired
    private DefaultConfig defaultConfig;

}
