package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public abstract class TTSamplingSettingProvider {

    public static class TTEventLogSamplingRule {
        public String[] mEventLogTypeWhiteList;

        public TTEventLogSamplingRule() {
        }

        @CalledByNative
        public String[] getEventLogTypeWhiteList() {
            return this.mEventLogTypeWhiteList;
        }
    }

    public static class TTSlaSamplingRule {
        public boolean mEnableApiAllUpload;
        public boolean mEnableBaseApiAll;
        public String[] mHostPatternWhiteList;
        public String[] mPathContainWhiteList;
        public String[] mPathEqualWhiteList;
        public String[] mPathPrefixWhiteList;
        public String[] mPathRegexWhiteList;
        public String[] mUrlRegexBlackList;
        public String[] mUrlRegexWhiteList;

        public TTSlaSamplingRule() {
        }

        @CalledByNative
        public String[] getHostPatternWhiteList() {
            return this.mHostPatternWhiteList;
        }

        @CalledByNative
        public String[] getPathContainWhiteList() {
            return this.mPathContainWhiteList;
        }

        @CalledByNative
        public String[] getPathEqualWhiteList() {
            return this.mPathEqualWhiteList;
        }

        @CalledByNative
        public String[] getPathPrefixWhiteList() {
            return this.mPathPrefixWhiteList;
        }

        @CalledByNative
        public String[] getPathRegexWhiteList() {
            return this.mPathRegexWhiteList;
        }

        @CalledByNative
        public String[] getUrlRegexBlackList() {
            return this.mUrlRegexBlackList;
        }

        @CalledByNative
        public String[] getUrlRegexWhiteList() {
            return this.mUrlRegexWhiteList;
        }

        @CalledByNative
        public boolean isEnableApiAllUpload() {
            return this.mEnableApiAllUpload;
        }

        @CalledByNative
        public boolean isEnableBaseApiAll() {
            return this.mEnableBaseApiAll;
        }
    }

    public static class TTSlaSamplingSetting {
        public TTEventLogSamplingRule mEventLogSamplingRule;
        public int mHostAid;
        public int mSdkAid;
        public TTSlaSamplingRule mSlaSamplingRule;

        public TTSlaSamplingSetting() {
        }

        @CalledByNative
        public TTEventLogSamplingRule getEventLogSamplingRule() {
            return this.mEventLogSamplingRule;
        }

        @CalledByNative
        public int getHostAid() {
            return this.mHostAid;
        }

        @CalledByNative
        public int getSdkAid() {
            return this.mSdkAid;
        }

        @CalledByNative
        public TTSlaSamplingRule getSlaSamplingRule() {
            return this.mSlaSamplingRule;
        }
    }

    public TTSamplingSettingProvider() {
    }
}
