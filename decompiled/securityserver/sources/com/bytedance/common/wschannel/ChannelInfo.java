package com.bytedance.common.wschannel;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.wschannel.server.FrontierMessageManager;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ChannelInfo {
    int aid;
    String appKey;
    final int channelId;
    String deviceId;
    boolean disableFallbackWs;
    Map<String, String> extra;
    int fpid;
    Map<String, String> headers;
    String installId;
    boolean privateProtocolEnabled;
    String privateProtocolUrl;
    List<Integer> serviceIdList;
    TransportMode transportMode;
    int updateVersionCode;
    List<String> urls;

    public static class Builder {
        private int aid;
        private int appVersion;
        private String appkey;
        private final int channelId;
        private String deviceId;
        boolean disableFallbackWS;
        Map<String, String> extra;
        private int fpid;
        Map<String, String> headers;
        private String installId;
        boolean privateProtocolEnabled;
        String privateProtocolUrl;
        List<Integer> serviceIdList;
        TransportMode transportMode;
        List<String> urls;

        public Builder(int r2) {
            this.extra = new HashMap();
            this.headers = new HashMap();
            this.urls = new ArrayList();
            this.serviceIdList = new ArrayList();
            this.transportMode = TransportMode.TUDP;
            this.channelId = r2;
        }

        public static Builder create(int r1) {
            return new Builder(r1);
        }

        public ChannelInfo builder() {
            return new ChannelInfo(this.fpid, this.aid, this.appVersion, this.appkey, this.channelId, this.deviceId, this.installId, this.urls, this.extra, this.privateProtocolEnabled, this.serviceIdList, this.privateProtocolUrl, this.transportMode, this.disableFallbackWS, this);
        }

        public Builder disableFallbackWebSocket(boolean r1) {
            this.disableFallbackWS = r1;
            return this;
        }

        public Builder enablePrivateProtocol(boolean r1) {
            this.privateProtocolEnabled = r1;
            return this;
        }

        public Builder extra(String r2, String r3) {
            if (StringUtils.isEmpty(r2) == true) goto L5;
            this.extra.put(r2, r3);
        L5:
            return this;
        }

        public Builder extras(Map<String, String> r2) {
            if (r2 == null) goto L4;
            this.extra.putAll(r2);
        L4:
            return this;
        }

        public Builder header(String r2, String r3) {
            if (StringUtils.isEmpty(r2) == true) goto L5;
            this.headers.put(r2, r3);
        L5:
            return this;
        }

        public Builder headers(Map<String, String> r2) {
            if (r2 == null) goto L4;
            this.headers.putAll(r2);
        L4:
            return this;
        }

        public Builder setAid(int r1) {
            this.aid = r1;
            return this;
        }

        public Builder setAppKey(String r1) {
            this.appkey = r1;
            return this;
        }

        public Builder setAppVersion(int r1) {
            this.appVersion = r1;
            return this;
        }

        public Builder setDeviceId(String r1) {
            this.deviceId = r1;
            return this;
        }

        public Builder setFPID(int r1) {
            this.fpid = r1;
            return this;
        }

        public Builder setInstallId(String r1) {
            this.installId = r1;
            return this;
        }

        public Builder transportModeForPrivateProtocol(TransportMode r1) {
            this.transportMode = r1;
            return this;
        }

        public Builder uniqueServiceIdList(List<Integer> r2) {
            if (r2 == null) goto L4;
            this.serviceIdList.addAll(r2);
        L4:
            return this;
        }

        public Builder urlForPrivateProtocol(String r4) {
        L11:
            this.privateProtocolUrl = null;
            Logger.e("ChannelInfo", "The private protocol url is invalid.");
        L12:
            return this;
        L4:
            if (r4.startsWith("wss:") == false) goto L7;
            r4 = "https:" + r4.substring(4);     // Catch: Throwable -> L11
        L9:
            new URI(r4);     // Catch: Throwable -> L11
            this.privateProtocolUrl = r4;     // Catch: Throwable -> L11
            goto L12
        L7:
            if (r4.startsWith("ws:") == false) goto L9;
            r4 = "http:" + r4.substring(3);     // Catch: Throwable -> L11
            goto L9
        }

        public Builder urls(List<String> r2) {
            if (r2 == null) goto L4;
            this.urls.addAll(r2);
        L4:
            return this;
        }
    }

    public ChannelInfo(int r5, int r6, int r7, String r8, int r9, String r10, String r11, List<String> r12, Map<String, String> r13, boolean r14, List<Integer> r15, String r16, TransportMode r17, boolean r18, Builder r19) {
        this.extra = new HashMap();
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.serviceIdList = new ArrayList();
        this.channelId = r9;
        this.deviceId = r10;
        this.installId = r11;
        this.updateVersionCode = r7;
        if (r12 == null) goto L5;
        this.urls.addAll(r12);
    L5:
        if (r13 == null) goto L7;
        this.extra.putAll(r13);
    L7:
        Map<String, String> r1 = r19.headers;
        if (r1 == null) goto L11;
        this.headers.putAll(r1);
    L11:
        if (FrontierMessageManager.isQos2Enabled() == false) goto L13;
        this.headers.put("x-support-qos2", "1");
    L13:
        this.fpid = r5;
        this.aid = r6;
        this.appKey = r8;
        this.serviceIdList = r15;
        this.privateProtocolEnabled = r14;
        this.privateProtocolUrl = r16;
        this.transportMode = r17;
        if (TextUtils.isEmpty(r16) == false) goto L16;
        this.privateProtocolEnabled = false;
    L16:
        this.disableFallbackWs = r18;
    }

    public String toString() {
        return "ChannelInfo{channelId = " + this.channelId + ", deviceId = " + this.deviceId + ", installId = " + this.installId + ", fpid = " + this.fpid + ", aid = " + this.aid + ", updateVersionCode = " + this.updateVersionCode + ", appKey = " + this.appKey + ", header = " + this.headers + ", extra = " + this.extra + ", urls = " + this.urls + "}";
    }

    public ChannelInfo(ChannelInfo r3) {
        this.extra = new HashMap();
        this.headers = new HashMap();
        this.urls = new ArrayList();
        this.serviceIdList = new ArrayList();
        this.channelId = r3.channelId;
        this.deviceId = r3.deviceId;
        this.installId = r3.installId;
        List<String> r0 = r3.urls;
        if (r0 == null) goto L5;
        this.urls.addAll(r0);
    L5:
        Map<String, String> r1 = r3.extra;
        if (r1 == null) goto L8;
        this.extra.putAll(r1);
    L8:
        Map<String, String> r2 = r3.headers;
        if (r2 == null) goto L11;
        this.headers.putAll(r2);
    L11:
        this.fpid = r3.fpid;
        this.aid = r3.aid;
        this.appKey = r3.appKey;
        this.updateVersionCode = r3.updateVersionCode;
        this.privateProtocolEnabled = r3.privateProtocolEnabled;
        this.transportMode = r3.transportMode;
        this.privateProtocolUrl = r3.privateProtocolUrl;
        List<Integer> r4 = r3.serviceIdList;
        if (r4 == null) goto L14;
        this.serviceIdList.addAll(r4);
    L14:
        this.disableFallbackWs = r3.disableFallbackWs;
    }
}
