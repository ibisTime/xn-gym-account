package com.std.account.dto.res;

public class XN802210Res {
    // 订单号
    private String cqNo;

    public XN802210Res() {
    }

    public XN802210Res(String cqNo) {
        this.cqNo = cqNo;
    }

    public String getCqNo() {
        return cqNo;
    }

    public void setCqNo(String cqNo) {
        this.cqNo = cqNo;
    }
}