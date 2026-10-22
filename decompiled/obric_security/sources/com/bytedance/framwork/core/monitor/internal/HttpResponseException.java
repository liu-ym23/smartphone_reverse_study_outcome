package com.bytedance.framwork.core.monitor.internal;

/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class HttpResponseException extends Exception {
    public String message;
    public int statusCode;

    public HttpResponseException(int r1, String r2) {
        this.statusCode = r1;
        this.message = r2;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMsg() {
        return this.message;
    }
}
