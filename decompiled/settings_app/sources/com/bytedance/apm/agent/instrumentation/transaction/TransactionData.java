package com.bytedance.apm.agent.instrumentation.transaction;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class TransactionData {
    private long bytesReceived;
    private long bytesSent;
    private String carrier;
    private int errorCode;
    private JSONObject extraData;
    private String httpMethod;
    private Object lock;
    private long requestEnd;
    private long requestStart;
    private int statusCode;
    private long totalTime;
    private String url;
    private String wanType;

    public TransactionData(String r3, String r4, long r5, int r7, int r8, long r9, long r11, String r13, String r14, JSONObject r15) {
        this.requestStart = System.currentTimeMillis();
        this.lock = new Object();
        this.url = r3;
        this.carrier = r4;
        this.totalTime = r5;
        this.statusCode = r7;
        this.errorCode = r8;
        this.bytesSent = r9;
        this.bytesReceived = r11;
        this.wanType = r13;
        this.httpMethod = r14;
        this.extraData = r15;
    }

    public String getUrl() {
        return this.url;
    }

    public String getHttpMethod() {
        return this.httpMethod;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int r2) {
        Object r0 = this.lock;
        monitor-enter(r0);
        this.errorCode = r2;     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public long getBytesSent() {
        return this.bytesSent;
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public String getWanType() {
        return this.wanType;
    }

    public long getRequestStart() {
        return this.requestStart;
    }

    public long getTotalTime() {
        return this.totalTime;
    }

    public JSONObject getExtraData() {
        return this.extraData;
    }

    public long getRequestEnd() {
        return this.requestEnd;
    }

    public void setRequestEnd(long r1) {
        this.requestEnd = r1;
    }

    public String toString() {
        return "TransactionData{requestStart=" + this.requestStart + ", url='" + this.url + "', carrier='" + this.carrier + "', totalTime=" + this.totalTime + ", statusCode=" + this.statusCode + ", errorCode=" + this.errorCode + ", bytesSent=" + this.bytesSent + ", bytesReceived=" + this.bytesReceived + ", wanType='" + this.wanType + "', httpMethod='" + this.httpMethod + "', extraData=" + this.extraData + '}';
    }
}
