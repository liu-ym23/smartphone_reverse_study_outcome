package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall;
import com.bytedance.retrofit2.client.Request;
import java.io.IOException;
import java.net.HttpURLConnection;

/* JADX INFO: loaded from: classes.dex */
class CronetSsCall extends BaseCronetSsCall {
    private HttpURLConnection httpConnection;

    public CronetSsCall(Request r1) {
        super(r1);
        this.httpConnection = null;
    }

    @Override // com.bytedance.retrofit2.client.SsCall
    public void cancel() {
        cancelInner(this.httpConnection);
    }

    @Override // com.bytedance.retrofit2.ttnet.SsCallTTNetExtend
    public void cancelNormalRequest(Throwable r2, boolean r3) {
        cancelNormalRequestInner(this.httpConnection, r2, r3);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    public HttpURLConnection connection() {
        return this.httpConnection;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public IOException convertException(Exception r4) {
        if ("com.ttnet.org.chromium.net.urlconnection.TTRequestCanceledException".equals(r4.getClass().getName()) == false) goto L5;
        doCollect();
        int r0 = SsCronetHttpClient.getCronetInternalErrorCode(this.httpConnection);
    L7:
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r4.getClass().getName()) == false) goto L9;
    L10:
        r0 = SsCronetHttpClient.getCronetInternalErrorCode(this.httpConnection);
    L12:
        return new CronetIOException(r4, this.requestInfo, r0);
    L9:
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r4.getClass().getName()) == false) goto L12;
    L5:
        r0 = 0;
        goto L7
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        BaseSsCall.getRequestMetrics(this.requestInfo, this);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.impl.BaseSsCall
    public int getStatusCodeFromException(IOException r3) {
        if ("com.ttnet.org.chromium.net.impl.NetworkExceptionImpl".equals(r3.getClass().getName()) == true) goto L10;
        if ("com.ttnet.org.chromium.net.impl.QuicExceptionImpl".equals(r3.getClass().getName()) == true) goto L10;
        return -1;
    L10:
        return SsCronetHttpClient.getCronetInternalErrorCode(this.httpConnection);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall
    public void setConnection(HttpURLConnection r1) {
        this.httpConnection = r1;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.impl.BaseCronetSsCall, com.bytedance.retrofit2.client.SsCall
    public boolean setThrottleNetSpeed(long r3) {
        super.setThrottleNetSpeed(r3);
        HttpURLConnection r2 = this.httpConnection;
        if (r2 != null) goto L11;
        return true;
    L11:
        Reflect.on(r2).call("setThrottleNetSpeed", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(r3)});     // Catch: Throwable -> L6
        return true;
    L6:
        th = move-exception;
        th.printStackTrace();
        return false;
    }
}
