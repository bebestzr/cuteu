package com.example.cuteu.controller;


import com.example.cuteu.utils.TotalResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/xiaou")
public class XiaoUController {

    @RequestMapping
    @ResponseBody
    public TotalResult getRobotList(){
        return null;
        //Map<String,String> result = Maps.newHashMap() ;
       // String STRCONTEXT = GsonUtils.getGson().toJson();
    }
}
