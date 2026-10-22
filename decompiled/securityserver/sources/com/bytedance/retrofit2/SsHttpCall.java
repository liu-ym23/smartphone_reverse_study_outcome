package com.bytedance.retrofit2;

import android.os.SystemClock;
import android.util.Log;
import com.bytedance.common.utility.Logger;
import com.bytedance.retrofit2.client.Header;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.RealInterceptorChain;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.retrofit2.ttnet.ExceptionReportable;
import com.bytedance.retrofit2.ttnet.IHttpCallThrottleControl;
import com.bytedance.retrofit2.ttnet.TTNetExceptionStorage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes.dex */
public class SsHttpCall<T> implements Call<T>, IMetricsCollect, IRequestInfo {
    private static IHttpCallMonitor sCallMonitor;
    private static IHttpCallPriorityControl sPriorityControl;

    @Nullable
    private static IRequestFlagHandler sRequestFlagHandler;
    private static IHttpCallThrottleControl sThrottleControl;
    private long appCallTime;
    private final Object[] args;
    private final CallServerInterceptor callServerInterceptor;
    private Request delayRequest;
    private final RetrofitMetrics httpCallMetrics;
    private Request originalRequest;
    private final RequestFactory<T> requestFactory;

    public interface IHttpCallMonitor {
        default boolean handleApiSample(String r1, String r2) {
            return false;
        }

        boolean isAllErrorReport();

        void monitorApiError(long r1, long r3, String r5, String r6, Object r7, Throwable r8);

        void monitorApiOK(long r1, long r3, String r5, String r6, Object r7);
    }

    public interface IHttpCallPriorityControl {
        int getPriority(String r1, int r2);
    }

    public interface IRequestFlagHandler {
        Request handleFlag(Request r1);

        boolean shouldBypassInterceptor(Request r1);
    }

    public SsHttpCall(RequestFactory<T> r2, Object[] r3) {
        this.delayRequest = null;
        this.requestFactory = r2;
        this.args = r3;
        this.callServerInterceptor = new CallServerInterceptor(r2);
        this.httpCallMetrics = r2.getRetrofitMetrics().cloneMetrics();
    }

    public static /* synthetic */ Request access$000(SsHttpCall r0) {
        return r0.originalRequest;
    }

    public static /* synthetic */ Request access$002(SsHttpCall r0, Request r1) {
        r0.originalRequest = r1;
        return r1;
    }

    public static /* synthetic */ Object[] access$100(SsHttpCall r0) {
        return r0.args;
    }

    public static /* synthetic */ RequestFactory access$200(SsHttpCall r0) {
        return r0.requestFactory;
    }

    public static /* synthetic */ void access$300(SsHttpCall r0, Throwable r1, boolean r2) {
        r0.reportRequestError(r1, r2);
    }

    public static /* synthetic */ IHttpCallThrottleControl access$400() {
        return sThrottleControl;
    }

    public static /* synthetic */ Request access$500(SsHttpCall r0) {
        return r0.delayRequest;
    }

    public static /* synthetic */ void access$600(SsHttpCall r0, SsResponse r1, boolean r2) {
        r0.reportRequestOk(r1, r2);
    }

    public static /* synthetic */ IHttpCallPriorityControl access$700() {
        return sPriorityControl;
    }

    private Request addDebugMetricsInfoToRequest(Request r5, RetrofitMetrics r6) {
        if (r6.stateDelayTime < 0) goto L6;
        Request.Builder r4 = r5.newBuilder();
        ArrayList r0 = new ArrayList();
        r0.addAll(r5.getHeaders());
        r0.add(new Header("state-delay", String.valueOf(r6.stateDelayTime)));
        r4.headers(r0);
        return r4.build();
    L6:
        return r5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void reportRequestError(Throwable r14, boolean r15) {
        if (sCallMonitor != null) goto L5;
        return;
    L5:
        if (r15 == false) goto L7;
        long r0 = this.httpCallMetrics.enqueueTime;
    L8:
        long r1 = SystemClock.uptimeMillis() - r0;
        if ((r14 instanceof TTNetExceptionStorage) == false) goto L18;
        TTNetExceptionStorage r16 = (TTNetExceptionStorage) r14;
        if (r16.needReport == true) goto L13;
        return;
    L13:
        if (r16.reportMonitorOk == false) goto L16;
        sCallMonitor.monitorApiOK(r1, this.appCallTime, r16.url, r16.traceCode, r16.infoObj);
    L16:
        if (r16.reportMonitorError == false) goto L31;
        sCallMonitor.monitorApiError(r1, this.appCallTime, r16.url, r16.traceCode, r16.infoObj, r14);
        return;
    L31:
        return;
    L18:
        RetrofitMetrics r17 = this.httpCallMetrics;
        if (r17.callserverExecuteSuccess == false) goto L22;
        r17.interceptorResponseThrowable = r14;
        cancelNormalRequest(false, null, false);
        return;
    L22:
        if ((r14 instanceof ExceptionReportable) == false) goto L27;
        if (((ExceptionReportable) r14).shouldReport() == false) goto L34;
        cancelNormalRequest(false, r14, false);
        return;
    L34:
        return;
    L27:
        if (sCallMonitor.isAllErrorReport() == false) goto L36;
        cancelNormalRequest(false, r14, true);
        return;
    L36:
        return;
    L7:
        r0 = this.httpCallMetrics.executeTime;
        goto L8
    }

    private void reportRequestOk(SsResponse<T> r13, boolean r14) {
        if (Logger.debug() == false) goto L6;
        StringBuilder r0 = new StringBuilder("current url is ");
        r0.append(this.originalRequest.getUrl());
        r0.append(" 00  ");
        RetrofitMetrics r1 = this.httpCallMetrics;
        r0.append(r1.responseChainTime - r1.enqueueTime);
        r0.append(" 01  ");
        RetrofitMetrics r2 = this.httpCallMetrics;
        r0.append(r2.responseChainTime - r2.executeTime);
        r0.append(" 1 interceptorRequestInfo ");
        r0.append(this.httpCallMetrics.getRealChainInterceptorTimingInfo());
        r0.append(" 2 openConnectionDuration ");
        r0.append(this.httpCallMetrics.openConnectionDuration);
        r0.append(" 3 setThrottleNetSpeedDuration ");
        r0.append(this.httpCallMetrics.setThrottleNetSpeedDuration);
        r0.append(" 4 tryNecessaryInitDuration ");
        r0.append(this.httpCallMetrics.tryNecessaryInitDuration);
        r0.append(" 5 openConnectionDuration ");
        r0.append(this.httpCallMetrics.openConnectionDuration);
        r0.append(" 6 setConnectionDuration ");
        r0.append(this.httpCallMetrics.setConnectionDuration);
        r0.append(" 7 prepareRequestDuration ");
        r0.append(this.httpCallMetrics.prepareRequestDuration);
        Logger.d("TTNetReport", r0.toString());
    L6:
        if (sCallMonitor != null) goto L8;
        return;
    L8:
        if (isCanceled() == true) goto L15;
        if (r14 == false) goto L11;
        long r3 = this.httpCallMetrics.enqueueTime;
    L12:
        long r5 = SystemClock.uptimeMillis() - r3;
        sCallMonitor.monitorApiOK(r5, this.appCallTime, r13.raw().getUrl(), r13.raw().getTraceCode(), r13.raw().getExtraInfo());
        return;
    L11:
        r3 = this.httpCallMetrics.executeTime;
        goto L12
    }

    public static void setCallMonitor(IHttpCallMonitor r0) {
        sCallMonitor = r0;
    }

    public static void setPriorityControl(IHttpCallPriorityControl r0) {
        sPriorityControl = r0;
    }

    public static void setRequestFlagHandler(IRequestFlagHandler r0) {
        sRequestFlagHandler = r0;
    }

    public static void setThrottleControl(IHttpCallThrottleControl r0) {
        sThrottleControl = r0;
    }

    private boolean shouldAddInterceptors(Request r3) {
        if (r3.isPureRequest() == false) goto L5;
        return false;
    L5:
        IRequestFlagHandler r2 = sRequestFlagHandler;
        if (r2 == null) goto L10;
        if (r2.shouldBypassInterceptor(r3) == false) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // com.bytedance.retrofit2.Call
    public void cancel() {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public void cancelNormalRequest(boolean r1, Throwable r2, boolean r3) {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 == null) goto L6;
        r0.cancelNormalRequest(r1, r2, r3);
        return;
    }

    @Override // com.bytedance.retrofit2.Call
    public /* bridge */ /* synthetic */ Call clone() {
        return clone();
    }

    @Override // com.bytedance.retrofit2.IMetricsCollect
    public void doCollect() {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 == null) goto L6;
        r0.doCollect();
        return;
    }

    @Override // com.bytedance.retrofit2.Call
    public void enqueue(final Callback<T> r8) {
        final RetrofitMetrics r1 = this.httpCallMetrics;
        r1.enqueueTime = SystemClock.uptimeMillis();
        r1.ssHttpCallEnqueue = System.nanoTime();
        this.appCallTime = System.currentTimeMillis();
        if (r8 == null) goto L33;
        CallServerInterceptor r2 = this.callServerInterceptor;
        if (r2 != null) goto L7;
    L11:
        Executor r3 = this.requestFactory.httpExecutor;
        if ((r8 instanceof ExpandCallback) == false) goto L14;
        final ExpandCallback r4 = (ExpandCallback) r8;
    L15:
        SsRunnable r5 = new AnonymousClass1(this, r1, r4, r8);
        r1.toRequestStartTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L19
        this.originalRequest = this.requestFactory.toRequest(r4, this.args);     // Catch: Throwable -> L19
        if (Logger.debug() == false) goto L21;
        Logger.d("SsHttpCall", "get enqueue " + this.originalRequest.getPath());     // Catch: Throwable -> L19
    L21:
        r1.toRequestEndTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L19
        IHttpCallThrottleControl r0 = sThrottleControl;     // Catch: Throwable -> L19
        if (r0 == null) goto L26;
        Request r6 = r0.setOriginalRequestProperties(this.originalRequest);     // Catch: Throwable -> L19
        this.originalRequest = r6;     // Catch: Throwable -> L19
        this.delayRequest = r6;     // Catch: Throwable -> L19
        if (sThrottleControl.maybeDropRequestOrAsyncDelay(r6, r1, r3, r5) == false) goto L26;
        return;
    L26:
        r3.execute(r5);
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
        r8.onFailure(this, th);
        reportRequestError(th, true);
        IHttpCallThrottleControl r9 = sThrottleControl;
        if (r9 == null) goto L36;
        r9.notifyRequestCompleted(this.delayRequest);
        return;
    L36:
        return;
    L14:
        r4 = null;
        goto L15
    L7:
        if (r2.isExecuted() == false) goto L11;
        throw new IllegalStateException("Already executed.");
    L33:
        throw new NullPointerException("callback == null");
    }

    @Override // com.bytedance.retrofit2.Call
    public SsResponse<T> execute() {
        RetrofitMetrics r0 = this.httpCallMetrics;
        r0.executeTime = SystemClock.uptimeMillis();
        r0.ssHttpCallExecute = System.nanoTime();
        this.appCallTime = System.currentTimeMillis();
        r0.toRequestStartTime = SystemClock.uptimeMillis();
        this.originalRequest = this.requestFactory.toRequest(null, this.args);     // Catch: Exception -> L27
        r0.toRequestEndTime = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L34;
        Logger.d("SsHttpCall", "get execute " + this.originalRequest.getPath());
    L34:
        IHttpCallThrottleControl r2 = sThrottleControl;     // Catch: Throwable -> L11
        if (r2 == null) goto L13;
        Request r3 = r2.setOriginalRequestProperties(this.originalRequest);     // Catch: Throwable -> L11
        this.originalRequest = r3;     // Catch: Throwable -> L11
        this.delayRequest = r3;     // Catch: Throwable -> L11
        sThrottleControl.maybeDropRequestOrBlockingDelay(r3, r0);     // Catch: Throwable -> L11
    L13:
        SsResponse<T> r4 = getResponseWithInterceptorChain();     // Catch: Throwable -> L11
        r0.executeEndTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L11
        if (this.requestFactory.isResponseStreaming == true) goto L16;
        reportRequestOk(r4, false);     // Catch: Throwable -> L11
    L16:
        IHttpCallThrottleControl r1 = sThrottleControl;
        if (r1 == null) goto L19;
        r1.notifyRequestCompleted(this.delayRequest);
    L19:
        return r4;
    L11:
        th = move-exception;
        r0.executeEndTime = SystemClock.uptimeMillis();     // Catch: Throwable -> L22
        reportRequestError(th, false);     // Catch: Throwable -> L22
        throw th;     // Catch: Throwable -> L22
    L22:
        th = move-exception;
        IHttpCallThrottleControl r5 = sThrottleControl;
        if (r5 == null) goto L26;
        r5.notifyRequestCompleted(this.delayRequest);
    L26:
        throw th;
    L27:
        e = move-exception;
        Log.i("ToRequestLog", "catch and rethrow build ex in execute()");
        throw e;
    }

    @Override // com.bytedance.retrofit2.IRequestInfo
    public Object getRequestInfo() {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 != null) goto L5;
        return null;
    L5:
        return r0.getRequestInfo();
    }

    public SsResponse getResponseWithInterceptorChain() {
        RetrofitMetrics r6 = this.httpCallMetrics;
        r6.responseChainTime = SystemClock.uptimeMillis();
        if (Logger.debug() == false) goto L5;
        Logger.d("SsHttpCall", "real send " + this.originalRequest.getPath());
    L5:
        LinkedList r1 = new LinkedList();
        IRequestFlagHandler r0 = sRequestFlagHandler;
        if (r0 == null) goto L9;
        this.originalRequest = r0.handleFlag(this.originalRequest);
    L9:
        if (shouldAddInterceptors(this.originalRequest) == false) goto L11;
        r1.addAll(this.requestFactory.interceptors);
    L11:
        r1.add(this.callServerInterceptor);
        if (Logger.debug() == false) goto L14;
        this.originalRequest = addDebugMetricsInfoToRequest(this.originalRequest, r6);
    L14:
        r6.appLevelRequestStart = this.appCallTime;
        r6.beforeAllInterceptors = System.currentTimeMillis();
        this.originalRequest.setMetrics(r6);
        RealInterceptorChain r7 = new RealInterceptorChain(r1, 0, this.originalRequest, this, r6);
        if (RealInterceptorChain.isProceedWithoutHookEnabled() == false) goto L17;
        SsResponse r8 = r7.proceedWithoutHook(this.originalRequest);
    L18:
        r8.setRetrofitMetrics(r6);
        return r8;
    L17:
        r8 = r7.proceed(this.originalRequest);
        goto L18
    }

    public RetrofitMetrics getRetrofitMetrics() {
        return this.httpCallMetrics;
    }

    @Override // com.bytedance.retrofit2.Call
    public boolean isCanceled() {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isCanceled() == false) goto L7;
        return true;
    }

    @Override // com.bytedance.retrofit2.Call
    public synchronized boolean isExecuted() {
        monitor-enter(this);
        CallServerInterceptor r0 = this.callServerInterceptor;     // Catch: Throwable -> L8
        if (r0 == null) goto L10;
        if (r0.isExecuted() == false) goto L10;
        boolean r1 = true;
    L11:
        monitor-exit(this);
        return r1;
    L10:
        r1 = false;
    L8:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.retrofit2.Call
    public Request request() {
        CallServerInterceptor r1 = this.callServerInterceptor;
        if (r1 == null) goto L8;
        Request r2 = r1.request();
        if (r2 == null) goto L8;
        return r2;
    L8:
        if (this.originalRequest != null) goto L23;
        RetrofitMetrics r3 = this.httpCallMetrics;     // Catch: IOException -> L12 RuntimeException -> L14
        r3.toRequestStartTime = SystemClock.uptimeMillis();     // Catch: IOException -> L12 RuntimeException -> L14
        Log.i("ToRequestLog", "before toRequest");     // Catch: IOException -> L12 RuntimeException -> L14
        Request r4 = this.requestFactory.toRequest(null, this.args);     // Catch: IOException -> L12 RuntimeException -> L14
        this.originalRequest = r4;     // Catch: IOException -> L12 RuntimeException -> L14
        if (r4 == null) goto L16;
        Log.i("ToRequestLog", "originalRequest build success.");     // Catch: IOException -> L12 RuntimeException -> L14
    L17:
        r3.toRequestEndTime = SystemClock.uptimeMillis();     // Catch: IOException -> L12 RuntimeException -> L14
    L16:
        Log.i("ToRequestLog", "originalRequest build failed.");     // Catch: IOException -> L12 RuntimeException -> L14
    L12:
        e = move-exception;
        throw new RuntimeException("Unable to create request.", e);
    L14:
        e = move-exception;
        throw e;
    L23:
        return this.originalRequest;
    }

    public boolean setThrottleNetSpeed(long r1) {
        CallServerInterceptor r0 = this.callServerInterceptor;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.setThrottleNetSpeed(r1);
    }

    public T toResponseBody(TypedInput r1) {
        return this.requestFactory.toResponse(r1);
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m10clone() {
        return clone();
    }

    @Override // com.bytedance.retrofit2.Call
    public SsHttpCall<T> clone() {
        return new SsHttpCall(this.requestFactory, this.args);
    }
}
