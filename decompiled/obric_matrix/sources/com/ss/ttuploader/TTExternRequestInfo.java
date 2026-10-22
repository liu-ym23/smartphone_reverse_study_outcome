package com.ss.ttuploader;

import d.b.h.a.a.h.c;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTExternRequestInfo {
    private byte[] data;
    private c extraInfo;
    private String method;
    private JSONObject requestHeader;
    private String url;

    public TTExternRequestInfo() {
    }

    public TTExternRequestInfo(String r1, String r2, JSONObject r3, byte[] r4, c r5) {
        this.url = r1;
        this.method = r2;
        this.data = r4;
        this.requestHeader = r3;
        this.extraInfo = r5;
    }

    public byte[] getData() {
        return this.data;
    }

    public c getExtraInfo() {
        return this.extraInfo;
    }

    public String getMethod() {
        return this.method;
    }

    public JSONObject getRequestHeader() {
        return this.requestHeader;
    }

    public String getUrl() {
        return this.url;
    }

    public void setData(byte[] r1) {
        this.data = r1;
    }

    public void setExtraInfo(c r1) {
        this.extraInfo = r1;
    }

    public void setMethod(String r1) {
        this.method = r1;
    }

    public void setRequestHeader(JSONObject r1) {
        this.requestHeader = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
