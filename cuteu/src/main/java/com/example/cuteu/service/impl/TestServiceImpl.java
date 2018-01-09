package com.example.cuteu.service.impl;

import com.example.cuteu.service.TestService;
import com.example.cuteu.utils.MD5Utils;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String getMd5(String key){
        return MD5Utils.md5(key);
    }
}
