package com.example.cuteu.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class MD5Utils {
    private static Log log = LogFactory.getLog(MD5Utils.class);

    private String str;
    private String destKey;

    public String getDestKey() {
        return this.destKey;
    }

    private static char getSingleNumberChar() {
        Random random = new Random();
        int numberResult = random.nextInt(10);
        int ret = numberResult + 48;
        return (char) ret;
    }

    private static char getLowerOrUpperChar(int upper) {
        Random random = new Random();
        int numberResult = random.nextInt(26);
        int ret = 0;
        if (upper == 0) {// 小写
            ret = numberResult + 97;
        } else if (upper == 1) {// 大写
            ret = numberResult + 65;
        }
        return (char) ret;
    }

    public static String genKey() {
        String sRand = "";
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int wordType = random.nextInt(3);
            char retWord = 0;
            switch (wordType) {
                case 0:
                    retWord = getSingleNumberChar();
                    break;
                case 1:
                    retWord = getLowerOrUpperChar(0);
                    break;
                case 2:
                    retWord = getLowerOrUpperChar(1);
                    break;
            }
            sRand += String.valueOf(retWord);
        }
        return sRand;
    }

    public static void main(String[] args) {
//		System.out.println( new MD5Utils().encryption("hqradmins", "7FBY").equals("0a184406cac609c2cc00c48b6c83d8fd") );
        System.out.println(new MD5Utils().encryption("admin", "acdw"));
    }

    public String encryption(String plainText, String key) {
        if (key == null) {
            destKey = genKey();
            key = destKey;
        }
        String md5 = encrypt(plainText);
        return encrypt(md5 + key);
    }

    private String encrypt(String plainText) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
//			System.out.println("result: " + buf.toString());// 32位的加密
//			System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * md5加密
     *
     * @param text
     * @return
     */
    public static String md5(String text) {
        String str = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("MD5加密-NoSuchAlgorithm异常", e);
        } catch (Exception e) {
            log.error("MD5加密异常", e);
        }
        return str;
    }
}
