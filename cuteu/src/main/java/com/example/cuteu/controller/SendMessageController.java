package com.example.cuteu.controller;


import com.example.cuteu.service.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping(value = "/send")
public class SendMessageController {

    @Autowired
    private SendMessage sendMessage;

    @ResponseBody
    @RequestMapping(value = "/sendMessageEveryday")
    public void sendMessage(@RequestParam String vcChatRoomSerialNo)
            throws IOException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
        sendMessage.sendMessageEveryDay(vcChatRoomSerialNo);
    }
}
