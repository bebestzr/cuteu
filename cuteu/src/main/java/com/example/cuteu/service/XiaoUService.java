package com.example.cuteu.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public interface XiaoUService {
    String ApplyCodeList()throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException;
    /**
     * 获取机器人列表
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    String getRobotList()throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException;
    /**
     * 获取机器人所在群列表
     * @param vcRobotSerialNo 机器人编号
     * @return
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws KeyManagementException
     */
    String getChatRoomList(String vcRobotSerialNo)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException;
    String getRobotUserInfo(String vcRobotSerialNo)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException;
    String MerchantSendMessages(String vcWeixinSerialN, String content)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException;
    //获取群成员（请求回调）
    String getChatRoom(String vcChatRoomSerialNo)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException ;
    String MerchantCmd(String merchantCmd)throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException ;
}
