package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.frameworks.baselib.network.http.exception.HttpResponseException;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;

/* JADX INFO: loaded from: classes3.dex */
public class CronetIOException extends TTNetExceptionStorage {
    private final int cronetInternalErrorCode;
    private BaseHttpRequestInfo requestInfo;
    private int statusCode;

    public CronetIOException(Exception r3, BaseHttpRequestInfo r4, String r5, int r6) {
        String r0 = r3.getMessage();
        if (r3.getCause() != null) goto L5;
        Throwable r1 = r3;
    L6:
        super(r0, r1);
        this.needReport = true;
        this.reportMonitorOk = false;
        this.reportMonitorError = true;
        this.requestInfo = r4;
        this.traceCode = r5;
        if ((r3 instanceof HttpResponseException) == false) goto L9;
        this.statusCode = ((HttpResponseException) r3).getStatusCode();
    L9:
        this.cronetInternalErrorCode = r6;
        return;
    L5:
        r1 = r3.getCause();
        goto L6
    }

    public String getRequestLog() {
        return this.requestInfo.requestLog;
    }

    public BaseHttpRequestInfo getRequestInfo() {
        return this.requestInfo;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public int getCronetInternalErrorCode() {
        return this.cronetInternalErrorCode;
    }
}
