package com.bytedance.retrofit2.intercept;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.CallServerInterceptor;
import com.bytedance.retrofit2.RetrofitLogger;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class RealInterceptorChain implements Interceptor.Chain {
    private final Call call;
    private int calls;
    private final int index;
    private final List<Interceptor> interceptors;
    private final RetrofitMetrics metrics;
    private final Request request;

    public RealInterceptorChain(List<Interceptor> r1, int r2, Request r3, Call r4, RetrofitMetrics r5) {
        this.interceptors = r1;
        this.index = r2;
        this.request = r3;
        this.call = r4;
        this.metrics = r5;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Request request() {
        return this.request;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public SsResponse proceed(Request r10) throws Exception {
        if (this.index >= this.interceptors.size()) goto L37;
        int r0 = this.calls + 1;
        this.calls = r0;
        if (r0 <= 1) goto L12;
        Iterator<Interceptor> r1 = this.interceptors.iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Interceptor r2 = r1.next();
        if ((r2 instanceof CallServerInterceptor) == false) goto L8;
        ((CallServerInterceptor) r2).resetExecuted();
    L12:
        RealInterceptorChain r3 = new RealInterceptorChain(this.interceptors, this.index + 1, r10, this.call, this.metrics);
        Interceptor r4 = this.interceptors.get(this.index);
        StringBuilder r5 = new StringBuilder("interceptor = ");
        if (r4 == null) goto L15;
        String r6 = r4.toString();
    L16:
        RetrofitLogger.d("RealInterceptorChain", r5.append(r6).append(" url = ").append(r10.getUrl()).toString());
        if (r4 == null) goto L35;
        RetrofitMetrics r7 = this.metrics;
        if (r7 == null) goto L21;
        r7.recordInterceptorRequestEnd();
        this.metrics.recordInterceptorRequestStart(r4);
    L21:
        SsResponse r8 = r4.intercept(r3);
        RetrofitMetrics r9 = this.metrics;
        if (r9 == null) goto L26;
        r9.recordInterceptorResponseEnd();
        int r11 = this.index;
        if (r11 <= 0) goto L26;
        this.metrics.recordInterceptorResponseStart(this.interceptors.get(r11 - 1));
    L26:
        if (r8 == null) goto L33;
        if (r8.raw() == null) goto L31;
        return r8;
    L31:
        throw new IllegalStateException("interceptor " + r4 + " returned a ssResponse with no body");
    L33:
        throw new NullPointerException("interceptor " + r4 + " returned null");
    L35:
        throw new NullPointerException("interceptor " + this.index + " is null");
    L15:
        r6 = "";
        goto L16
    L37:
        throw new AssertionError();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public Call call() {
        return this.call;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor.Chain
    public RetrofitMetrics metrics() {
        return this.metrics;
    }
}
