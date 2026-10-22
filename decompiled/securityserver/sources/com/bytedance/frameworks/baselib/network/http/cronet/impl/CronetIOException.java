package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class CronetIOException extends TTNetExceptionStorage {
    private final int cronetInternalErrorCode;
    private int statusCode;

    public CronetIOException(Exception r9, BaseHttpRequestInfo r10, int r11) {
        String r0 = r9.getMessage();
        if (r9.getCause() != null) goto L5;
        Throwable r1 = r9;
    L6:
        super(r0, r1);
        URL r2 = r10.url;
        if (r2 == null) goto L10;
        String r3 = r2.toString();
    L9:
        String r5 = r3;
        super.setInfo(true, false, true, r5, r10.traceCode, r10);
        this.cronetInternalErrorCode = r11;
        if ((r9 instanceof HttpResponseException) == false) goto L15;
        this.statusCode = ((HttpResponseException) r9).getStatusCode();
        return;
    L15:
        return;
    L10:
        r3 = "";
        goto L9
    L5:
        r1 = r9.getCause();
        goto L6
    }

    public int getCronetInternalErrorCode() {
        return this.cronetInternalErrorCode;
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
}
