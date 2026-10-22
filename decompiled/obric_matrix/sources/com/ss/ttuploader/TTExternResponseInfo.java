package com.ss.ttuploader;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class TTExternResponseInfo {
    public byte[] responseBody;
    public JSONObject responseHeader;
    public String responseHeaderStr;
    public int statusCode;
    public String url;

    public TTExternResponseInfo() {
    }

    public byte[] getResponseBody() {
        return this.responseBody;
    }

    public JSONObject getResponseHeader() {
        return this.responseHeader;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getUrl() {
        return this.url;
    }

    public void setResponseBody(byte[] r1) {
        this.responseBody = r1;
    }

    public void setResponseHeader(JSONObject r1) {
        this.responseHeader = r1;
        if (r1 == null) goto L6;
        this.responseHeaderStr = r1.toString();
        return;
    }

    public void setStatusCode(int r1) {
        this.statusCode = r1;
    }

    public void setUrl(String r1) {
        this.url = r1;
    }
}
