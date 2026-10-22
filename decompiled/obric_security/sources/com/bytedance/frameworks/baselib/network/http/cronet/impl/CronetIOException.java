package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;

/* JADX INFO: loaded from: classes.dex */
public class CronetIOException extends TTNetExceptionStorage {
    private final int cronetInternalErrorCode;
    private int statusCode;

    public CronetIOException(Exception r10, BaseHttpRequestInfo r11, int r12) {
        String r0 = r10.getMessage();
        if (r10.getCause() != null) goto L5;
        Throwable r1 = r10;
    L6:
        super(r0, r1);
        if (r11.url == null) goto L9;
        String r2 = r11.url.toString();
    L10:
        super.setInfo(true, false, true, r2, r11.traceCode, r11);
        this.cronetInternalErrorCode = r12;
        if ((r10 instanceof HttpResponseException) == false) goto L14;
        this.statusCode = ((HttpResponseException) r10).getStatusCode();
        return;
    L14:
        return;
    L9:
        r2 = "";
        goto L10
    L5:
        r1 = r10.getCause();
        goto L6
    }

    public BaseHttpRequestInfo getRequestInfo() {
        return (BaseHttpRequestInfo) this.infoObj;
    }

    public String getRequestLog() {
        return getRequestInfo().requestLog;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getCronetInternalErrorCode() {
        return this.cronetInternalErrorCode;
    }
}
