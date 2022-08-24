package com.jws.wonseok.config.common;

import com.jws.wonseok.biz.v1.EnumTestModel.EnumMapperEnum;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EnumMapperConfig {

    @Bean
    public EnumMapper1 enumMapper1(){
        EnumMapper1 enumMapper = new EnumMapper1();
        enumMapper.put("EnumMapperEnum1", EnumMapperEnum.class);
        return enumMapper;
    }
    @Bean
    public EnumMapper2 enumMapper2(){
        EnumMapper2 enumMapper = new EnumMapper2();
        enumMapper.put("EnumMapperEnum2", EnumMapperEnum.class);
    return enumMapper;
    }

}
