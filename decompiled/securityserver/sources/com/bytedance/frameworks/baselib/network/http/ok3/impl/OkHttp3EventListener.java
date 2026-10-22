package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import com.bytedance.frameworks.baselib.network.http.ok3.IOkHttpAppInfoProvider;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class OkHttp3EventListener extends EventListener {
    private final String TAG;
    private final OkHttp3RequestLog mOkHttp3RequestLog;
    private final EventListener mOriginEventListener;

    public OkHttp3EventListener(EventListener r2, OkHttp3RequestLog r3) {
        this.TAG = "OkHttp3EventListener";
        this.mOriginEventListener = r2;
        this.mOkHttp3RequestLog = r3;
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call r2) {
        super.callEnd(r2);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.callEnd(r2);
    L5:
        this.mOkHttp3RequestLog.callEnd();
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call r2, IOException r3) {
        super.callFailed(r2, r3);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.callFailed(r2, r3);
    L5:
        this.mOkHttp3RequestLog.callFailed(r3);
    }

    public void callInSecureRedirect(Call r1, JSONObject r2) {
        super.callInSecureRedirect(r1, r2);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.callInSecureRedirect(r1, r2);
    L5:
        IOkHttpAppInfoProvider r3 = SsOkHttp3Client.getOkHttpAppInfoProvider();
        if (r3 == null) goto L9;
        r3.sendAppMonitorEvent(r2.toString(), "ttnet_insec_rect");
        return;
    }

    @Override // okhttp3.EventListener
    public void callStart(Call r2) {
        super.callStart(r2);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.callStart(r2);
    L5:
        this.mOkHttp3RequestLog.callStart();
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call r2, InetSocketAddress r3, Proxy r4, Protocol r5) {
        super.connectEnd(r2, r3, r4, r5);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.connectEnd(r2, r3, r4, r5);
    L5:
        this.mOkHttp3RequestLog.connectEnd(r4);
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call r7, InetSocketAddress r8, Proxy r9, Protocol r10, IOException r11) {
        super.connectFailed(r7, r8, r9, r10, r11);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L6;
        r0.connectFailed(r7, r8, r9, r10, r11);
        return;
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call r2, InetSocketAddress r3, Proxy r4) {
        super.connectStart(r2, r3, r4);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.connectStart(r2, r3, r4);
    L5:
        this.mOkHttp3RequestLog.connectStart();
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call r2, Connection r3) {
        super.connectionAcquired(r2, r3);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.connectionAcquired(r2, r3);
    L5:
        this.mOkHttp3RequestLog.connectionAcquired(r3);
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call r1, Connection r2) {
        super.connectionReleased(r1, r2);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L6;
        r0.connectionReleased(r1, r2);
        return;
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call r2, String r3, List<InetAddress> r4) {
        super.dnsEnd(r2, r3, r4);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.dnsEnd(r2, r3, r4);
    L5:
        this.mOkHttp3RequestLog.dnsEnd();
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call r2, String r3) {
        super.dnsStart(r2, r3);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.dnsStart(r2, r3);
    L5:
        this.mOkHttp3RequestLog.dnsStart();
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call r2, long r3) {
        super.requestBodyEnd(r2, r3);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.requestBodyEnd(r2, r3);
    L5:
        this.mOkHttp3RequestLog.requestBodyEnd(r3);
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call r2) {
        super.requestBodyStart(r2);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.requestBodyStart(r2);
    L5:
        this.mOkHttp3RequestLog.requestBodyStart();
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call r2, Request r3) {
        super.requestHeadersEnd(r2, r3);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.requestHeadersEnd(r2, r3);
    L5:
        this.mOkHttp3RequestLog.requestHeadersEnd(r3);
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call r2) {
        super.requestHeadersStart(r2);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.requestHeadersStart(r2);
    L5:
        this.mOkHttp3RequestLog.requestHeadersStart();
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call r2, long r3) {
        super.responseBodyEnd(r2, r3);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.responseBodyEnd(r2, r3);
    L5:
        this.mOkHttp3RequestLog.responseBodyEnd(r3);
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call r2) {
        super.responseBodyStart(r2);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.responseBodyStart(r2);
    L5:
        this.mOkHttp3RequestLog.responseBodyStart();
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call r2, Response r3) {
        super.responseHeadersEnd(r2, r3);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.responseHeadersEnd(r2, r3);
    L5:
        this.mOkHttp3RequestLog.responseHeadersEnd(r3);
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call r2) {
        super.responseHeadersStart(r2);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.responseHeadersStart(r2);
    L5:
        this.mOkHttp3RequestLog.responseHeadersStart();
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call r2, Handshake r3) {
        super.secureConnectEnd(r2, r3);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.secureConnectEnd(r2, r3);
    L5:
        this.mOkHttp3RequestLog.secureConnectEnd();
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call r2) {
        super.secureConnectStart(r2);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.secureConnectStart(r2);
    L5:
        this.mOkHttp3RequestLog.secureConnectStart();
    }

    public void connectFailed(Call r7, InetSocketAddress r8, Proxy r9, Protocol r10, IOException r11, String r12) {
        super.connectFailed(r7, r8, r9, r10, r11, r12);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.connectFailed(r7, r8, r9, r10, r11);
    L5:
        this.mOkHttp3RequestLog.connectFailed(r8, r11, r12);
    }

    public void dnsEnd(Call r2, String r3, List<InetAddress> r4, String r5) {
        super.dnsEnd(r2, r3, r4, r5);
        EventListener r0 = this.mOriginEventListener;
        if (r0 == null) goto L5;
        r0.dnsEnd(r2, r3, r4);
    L5:
        this.mOkHttp3RequestLog.dnsEnd(r5);
    }
}
