package com.bytedance.frameworks.baselib.network.sampling;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class SamplingSettingProvider {

    public static class SlaEventLogSamplingRule {
        private String[] mEventLogTypeWhiteList;

        public SlaEventLogSamplingRule(String[] r1) {
            this.mEventLogTypeWhiteList = r1;
        }

        public String[] getEventLogTypeWhiteList() {
            return this.mEventLogTypeWhiteList;
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L5;
            return true;
        L5:
            if (r3 != null) goto L7;
            return false;
        L7:
            if (getClass() == r3.getClass()) goto L10;
            return false;
        L10:
            return Arrays.equals(this.mEventLogTypeWhiteList, ((SlaEventLogSamplingRule) r3).mEventLogTypeWhiteList);
        }
    }

    public static class SlaSamplingRule {
        private boolean mEnableApiAllUpload;
        private boolean mEnableBaseApiAll;
        private String[] mHostPatternWhiteList;
        private String[] mPathContainWhiteList;
        private String[] mPathEqualWhiteList;
        private String[] mPathPrefixWhiteList;
        private String[] mPathRegexWhiteList;
        private String[] mUrlRegexBlackList;
        private String[] mUrlRegexWhiteList;

        public SlaSamplingRule(boolean r1, boolean r2, String[] r3, String[] r4, String[] r5, String[] r6, String[] r7, String[] r8, String[] r9) {
            this.mEnableBaseApiAll = r1;
            this.mEnableApiAllUpload = r2;
            this.mUrlRegexBlackList = r3;
            this.mPathEqualWhiteList = r4;
            this.mPathContainWhiteList = r5;
            this.mPathPrefixWhiteList = r6;
            this.mPathRegexWhiteList = r7;
            this.mUrlRegexWhiteList = r8;
            this.mHostPatternWhiteList = r9;
        }

        public boolean getEnableBaseApiAll() {
            return this.mEnableBaseApiAll;
        }

        public boolean getEnableApiAllUpload() {
            return this.mEnableApiAllUpload;
        }

        public String[] getUrlRegexBlackList() {
            return this.mUrlRegexBlackList;
        }

        public String[] getPathEqualWhiteList() {
            return this.mPathEqualWhiteList;
        }

        public String[] getPathContainWhiteList() {
            return this.mPathContainWhiteList;
        }

        public String[] getPathPrefixWhiteList() {
            return this.mPathPrefixWhiteList;
        }

        public String[] getPathRegexWhiteList() {
            return this.mPathRegexWhiteList;
        }

        public String[] getUrlRegexWhiteList() {
            return this.mUrlRegexWhiteList;
        }

        public String[] getHostPatternWhiteList() {
            return this.mHostPatternWhiteList;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L31:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L31;
            SlaSamplingRule r6 = (SlaSamplingRule) r5;
            if (this.mEnableBaseApiAll != r6.mEnableBaseApiAll) goto L30;
            if (this.mEnableApiAllUpload != r6.mEnableApiAllUpload) goto L30;
            if (Arrays.equals(this.mUrlRegexBlackList, r6.mUrlRegexBlackList) == false) goto L30;
            if (Arrays.equals(this.mPathEqualWhiteList, r6.mPathEqualWhiteList) == false) goto L30;
            if (Arrays.equals(this.mPathContainWhiteList, r6.mPathContainWhiteList) == false) goto L30;
            if (Arrays.equals(this.mPathPrefixWhiteList, r6.mPathPrefixWhiteList) == false) goto L30;
            if (Arrays.equals(this.mPathRegexWhiteList, r6.mPathRegexWhiteList) == false) goto L30;
            if (Arrays.equals(this.mUrlRegexWhiteList, r6.mUrlRegexWhiteList) == false) goto L30;
            if (Arrays.equals(this.mHostPatternWhiteList, r6.mHostPatternWhiteList) == false) goto L30;
            return true;
        L30:
            return false;
        }
    }

    public static class SlaSamplingSetting {
        private SlaEventLogSamplingRule mEventLogSamplingRule;
        private int mHostAid;
        private SlaSamplingRule mSamplingRule;
        private int mSdkAid;

        public SlaSamplingSetting(int r2, SlaSamplingRule r3, SlaEventLogSamplingRule r4) {
            this(r2, 0, r3, r4);
        }

        public SlaSamplingSetting(int r1, int r2, SlaSamplingRule r3, SlaEventLogSamplingRule r4) {
            this.mHostAid = r1;
            this.mSdkAid = r2;
            this.mSamplingRule = r3;
            this.mEventLogSamplingRule = r4;
        }

        public int getHostAid() {
            return this.mHostAid;
        }

        public int getSdkAid() {
            return this.mSdkAid;
        }

        public SlaSamplingRule getSlaSamplingRule() {
            return this.mSamplingRule;
        }

        public SlaEventLogSamplingRule getSlaEventLogSamplingRule() {
            return this.mEventLogSamplingRule;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L8;
        L21:
            return false;
        L8:
            if (getClass() != r5.getClass()) goto L21;
            SlaSamplingSetting r6 = (SlaSamplingSetting) r5;
            if (this.mHostAid != r6.mHostAid) goto L20;
            if (this.mSdkAid != r6.mSdkAid) goto L20;
            if (Objects.equals(this.mSamplingRule, r6.mSamplingRule) == false) goto L20;
            if (Objects.equals(this.mEventLogSamplingRule, r6.mEventLogSamplingRule) == false) goto L20;
            return true;
        L20:
            return false;
        }
    }

    public SamplingSettingProvider() {
    }
}
