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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TTNetHelper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0004J\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\bJ>\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002J\u001c\u0010!\u001a\u00020\u00132\b\u0010 \u001a\u0004\u0018\u00010\r2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0010\u0010$\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010\nJ\f\u0010&\u001a\u00020\u0013*\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/matrix/sdk/network/TTNetHelper;", "", "()V", "DEFAULT_TIMEOUT_MILLISECONDS", "", "TAG", "", "mContext", "Landroid/app/Application;", "requestListener", "Lcom/obric/matrix/sdk/network/InterfaceRequestListener;", "sApiProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$ApiProcessHook;", "Lcom/bytedance/ttnet/http/HttpRequestInfo;", "sMonitorProcessHook", "Lcom/bytedance/frameworks/baselib/network/http/NetworkParams$MonitorProcessHook;", "timeoutConfig", "Ljava/util/concurrent/ConcurrentHashMap;", "addTimeoutConfig", "", "url", "timeout", "initTTNet", "context", "Landroid/content/Context;", "application", "logApiRequest", "isError", "", "traceCode", "duration", "sendTime", "info", "packageRequestParamters", "jsonObject", "Lorg/json/JSONObject;", "setRequestListener", "listener", "printNecessaryHeader", "sdk_network_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TTNetHelper {
    private static final long DEFAULT_TIMEOUT_MILLISECONDS = 120000;
    public static final TTNetHelper INSTANCE = null;
    private static final String TAG = "matrix_network_TTNetInitHelper";
    private static Application mContext;
    private static InterfaceRequestListener requestListener;
    private static final NetworkParams.ApiProcessHook<HttpRequestInfo> sApiProcessHook = null;
    private static final NetworkParams.MonitorProcessHook<HttpRequestInfo> sMonitorProcessHook = null;
    private static final ConcurrentHashMap<String, Long> timeoutConfig = null;

    public static /* synthetic */ SsResponse $r8$lambda$3PuLVJlhXw0M882fHAf7Chu7uuA(Interceptor.Chain r0) {
        return m1044initTTNet$lambda0(r0);
    }

    private TTNetHelper() {
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

    static {
        INSTANCE = new TTNetHelper();
        timeoutConfig = new ConcurrentHashMap(4, 0.9f, 1);
        sMonitorProcessHook = new TTNetHelper$sMonitorProcessHook$1();
        sApiProcessHook = new TTNetHelper$sApiProcessHook$1();
    }

    public final void setRequestListener(InterfaceRequestListener r1) {
        requestListener = r1;
    }

    public final void addTimeoutConfig(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "url");
        timeoutConfig.put(r1, Long.valueOf(r2));
    }

    public final void initTTNet(Context r9, Application r10) {
        Intrinsics.checkNotNullParameter(r9, "context");
        Intrinsics.checkNotNullParameter(r10, "application");
        Log.i(TAG, "initTTNet start");     // Catch: Throwable -> L5
        mContext = r10;     // Catch: Throwable -> L5
        TTNetCronetDependAdapter.INSTANCE.inJect();     // Catch: Throwable -> L5
        TTNetInit.setTTNetDepend(new TTNetDepend(r9));     // Catch: Throwable -> L5
        TTNetInit.tryInitTTNet(r9, r10, sApiProcessHook, sMonitorProcessHook, null, true, new boolean[]{false});     // Catch: Throwable -> L5
        TTNetInit.setCronetDepend(TTNetCronetDependAdapter.INSTANCE);     // Catch: Throwable -> L5
        TTNetInit.preInitCronetKernel();     // Catch: Throwable -> L5
        RetrofitUtils.addInterceptor(new TTNetHelper$$ExternalSyntheticLambda0());     // Catch: Throwable -> L5
        SSNetworkClient.setDefault(new CustomNetworkClient());     // Catch: Throwable -> L5
        Log.i(TAG, "initTTNet end");     // Catch: Throwable -> L5
    L7:
        NetworkClient.setDefault(new SSNetworkClient());
        return;
    L5:
        th = move-exception;
        Log.e(TAG, "initTTNet error", th);
        goto L7
    }

    /* JADX INFO: renamed from: initTTNet$lambda-0, reason: not valid java name */
    private static final SsResponse m1044initTTNet$lambda0(Interceptor.Chain r8) {
        Request r0 = r8.request();
        String r1 = r0.getUrl().toString();
        Iterator<Map.Entry<String, Long>> r2 = timeoutConfig.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, Long> r3 = r2.next();
        if (StringsKt.startsWith$default(r1, r3.getKey(), false, 2, null) == false) goto L4;
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
        return r8.proceed(r0);
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
