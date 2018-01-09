package com.example.cuteu.vo;

import java.util.List;

public class PageBeanVo {
    private List objectList;
    private Long totalNum;

    public List getObjectList() {
        return objectList;
    }

    public void setObjectList(List objectList) {
        this.objectList = objectList;
    }

    public Long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Long totalNum) {
        this.totalNum = totalNum;
    }
}
