package com.bytedance.article.common.monitor.stack;

/* JADX INFO: loaded from: classes.dex */
public class HttpResponseException extends Exception {
    public String message;
    public int statusCode;

    public HttpResponseException(int r1, String r2) {
        this.statusCode = r1;
        this.message = r2;
    }

    public String getMsg() {
        return this.message;
    }

    public int getStatusCode() {
        return this.statusCode;
    }
}
