package com.bytedance.retrofit2;

import android.os.SystemClock;
import android.util.Log;
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

/* JADX INFO: loaded from: classes3.dex */
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

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public SsResponse intercept(Interceptor.Chain r10) throws Exception {
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
    L76:
        th = move-exception;
        throw th;
    L10:
        if (this.mExecuted == true) goto L75;
        this.mExecuted = true;     // Catch: Throwable -> L76
        monitor-exit(this);     // Catch: Throwable -> L76
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
        if (r5 == null) goto L80;
    L65:
        if (r0 == null) goto L70;
        List<Header> r12 = r5.headers("content-encoding");
        if (r12 == null) goto L69;
        r0.responseCompressType = r12.get(0).getValue();
    L69:
        r0.recordInterceptorResponseStart(this);
    L70:
        long r2 = SystemClock.uptimeMillis();
        SsResponse<T> r9 = parseResponse(r5, r0);
        if (r0 == null) goto L73;
        r0.responseInterceptDuration.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r2));
    L73:
        return r9;
    L80:
        this.mRawCall = createRawCall(this.mOriginalRequest);     // Catch: Throwable -> L55 Throwable -> L62
        if (this.mThrottleNetSpeed <= 0) goto L38;
        long r6 = SystemClock.uptimeMillis();     // Catch: Throwable -> L55 Throwable -> L62
        this.mRawCall.setThrottleNetSpeed(this.mThrottleNetSpeed);     // Catch: Throwable -> L55 Throwable -> L62
        if (r0 == null) goto L38;
        r0.setThrottleNetSpeedDuration = SystemClock.uptimeMillis() - r6;     // Catch: Throwable -> L55 Throwable -> L62
    L38:
        if (this.mCanceled == false) goto L40;
        this.mRawCall.cancel();
    L40:
        if (r0 == null) goto L47;
        r0.requestInterceptDuration.put("CallServerInterceptor", Long.valueOf(SystemClock.uptimeMillis() - r1));
        List<Header> r7 = this.mOriginalRequest.headers("content-encoding");
        if (r7 != null) goto L44;
    L46:
        r0.recordInterceptorRequestEnd();
        goto L47
    L44:
        if (r7.size() <= 0) goto L46;
        r0.requestCompressType = this.mOriginalRequest.headers("content-encoding").get(0).getValue();
    L47:
        r5 = executeCall(this.mRawCall, r0);
        if (r0 == null) goto L51;
        r0.callserverExecuteSuccess = true;
    L51:
        if (this.mRequestFactory.cacheServer == null) goto L65;
        Response r13 = this.mRequestFactory.cacheServer.putCacheResponse(this.mOriginalRequest, r5);
        if (r13 == null) goto L65;
        r5 = r13;
    L62:
        e = move-exception;
        this.mCreationFailure = e;
        throw e;
    L55:
        th = move-exception;
        this.mCreationFailure = th;
        if ((th instanceof Exception) == false) goto L61;
        throw th;
    L61:
        throw new Exception(th);
    L29:
        r5 = null;
        goto L31
    L16:
        if ((r3 instanceof IOException) == false) goto L20;
        throw ((IOException) r3);
    L20:
        throw new Exception(this.mCreationFailure);
    L75:
        throw new IllegalStateException("Already executed.");     // Catch: Throwable -> L76
    }

    private SsCall createRawCall(Request r1) throws IOException {
        return this.mRequestFactory.clientProvider.get().newSsCall(r1);
    }

    private Response executeCall(SsCall r3, RetrofitMetrics r4) throws IOException {
        if (r4 == null) goto L5;
        r4.executeCallStartTime = SystemClock.uptimeMillis();
    L5:
        return r3.execute();
    }

    SsResponse<T> parseResponse(Response r4, RetrofitMetrics r5) throws IOException {
        if (r4 == null) goto L30;
        TypedInput r0 = r4.getBody();
        int r1 = r4.getStatus();
        if (r1 < 200) goto L28;
        if (r1 >= 300) goto L28;
        if (r1 == 204) goto L26;
        if (r1 == 205) goto L26;
        if (r5 != null) goto L31;
    L15:
        T r3 = this.mRequestFactory.toResponse(r0);     // Catch: Throwable -> L20
        if (r5 == null) goto L18;
        r5.toResponseEndTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
    L18:
        return SsResponse.success(r3, r4);
    L20:
        th = move-exception;
        if (r5 == null) goto L23;
        r5.responseConvertSuccess = false;
    L23:
        Log.i("ToResponseLog", "toResponse failed");
        throw th;
    L31:
        r5.toResponseStartTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L20
    L26:
        return SsResponse.success(null, r4);
    L28:
        return SsResponse.error(r0, r4);
    L30:
        throw new IOException("SsResponse is null");
    }

    public Request request() {
        return this.mOriginalRequest;
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

    public synchronized void resetExecuted() {
        monitor-enter(this);
        this.mExecuted = false;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
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

    public boolean setThrottleNetSpeed(long r2) {
        this.mThrottleNetSpeed = r2;
        if (this.mRawCall != null) goto L5;
        return false;
    L5:
        return this.mRawCall.setThrottleNetSpeed(r2);
    }

    public boolean isCanceled() {
        return this.mCanceled;
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
}
