package com.bytedance.retrofit2;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.retrofit2.cache.ICacheServer;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.SsCallTTNetExtend;
import java.io.IOException;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class CallServerInterceptor<T> implements Interceptor, IMetricsCollect, IRequestInfo {
    private volatile boolean mCanceled;

    @Nullable
    private Throwable mCreationFailure;
    private volatile boolean mExecuted;

    @Nullable
    private Request mOriginalRequest;

    @Nullable
    private volatile SsCall mRawCall;
    private final RequestFactory<T> mRequestFactory;
    private volatile long mThrottleNetSpeed;

    public CallServerInterceptor(RequestFactory<T> r1) {
        this.mRequestFactory = r1;
    }

    private SsCall createRawCall(Request r1) {
        return this.mRequestFactory.clientProvider.get().newSsCall(r1);
    }

    private Response executeCall(SsCall r3, RetrofitMetrics r4) {
        if (r4 == null) goto L5;
        r4.executeCallStartTime = SystemClock.uptimeMillis();
    L5:
        return r3.execute();
    }

    public void cancel() {
        this.mCanceled = true;
        if (this.mRawCall == null) goto L6;
        this.mRawCall.cancel();
        return;
    }

    public void cancelNormalRequest(boolean r1, Throwable r2, boolean r3) {
        this.mCanceled = r1;
        if (this.mRawCall != null) goto L5;
        return;
    L5:
        if ((this.mRawCall instanceof SsCallTTNetExtend) == false) goto L9;
        ((SsCallTTNetExtend) this.mRawCall).cancelNormalRequest(r2, r3);
        return;
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        if ((this.mRawCall instanceof IMetricsCollect) == false) goto L6;
        ((IMetricsCollect) this.mRawCall).doCollect();
        return;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        if ((this.mRawCall instanceof IRequestInfo) == true) goto L5;
        return null;
    L5:
        return ((IRequestInfo) this.mRawCall).getRequestInfo();
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r10) {
        RetrofitMetrics r0 = r10.metrics();
        if (r0 == null) goto L5;
        r0.callServerInterceptorTime = System.currentTimeMillis();
    L5:
        long r1 = SystemClock.uptimeMillis();
        Request r11 = r10.request();
        this.mOriginalRequest = r11;
        if (r0 == null) goto L8;
        r0.priorityLevel = r11.getPriorityLevel();
        r0.requestPriorityLevel = this.mOriginalRequest.getRequestPriorityLevel();
    L8:
        monitor-enter(this);
    L77:
        th = move-exception;
        throw th;
    L10:
        if (this.mExecuted == true) goto L80;
        this.mExecuted = true;     // Catch: Throwable -> L77
        monitor-exit(this);     // Catch: Throwable -> L77
        Throwable r3 = this.mCreationFailure;
        if (r3 != null) goto L16;
        Request r4 = this.mOriginalRequest;
        if (r4 == null) goto L25;
        r4.setMetrics(r0);
    L25:
        if (this.mRequestFactory.cacheServer == null) goto L29;
        if (r0 == null) goto L28;
        r0.requestInterceptDuration.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r1));
    L28:
        Response r5 = this.mRequestFactory.cacheServer.getCacheResponse(this.mOriginalRequest);
    L31:
        if (r5 == null) goto L84;
    L68:
        if (r0 == null) goto L73;
        List<Header> r12 = r5.headers("content-encoding");
        if (r12 == null) goto L72;
        r0.responseCompressType = r12.get(0).getValue();
    L72:
        r0.recordInterceptorResponseStart(this);
    L73:
        long r2 = SystemClock.uptimeMillis();
        SsResponse<T> r9 = parseResponse(r5, r0);
        if (r0 == null) goto L76;
        r0.responseInterceptDuration.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r2));
    L76:
        return r9;
    L84:
        this.mRawCall = createRawCall(this.mOriginalRequest);     // Catch: Throwable -> L38 Throwable -> L40
        if (this.mThrottleNetSpeed <= 0) goto L43;
        long r6 = SystemClock.uptimeMillis();     // Catch: Throwable -> L38 Throwable -> L40
        this.mRawCall.setThrottleNetSpeed(this.mThrottleNetSpeed);     // Catch: Throwable -> L38 Throwable -> L40
        if (r0 == null) goto L43;
        r0.setThrottleNetSpeedDuration = SystemClock.uptimeMillis() - r6;     // Catch: Throwable -> L38 Throwable -> L40
    L43:
        if (this.mCanceled == false) goto L45;
        this.mRawCall.cancel();
    L45:
        if (r0 == null) goto L52;
        r0.requestInterceptDuration.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r1));
        List<Header> r7 = this.mOriginalRequest.headers("content-encoding");
        if (r7 != null) goto L49;
    L51:
        r0.recordInterceptorRequestEnd();
        goto L52
    L49:
        if (r7.size() <= 0) goto L51;
        r0.requestCompressType = this.mOriginalRequest.headers("content-encoding").get(0).getValue();
    L52:
        r5 = executeCall(this.mRawCall, r0);
        if (r0 == null) goto L55;
        r0.callserverExecuteSuccess = true;
    L55:
        ICacheServer r13 = this.mRequestFactory.cacheServer;
        if (r13 == null) goto L68;
        Response r14 = r13.putCacheResponse(this.mOriginalRequest, r5);
        if (r14 == null) goto L68;
        r5 = r14;
    L40:
        e = move-exception;
        this.mCreationFailure = e;
        throw e;
    L38:
        th = move-exception;
        this.mCreationFailure = th;
        if ((th instanceof Exception) == false) goto L65;
        throw th;
    L65:
        throw new Exception(th);
    L29:
        r5 = null;
        goto L31
    L16:
        if ((r3 instanceof IOException) == false) goto L20;
        throw ((IOException) r3);
    L20:
        throw new Exception(this.mCreationFailure);
    L80:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L77
    }

    public boolean isCanceled() {
        return this.mCanceled;
    }

    public synchronized boolean isExecuted() {
        monitor-enter(this);
        boolean r0 = this.mExecuted;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public SsResponse<T> parseResponse(Response r4, RetrofitMetrics r5) {
        if (r4 == null) goto L31;
        TypedInput r0 = r4.getBody();
        int r1 = r4.getStatus();
        if (r1 < 200) goto L29;
        if (r1 >= 300) goto L29;
        if (r1 == 204) goto L27;
        if (r1 == 205) goto L27;
        if (r5 != null) goto L32;
    L17:
        T r3 = this.mRequestFactory.toResponse(r0);     // Catch: Throwable -> L15
        if (r5 == null) goto L20;
        r5.toResponseEndTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
    L20:
        return SsResponse.success(r3, r4);
    L15:
        th = move-exception;
        if (r5 == null) goto L24;
        r5.responseConvertSuccess = false;
    L24:
        Log.i("ToResponseLog", "toResponse failed");
        throw th;
    L32:
        r5.toResponseStartTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L15
    L27:
        return SsResponse.success(null, r4);
    L29:
        return SsResponse.error(r0, r4);
    L31:
        throw new IOException("SsResponse is null");
    }

    public Request request() {
        return this.mOriginalRequest;
    }

    public synchronized void resetExecuted() {
        monitor-enter(this);
        this.mExecuted = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean setThrottleNetSpeed(long r2) {
        this.mThrottleNetSpeed = r2;
        if (this.mRawCall != null) goto L5;
        return false;
    L5:
        return this.mRawCall.setThrottleNetSpeed(r2);
    }
}
