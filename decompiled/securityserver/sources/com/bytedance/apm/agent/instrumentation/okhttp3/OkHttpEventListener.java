package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.apm.ApmContext;
import com.bytedance.apm.agent.monitor.MonitorTool;
import com.bytedance.apm.constant.SlardarSettingsConsts;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.util.NetUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Iterator;
import java.util.List;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class OkHttpEventListener extends EventListener {
    public static final String X_TT_CONTENT_ENCODING = "x-tt-content-encoding";
    public static final String X_TT_TRACE_HOST = "x-tt-trace-host";
    public static final String X_TT_TRACE_ID = "x-tt-trace-id";
    public static final String X_TT_TRACE_TAG = "x-tt-trace-tag";
    private static String sIgnoreMonitorLabel;
    private long connectStartTime;
    private long dnsStartTime;
    private boolean needToDeal;
    private OkHttpRecord okHttpRecord;
    public EventListener originListener;
    private long requestBodyEndTime;
    private JSONObject requestHeader;
    private long requestHeadersEndTime;
    private long requestHeadersStartTime;
    private long responseBodyStartTime;
    private JSONObject responseHeader;
    private long responseHeadersStartTime;
    private long secureConnectStartTime;
    private String url;

    public OkHttpEventListener(EventListener r2) {
        this.needToDeal = true;
        this.originListener = r2;
        this.okHttpRecord = new OkHttpRecord();
    }

    private void dealSpecialHeader(Response r12) {
        Iterator<String> r13 = r12.headers("server-timing").iterator();
    L4:
        if (r13.hasNext() == false) goto L79;
        String r3 = r13.next();
        if (TextUtils.isEmpty(r3) == true) goto L7;
        this.okHttpRecord.headerRequest.serverTimings.add(r3);
        String[] r4 = r3.split(",");
        int r5 = r4.length;
        int r6 = 0;
    L9:
        if (r6 >= r5) goto L4;
        String r7 = r4[r6];
        if (TextUtils.isEmpty(r7) == false) goto L14;
    L78:
        r6 = r6 + 1;
        goto L9
    L14:
        if (r7.contains(";") == false) goto L78;
        String[] r8 = r7.split(";");
        if (r8.length < 2) goto L78;
        String r9 = r8[0].replace(" ", "");
        String r10 = r8[1].replace(" ", "");
        if (TextUtils.isEmpty(r9) == true) goto L78;
        r9.getClass();
        byte r11 = -1;
        switch(r9.hashCode()) {
            case -1008619738: goto L35;
            case -138105374: goto L31;
            case 3108285: goto L27;
            case 100355670: goto L23;
            default: goto L38;
        };
    L38:
        switch(r11) {
            case 0: goto L70;
            case 1: goto L59;
            case 2: goto L50;
            case 3: goto L41;
            default: goto L78;
        };
    L41:
        if (TextUtils.isEmpty(r10) == true) goto L78;
        String[] r14 = r10.split("=");
        if (r14.length < 2) goto L78;
        OkHttpRecord.DetailedDuration r15 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r14[1]) == true) goto L47;
        int r16 = Integer.parseInt(r14[1]);
    L48:
        r15.inner = r16;
        goto L78
    L47:
        r16 = 0;
        goto L48
    L50:
        if (TextUtils.isEmpty(r10) == true) goto L78;
        String[] r17 = r10.split("=");
        if (r17.length < 2) goto L78;
        OkHttpRecord.DetailedDuration r18 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r17[1]) == true) goto L56;
        int r19 = Integer.parseInt(r17[1]);
    L57:
        r18.edge = r19;
        goto L78
    L56:
        r19 = 0;
        goto L57
    L59:
        if (TextUtils.isEmpty(r10) == true) goto L78;
        String[] r20 = r10.split("=");
        if (r20.length < 2) goto L78;
        OkHttpRecord.DetailedDuration r21 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r20[1]) == false) goto L65;
    L67:
        boolean r22 = false;
    L68:
        r21.cdn_hit_cache = r22;
        goto L78
    L65:
        if (r20[1].equalsIgnoreCase(BaseHttpRequestInfo.KEY_HIT) == false) goto L67;
        r22 = true;
        goto L68
    L70:
        if (TextUtils.isEmpty(r10) == true) goto L78;
        String[] r23 = r10.split("=");
        if (r23.length < 2) goto L78;
        OkHttpRecord.DetailedDuration r24 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r23[1]) == true) goto L76;
        int r25 = Integer.parseInt(r23[1]);
    L77:
        r24.origin = r25;
        goto L78
    L76:
        r25 = 0;
        goto L77
    L23:
        if (r9.equals("inner") == false) goto L38;
        r11 = 3;
        goto L38
    L27:
        if (r9.equals("edge") == false) goto L38;
        r11 = 2;
        goto L38
    L31:
        if (r9.equals("cdn-cache") == false) goto L38;
        r11 = 1;
        goto L38
    L35:
        if (r9.equals("origin") == false) goto L38;
        r11 = 0;
        goto L38
    L7:
        return;
    L79:
        OkHttpRecord.DetailedDuration r110 = this.okHttpRecord.timeDetailedDuration;
        int r111 = r110.ttfb - r110.edge;
        int r0 = r110.origin;
        int r112 = r111 - r0;
        if (r112 <= 0) goto L82;
        r110.rtt = r112;
    L82:
        int r1 = r0 - r110.inner;
        if (r1 <= 0) goto L91;
        r110.origin = r1;
        return;
    }

    private JSONObject getHeaders(Headers r4) {
        JSONObject r3 = new JSONObject();
        if (r4 != null) goto L19;
    L16:
        return r3;
    L19:
        Iterator<String> r0 = r4.names().iterator();     // Catch: Exception -> L10
    L5:
        if (r0.hasNext() == false) goto L16;
        String r1 = r0.next();     // Catch: Exception -> L10
        r3.put(r1, r4.get(r1));     // Catch: Exception -> L10 JSONException -> L12
    L12:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    private void record() {
        if (this.needToDeal == true) goto L5;
        return;
    L5:
        OkHttpRecord r0 = this.okHttpRecord;
        if (r0 != null) goto L8;
        return;
    L8:
        OkHttpRecord.TimeRequest r1 = r0.timeRequest;
        r1.duration = System.currentTimeMillis() - this.okHttpRecord.timeRequest.start_time;
        JSONObject r2 = new JSONObject(this.okHttpRecord.toString());     // Catch: JSONException -> L13
        r2.put(TrafficConsts.KEY_SENT_BYTES, this.okHttpRecord.recordResponse.sent_bytes);     // Catch: JSONException -> L13
        r2.put(TrafficConsts.KEY_RECEIVED_BYTES, this.okHttpRecord.recordResponse.received_bytes);     // Catch: JSONException -> L13
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L13
        r12.put("request_log", r2);     // Catch: JSONException -> L13
        r12.put(TrafficConsts.KEY_NET_CONSUME_TYPE, "okhttp");     // Catch: JSONException -> L13
        JSONObject r3 = this.requestHeader;     // Catch: JSONException -> L13
        String r4 = "";
        if (r3 == null) goto L15;
        String r5 = r3.toString();     // Catch: JSONException -> L13
    L16:
        r12.put(SlardarSettingsConsts.EXT_REQUEST_HEADER, r5);     // Catch: JSONException -> L13
        JSONObject r6 = this.responseHeader;     // Catch: JSONException -> L13
        if (r6 == null) goto L19;
        r4 = r6.toString();     // Catch: JSONException -> L13
    L19:
        r12.put(SlardarSettingsConsts.EXT_RESPONSE_HEADER, r4);     // Catch: JSONException -> L13
        OkHttpRecord r7 = this.okHttpRecord;     // Catch: JSONException -> L13
        OkHttpRecord.TimeRequest r8 = r7.timeRequest;     // Catch: JSONException -> L13
        MonitorTool.monitorSLA(r8.duration, r8.start_time, this.url, r7.socketInfo.remote, "", r7.recordResponse.code, r12);     // Catch: JSONException -> L13
        return;
    L15:
        r5 = "";
    L13:
        e = move-exception;
        e.printStackTrace();
    }

    public static void setIgnoreMonitorLabel(String r0) {
        sIgnoreMonitorLabel = r0;
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call r2) {
        super.callEnd(r2);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L5;
        r0.callEnd(r2);
    L5:
        record();
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call r2, IOException r3) {
        super.callFailed(r2, r3);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L5;
        r0.callFailed(r2, r3);
    L5:
        record();
    }

    @Override // okhttp3.EventListener
    public void callStart(Call r3) {
        super.callStart(r3);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.callStart(r3);
    L6:
        if (this.needToDeal == false) goto L9;
        OkHttpRecord.TimeRequest r2 = this.okHttpRecord.timeRequest;
        r2.start_time = System.currentTimeMillis();
        return;
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call r2, InetSocketAddress r3, Proxy r4, @Nullable Protocol r5) {
        super.connectEnd(r2, r3, r4, r5);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.connectEnd(r2, r3, r4, r5);
    L6:
        if (this.needToDeal == false) goto L17;
        OkHttpRecord.RecordResponse r6 = this.okHttpRecord.recordResponse;
        if (r4.address() == null) goto L10;
        boolean r7 = true;
    L11:
        r6.via_Proxy = r7;
        if (r3 != null) goto L14;
        return;
    L14:
        if (r3.getAddress() == null) goto L19;
        this.okHttpRecord.socketInfo.remote = r3.getAddress().getHostAddress() + ":" + r3.getPort();
        this.okHttpRecord.socketInfo.host = r3.getAddress().getHostAddress();
        this.okHttpRecord.socketInfo.port = r3.getPort() + "";
        return;
    L19:
        return;
    L10:
        r7 = false;
        goto L11
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call r7, InetSocketAddress r8, Proxy r9, @Nullable Protocol r10, IOException r11) {
        super.connectFailed(r7, r8, r9, r10, r11);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.connectFailed(r7, r8, r9, r10, r11);
        return;
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call r3, InetSocketAddress r4, Proxy r5) {
        super.connectStart(r3, r4, r5);
        if (this.needToDeal == false) goto L5;
        this.connectStartTime = System.currentTimeMillis();
    L5:
        EventListener r2 = this.originListener;
        if (r2 == null) goto L9;
        r2.connectStart(r3, r4, r5);
        return;
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call r3, Connection r4) {
        super.connectionAcquired(r3, r4);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.connectionAcquired(r3, r4);
    L6:
        if (this.needToDeal == true) goto L8;
        return;
    L8:
        if (this.dnsStartTime != 0) goto L10;
        this.okHttpRecord.socketInfo.socketReused = true;
        return;
    L10:
        this.okHttpRecord.socketInfo.socketReused = false;
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call r1, Connection r2) {
        super.connectionReleased(r1, r2);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.connectionReleased(r1, r2);
        return;
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call r5, String r6, List<InetAddress> r7) {
        super.dnsEnd(r5, r6, r7);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.dnsEnd(r5, r6, r7);
    L6:
        if (this.needToDeal == false) goto L15;
        OkHttpRecord.DetailedDuration r8 = this.okHttpRecord.timeDetailedDuration;
        r8.dns = (int) (System.currentTimeMillis() - this.dnsStartTime);
        if (r7 != null) goto L10;
        return;
    L10:
        if (r7.size() <= 0) goto L18;
        Iterator<InetAddress> r9 = r7.iterator();
    L13:
        if (r9.hasNext() == false) goto L19;
        InetAddress r10 = r9.next();
        OkHttpRecord.DnsInfo r11 = new OkHttpRecord.DnsInfo();
        r11.address = r10.getHostAddress();
        this.okHttpRecord.addressList.add(r11);
        goto L13
    L19:
        return;
    L18:
        return;
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call r3, String r4) {
        super.dnsStart(r3, r4);
        if (this.needToDeal == false) goto L5;
        this.dnsStartTime = System.currentTimeMillis();
    L5:
        EventListener r2 = this.originListener;
        if (r2 == null) goto L9;
        r2.dnsStart(r3, r4);
        return;
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call r6, long r7) {
        super.requestBodyEnd(r6, r7);
        if (this.needToDeal == false) goto L5;
        this.requestBodyEndTime = System.currentTimeMillis();
        this.okHttpRecord.timeDetailedDuration.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
    L5:
        EventListener r0 = this.originListener;
        if (r0 == null) goto L9;
        r0.requestBodyEnd(r6, r7);
    L9:
        if (this.needToDeal == false) goto L12;
        this.okHttpRecord.recordResponse.sent_bytes += r7;
        return;
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call r1) {
        super.requestBodyStart(r1);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.requestBodyStart(r1);
        return;
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call r6, Request r7) {
        super.requestHeadersEnd(r6, r7);
        if (this.needToDeal == false) goto L5;
        this.requestHeadersEndTime = System.currentTimeMillis();
        OkHttpRecord.DetailedDuration r0 = this.okHttpRecord.timeDetailedDuration;
        r0.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
    L5:
        EventListener r1 = this.originListener;
        if (r1 == null) goto L8;
        r1.requestHeadersEnd(r6, r7);
    L8:
        String r8 = r7.header("User-Agent");
        String r2 = sIgnoreMonitorLabel;
        if (r2 == null) goto L15;
        if (r8 == null) goto L15;
        if (r8.contains(r2) == false) goto L15;
        this.needToDeal = false;
    L15:
        if (this.needToDeal == false) goto L18;
        OkHttpRecord.RecordResponse r9 = this.okHttpRecord.recordResponse;
        long r3 = r9.sent_bytes;
        r9.sent_bytes = r7.headers().byteCount() + r3;
        this.url = r7.url().toString();
        this.requestHeader = getHeaders(r7.headers());
        return;
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call r4) {
        super.requestHeadersStart(r4);
        if (this.needToDeal == false) goto L5;
        long r0 = System.currentTimeMillis();
        this.requestHeadersStartTime = r0;
        this.okHttpRecord.timeRequest.request_sent_time = r0;
    L5:
        EventListener r3 = this.originListener;
        if (r3 == null) goto L9;
        r3.requestHeadersStart(r4);
        return;
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call r4, long r5) {
        super.responseBodyEnd(r4, r5);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.responseBodyEnd(r4, r5);
    L6:
        if (this.needToDeal == false) goto L9;
        OkHttpRecord r6 = this.okHttpRecord;
        r6.recordResponse.received_bytes += r5;
        r6.timeDetailedDuration.body_recv = (int) (System.currentTimeMillis() - this.responseBodyStartTime);
        return;
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call r3) {
        super.responseBodyStart(r3);
        if (this.needToDeal == false) goto L5;
        this.responseBodyStartTime = System.currentTimeMillis();
    L5:
        EventListener r2 = this.originListener;
        if (r2 == null) goto L9;
        r2.responseBodyStart(r3);
        return;
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call r5, Response r6) {
        super.responseHeadersEnd(r5, r6);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.responseHeadersEnd(r5, r6);
    L6:
        if (this.needToDeal == false) goto L14;
        OkHttpRecord.DetailedDuration r7 = this.okHttpRecord.timeDetailedDuration;
        r7.header_recv = (int) (System.currentTimeMillis() - this.responseHeadersStartTime);
        OkHttpRecord.RecordResponse r8 = this.okHttpRecord.recordResponse;
        r8.code = r6.code();
        OkHttpRecord.RecordResponse r9 = this.okHttpRecord.recordResponse;
        long r1 = r9.received_bytes;
        r9.received_bytes = r6.headers().byteCount() + r1;
        OkHttpRecord.RecordResponse r10 = this.okHttpRecord.recordResponse;
        r10.network_accessed = NetUtils.isNetworkAvailable(ApmContext.getContext());
        OkHttpRecord.HeaderRequest r11 = this.okHttpRecord.headerRequest;
        r11.x_tt_trace_id = r6.header(X_TT_TRACE_ID, "");
        OkHttpRecord.HeaderRequest r12 = this.okHttpRecord.headerRequest;
        r12.x_tt_trace_host = r6.header(X_TT_TRACE_HOST, "");
        OkHttpRecord.HeaderRequest r13 = this.okHttpRecord.headerRequest;
        r13.x_tt_trace_tag = r6.header(X_TT_TRACE_TAG, "");
        OkHttpRecord.HeaderRequest r14 = this.okHttpRecord.headerRequest;
        r14.x_tt_content_encoding = r6.header(X_TT_CONTENT_ENCODING, "");
        dealSpecialHeader(r6);     // Catch: Exception -> L11
    L9:
        this.responseHeader = getHeaders(r6.headers());
        return;
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call r5) {
        super.responseHeadersStart(r5);
        if (this.needToDeal == false) goto L10;
        this.responseHeadersStartTime = System.currentTimeMillis();
        if (this.requestBodyEndTime == 0) goto L8;
        long r0 = System.currentTimeMillis();
        long r2 = this.requestBodyEndTime;
    L7:
        long r1 = r0 - r2;
        OkHttpRecord r3 = this.okHttpRecord;
        int r4 = (int) r1;
        r3.timeDetailedDuration.ttfb = r4;
        OkHttpRecord.TimeRequest r6 = r3.timeRequest;
        r6.response_recv_time = System.currentTimeMillis();
        goto L10
    L8:
        r0 = System.currentTimeMillis();
        r2 = this.requestHeadersEndTime;
    L10:
        EventListener r7 = this.originListener;
        if (r7 == null) goto L14;
        r7.responseHeadersStart(r5);
        return;
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call r6, @Nullable Handshake r7) {
        super.secureConnectEnd(r6, r7);
        if (this.needToDeal == false) goto L5;
        OkHttpRecord.DetailedDuration r0 = this.okHttpRecord.timeDetailedDuration;
        r0.ssl = (int) (System.currentTimeMillis() - this.secureConnectStartTime);
    L5:
        EventListener r5 = this.originListener;
        if (r5 == null) goto L9;
        r5.secureConnectEnd(r6, r7);
        return;
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call r6) {
        super.secureConnectStart(r6);
        if (this.needToDeal == false) goto L5;
        OkHttpRecord.DetailedDuration r0 = this.okHttpRecord.timeDetailedDuration;
        r0.tcp = (int) (System.currentTimeMillis() - this.connectStartTime);
        this.secureConnectStartTime = System.currentTimeMillis();
    L5:
        EventListener r5 = this.originListener;
        if (r5 == null) goto L9;
        r5.secureConnectStart(r6);
        return;
    }
}
