package com.app.hst.common.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class DefaultConfig {

    @Value("${test.flg}")
    private String testFlg;
}
