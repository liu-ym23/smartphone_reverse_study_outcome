package com.ttnet.org.chromium.net.impl;

import java.time.Duration;

/* JADX INFO: loaded from: classes2.dex */
public abstract class CronetLogger {

    public static class CronetEngineBuilderInfo {
        private final boolean mBrotiEnabled;
        private final String mExperimentalOptions;
        private final boolean mHttp2Enabled;
        private final int mHttpCacheMode;
        private final boolean mNetworkQualityEstimatorEnabled;
        private final boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
        private final boolean mQuicEnabled;
        private final String mStoragePath;
        private final int mThreadPriority;
        private final String mUserAgent;

        public CronetEngineBuilderInfo(CronetEngineBuilderImpl r2) {
            this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = r2.publicKeyPinningBypassForLocalTrustAnchorsEnabled();
            this.mUserAgent = r2.getUserAgent();
            this.mStoragePath = r2.storagePath();
            this.mQuicEnabled = r2.quicEnabled();
            this.mHttp2Enabled = r2.http2Enabled();
            this.mBrotiEnabled = r2.brotliEnabled();
            this.mHttpCacheMode = r2.publicBuilderHttpCacheMode();
            this.mExperimentalOptions = r2.experimentalOptions();
            this.mNetworkQualityEstimatorEnabled = r2.networkQualityEstimatorEnabled();
            this.mThreadPriority = r2.threadPriority(10);
        }

        public String getExperimentalOptions() {
            return this.mExperimentalOptions;
        }

        public int getHttpCacheMode() {
            return this.mHttpCacheMode;
        }

        public String getStoragePath() {
            return this.mStoragePath;
        }

        public int getThreadPriority() {
            return this.mThreadPriority;
        }

        public String getUserAgent() {
            return this.mUserAgent;
        }

        public boolean isBrotliEnabled() {
            return this.mBrotiEnabled;
        }

        public boolean isHttp2Enabled() {
            return this.mHttp2Enabled;
        }

        public boolean isNetworkQualityEstimatorEnabled() {
            return this.mNetworkQualityEstimatorEnabled;
        }

        public boolean isPublicKeyPinningBypassForLocalTrustAnchorsEnabled() {
            return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
        }

        public boolean isQuicEnabled() {
            return this.mQuicEnabled;
        }
    }

    public static final enum CronetSource extends Enum<CronetSource> {
        private static final /* synthetic */ CronetSource[] $VALUES = null;
        public static final CronetSource CRONET_SOURCE_FALLBACK = null;
        public static final CronetSource CRONET_SOURCE_PLAY_SERVICES = null;
        public static final CronetSource CRONET_SOURCE_STATICALLY_LINKED = null;
        public static final CronetSource CRONET_SOURCE_UNSPECIFIED = null;

        static {
            CronetSource r0 = new CronetSource("CRONET_SOURCE_UNSPECIFIED", 0);
            CRONET_SOURCE_UNSPECIFIED = r0;
            CronetSource r1 = new CronetSource("CRONET_SOURCE_STATICALLY_LINKED", 1);
            CRONET_SOURCE_STATICALLY_LINKED = r1;
            CronetSource r3 = new CronetSource("CRONET_SOURCE_PLAY_SERVICES", 2);
            CRONET_SOURCE_PLAY_SERVICES = r3;
            CronetSource r5 = new CronetSource("CRONET_SOURCE_FALLBACK", 3);
            CRONET_SOURCE_FALLBACK = r5;
            $VALUES = new CronetSource[]{r0, r1, r3, r5};
        }

        private CronetSource(String r1, int r2) {
            super(r1, r2);
        }

        public static CronetSource valueOf(String r1) {
            return (CronetSource) Enum.valueOf(CronetSource.class, r1);
        }

        public static CronetSource[] values() {
            return (CronetSource[]) $VALUES.clone();
        }
    }

    public static class CronetTrafficInfo {
        private final boolean mDidConnectionMigrationSucceed;
        private final Duration mHeadersLatency;
        private final String mNegotiatedProtocol;
        private final long mRequestBodySizeInBytes;
        private final long mRequestHeaderSizeInBytes;
        private final long mResponseBodySizeInBytes;
        private final long mResponseHeaderSizeInBytes;
        private final int mResponseStatusCode;
        private final Duration mTotalLatency;
        private final boolean mWasConnectionMigrationAttempted;

        public CronetTrafficInfo(long r1, long r3, long r5, long r7, int r9, Duration r10, Duration r11, String r12, boolean r13, boolean r14) {
            this.mRequestHeaderSizeInBytes = r1;
            this.mRequestBodySizeInBytes = r3;
            this.mResponseHeaderSizeInBytes = r5;
            this.mResponseBodySizeInBytes = r7;
            this.mResponseStatusCode = r9;
            this.mHeadersLatency = r10;
            this.mTotalLatency = r11;
            this.mNegotiatedProtocol = r12;
            this.mWasConnectionMigrationAttempted = r13;
            this.mDidConnectionMigrationSucceed = r14;
        }

        public boolean didConnectionMigrationSucceed() {
            return this.mDidConnectionMigrationSucceed;
        }

        public Duration getHeadersLatency() {
            return this.mHeadersLatency;
        }

        public String getNegotiatedProtocol() {
            return this.mNegotiatedProtocol;
        }

        public long getRequestBodySizeInBytes() {
            return this.mRequestBodySizeInBytes;
        }

        public long getRequestHeaderSizeInBytes() {
            return this.mRequestHeaderSizeInBytes;
        }

        public long getResponseBodySizeInBytes() {
            return this.mResponseBodySizeInBytes;
        }

        public long getResponseHeaderSizeInBytes() {
            return this.mResponseHeaderSizeInBytes;
        }

        public int getResponseStatusCode() {
            return this.mResponseStatusCode;
        }

        public Duration getTotalLatency() {
            return this.mTotalLatency;
        }

        public boolean wasConnectionMigrationAttempted() {
            return this.mWasConnectionMigrationAttempted;
        }
    }

    public static class CronetVersion {
        private final int mBuildVersion;
        private final int mMajorVersion;
        private final int mMinorVersion;
        private final int mPatchVersion;

        public CronetVersion(String r2) {
            String[] r3 = r2.split("\\.");
            this.mMajorVersion = Integer.parseInt(r3[0]);
            this.mMinorVersion = Integer.parseInt(r3[1]);
            this.mBuildVersion = Integer.parseInt(r3[2]);
            this.mPatchVersion = Integer.parseInt(r3[3]);
        }

        public int getBuildVersion() {
            return this.mBuildVersion;
        }

        public int getMajorVersion() {
            return this.mMajorVersion;
        }

        public int getMinorVersion() {
            return this.mMinorVersion;
        }

        public int getPatchVersion() {
            return this.mPatchVersion;
        }

        public String toString() {
            return "" + this.mMajorVersion + "." + this.mMinorVersion + "." + this.mBuildVersion + "." + this.mPatchVersion;
        }
    }

    public CronetLogger() {
    }

    public abstract void logCronetEngineCreation(int r1, CronetEngineBuilderInfo r2, CronetVersion r3, CronetSource r4);

    public abstract void logCronetTrafficInfo(int r1, CronetTrafficInfo r2);
}
