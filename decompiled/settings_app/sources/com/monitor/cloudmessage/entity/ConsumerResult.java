package com.monitor.cloudmessage.entity;

import java.util.HashMap;

/* JADX INFO: loaded from: classes4.dex */
public class ConsumerResult {
    private String mErrMsg;
    private boolean mIsSuccess;
    private HashMap<String, String> specificParams;

    private ConsumerResult(boolean r1, String r2, HashMap<String, String> r3) {
        this.mIsSuccess = r1;
        this.mErrMsg = r2;
        this.specificParams = r3;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public HashMap<String, String> getSpecificParams() {
        return this.specificParams;
    }

    public static ConsumerResult build(boolean r1, String r2, HashMap<String, String> r3) {
        return new ConsumerResult(r1, r2, r3);
    }
}
