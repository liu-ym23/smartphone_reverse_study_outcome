package com.bytedance.privacy.pseudoid.network;

/* JADX INFO: loaded from: classes3.dex */
public class NetworkRequest {
    private String certChain;
    private String requestType;
    private String requestUrl;

    public NetworkRequest() {
    }

    public void setRequestType(String r1) {
        this.requestType = r1;
    }

    public void setRequestUrl(String r1) {
        this.requestUrl = r1;
    }

    public void setCertChain(String r1) {
        this.certChain = r1;
    }

    public String getRequestType() {
        return this.requestType;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public String getCertChain() {
        return this.certChain;
    }
}
