package com.example.cuteu.service.impl;

import com.example.cuteu.service.XiaoUService;
import com.example.cuteu.utils.*;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
@Service
public class XiaoUServiceImpl implements XiaoUService {
    /**
     * 开群信息
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    @Override
    public String ApplyCodeList()throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        Map<String,String> context = Maps.newLinkedHashMap();
        context.put("MerchantNo", AppContents.MerchantNo);
        context.put("vcRobotSerialNo",  AppContents.RobotSerialNo_1);
        context.put("nType", "10");
        context.put("vcChatRoomSerialNo","");
        context.put("nCodeCount", "1");
        context.put("nAddMinute","10");
        context.put("nIsNotify", "1");
        context.put("vcNotifyContent","yxtk");
        String strContext = GsonUtils.getGson().toJson(context);
        String md5 = MD5Utils.md5(strContext + AppContents.Secret);
        String url = "http://skyagent.shequnguanjia.com/Merchant.asmx/ApplyCodeList?strContext="+strContext+"&strSign="+md5;
        return HttpUtils.sendGet(url,null);

    }

    /**
     * 获取机器人列表
     * @return
     * @throws IOException
     *
     *
     *
     *
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    @Override
    public String getRobotList()throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        Map<String,String> context = Maps.newLinkedHashMap();
        context.put("MerchantNo", AppContents.MerchantNo);
        String strContext = GsonUtils.getGson().toJson(context);
        String md5 = MD5Utils.md5(strContext + AppContents.Secret);
        String url = "http://skyagent.shequnguanjia.com/Merchant.asmx/RobotList?strContext="+strContext+"&strSign="+md5;
        return HttpUtils.sendGet(url,null);

    }

    /**
     * 获取机器人所在群列表
     * @param vcRobotSerialNo 机器人编号
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    @Override
    public String getChatRoomList(String vcRobotSerialNo)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        Map<String,String> context = Maps.newLinkedHashMap() ;
        context.put("MerchantNo", AppContents.MerchantNo);
        context.put("vcRobotSerialNo", vcRobotSerialNo);
        String strContext = GsonUtils.getGson().toJson(context);
        String md5 = MD5Utils.md5(strContext + AppContents.Secret);
        String url = "http://skyagent.shequnguanjia.com/Merchant.asmx/ChatRoomList?strContext="+strContext+"&strSign="+md5;
        return HttpUtils.sendGet(url,null);
    }

    /**
     * 获取好友
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    @Override
    public String getRobotUserInfo(String vcRobotSerialNo)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        Map<String,String> context = Maps.newLinkedHashMap() ;
        context.put("MerchantNo", AppContents.MerchantNo);
        context.put("vcRobotSerialNo", AppContents.RobotSerialNo_1);
        String strContext = GsonUtils.getGson().toJson(context);
        String md5 = MD5Utils.md5(strContext + AppContents.Secret);
        String url = "http://skyagent.shequnguanjia.com/Merchant.asmx/GetRobotUserInfo?strContext="+strContext+"&strSign="+md5;
        return HttpUtils.sendGet(url,null);

    }

    /**
     * 群内发送消息
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    @Override
    public String MerchantSendMessages(String vcChatRoomSerialNo,String content)throws IOException,
            NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        /*Map<String,String> context = Maps.newLinkedHashMap();
        //商家编号
        context.put("MerchantNo", AppContents.MerchantNo);
        //商家业务流水号
        context.put("vcRelaSerialNo", "");
        //群编号 (如果群编号传空，则会私聊指定艾特用户编号，必须先加机器人为好友。)
        context.put("vcChatRoomSerialNo", "1AEA1A2A1D192D638A96143C9CC340AE");
        //机器人编号
        context.put("vcRobotSerialNo",  AppContents.RobotSerialNo_1);
        //是否艾特所有人 (0 艾特群内所有人 1 艾特单个人或者不艾特人)
        context.put("nIsHit", "1");
        //指定艾特用户编号(多个用,号隔开,如果不用艾特则传空)
        context.put("vcWeixinSerialNo", "69276C5973E37C2B22E2AFEA1F2DC428,5E78055D8A21026C699A0F41FE256FB1");*/

        //发送消息格式处理
        JsonObject object = new JsonObject();
        JsonArray array = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("nMsgNum","1");
        jsonObject.addProperty("nCallBack","1");
        jsonObject.addProperty("nMsgType","2001");
        jsonObject.addProperty("msgContent",content);
        jsonObject.addProperty("vcTitle","");
        jsonObject.addProperty("vcDesc","");
        jsonObject.addProperty("nVoiceTime","0");
        jsonObject.addProperty("vcHref","");
        array.add(jsonObject);

        object.addProperty("MerchantNo", AppContents.MerchantNo);
        object.addProperty("vcRelaSerialNo", "");
        object.addProperty("vcChatRoomSerialNo", vcChatRoomSerialNo);
        object.addProperty("vcRobotSerialNo",  AppContents.RobotSerialNo_1);
        object.addProperty("nIsHit", "1");
        object.addProperty("vcWeixinSerialNo", "");
        /*object.addProperty("vcWeixinSerialNo", "69276C5973E37C2B22E2AFEA1F2DC428,5E78055D8A21026C699A0F41FE256FB1");*/
        object.add("Data",array);

        //String strContext = GsonUtils.getGson().toJson(context) +object;
        //strContext = strContext.replaceAll("}[{]",",");
        String md5 = MD5Utils.md5(object + AppContents.Secret);
        String url = "http://skyagent.shequnguanjia.com/Merchant.asmx/MerchantSendMessages?strContext="+object+"&strSign="+md5;
        return HttpUtils.sendGet(url,null);
    }

    //获取群成员（请求回调）
    @Override
    public String getChatRoom(String vcChatRoomSerialNo)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        JsonObject object = new JsonObject();
        object.addProperty("MerchantNo", AppContents.MerchantNo);
        object.addProperty("vcChatRoomSerialNo", "1AEA1A2A1D192D638A96143C9CC340AE");
        String md5 = MD5Utils.md5(object + AppContents.Secret);
        String url = "http://skyagent.shequnguanjia.com/Merchant.asmx/ChatRoomUserInfo?strContext="+object+"&strSign="+md5;
        return HttpUtils.sendGet(url,null);
    }

    //关键字
    @Override
    public String MerchantCmd(String merchantCmd)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        JsonObject object = new JsonObject();
        JsonArray array = new JsonArray();
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("vcCmdName","ab");
        array.add(jsonObject);
        object.addProperty("MerchantNo", AppContents.MerchantNo);
        object.addProperty("vcChatRoomSerialNo","1E7B48F25E68DD707E7601902DA427BF");
        object.add("Data",array);
        String md5 = MD5Utils.md5(object + AppContents.Secret);
        String url = "http://skyagent.shequnguanjia.com/Merchant.asmx/MerchantCmd?strContext="+object+"&strSign="+md5;
        return HttpUtils.sendGet(url,null);
    }
}
