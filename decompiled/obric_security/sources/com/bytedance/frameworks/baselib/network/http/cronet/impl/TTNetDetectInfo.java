package com.bytedance.frameworks.baselib.network.http.cronet.impl;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class TTNetDetectInfo {
    public int actions;
    public String appVersion;
    public String clientIp;
    public List<TTNetDetectInfoBase> details;
    public int failCount;
    public String localDnsServer;
    public String nettype;
    public String os;
    public String osVersion;
    public int rank;
    public int source;
    public int succCount;
    public long timestamp;

    public static class TTNetDetectHttpDnsInfo extends TTNetDetectInfoBase {
        public int cost;
        public int error;
        public String host;
        public List<String> ips;

        public TTNetDetectHttpDnsInfo() {
            this.ips = new ArrayList();
        }

        public static TTNetDetectHttpDnsInfo fromJson(JSONObject r4) {
            TTNetDetectHttpDnsInfo r0 = new TTNetDetectHttpDnsInfo();     // Catch: Throwable -> L18
            r0.host = r4.getString("host");     // Catch: Throwable -> L18
            r0.error = r4.getInt("error");     // Catch: Throwable -> L18
            r0.cost = r4.getInt("cost");     // Catch: Throwable -> L18
            JSONArray r5 = r4.optJSONArray("ips");     // Catch: Throwable -> L18
            if (r5 != null) goto L5;
        L17:
            return r0;
        L5:
            if (r5.length() <= 0) goto L17;
            int r1 = 0;
        L8:
            if (r1 >= r5.length()) goto L17;
            if (r5.get(r1) == null) goto L16;
            if ((r5.get(r1) instanceof String) == false) goto L16;
            String r2 = (String) r5.get(r1);     // Catch: Throwable -> L18
            if (TextUtils.isEmpty(r2) == true) goto L16;
            r0.ips.add(r2);     // Catch: Throwable -> L18
        L16:
            r1 = r1 + 1;
        L18:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public static class TTNetDetectHttpGetInfo extends TTNetDetectInfoBase {
        public int cached;
        public int dnsCost;
        public int errorCode;
        public int httpCode;
        public String ip;
        public int port;
        public int recvBytes;
        public int recvCost;
        public int sendCost;
        public int sockReused;
        public int sslCost;
        public int tcpCost;
        public int timeout;
        public int totalCost;
        public String url;
        public int waitCost;

        public TTNetDetectHttpGetInfo() {
        }

        public static TTNetDetectHttpGetInfo fromJson(JSONObject r2) {
            TTNetDetectHttpGetInfo r0 = new TTNetDetectHttpGetInfo();     // Catch: Throwable -> L4
            r0.url = r2.getString("url");     // Catch: Throwable -> L4
            r0.httpCode = r2.getInt("httpcode");     // Catch: Throwable -> L4
            r0.errorCode = r2.getInt("error");     // Catch: Throwable -> L4
            r0.timeout = r2.getInt("timeout");     // Catch: Throwable -> L4
            r0.ip = r2.getString("addr");     // Catch: Throwable -> L4
            r0.port = r2.getInt("port");     // Catch: Throwable -> L4
            r0.cached = r2.getInt("cached");     // Catch: Throwable -> L4
            r0.sockReused = r2.getInt("sock_reused");     // Catch: Throwable -> L4
            r0.totalCost = r2.getInt("totalcost");     // Catch: Throwable -> L4
            r0.dnsCost = r2.getInt("dnscost");     // Catch: Throwable -> L4
            r0.tcpCost = r2.getInt("tcpcost");     // Catch: Throwable -> L4
            r0.sslCost = r2.getInt("sslcost");     // Catch: Throwable -> L4
            r0.sendCost = r2.getInt("sendcost");     // Catch: Throwable -> L4
            r0.waitCost = r2.getInt("waitcost");     // Catch: Throwable -> L4
            r0.recvCost = r2.getInt("recvcost");     // Catch: Throwable -> L4
            r0.recvBytes = r2.getInt("recvd_bytes");     // Catch: Throwable -> L4
            return r0;
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public static class TTNetDetectInfoBase {
        public TTNetDetectInfoBase() {
        }
    }

    public static class TTNetDetectLocalDnsInfo extends TTNetDetectInfoBase {
        public int cost;
        public int error;
        public String host;
        public List<String> ips;

        public TTNetDetectLocalDnsInfo() {
            this.ips = new ArrayList();
        }

        public static TTNetDetectLocalDnsInfo fromJson(JSONObject r4) {
            TTNetDetectLocalDnsInfo r0 = new TTNetDetectLocalDnsInfo();     // Catch: Throwable -> L18
            r0.host = r4.getString("host");     // Catch: Throwable -> L18
            r0.error = r4.getInt("error");     // Catch: Throwable -> L18
            r0.cost = r4.getInt("cost");     // Catch: Throwable -> L18
            JSONArray r5 = r4.optJSONArray("ips");     // Catch: Throwable -> L18
            if (r5 != null) goto L5;
        L17:
            return r0;
        L5:
            if (r5.length() <= 0) goto L17;
            int r1 = 0;
        L8:
            if (r1 >= r5.length()) goto L17;
            if (r5.get(r1) == null) goto L16;
            if ((r5.get(r1) instanceof String) == false) goto L16;
            String r2 = (String) r5.get(r1);     // Catch: Throwable -> L18
            if (TextUtils.isEmpty(r2) == true) goto L16;
            r0.ips.add(r2);     // Catch: Throwable -> L18
        L16:
            r1 = r1 + 1;
        L18:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public static class TTNetDetectPingInfo extends TTNetDetectInfoBase {
        public int avgCost;
        public int error;
        public String host;
        public String ip;
        public int pingTimes;
        public int succTimes;

        public TTNetDetectPingInfo() {
        }

        public static TTNetDetectPingInfo fromJson(JSONObject r2) {
            TTNetDetectPingInfo r0 = new TTNetDetectPingInfo();     // Catch: Throwable -> L4
            r0.host = r2.getString("host");     // Catch: Throwable -> L4
            r0.ip = r2.getString("ip");     // Catch: Throwable -> L4
            r0.error = r2.getInt("error");     // Catch: Throwable -> L4
            r0.pingTimes = r2.getInt("ping_times");     // Catch: Throwable -> L4
            r0.succTimes = r2.getInt("succ_times");     // Catch: Throwable -> L4
            r0.avgCost = r2.getInt("avg_cost");     // Catch: Throwable -> L4
            return r0;
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public static class TTNetDetectTracerouteInfo extends TTNetDetectInfoBase {
        public List<TracerouteHopInfo> details;
        public int error;
        public String host;
        public String ip;
        public int tryHops;

        public TTNetDetectTracerouteInfo() {
            this.details = new ArrayList();
        }

        public static TTNetDetectTracerouteInfo fromJson(JSONObject r4) {
            TTNetDetectTracerouteInfo r0 = new TTNetDetectTracerouteInfo();     // Catch: Throwable -> L14
            r0.host = r4.getString("host");     // Catch: Throwable -> L14
            r0.ip = r4.getString("ip");     // Catch: Throwable -> L14
            r0.error = r4.getInt("error");     // Catch: Throwable -> L14
            r0.tryHops = r4.getInt("hops");     // Catch: Throwable -> L14
            JSONArray r5 = r4.optJSONArray("detail");     // Catch: Throwable -> L14
            if (r5 != null) goto L5;
        L13:
            return r0;
        L5:
            if (r5.length() <= 0) goto L13;
            int r1 = 0;
        L8:
            if (r1 >= r5.length()) goto L13;
            TracerouteHopInfo r2 = TracerouteHopInfo.fromJson((JSONObject) r5.get(r1));     // Catch: Throwable -> L14
            if (r2 == null) goto L12;
            r0.details.add(r2);     // Catch: Throwable -> L14
        L12:
            r1 = r1 + 1;
        L14:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public static class TracerouteHopInfo {
        public int cost;
        public String ip;
        public int replyHops;
        public int sendHops;

        public TracerouteHopInfo() {
        }

        public static TracerouteHopInfo fromJson(JSONObject r2) {
            TracerouteHopInfo r0 = new TracerouteHopInfo();     // Catch: Throwable -> L4
            r0.ip = r2.getString("ip");     // Catch: Throwable -> L4
            r0.sendHops = r2.getInt("sendhops");     // Catch: Throwable -> L4
            r0.replyHops = r2.getInt("replyhops");     // Catch: Throwable -> L4
            r0.cost = r2.getInt("cost");     // Catch: Throwable -> L4
            return r0;
        L4:
            th = move-exception;
            th.printStackTrace();
            return null;
        }
    }

    public TTNetDetectInfo() {
        this.details = new ArrayList();
    }
}
