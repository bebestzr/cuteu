package com.example.cuteu.service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

public interface SendMessage {
    void  sendMessageEveryDay(String vcChatRoomSerialNo) throws
            KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException;
}
