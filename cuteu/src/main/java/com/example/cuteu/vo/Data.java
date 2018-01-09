package com.example.cuteu.vo;

import java.util.Map;

public class Data {
    private String nMsgNum;
    private String nCallBack;
    private String nMsgType;
    private String msgContent;
    private String vcTitle;
    private String vcDesc;
    private String nVoiceTime;
    private String vcHref;

    @Override
    public String toString() {
        return "[{nMsgNum='"+ nMsgNum + ",nCallBack='" + nCallBack + ",nMsgType='" + nMsgType + ",msgContent='" + msgContent + ",vcTitle='" + vcTitle + ",vcDesc='" + vcDesc + ",nVoiceTime='" + nVoiceTime +",vcHref='" + vcHref+"}]";
    }

    public String getnMsgNum() {
        return nMsgNum;
    }

    public void setnMsgNum(String nMsgNum) {
        this.nMsgNum = nMsgNum;
    }

    public String getnCallBack() {
        return nCallBack;
    }

    public void setnCallBack(String nCallBack) {
        this.nCallBack = nCallBack;
    }

    public String getnMsgType() {
        return nMsgType;
    }

    public void setnMsgType(String nMsgType) {
        this.nMsgType = nMsgType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public String getVcTitle() {
        return vcTitle;
    }

    public void setVcTitle(String vcTitle) {
        this.vcTitle = vcTitle;
    }

    public String getVcDesc() {
        return vcDesc;
    }

    public void setVcDesc(String vcDesc) {
        this.vcDesc = vcDesc;
    }

    public String getnVoiceTime() {
        return nVoiceTime;
    }

    public void setnVoiceTime(String nVoiceTime) {
        this.nVoiceTime = nVoiceTime;
    }

    public String getVcHref() {
        return vcHref;
    }

    public void setVcHref(String vcHref) {
        this.vcHref = vcHref;
    }
}
