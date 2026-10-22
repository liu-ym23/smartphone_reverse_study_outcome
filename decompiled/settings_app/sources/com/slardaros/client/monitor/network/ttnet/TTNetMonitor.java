package com.slardaros.client.monitor.network.ttnet;

import android.icu.text.PluralRules;
import android.text.TextUtils;
import com.android.settings.wifi.WifiAuthorizeUtils;
import com.bytedance.apm.alog.AlogMonitor;
import com.bytedance.apm.constant.TraceStatsConsts;
import com.bytedance.apm.constant.TrafficConsts;
import com.bytedance.apm.perf.traffic.ApmTrafficStats;
import com.bytedance.bdinstall.BuildConfig;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetClient;
import com.google.common.net.HttpHeaders;
import com.obric.olog.OLog;
import com.slardaros.client.Constants;
import com.slardaros.client.SlardarAgent;
import com.slardaros.client.SlardarUtil;
import com.slardaros.client.monitor.Util;
import com.slardaros.client.monitor.network.NetUtil;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class TTNetMonitor {
    public TTNetMonitor() {
    }

    public static void sendTTNetMetricEvent(long r29, JSONObject r31, Throwable r32) {
        String r16 = Constants.METRIC_EVENT_NETWORK;
        JSONObject r4 = new JSONObject();
        JSONObject r3 = new JSONObject();
        JSONObject r2 = new JSONObject();
        r3.put("duration", r29);     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("interceptors_time", r31.optLong("requestStart") - r31.optLong("beforeAllInterceptors"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("total_time", r31.optInt("timing_total"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put(ICronetClient.KEY_DNS_TIME, r31.optInt("timing_dns"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("tcp_time", r31.optInt("timing_connect"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put(ICronetClient.KEY_SSL_TIME, r31.optInt("timing_ssl"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put(ICronetClient.KEY_SEND_TIME, r31.optInt("timing_send"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("waiting_time", r31.optInt("timing_waiting"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put(ICronetClient.KEY_RECEIVE_TIME, r31.optInt("timing_receive"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("send_bytes", r31.optLong(TrafficConsts.KEY_SENT_BYTES));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("received_bytes", r31.optLong(TrafficConsts.KEY_RECEIVED_BYTES));     // Catch: Throwable -> L71 JSONException -> L73
        r4.put(ICronetClient.KEY_REMOTE_IP, r31.optString("timing_remoteIP", ""));     // Catch: Throwable -> L71 JSONException -> L73
        if (r32 != null) goto L6;
        boolean r9 = true;
    L7:
        r4.put("request_success", r9);     // Catch: Throwable -> L71 JSONException -> L73
        r2.put("log", r31.toString());     // Catch: Throwable -> L71 JSONException -> L73
        if (r32 == null) goto L10;
        r2.put("exception", r32.getMessage());     // Catch: Throwable -> L71 JSONException -> L73
    L10:
        String r0 = r31.optString("request_log");     // Catch: Throwable -> L71 JSONException -> L73
        if (TextUtils.isEmpty(r0) == true) goto L70;
        JSONObject r5 = new JSONObject(r0);     // Catch: Throwable -> L71 JSONException -> L73
        JSONObject r1 = r5.optJSONObject("timing");     // Catch: Throwable -> L71 JSONException -> L73
        if (r1 == null) goto L17;
        JSONObject r6 = r1.optJSONObject("detailed_duration");     // Catch: Throwable -> L71 JSONException -> L73
        if (r6 == null) goto L17;
        r3.put("security_callback", r6.optInt("security_callback"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("dispatch_time", r6.optInt("dispatch"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("proxy_time", r6.optInt("proxy"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("rtt_time", r6.optInt("rtt"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("edge_time", r6.optInt("edge"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("origin_time", r6.optInt(HttpHeaders.ReferrerPolicyValues.ORIGIN));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("inner_time", r6.optInt(BuildConfig.FLAVOR_type));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("header_recv_time", r6.optInt("header_recv"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("body_recv_time", r6.optInt("body_recv"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("before_steam_time", r6.optInt("before_steam"));     // Catch: Throwable -> L71 JSONException -> L73
        r3.put("create_steam_time", r6.optInt("create_steam"));     // Catch: Throwable -> L71 JSONException -> L73
    L17:
        JSONObject r7 = r5.optJSONObject(TraceStatsConsts.STATS_BASE_MODULE);     // Catch: Throwable -> L71 JSONException -> L73
        if (r7 == null) goto L34;
        String r10 = r7.getString("origin_url");     // Catch: Throwable -> L71 JSONException -> L73
        String r14 = r10.replace("http://", "").replace("https://", "");     // Catch: Throwable -> L71 JSONException -> L73
        JSONObject r25 = r2;
        int r8 = r14.indexOf(47);     // Catch: Throwable -> L66 JSONException -> L68
        if (r8 == (-1)) goto L24;
        r14 = r14.substring(0, r8);     // Catch: Throwable -> L66 JSONException -> L68
    L24:
        r4.put("original_host", r14);     // Catch: Throwable -> L66 JSONException -> L68
        r4.put(WifiAuthorizeUtils.AUTO_LOGIN_HOST, r14);     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("original_url", r10);     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("url", r10);     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("protocol", NetUtil.getProtocol(r10));     // Catch: Throwable -> L66 JSONException -> L68
        if (r7.has("redirecting_list") == false) goto L32;
        JSONArray r11 = r7.getJSONArray("redirecting_list");     // Catch: Throwable -> L66 JSONException -> L68
        if (r11.length() <= 0) goto L32;
        boolean r15 = true;
        String r12 = r11.getString(r11.length() - 1);     // Catch: Throwable -> L66 JSONException -> L68
        String r13 = r12.replace("http://", "").replace("https://", "");     // Catch: Throwable -> L66 JSONException -> L68
        int r17 = r13.indexOf(47);     // Catch: Throwable -> L66 JSONException -> L68
        if (r17 == (-1)) goto L31;
        r13 = r13.substring(0, r17);     // Catch: Throwable -> L66 JSONException -> L68
    L31:
        r4.put(WifiAuthorizeUtils.AUTO_LOGIN_HOST, r13);     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("url", r12);     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("protocol", NetUtil.getProtocol(r12));     // Catch: Throwable -> L66 JSONException -> L68
    L33:
        r4.put("request_status", r7.optString("status", ""));     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("net_error", r7.optInt("net_error", 0));     // Catch: Throwable -> L66 JSONException -> L68
    L35:
        JSONObject r18 = r5.optJSONObject("ifconfig");     // Catch: Throwable -> L66 JSONException -> L68
        if (r18 == null) goto L38;
        r4.put("ipv4_reachable", r18.optBoolean("ipv4_reachable", false));     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("ipv6_reachable", r18.optBoolean("ipv6_reachable", false));     // Catch: Throwable -> L66 JSONException -> L68
    L38:
        JSONObject r19 = r5.optJSONObject("socket");     // Catch: Throwable -> L66 JSONException -> L68
        if (r19 == null) goto L47;
        int r20 = r19.optInt("address_family", 0);     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("address_family", r20);     // Catch: Throwable -> L66 JSONException -> L68
        String r21 = r19.optString("remote", "");     // Catch: Throwable -> L66 JSONException -> L68
        if (r20 == 2) goto L43;
    L45:
        boolean r22 = false;
    L46:
        r4.put("is_dns64", r22);     // Catch: Throwable -> L66 JSONException -> L68
        goto L47
    L43:
        if (r21.startsWith("64:ff9b::") == false) goto L45;
        r22 = r15;
    L47:
        JSONObject r23 = r5.optJSONObject(PluralRules.KEYWORD_OTHER);     // Catch: Throwable -> L66 JSONException -> L68
        if (r23 == null) goto L51;
        r4.put("network_lib", "ttnet(" + r23.optString("libcore") + ")");     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("network_lib_version", r23.optString("ttnet_version"));     // Catch: Throwable -> L66 JSONException -> L68
        r4.put(ICronetClient.KEY_RETRY_ATTEMPTS, r23.optInt(ICronetClient.KEY_RETRY_ATTEMPTS));     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("is_background", r23.optBoolean("is_background"));     // Catch: Throwable -> L66 JSONException -> L68
    L56:
        JSONObject r24 = r5.optJSONObject("ssl");     // Catch: Throwable -> L66 JSONException -> L68
        if (r24 == null) goto L59;
        r4.put("handshake_type", r24.optInt("handshake_type", 0));     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("cert_status", r24.optInt("cert_status", 0));     // Catch: Throwable -> L66 JSONException -> L68
    L59:
        JSONObject r26 = r5.optJSONObject("nqe");     // Catch: Throwable -> L66 JSONException -> L68
        if (r26 == null) goto L62;
        r4.put("network_type", r26.optInt("real_net_type", 0));     // Catch: Throwable -> L66 JSONException -> L68
    L62:
        JSONObject r27 = r5.optJSONObject(ApmTrafficStats.TTNET_RESPONSE);     // Catch: Throwable -> L66 JSONException -> L68
        if (r27 == null) goto L65;
        r4.put("is_cached", r27.optBoolean("cached", false));     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("via_proxy", r27.optBoolean("via_proxy", false));     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("connection_info", String.valueOf(r27.optInt("connection_info", 0)));     // Catch: Throwable -> L66 JSONException -> L68
        r4.put("status_code", r27.optInt(AlogMonitor.ALOG_RESULT_CODE, 0));     // Catch: Throwable -> L66 JSONException -> L68
    L65:
        r16 = r16;
        JSONObject r28 = r25;
    L76:
        Util.sendMetricEvent(r16, r4, r3, r28);
        return;
    L51:
        r4.put("network_lib", ApmTrafficStats.KEY_TRAFFIC_SOURCE_TTNET);     // Catch: Throwable -> L66 JSONException -> L68
        if (SlardarUtil.isAppInForeground(SlardarAgent.getContext()) == true) goto L54;
        boolean r30 = r15;
    L55:
        r4.put("is_background", r30);     // Catch: Throwable -> L66 JSONException -> L68
        goto L56
    L54:
        r30 = false;
    L32:
        r15 = true;
    L68:
        e = e;
        r28 = r25;
    L81:
        OLog.e("sendTTNetMetricEvent", "sendMetricTTNetEvent: " + e.getMessage());     // Catch: Throwable -> L78
    L78:
        th = th;
    L79:
        Util.sendMetricEvent(r16, r4, r3, r28);
        throw th;
    L66:
        th = th;
        r16 = r16;
        r28 = r25;
        goto L79
    L34:
        r25 = r2;
        r15 = true;
        goto L35
    L70:
        r28 = r2;
        r16 = r16;
        goto L76
    L6:
        r9 = false;
    L73:
        e = e;
        r28 = r2;
    L71:
        th = th;
        r28 = r2;
        r16 = r16;
        goto L79
    }
}
