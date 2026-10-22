package com.bytedance.apm.agent.instrumentation.okhttp3;

import android.text.TextUtils;
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

    public static void setIgnoreMonitorLabel(String r0) {
        sIgnoreMonitorLabel = r0;
    }

    public OkHttpEventListener(EventListener r2) {
        this.needToDeal = true;
        this.originListener = r2;
        this.okHttpRecord = new OkHttpRecord();
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

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call r6, Handshake r7) {
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
    public void connectEnd(Call r2, InetSocketAddress r3, Proxy r4, Protocol r5) {
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
    public void connectFailed(Call r7, InetSocketAddress r8, Proxy r9, Protocol r10, IOException r11) {
        super.connectFailed(r7, r8, r9, r10, r11);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.connectFailed(r7, r8, r9, r10, r11);
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
    public void requestHeadersStart(Call r4) {
        super.requestHeadersStart(r4);
        if (this.needToDeal == false) goto L5;
        this.requestHeadersStartTime = System.currentTimeMillis();
        OkHttpRecord.TimeRequest r0 = this.okHttpRecord.timeRequest;
        r0.request_sent_time = this.requestHeadersStartTime;
    L5:
        EventListener r3 = this.originListener;
        if (r3 == null) goto L9;
        r3.requestHeadersStart(r4);
        return;
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call r6, Request r7) {
        super.requestHeadersEnd(r6, r7);
        if (this.needToDeal == false) goto L5;
        this.requestHeadersEndTime = System.currentTimeMillis();
        this.okHttpRecord.timeDetailedDuration.send = (int) (System.currentTimeMillis() - this.requestHeadersStartTime);
    L5:
        EventListener r0 = this.originListener;
        if (r0 == null) goto L8;
        r0.requestHeadersEnd(r6, r7);
    L8:
        String r8 = r7.header("User-Agent");
        String r1 = sIgnoreMonitorLabel;
        if (r1 == null) goto L15;
        if (r8 == null) goto L15;
        if (r8.contains(r1) == false) goto L15;
        this.needToDeal = false;
    L15:
        if (this.needToDeal == false) goto L18;
        this.okHttpRecord.recordResponse.sent_bytes += r7.headers().byteCount();
        this.url = r7.url().toString();
        this.requestHeader = getHeaders(r7.headers());
        return;
    }

    private JSONObject getHeaders(Headers r4) {
        JSONObject r3 = new JSONObject();
        if (r4 != null) goto L18;
    L15:
        return r3;
    L18:
        Iterator<String> r0 = r4.names().iterator();     // Catch: Exception -> L13
    L5:
        if (r0.hasNext() == false) goto L15;
        String r1 = r0.next();     // Catch: Exception -> L13
        r3.put(r1, r4.get(r1));     // Catch: JSONException -> L10 Exception -> L13
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Exception -> L13
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
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
    public void responseHeadersStart(Call r5) {
        super.responseHeadersStart(r5);
        if (this.needToDeal == false) goto L9;
        this.responseHeadersStartTime = System.currentTimeMillis();
        if (this.requestBodyEndTime == 0) goto L7;
        long r0 = System.currentTimeMillis();
        long r2 = this.requestBodyEndTime;
    L8:
        long r1 = r0 - r2;
        int r3 = (int) r1;
        this.okHttpRecord.timeDetailedDuration.ttfb = r3;
        OkHttpRecord.TimeRequest r4 = this.okHttpRecord.timeRequest;
        r4.response_recv_time = System.currentTimeMillis();
        goto L9
    L7:
        r0 = System.currentTimeMillis();
        r2 = this.requestHeadersEndTime;
    L9:
        EventListener r6 = this.originListener;
        if (r6 == null) goto L13;
        r6.responseHeadersStart(r5);
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
        this.okHttpRecord.timeDetailedDuration.header_recv = (int) (System.currentTimeMillis() - this.responseHeadersStartTime);
        this.okHttpRecord.recordResponse.code = r6.code();
        this.okHttpRecord.recordResponse.received_bytes += r6.headers().byteCount();
        this.okHttpRecord.recordResponse.network_accessed = NetUtils.isNetworkAvailable(ApmContext.getContext());
        this.okHttpRecord.headerRequest.x_tt_trace_id = r6.header(X_TT_TRACE_ID, "");
        this.okHttpRecord.headerRequest.x_tt_trace_host = r6.header(X_TT_TRACE_HOST, "");
        this.okHttpRecord.headerRequest.x_tt_trace_tag = r6.header(X_TT_TRACE_TAG, "");
        this.okHttpRecord.headerRequest.x_tt_content_encoding = r6.header(X_TT_CONTENT_ENCODING, "");
        dealSpecialHeader(r6);     // Catch: Exception -> L11
    L9:
        this.responseHeader = getHeaders(r6.headers());
        return;
    }

    private void dealSpecialHeader(Response r11) {
        Iterator<String> r12 = r11.headers("server-timing").iterator();
    L4:
        if (r12.hasNext() == false) goto L80;
        String r0 = r12.next();
        if (TextUtils.isEmpty(r0) == true) goto L7;
        this.okHttpRecord.headerRequest.serverTimings.add(r0);
        String[] r1 = r0.split(",");
        int r2 = r1.length;
        int r3 = 0;
    L9:
        if (r3 >= r2) goto L4;
        String r4 = r1[r3];
        if (TextUtils.isEmpty(r4) == false) goto L14;
    L79:
        r3 = r3 + 1;
        goto L9
    L14:
        if (r4.contains(";") == false) goto L79;
        String[] r5 = r4.split(";");
        if (r5.length < 2) goto L79;
        String r6 = r5[0].replace(" ", "");
        boolean r9 = true;
        String r7 = r5[1].replace(" ", "");
        if (TextUtils.isEmpty(r6) == true) goto L79;
        r6.hashCode();
        byte r8 = -1;
        switch(r6.hashCode()) {
            case -1008619738: goto L35;
            case -138105374: goto L31;
            case 3108285: goto L27;
            case 100355670: goto L23;
            default: goto L39;
        };
    L23:
        if (r6.equals("inner") == false) goto L39;
        r8 = 3;
        goto L39
    L27:
        if (r6.equals("edge") == false) goto L39;
        r8 = 2;
        goto L39
    L31:
        if (r6.equals("cdn-cache") == false) goto L39;
        r8 = 1;
        goto L39
    L35:
        if (r6.equals("origin") == false) goto L39;
        r8 = 0;
    L39:
        switch(r8) {
            case 0: goto L71;
            case 1: goto L60;
            case 2: goto L51;
            case 3: goto L42;
            default: goto L79;
        };
    L42:
        if (TextUtils.isEmpty(r7) == true) goto L79;
        String[] r10 = r7.split("=");
        if (r10.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r13 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r10[1]) == true) goto L48;
        int r14 = Integer.parseInt(r10[1]);
    L49:
        r13.inner = r14;
        goto L79
    L48:
        r14 = 0;
        goto L49
    L51:
        if (TextUtils.isEmpty(r7) == true) goto L79;
        String[] r15 = r7.split("=");
        if (r15.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r16 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r15[1]) == true) goto L57;
        int r17 = Integer.parseInt(r15[1]);
    L58:
        r16.edge = r17;
        goto L79
    L57:
        r17 = 0;
        goto L58
    L60:
        if (TextUtils.isEmpty(r7) == true) goto L79;
        String[] r18 = r7.split("=");
        if (r18.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r19 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r18[1]) == false) goto L66;
    L68:
        r9 = false;
    L69:
        r19.cdn_hit_cache = r9;
        goto L79
    L66:
        if (r18[1].equalsIgnoreCase(BaseHttpRequestInfo.KEY_HIT) == false) goto L68;
    L71:
        if (TextUtils.isEmpty(r7) == true) goto L79;
        String[] r20 = r7.split("=");
        if (r20.length < 2) goto L79;
        OkHttpRecord.DetailedDuration r21 = this.okHttpRecord.timeDetailedDuration;
        if (TextUtils.isEmpty(r20[1]) == true) goto L77;
        int r22 = Integer.parseInt(r20[1]);
    L78:
        r21.origin = r22;
        goto L79
    L77:
        r22 = 0;
        goto L78
    L7:
        return;
    L80:
        int r110 = (this.okHttpRecord.timeDetailedDuration.ttfb - this.okHttpRecord.timeDetailedDuration.edge) - this.okHttpRecord.timeDetailedDuration.origin;
        if (r110 <= 0) goto L83;
        this.okHttpRecord.timeDetailedDuration.rtt = r110;
    L83:
        int r111 = this.okHttpRecord.timeDetailedDuration.origin - this.okHttpRecord.timeDetailedDuration.inner;
        if (r111 <= 0) goto L92;
        this.okHttpRecord.timeDetailedDuration.origin = r111;
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
    public void responseBodyEnd(Call r3, long r4) {
        super.responseBodyEnd(r3, r4);
        EventListener r0 = this.originListener;
        if (r0 == null) goto L6;
        r0.responseBodyEnd(r3, r4);
    L6:
        if (this.needToDeal == false) goto L9;
        this.okHttpRecord.recordResponse.received_bytes += r4;
        this.okHttpRecord.timeDetailedDuration.body_recv = (int) (System.currentTimeMillis() - this.responseBodyStartTime);
        return;
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
        JSONObject r2 = new JSONObject(this.okHttpRecord.toString());     // Catch: JSONException -> L19
        r2.put(TrafficConsts.KEY_SENT_BYTES, this.okHttpRecord.recordResponse.sent_bytes);     // Catch: JSONException -> L19
        r2.put(TrafficConsts.KEY_RECEIVED_BYTES, this.okHttpRecord.recordResponse.received_bytes);     // Catch: JSONException -> L19
        JSONObject r12 = new JSONObject();     // Catch: JSONException -> L19
        r12.put("request_log", r2);     // Catch: JSONException -> L19
        r12.put(TrafficConsts.KEY_NET_CONSUME_TYPE, "okhttp");     // Catch: JSONException -> L19
        JSONObject r3 = this.requestHeader;     // Catch: JSONException -> L19
        String r4 = "";
        if (r3 == null) goto L13;
        String r5 = r3.toString();     // Catch: JSONException -> L19
    L14:
        r12.put(SlardarSettingsConsts.EXT_REQUEST_HEADER, r5);     // Catch: JSONException -> L19
        JSONObject r6 = this.responseHeader;     // Catch: JSONException -> L19
        if (r6 == null) goto L17;
        r4 = r6.toString();     // Catch: JSONException -> L19
    L17:
        r12.put(SlardarSettingsConsts.EXT_RESPONSE_HEADER, r4);     // Catch: JSONException -> L19
        MonitorTool.monitorSLA(this.okHttpRecord.timeRequest.duration, this.okHttpRecord.timeRequest.start_time, this.url, this.okHttpRecord.socketInfo.remote, "", this.okHttpRecord.recordResponse.code, r12);     // Catch: JSONException -> L19
        return;
    L13:
        r5 = "";
    L19:
        e = move-exception;
        e.printStackTrace();
    }
}
