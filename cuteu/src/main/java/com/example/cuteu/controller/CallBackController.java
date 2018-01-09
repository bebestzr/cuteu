package com.example.cuteu.controller;

import com.example.cuteu.service.XiaoUService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(value = "/callBack")
public class CallBackController {

    @Autowired
    private final XiaoUService xiaoUService;

    public CallBackController(XiaoUService xiaoUService) {
        this.xiaoUService = xiaoUService;
    }

    //群成员回调地址
    @RequestMapping(value = "/userInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getCallBack(HttpServletRequest request){
        String strContext = request.getParameter("strContext");
        //获取对象
        JSONObject jsonObject = JSONObject.fromObject(strContext);
        //获取对象中的数组
        Object data = jsonObject.get("Data");
        JSONArray jsonArray = JSONArray.fromObject(data);
        //获取ChatRoomUserData数组
        JSONArray ChatRoomUserData = JSONArray.fromObject(jsonArray.get(0));
        JSONArray ChatRoomUserDataArray = JSONArray.fromObject(ChatRoomUserData);
        //测试数组中第一个对象
        JSONObject userInfo = JSONObject.fromObject( ChatRoomUserDataArray.get(0));
        Object vcNickName = userInfo.get("vcNickName");

        //JSONObject jsonOne = jsonObject.getJSONObject("ChatRoomUserData");
        //Object o = jsonOne.get("vcChatRoomSerialNo");
        //System.out.println("json"+json);
        System.out.println("value"+jsonObject.get("vcChatRoomSerialNo"));

        System.out.println("strContext"+strContext);
        System.out.println("数组"+userInfo);
        System.out.println("昵称"+vcNickName);
        return "SUCCESS";
    }

    /**
     * 群关键字回调地址
     * @param request
     * @return
     */
    @RequestMapping(value = "/vcCmdName",method = RequestMethod.POST)
    @ResponseBody
    public String vcCmdName(HttpServletRequest request)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        //String strContext = request.getParameter("strContext");
        //获取对象
        //JSONObject jsonObject = JSONObject.fromObject(strContext);
        //获取对象中的数组
        //Object data = jsonObject.get("Data");
        //JSONArray jsonArray = JSONArray.fromObject(data);
        //JSONObject result = JSONObject.fromObject(jsonArray.get(0));
        //Object vcFromWxUserSerialNo = result.get("vcFromWxUserSerialNo");
        //xiaoUService.MerchantSendMessages(vcFromWxUserSerialNo.toString());
        System.out.println("ceshi");
        return "SUCCESS";
    }

    @RequestMapping(value = "/a",method = RequestMethod.POST)
    @ResponseBody
    public String Statistics(HttpServletRequest request)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        String strContext = request.getParameter("strContext");
        //获取对象
        JSONObject jsonObject = JSONObject.fromObject(strContext);
        //获取对象中的数组
        Object data = jsonObject.get("Data");
        JSONArray jsonArray = JSONArray.fromObject(data);
        JSONObject result = JSONObject.fromObject(jsonArray.get(0));
        Object vcFromWxUserSerialNo = result.get("vcWXSerialNo");
        xiaoUService.MerchantSendMessages(vcFromWxUserSerialNo.toString(),null);
        System.out.println(jsonObject);
        return "SUCCESS";
    }
}
