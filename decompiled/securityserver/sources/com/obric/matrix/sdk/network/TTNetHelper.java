package com.obric.matrix.sdk.network;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.article.common.network.SSNetworkClient;
import com.bytedance.common.utility.NetworkClient;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.intercept.Interceptor;
import com.bytedance.ttnet.TTNetInit;
import com.bytedance.ttnet.http.HttpRequestInfo;
import com.bytedance.ttnet.http.RequestContext;
import com.bytedance.ttnet.utils.RetrofitUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class TTNetHelper {
    private static final long DEFAULT_TIMEOUT_MILLISECONDS = 120000;

    @NotNull
    public static final TTNetHelper INSTANCE = null;

    @NotNull
    private static final String TAG = "matrix_network_TTNetInitHelper";

    @Nullable
    private static Application mContext;

    @Nullable
    private static InterfaceRequestListener requestListener;

    @NotNull
    private static final NetworkParams.ApiProcessHook<HttpRequestInfo> sApiProcessHook = null;

    @NotNull
    private static final NetworkParams.MonitorProcessHook<HttpRequestInfo> sMonitorProcessHook = null;

    @NotNull
    private static final ConcurrentHashMap<String, Long> timeoutConfig = null;

    static {
        INSTANCE = new TTNetHelper();
        timeoutConfig = new ConcurrentHashMap(4, 0.9f, 1);
        sMonitorProcessHook = new TTNetHelper$sMonitorProcessHook$1();
        sApiProcessHook = new TTNetHelper$sApiProcessHook$1();
    }

    private TTNetHelper() {
    }

    public static /* synthetic */ SsResponse a(Interceptor.Chain r0) {
        return m40initTTNet$lambda0(r0);
    }

    public static final /* synthetic */ InterfaceRequestListener access$getRequestListener$p() {
        return requestListener;
    }

    public static final /* synthetic */ void access$logApiRequest(TTNetHelper r0, boolean r1, String r2, String r3, long r4, long r6, HttpRequestInfo r8) {
        r0.logApiRequest(r1, r2, r3, r4, r6, r8);
    }

    public static final /* synthetic */ void access$packageRequestParamters(TTNetHelper r0, HttpRequestInfo r1, JSONObject r2) {
        r0.packageRequestParamters(r1, r2);
    }

    public static /* synthetic */ void initTTNet$default(TTNetHelper r0, Context r1, Application r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = true;
    L5:
        r0.initTTNet(r1, r2, r3);
    }

    /* JADX INFO: renamed from: initTTNet$lambda-0, reason: not valid java name */
    private static final SsResponse m40initTTNet$lambda0(Interceptor.Chain r6) {
        Request r0 = r6.request();
        String r1 = r0.getUrl().toString();
        Iterator<Map.Entry<String, Long>> r2 = timeoutConfig.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, Long> r3 = r2.next();
        if (StringsKt.F(r1, r3.getKey(), false) == false) goto L4;
        long r4 = r3.getValue().longValue();
    L9:
        RequestContext r5 = new RequestContext();
        r5.timeout_connect = r4;
        r5.timeout_read = r4;
        r5.timeout_write = r4;
        r5.socket_connect_timeout = r4;
        r5.socket_read_timeout = r4;
        r5.socket_write_timeout = r4;
        r0.setExtraInfo(r5);
        return r6.proceed(r0);
    L8:
        r4 = 120000;
        goto L9
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

    private final void packageRequestParamters(HttpRequestInfo r5, JSONObject r6) {
        if (r5 == null) goto L20;
        if (r6 == null) goto L21;
        Log.i(TAG, "[packageRequestParamters] responseHeaders= " + r5.responseHeaders);     // Catch: JSONException -> L9
        r6.put("cronet_plugin_install", TTNetInit.getTTNetDepend().isCronetPluginInstalled());     // Catch: JSONException -> L9
        r6.put("appLevelRequestStart", r5.appLevelRequestStart);     // Catch: JSONException -> L9
        r6.put("beforeAllInterceptors", r5.beforeAllInterceptors);     // Catch: JSONException -> L9
        r6.put("requestStart", r5.requestStart);     // Catch: JSONException -> L9
        r6.put("responseBack", r5.responseBack);     // Catch: JSONException -> L9
        r6.put("completeReadResponse", r5.completeReadResponse);     // Catch: JSONException -> L9
        r6.put("requestEnd", r5.requestEnd);     // Catch: JSONException -> L9
        r6.put("recycleCount", r5.recycleCount);     // Catch: JSONException -> L9
        if (r5.httpClientType != 0) goto L11;
        r6.put("timing_dns", r5.dnsTime);     // Catch: JSONException -> L9
        r6.put("timing_connect", r5.connectTime);     // Catch: JSONException -> L9
        r6.put("timing_ssl", r5.sslTime);     // Catch: JSONException -> L9
        r6.put("timing_send", r5.sendTime);     // Catch: JSONException -> L9
        r6.put("timing_waiting", r5.ttfbMs);     // Catch: JSONException -> L9
        r6.put("timing_receive", r5.receiveTime);     // Catch: JSONException -> L9
        r6.put("timing_total", r5.totalTime);     // Catch: JSONException -> L9
        r6.put("timing_isSocketReused", r5.isSocketReused);     // Catch: JSONException -> L9
        r6.put(TrafficConsts.KEY_SENT_BYTES, r5.sentByteCount);     // Catch: JSONException -> L9
        r6.put(TrafficConsts.KEY_RECEIVED_BYTES, r5.receivedByteCount);     // Catch: JSONException -> L9
        r6.put("timing_remoteIP", r5.remoteIp);     // Catch: JSONException -> L9
        r6.put("request_log", r5.requestLog);     // Catch: JSONException -> L9
        Log.i(TAG, "[packageRequestParamters] timing_dns: " + r5.dnsTime + " timing_connect: " + r5.connectTime + " timing_ssl: " + r5.sslTime + " timing_send: " + r5.sendTime + " timing_waiting: " + r5.ttfbMs + " timing_receive: " + r5.receiveTime + " timing_total: " + r5.totalTime + " timing_isSocketReused: " + r5.isSocketReused + " timing_totalSendBytes: " + r5.sentByteCount + " timing_totalReceivedBytes: " + r5.receivedByteCount + " timing_remoteIP: " + r5.remoteIp);     // Catch: JSONException -> L9
    L11:
        JSONObject r0 = r5.extraInfo;     // Catch: JSONException -> L9
        if (r0 == null) goto L14;
        r6.put("req_info", r0);     // Catch: JSONException -> L9
    L14:
        r6.put("streaming", r5.downloadFile);     // Catch: JSONException -> L9
        return;
    L9:
        e = move-exception;
        Log.e(TAG, "[packageRequestParamters] json op error. ", e);
        return;
    L21:
        return;
    }

    private final void printNecessaryHeader(String r3) {
        JSONObject r2 = new JSONObject(r3);     // Catch: Throwable -> L8
        Iterator<String> r4 = r2.keys();     // Catch: Throwable -> L8
        Intrinsics.e(r4, "json.keys()");     // Catch: Throwable -> L8
    L4:
        if (r4.hasNext() == false) goto L13;
        String r0 = r4.next();     // Catch: Throwable -> L8
        Intrinsics.e(r0, "key");     // Catch: Throwable -> L8
        String r1 = r0.toLowerCase();     // Catch: Throwable -> L8
        Intrinsics.e(r1, "this as java.lang.String).toLowerCase()");     // Catch: Throwable -> L8
        r2.get(r1);     // Catch: Throwable -> L8
    L13:
        return;
    }

    public final void addTimeoutConfig(@NotNull String r1, long r2) {
        Intrinsics.f(r1, "url");
        timeoutConfig.put(r1, Long.valueOf(r2));
    }

    @JvmOverloads
    public final void initTTNet(@NotNull Context r8, @NotNull Application r9) {
        Intrinsics.f(r8, "context");
        Intrinsics.f(r9, "application");
        initTTNet$default(this, r8, r9, false, 4, null);
    }

    public final void setRequestListener(@Nullable InterfaceRequestListener r1) {
        requestListener = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void initTTNet$default(TTNetHelper r0, Context r1, Application r2, boolean r3, NetworkParams.ApiProcessHook r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = null;
    L5:
        r0.initTTNet(r1, r2, r3, r4);
    }

    @JvmOverloads
    public final void initTTNet(@NotNull Context r2, @NotNull Application r3, boolean r4) {
        Intrinsics.f(r2, "context");
        Intrinsics.f(r3, "application");
        initTTNet(r2, r3, r4, null);
    }

    public final void initTTNet(@NotNull Context r10, @NotNull Application r11, boolean r12, @Nullable NetworkParams.ApiProcessHook<HttpRequestInfo> r13) {
        Intrinsics.f(r10, "context");
        Intrinsics.f(r11, "application");
        Log.i(TAG, "initTTNet start");     // Catch: Throwable -> L7
        mContext = r11;     // Catch: Throwable -> L7
        TTNetCronetDependAdapter r1 = TTNetCronetDependAdapter.INSTANCE;     // Catch: Throwable -> L7
        r1.inJect();     // Catch: Throwable -> L7
        TTNetInit.setTTNetDepend(new TTNetDepend(r10));     // Catch: Throwable -> L7
        if (r13 != null) goto L6;
        r13 = sApiProcessHook;     // Catch: Throwable -> L7
    L6:
        NetworkParams.ApiProcessHook<HttpRequestInfo> r4 = r13;
        TTNetInit.tryInitTTNet(r10, r11, r4, sMonitorProcessHook, null, r12, new boolean[]{false});     // Catch: Throwable -> L7
        TTNetInit.setCronetDepend(r1);     // Catch: Throwable -> L7
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L7
        RetrofitUtils.addInterceptor(new c());     // Catch: Throwable -> L7
        NetworkClient.setDefault(new CustomNetworkClient());     // Catch: Throwable -> L7
        Log.i(TAG, "initTTNet end");     // Catch: Throwable -> L7
    L12:
        NetworkClient.setDefault(new SSNetworkClient());
        return;
    L7:
        th = move-exception;
        Log.e(TAG, "initTTNet error", th);
        goto L12
    }
}
