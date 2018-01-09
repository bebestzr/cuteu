package com.example.cuteu.service.impl;

import com.example.cuteu.service.SendMessage;
import com.example.cuteu.utils.DateUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


@Service
public class SendMessageImpl implements SendMessage{
    @Override
    public void sendMessageEveryDay(String vcChatRoomSerialNo) throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, IOException {
        Timer timer=new Timer();
        Date morning = DateUtils.parse("2017-12-23 08:30:00", DateUtils.FORMAT_LONG);
        Date evening = DateUtils.parse("2017-12-22 22:00:00", DateUtils.FORMAT_LONG);
        new XiaoUServiceImpl().
                MerchantSendMessages(vcChatRoomSerialNo,"大家好，我开始工作了！");
        TimerTask morningTask=new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println(new XiaoUServiceImpl().
                            MerchantSendMessages(vcChatRoomSerialNo,"天亮了吧，闹铃响了吧，极不情愿地起床了吧，" +
                                    "我的问候及时赶到了吧，高兴了吧，那就笑笑吧。早安，祝你好心情!"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (KeyStoreException e) {
                    e.printStackTrace();
                } catch (KeyManagementException e) {
                    e.printStackTrace();
                }
                System.out.println("hello!");
            }
        };
        TimerTask eveningTask=new TimerTask() {
            @Override
            public void run() {
                try {
                    System.out.println(new XiaoUServiceImpl().
                            MerchantSendMessages(vcChatRoomSerialNo,"白日赚钱，顺从其美，夜晚入眠，精力充沛，放松心境，满意美梦，" +
                                    "自在安然，高兴无限，祝你晚安，轻松入眠，祝你开心每一天。"));
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                } catch (KeyStoreException e) {
                    e.printStackTrace();
                } catch (KeyManagementException e) {
                    e.printStackTrace();
                }
                System.out.println("hello!");
            }
        };
        timer.schedule(morningTask,morning,24*60*60*1000);

        timer.schedule(eveningTask,evening,24*60*60*1000);
    }
}
