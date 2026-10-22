package com.bytedance.apm.agent.instrumentation.interceptor;

import android.text.TextUtils;
import com.bytedance.apm.data.pipeline.NetDataPipeline;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
public class AddHeaderInterceptor implements Interceptor {
    public static final String X_TT_TRACE_LOG = "x-tt-trace-log";

    public AddHeaderInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain r4) throws IOException {
        Request r3 = r4.request();
        Request.Builder r0 = r3.newBuilder();
        if (TextUtils.isEmpty(r3.header("x-tt-trace-log")) == false) goto L17;
        if (NetDataPipeline.getInstance().isNetWorkV2() == false) goto L17;
        if (NetDataPipeline.getInstance().isEnableBaseApiAll() == false) goto L12;
        if (NetDataPipeline.getInstance().isEnableHookNetSample() == false) goto L12;
        r0.addHeader("x-tt-trace-log", "01");
    L12:
        if (NetDataPipeline.getInstance().getReportSLA() != 1) goto L17;
        if (NetDataPipeline.getInstance().isEnableHookNetSample() == false) goto L17;
        r0.addHeader("x-tt-trace-log", "02");
    L17:
        return r4.proceed(r0.build());
    }
}
