package com.loopj.android.http;

import android.content.Context;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.protocol.HttpContext;

/* JADX INFO: loaded from: classes4.dex */
public class SyncHttpClient extends AsyncHttpClient {
    public SyncHttpClient() {
        super(false, 80, 443);
    }

    public SyncHttpClient(int r3) {
        super(false, r3, 443);
    }

    public SyncHttpClient(int r2, int r3) {
        super(false, r2, r3);
    }

    public SyncHttpClient(boolean r1, int r2, int r3) {
        super(r1, r2, r3);
    }

    public SyncHttpClient(SchemeRegistry r1) {
        super(r1);
    }

    @Override // com.loopj.android.http.AsyncHttpClient
    protected RequestHandle sendRequest(DefaultHttpClient r2, HttpContext r3, HttpUriRequest r4, String r5, ResponseHandlerInterface r6, Context r7) {
        if (r5 == null) goto L4;
        r4.addHeader("Content-Type", r5);
    L4:
        r6.setUseSynchronousMode(true);
        newAsyncHttpRequest(r2, r3, r4, r5, r6, r7).run();
        return new RequestHandle(null);
    }
}
