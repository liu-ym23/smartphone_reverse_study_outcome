package com.bytedance.apm.ttnet;

import com.bytedance.apm.data.pipeline.NetDataPipeline;
import com.bytedance.apm.util.ListUtils;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public class TTNetSampleInterceptor implements Interceptor {
    public static final String X_TT_TRACE_LOG = "x-tt-trace-log";

    public TTNetSampleInterceptor() {
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r4) throws Exception {
        Request r0 = r4.request();
        if (ListUtils.isEmpty(r0.headers("x-tt-trace-log")) == false) goto L19;
        if (NetDataPipeline.getInstance().isNetWorkV2() == false) goto L19;
        if (NetDataPipeline.getInstance().isEnableBaseApiAll() == false) goto L13;
        if (NetDataPipeline.getInstance().isEnableHookNetSample() == false) goto L13;
        return r4.proceed(getNewRequest(r0, "01"));
    L13:
        if (NetDataPipeline.getInstance().getReportSLA() != 1) goto L19;
        if (NetDataPipeline.getInstance().isEnableHookNetSample() == false) goto L19;
        return r4.proceed(getNewRequest(r0, "02"));
    L19:
        return r4.proceed(r0);
    }

    private Request getNewRequest(Request r3, String r4) {
        ArrayList r0 = new ArrayList(r3.getHeaders());
        Request.Builder r2 = r3.newBuilder();
        r0.add(new Header("x-tt-trace-log", r4));
        return r2.headers(r0).build();
    }
}
