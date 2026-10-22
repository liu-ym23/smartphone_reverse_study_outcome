package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.CalledByNative;
import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes2.dex */
@JNINamespace("cronet")
public abstract class TTAppInfoProvider {

    public static class AppInfo {
        private String mAbSdkVersion;
        private String mAbi;
        private String mAppId;
        private String mAppName;
        private String mCarrierRegion;
        private String mChannel;
        private String mDeviceBrand;
        private String mDeviceId;
        private String mDeviceModel;
        private String mDevicePlatform;
        private String mDeviceType;
        private String mDomainBoe;
        private String mDomainBoeHttps;
        private String mDomainHttpDns;
        private String mHostFirst;
        private String mHostSecond;
        private String mHostThird;
        private String mHttpDnsRequestFlags;
        private String mInitRegion;
        private String mIsDomestic;
        private String mIsDropFirstTnc;
        private String mManifestVersionCode;
        private String mNetAccessType;
        private String mOSApi;
        private String mOSVersion;
        private String mRegion;
        private String mSdkAppID;
        private String mSdkVersion;
        private String mStoreIdc;
        private String mSysRegion;
        private String mTNCRequestFlags;
        private String mTNCRequestHeader;
        private String mTNCRequestQuery;
        private String mUpdateVersionCode;
        private String mUserId;
        private String mVersionCode;
        private String mVersionName;

        public AppInfo() {
        }

        @CalledByNative
        public String getAbSdkVersion() {
            return this.mAbSdkVersion;
        }

        @CalledByNative
        public String getAbi() {
            return this.mAbi;
        }

        @CalledByNative
        public String getAppId() {
            return this.mAppId;
        }

        @CalledByNative
        public String getAppName() {
            return this.mAppName;
        }

        @CalledByNative
        public String getCarrierRegion() {
            return this.mCarrierRegion;
        }

        @CalledByNative
        public String getChannel() {
            return this.mChannel;
        }

        @CalledByNative
        public String getDeviceBrand() {
            return this.mDeviceBrand;
        }

        @CalledByNative
        public String getDeviceId() {
            return this.mDeviceId;
        }

        @CalledByNative
        public String getDeviceModel() {
            return this.mDeviceModel;
        }

        @CalledByNative
        public String getDevicePlatform() {
            return this.mDevicePlatform;
        }

        @CalledByNative
        public String getDeviceType() {
            return this.mDeviceType;
        }

        @CalledByNative
        public String getDomainBoe() {
            return this.mDomainBoe;
        }

        @CalledByNative
        public String getDomainBoeHttps() {
            return this.mDomainBoeHttps;
        }

        @CalledByNative
        public String getDomainHttpDns() {
            return this.mDomainHttpDns;
        }

        @CalledByNative
        public String getHostFirst() {
            return this.mHostFirst;
        }

        @CalledByNative
        public String getHostSecond() {
            return this.mHostSecond;
        }

        @CalledByNative
        public String getHostThird() {
            return this.mHostThird;
        }

        @CalledByNative
        public String getHttpDnsRequestFlags() {
            return this.mHttpDnsRequestFlags;
        }

        @CalledByNative
        public String getInitRegion() {
            return this.mInitRegion;
        }

        @CalledByNative
        public String getIsDomestic() {
            return this.mIsDomestic;
        }

        @CalledByNative
        public String getIsDropFirstTnc() {
            return this.mIsDropFirstTnc;
        }

        @CalledByNative
        public String getManifestVersionCode() {
            return this.mManifestVersionCode;
        }

        @CalledByNative
        public String getNetAccessType() {
            return this.mNetAccessType;
        }

        @CalledByNative
        public String getOSApi() {
            return this.mOSApi;
        }

        @CalledByNative
        public String getOSVersion() {
            return this.mOSVersion;
        }

        @CalledByNative
        public String getRegion() {
            return this.mRegion;
        }

        @CalledByNative
        public String getSdkAppID() {
            return this.mSdkAppID;
        }

        @CalledByNative
        public String getSdkVersion() {
            return this.mSdkVersion;
        }

        @CalledByNative
        public String getStoreIdc() {
            return this.mStoreIdc;
        }

        @CalledByNative
        public String getSysRegion() {
            return this.mSysRegion;
        }

        @CalledByNative
        public String getTNCRequestFlags() {
            return this.mTNCRequestFlags;
        }

        @CalledByNative
        public String getTNCRequestHeader() {
            return this.mTNCRequestHeader;
        }

        @CalledByNative
        public String getTNCRequestQuery() {
            return this.mTNCRequestQuery;
        }

        @CalledByNative
        public String getUpdateVersionCode() {
            return this.mUpdateVersionCode;
        }

        @CalledByNative
        public String getUserId() {
            return this.mUserId;
        }

        @CalledByNative
        public String getVersionCode() {
            return this.mVersionCode;
        }

        @CalledByNative
        public String getVersionName() {
            return this.mVersionName;
        }

        public void setAbSdkVersion(String r1) {
            this.mAbSdkVersion = r1;
        }

        public void setAbi(String r1) {
            this.mAbi = r1;
        }

        public void setAppId(String r1) {
            this.mAppId = r1;
        }

        public void setAppName(String r1) {
            this.mAppName = r1;
        }

        public void setCarrierRegion(String r1) {
            this.mCarrierRegion = r1;
        }

        public void setChannel(String r1) {
            this.mChannel = r1;
        }

        public void setDeviceBrand(String r1) {
            this.mDeviceBrand = r1;
        }

        public void setDeviceId(String r1) {
            this.mDeviceId = r1;
        }

        public void setDeviceModel(String r1) {
            this.mDeviceModel = r1;
        }

        public void setDevicePlatform(String r1) {
            this.mDevicePlatform = r1;
        }

        public void setDeviceType(String r1) {
            this.mDeviceType = r1;
        }

        public void setDomainBoe(String r1) {
            this.mDomainBoe = r1;
        }

        public void setDomainBoeHttps(String r1) {
            this.mDomainBoeHttps = r1;
        }

        public void setDomainHttpDns(String r1) {
            this.mDomainHttpDns = r1;
        }

        public void setHostFirst(String r1) {
            this.mHostFirst = r1;
        }

        public void setHostSecond(String r1) {
            this.mHostSecond = r1;
        }

        public void setHostThird(String r1) {
            this.mHostThird = r1;
        }

        public void setHttpDnsRequestFlags(String r1) {
            this.mHttpDnsRequestFlags = r1;
        }

        public void setInitRegion(String r1) {
            this.mInitRegion = r1;
        }

        public void setIsDomestic(String r1) {
            this.mIsDomestic = r1;
        }

        public void setIsDropFirstTnc(String r1) {
            this.mIsDropFirstTnc = r1;
        }

        public void setManifestVersionCode(String r1) {
            this.mManifestVersionCode = r1;
        }

        public void setNetAccessType(String r1) {
            this.mNetAccessType = r1;
        }

        public void setOSApi(String r1) {
            this.mOSApi = r1;
        }

        public void setOSVersion(String r1) {
            this.mOSVersion = r1;
        }

        public void setRegion(String r1) {
            this.mRegion = r1;
        }

        public void setSdkAppID(String r1) {
            this.mSdkAppID = r1;
        }

        public void setSdkVersion(String r1) {
            this.mSdkVersion = r1;
        }

        public void setStoreIdc(String r1) {
            this.mStoreIdc = r1;
        }

        public void setSysRegion(String r1) {
            this.mSysRegion = r1;
        }

        public void setTNCRequestFlags(String r1) {
            this.mTNCRequestFlags = r1;
        }

        public void setTNCRequestHeader(String r1) {
            this.mTNCRequestHeader = r1;
        }

        public void setTNCRequestQuery(String r1) {
            this.mTNCRequestQuery = r1;
        }

        public void setUpdateVersionCode(String r1) {
            this.mUpdateVersionCode = r1;
        }

        public void setUserId(String r1) {
            this.mUserId = r1;
        }

        public void setVersionCode(String r1) {
            this.mVersionCode = r1;
        }

        public void setVersionName(String r1) {
            this.mVersionName = r1;
        }
    }

    public TTAppInfoProvider() {
    }

    public abstract AppInfo getAppInfo();
}
