package com.obric.netdetect.API;

import com.bytedance.keva.KevaImpl;

/* JADX INFO: loaded from: classes3.dex */
public class NetDetectConfig {
    private static final int DEFAULT_DNS_RESOLVE_TIMEOUT = 10000;
    private static final String DEFAULT_DNS_RESOLVE_URL = "http://connectivitycheck.picovr.com/generate_204";
    private static final String DEFAULT_HTTPS_PROBE_URL = "https://connectivitycheck.picovr.com/generate_204";
    private static final int DEFAULT_HTTP_PROBE_TIMEOUT = 10000;
    private static final String DEFAULT_HTTP_PROBE_URL = "http://connectivitycheck.picovr.com/generate_204";
    private static final int DEFAULT_IP_PROBE_TIMEOUT = 5000;
    private static final int DEFAULT_PING_PROBE_COUNT = 3;
    private static final int DEFAULT_PING_PROBE_TIMEOUT = 5000;
    public static final String TAG = "NetDetectConfig";
    public int dnsResolveTimeout;
    public int dnsType;
    public String hostUrl;
    public int httpProbeTimeout;
    public String httpProbeUrl;
    public String httpsProbeUrl;
    public int ipProbeTimeout;
    public int logLevel;
    public int pingProbeCount;
    public int pingProbeTimeout;
    public boolean useHttps;

    /* JADX INFO: renamed from: com.obric.netdetect.API.NetDetectConfig$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class Builder {
        private int mDnsResolveTimeout;
        private int mDnsType;
        private String mHostUrl;
        private int mHttpProbeTimeout;
        private String mHttpProbeUrl;
        private String mHttpsProbeUrl;
        private int mIpProbeTimeout;
        private int mLogLevel;
        private int mPingProbeCount;
        private int mPingProbeTimeout;
        private boolean mUseHttps;

        public Builder() {
            this.mLogLevel = 1;
            this.mUseHttps = true;
            this.mHttpsProbeUrl = NetDetectConfig.DEFAULT_HTTPS_PROBE_URL;
            this.mHttpProbeUrl = "http://connectivitycheck.picovr.com/generate_204";
            this.mHttpProbeTimeout = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.mDnsResolveTimeout = KevaImpl.PrivateConstants.REPORT_VALUE_SIZE_THRESHOLD;
            this.mDnsType = 0;
            this.mHostUrl = "http://connectivitycheck.picovr.com/generate_204";
            this.mPingProbeCount = 3;
            this.mPingProbeTimeout = 5000;
            this.mIpProbeTimeout = 5000;
        }

        public Builder setLogLevel(int r1) {
            this.mLogLevel = r1;
            return this;
        }

        public Builder setUseHttps(boolean r1) {
            this.mUseHttps = r1;
            return this;
        }

        public Builder setHttpsProbeUrl(String r1) {
            this.mHttpsProbeUrl = r1;
            return this;
        }

        public Builder setHttpProbeUrl(String r1) {
            this.mHttpProbeUrl = r1;
            return this;
        }

        public Builder setHttpProbeTimeout(int r1) {
            this.mHttpProbeTimeout = r1;
            return this;
        }

        public Builder setDnsResolveTimeout(int r1) {
            this.mDnsResolveTimeout = r1;
            return this;
        }

        public Builder setDnsType(int r2) {
            if (r2 != 1) goto L6;
            this.mDnsType = 1;
        L9:
            return this;
        L6:
            if (r2 != 2) goto L8;
            this.mDnsType = 28;
            goto L9
        L8:
            this.mDnsType = 0;
            goto L9
        }

        public Builder setHostUrl(String r1) {
            this.mHostUrl = r1;
            return this;
        }

        public Builder setPingProbeCount(int r1) {
            this.mPingProbeCount = r1;
            return this;
        }

        public Builder setPingProbeTimeout(int r1) {
            this.mPingProbeTimeout = r1;
            return this;
        }

        public Builder setIpProbeTimeout(int r1) {
            this.mIpProbeTimeout = r1;
            return this;
        }

        public NetDetectConfig build() {
            NetDetectConfig r0 = new NetDetectConfig(null);
            r0.logLevel = this.mLogLevel;
            r0.useHttps = this.mUseHttps;
            r0.httpsProbeUrl = this.mHttpsProbeUrl;
            r0.httpProbeUrl = this.mHttpProbeUrl;
            r0.httpProbeTimeout = this.mHttpProbeTimeout;
            r0.dnsResolveTimeout = this.mDnsResolveTimeout;
            r0.dnsType = this.mDnsType;
            r0.hostUrl = this.mHostUrl;
            r0.pingProbeCount = this.mPingProbeCount;
            r0.pingProbeTimeout = this.mPingProbeTimeout;
            r0.ipProbeTimeout = this.mIpProbeTimeout;
            return r0;
        }
    }

    /* synthetic */ NetDetectConfig(AnonymousClass1 r1) {
        this();
    }

    private NetDetectConfig() {
    }
}
