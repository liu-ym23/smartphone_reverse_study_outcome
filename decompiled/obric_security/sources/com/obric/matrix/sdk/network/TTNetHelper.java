package com.obric.matrix.sdk.network;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.article.common.network.SSNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTNetHelper.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0014J\"\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\b\b\u0002\u0010\u001e\u001a\u00020\u001fH\u0007J0\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ>\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010\u000eH\u0002JH\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002JH\u0010/\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010\u00062\b\u0010*\u001a\u0004\u0018\u00010\u00062\b\u0010#\u001a\u0004\u0018\u00010\u00062\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010.H\u0002J\u001c\u00100\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u000e2\b\u00101\u001a\u0004\u0018\u00010.H\u0002J\u0010\u00102\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\u0010\u00103\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bJ\f\u00104\u001a\u00020\u0014*\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/matrix/sdk/network/TTNetHelper;", "", "()V", "DEFAULT_TIMEOUT_MILLISECONDS", "", "TAG", "", "mContext", "Landroid/app/Application;", "requestListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/matrix/sdk/network/InterfaceRequestListener;", "sApiProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "sMonitorProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$MonitorProcessHook;", "timeoutConfig", "Ljava/util/concurrent/ConcurrentHashMap;", "addRequestListener", "", "listener", "addTimeoutConfig", "url", "timeout", "clearRequestListeners", "initTTNet", "context", "Landroid/content/Context;", "application", "needSetCookieHandler", "", "apiProcessHook", "logApiRequest", "isError", "traceCode", "duration", "sendTime", AlogMonitor.ALOG_RESULT_INFO, "notifyApiDuration", "sendDuration", "sendUrl", "sendIp", "status", "", "extJson", "Lorg/json/JSONObject;", "notifyApiError", "packageRequestParamters", "jsonObject", "removeRequestListener", "setRequestListener", "printNecessaryHeader", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TTNetHelper {
    private static final long DEFAULT_TIMEOUT_MILLISECONDS = 120000;
    public static final TTNetHelper INSTANCE = null;
    private static final String TAG = "matrix_network_TTNetInitHelper";
    private static Application mContext;
    private static final CopyOnWriteArrayList<InterfaceRequestListener> requestListeners = null;
    private static final NetworkParams.ApiProcessHook<HttpRequestInfo> sApiProcessHook = null;
    private static final NetworkParams.MonitorProcessHook<HttpRequestInfo> sMonitorProcessHook = null;
    private static final ConcurrentHashMap<String, Long> timeoutConfig = null;

    /* JADX INFO: renamed from: $r8$lambda$wWtCjnhRG3yeJBqUjcXnTz_a-VA, reason: not valid java name */
    public static /* synthetic */ SsResponse m191$r8$lambda$wWtCjnhRG3yeJBqUjcXnTz_aVA(boolean r0, Interceptor.Chain r1) {
        return m192initTTNet$lambda0(r0, r1);
    }

    public final void initTTNet(Context r8, Application r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "application");
        initTTNet$default(this, r8, r9, false, 4, null);
    }

    private TTNetHelper() {
    }

    public static final /* synthetic */ void access$logApiRequest(TTNetHelper r0, boolean r1, String r2, String r3, long r4, long r6, HttpRequestInfo r8) {
        r0.logApiRequest(r1, r2, r3, r4, r6, r8);
    }

    public static final /* synthetic */ void access$notifyApiDuration(TTNetHelper r0, long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9) {
        r0.notifyApiDuration(r1, r3, r5, r6, r7, r8, r9);
    }

    public static final /* synthetic */ void access$notifyApiError(TTNetHelper r0, long r1, long r3, String r5, String r6, String r7, int r8, JSONObject r9) {
        r0.notifyApiError(r1, r3, r5, r6, r7, r8, r9);
    }

    public static final /* synthetic */ void access$packageRequestParamters(TTNetHelper r0, HttpRequestInfo r1, JSONObject r2) {
        r0.packageRequestParamters(r1, r2);
    }

    static {
        INSTANCE = new TTNetHelper();
        requestListeners = new CopyOnWriteArrayList();
        timeoutConfig = new ConcurrentHashMap(4, 0.9f, 1);
        sMonitorProcessHook = new TTNetHelper$sMonitorProcessHook$1();
        sApiProcessHook = new TTNetHelper$sApiProcessHook$1();
    }

    public final void setRequestListener(InterfaceRequestListener r1) {
        addRequestListener(r1);
    }

    public final void addRequestListener(InterfaceRequestListener r2) {
        if (r2 == null) goto L8;
        CopyOnWriteArrayList<InterfaceRequestListener> r1 = requestListeners;
        if (r1.contains(r2) == true) goto L9;
        r1.add(r2);
        return;
    L9:
        return;
    }

    public final void removeRequestListener(InterfaceRequestListener r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        requestListeners.remove(r1);
    }

    public final void clearRequestListeners() {
        requestListeners.clear();
    }

    public final void addTimeoutConfig(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "url");
        timeoutConfig.put(r1, Long.valueOf(r2));
    }

    public static /* synthetic */ void initTTNet$default(TTNetHelper r0, Context r1, Application r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        r0.initTTNet(r1, r2, r3);
    }

    public final void initTTNet(Context r2, Application r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "application");
        initTTNet(r2, r3, r4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initTTNet$default(TTNetHelper r0, Context r1, Application r2, boolean r3, NetworkParams.ApiProcessHook r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.initTTNet(r1, r2, r3, r4);
    }

    public final void initTTNet(Context r8, Application r9, final boolean r10, NetworkParams.ApiProcessHook<HttpRequestInfo> r11) {
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter(r9, "application");
        Log.i(TAG, "initTTNet start");     // Catch: Throwable -> L8
        mContext = r9;     // Catch: Throwable -> L8
        TTNetCronetDependAdapter.INSTANCE.inJect();     // Catch: Throwable -> L8
        TTNetInit.setTTNetDepend(new TTNetDepend(r8));     // Catch: Throwable -> L8
        TTNetInit.setCronetDepend(TTNetCronetDependAdapter.INSTANCE);     // Catch: Throwable -> L8
        if (r11 != null) goto L6;
        r11 = sApiProcessHook;     // Catch: Throwable -> L8
    L6:
        TTNetInit.tryInitTTNet(r8, r9, r11, sMonitorProcessHook, null, r10, new boolean[]{false});     // Catch: Throwable -> L8
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L8
        RetrofitUtils.addInterceptor(new TTNetHelper$$ExternalSyntheticLambda0(r10));     // Catch: Throwable -> L8
        SSNetworkClient.setDefault(new CustomNetworkClient());     // Catch: Throwable -> L8
        Log.i(TAG, "initTTNet end");     // Catch: Throwable -> L8
    L10:
        NetworkClient.setDefault(new SSNetworkClient());
        return;
    L8:
        th = move-exception;
        Log.e(TAG, "initTTNet error", th);
        goto L10
    }

    /* JADX INFO: renamed from: initTTNet$lambda-0, reason: not valid java name */
    private static final SsResponse m192initTTNet$lambda0(boolean r8, Interceptor.Chain r9) {
        Request r0 = r9.request();
        String r1 = r0.getUrl().toString();
        Iterator<Map.Entry<String, Long>> r2 = timeoutConfig.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, Long> r3 = r2.next();
        if (StringsKt.startsWith$default(r1, r3.getKey(), false, 2, null) == false) goto L4;
        long r4 = r3.getValue().longValue();
    L9:
        TTNetRequestContextHelper.configure(r0, r4, r8);
        return r9.proceed(r0);
    L8:
        r4 = 120000;
        goto L9
    }

    private final void printNecessaryHeader(String r3) {
        JSONObject r2 = new JSONObject(r3);     // Catch: Throwable -> L8
        Iterator<String> r4 = r2.keys();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r4, "json.keys()");     // Catch: Throwable -> L8
    L4:
        if (r4.hasNext() == false) goto L13;
        String r0 = r4.next();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r0, "key");     // Catch: Throwable -> L8
        String r1 = r0.toLowerCase();     // Catch: Throwable -> L8
        Intrinsics.checkNotNullExpressionValue(r1, "this as java.lang.String).toLowerCase()");     // Catch: Throwable -> L8
        r2.get(r1);     // Catch: Throwable -> L8
    L13:
        return;
    }

    private final void logApiRequest(boolean r3, String r4, String r5, long r6, long r8, HttpRequestInfo r10) {
        Log.i(TAG, "[TTNet headers - isError=" + r3 + ']');
        Log.i(TAG, " - [url|traceCode|duration|sendTime] = " + r5 + " | " + r4 + " | " + r6 + " | " + r8);
        if (r10 == null) goto L7;
        String r7 = r10.requestHeaders;
        if (r7 == null) goto L7;
        printNecessaryHeader(r7);
    L7:
        if (r10 == null) goto L12;
        String r9 = r10.responseHeaders;
        if (r9 == null) goto L13;
        printNecessaryHeader(r9);
        return;
    L13:
        return;
    }

    private final void notifyApiError(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        Iterator<T> r1 = requestListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        ((InterfaceRequestListener) r1.next()).onApiError(r13, r15, r17, r18, r19, r20, r21);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Log.e(TAG, "notifyApiError error", th);
        goto L4
    }

    private final void notifyApiDuration(long r13, long r15, String r17, String r18, String r19, int r20, JSONObject r21) {
        Iterator<T> r1 = requestListeners.iterator();
    L4:
        if (r1.hasNext() == false) goto L10;
        ((InterfaceRequestListener) r1.next()).onApiDuration(r13, r15, r17, r18, r19, r20, r21);     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        Log.e(TAG, "notifyApiDuration error", th);
        goto L4
    }

    private final void packageRequestParamters(HttpRequestInfo r5, JSONObject r6) {
        if (r5 == null) goto L19;
        if (r6 == null) goto L20;
        Log.i(TAG, "[packageRequestParamters] responseHeaders= " + r5.responseHeaders);     // Catch: JSONException -> L14
        r6.put("cronet_plugin_install", TTNetInit.getTTNetDepend().isCronetPluginInstalled());     // Catch: JSONException -> L14
        r6.put("appLevelRequestStart", r5.appLevelRequestStart);     // Catch: JSONException -> L14
        r6.put("beforeAllInterceptors", r5.beforeAllInterceptors);     // Catch: JSONException -> L14
        r6.put("requestStart", r5.requestStart);     // Catch: JSONException -> L14
        r6.put("responseBack", r5.responseBack);     // Catch: JSONException -> L14
        r6.put("completeReadResponse", r5.completeReadResponse);     // Catch: JSONException -> L14
        r6.put("requestEnd", r5.requestEnd);     // Catch: JSONException -> L14
        r6.put("recycleCount", r5.recycleCount);     // Catch: JSONException -> L14
        if (r5.httpClientType != 0) goto L10;
        r6.put("timing_dns", r5.dnsTime);     // Catch: JSONException -> L14
        r6.put("timing_connect", r5.connectTime);     // Catch: JSONException -> L14
        r6.put("timing_ssl", r5.sslTime);     // Catch: JSONException -> L14
        r6.put("timing_send", r5.sendTime);     // Catch: JSONException -> L14
        r6.put("timing_waiting", r5.ttfbMs);     // Catch: JSONException -> L14
        r6.put("timing_receive", r5.receiveTime);     // Catch: JSONException -> L14
        r6.put("timing_total", r5.totalTime);     // Catch: JSONException -> L14
        r6.put("timing_isSocketReused", r5.isSocketReused);     // Catch: JSONException -> L14
        r6.put(TrafficConsts.KEY_SENT_BYTES, r5.sentByteCount);     // Catch: JSONException -> L14
        r6.put(TrafficConsts.KEY_RECEIVED_BYTES, r5.receivedByteCount);     // Catch: JSONException -> L14
        r6.put("timing_remoteIP", r5.remoteIp);     // Catch: JSONException -> L14
        r6.put("request_log", r5.requestLog);     // Catch: JSONException -> L14
        Log.i(TAG, "[packageRequestParamters] timing_dns: " + r5.dnsTime + " timing_connect: " + r5.connectTime + " timing_ssl: " + r5.sslTime + " timing_send: " + r5.sendTime + " timing_waiting: " + r5.ttfbMs + " timing_receive: " + r5.receiveTime + " timing_total: " + r5.totalTime + " timing_isSocketReused: " + r5.isSocketReused + " timing_totalSendBytes: " + r5.sentByteCount + " timing_totalReceivedBytes: " + r5.receivedByteCount + " timing_remoteIP: " + r5.remoteIp);     // Catch: JSONException -> L14
    L10:
        if (r5.extraInfo == null) goto L12;
        r6.put("req_info", r5.extraInfo);     // Catch: JSONException -> L14
    L12:
        r6.put("streaming", r5.downloadFile);     // Catch: JSONException -> L14
        return;
    L14:
        e = move-exception;
        Log.e(TAG, "[packageRequestParamters] json op error. ", e);
        return;
    L20:
        return;
    }
}
