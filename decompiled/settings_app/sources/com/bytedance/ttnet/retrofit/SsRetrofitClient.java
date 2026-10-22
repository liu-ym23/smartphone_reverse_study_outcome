package com.bytedance.ttnet.retrofit;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.frameworks.baselib.network.http.IHttpClient;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.ttnet.HttpClient;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public class SsRetrofitClient implements Client {
    public SsRetrofitClient() {
    }

    @Override // com.bytedance.retrofit2.client.Client
    public SsCall newSsCall(Request r2) throws IOException {
        if ((r2.getExtraInfo() instanceof BaseRequestContext) == false) goto L5;
        boolean r1 = ((BaseRequestContext) r2.getExtraInfo()).force_use_okhttp;
    L6:
        IHttpClient r3 = HttpClient.getHttpClient(r2.getUrl(), r1);
        if (r3 != null) goto L11;
        return null;
    L11:
        return r3.newSsCall(r2);
    L5:
        r1 = false;
        goto L6
    }
}
