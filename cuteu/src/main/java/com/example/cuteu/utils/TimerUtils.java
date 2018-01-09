package com.example.cuteu.utils;


import com.example.cuteu.service.impl.XiaoUServiceImpl;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.TimerTask;

public class TimerUtils extends TimerTask{

    @Override
    public void run() {
        /*try {
            System.out.println(new XiaoUServiceImpl().
                    MerchantSendMessages("1AEA1A2A1D192D638A96143C9CC340AE"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }*/
        System.out.println("hello!");
    }
}
