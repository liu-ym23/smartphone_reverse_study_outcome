package com.bytedance.framwork.core.sdkmonitor;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ApiData {
    public String apiType;
    public long duration;
    public JSONObject extJson;
    public String sendIp;
    public long sendTime;
    public String sendUrl;
    public int status;
    public String traceCode;

    public ApiData(String r1, long r2, long r4, String r6, String r7, String r8, int r9, JSONObject r10) {
        this.apiType = r1;
        this.duration = r2;
        this.sendTime = r4;
        this.sendUrl = r6;
        this.sendIp = r7;
        this.traceCode = r8;
        this.status = r9;
        this.extJson = r10;
    }
}
