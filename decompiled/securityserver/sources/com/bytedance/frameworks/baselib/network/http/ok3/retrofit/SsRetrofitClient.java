package com.bytedance.frameworks.baselib.network.http.ok3.retrofit;

import android.content.Context;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.frameworks.baselib.network.http.ok3.HttpClient;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;

/* JADX INFO: loaded from: classes.dex */
public class SsRetrofitClient implements Client {
    private Context mContext;

    @Deprecated
    public SsRetrofitClient(Context r1) {
        this.mContext = r1;
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request r2) {
        IHttpClient r1 = HttpClient.getHttpClient(this.mContext, r2.getUrl());
        if (r1 != null) goto L5;
        return null;
    L5:
        return r1.newSsCall(r2);
    }
}
