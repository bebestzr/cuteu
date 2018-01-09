package com.example.cuteu.vo;

public class RobotInfoVo {
    //机器人流水号/编号
    private String vcSerialNo;
    //群数
    private String nChatRoomCount;
    //昵称
    private String vcNickName;
    private String vcWxAlias;
    //base64昵称
    private String vcBase64NickName;
    //头像
    private String vcHeadImages;
    //二维码图片
    private String vcCodeImages;
    //机器人状态 10:开启 11:停止 14:异常
    private String nStatus;
    private String vcRobotWxId;

    public String getVcSerialNo() {
        return vcSerialNo;
    }

    public void setVcSerialNo(String vcSerialNo) {
        this.vcSerialNo = vcSerialNo;
    }

    public String getnChatRoomCount() {
        return nChatRoomCount;
    }

    public void setnChatRoomCount(String nChatRoomCount) {
        this.nChatRoomCount = nChatRoomCount;
    }

    public String getVcNickName() {
        return vcNickName;
    }

    public void setVcNickName(String vcNickName) {
        this.vcNickName = vcNickName;
    }

    public String getVcWxAlias() {
        return vcWxAlias;
    }

    public void setVcWxAlias(String vcWxAlias) {
        this.vcWxAlias = vcWxAlias;
    }

    public String getVcBase64NickName() {
        return vcBase64NickName;
    }

    public void setVcBase64NickName(String vcBase64NickName) {
        this.vcBase64NickName = vcBase64NickName;
    }

    public String getVcHeadImages() {
        return vcHeadImages;
    }

    public void setVcHeadImages(String vcHeadImages) {
        this.vcHeadImages = vcHeadImages;
    }

    public String getVcCodeImages() {
        return vcCodeImages;
    }

    public void setVcCodeImages(String vcCodeImages) {
        this.vcCodeImages = vcCodeImages;
    }

    public String getnStatus() {
        return nStatus;
    }

    public void setnStatus(String nStatus) {
        this.nStatus = nStatus;
    }

    public String getVcRobotWxId() {
        return vcRobotWxId;
    }

    public void setVcRobotWxId(String vcRobotWxId) {
        this.vcRobotWxId = vcRobotWxId;
    }
}
