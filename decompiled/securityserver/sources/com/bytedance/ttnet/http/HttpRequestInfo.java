package com.bytedance.ttnet.http;

import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;

/* JADX INFO: loaded from: classes.dex */
public class HttpRequestInfo extends BaseHttpRequestInfo<RequestContext> {
    public int cdnVerifyValue;
    public boolean reqTicketUnmatch;

    public HttpRequestInfo() {
        this.reqTicketUnmatch = false;
        this.cdnVerifyValue = -1;
    }

    public static void injectCreate() {
        BaseHttpRequestInfo.setCreate(new AnonymousClass1());
    }
}
