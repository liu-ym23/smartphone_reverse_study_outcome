package com.ttnet.org.chromium.net;

import com.ttnet.org.chromium.base.annotations.JNINamespace;

/* JADX INFO: loaded from: classes3.dex */
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

        public String getUserId() {
            return this.mUserId;
        }

        public void setUserId(String r1) {
            this.mUserId = r1;
        }

        public String getAppId() {
            return this.mAppId;
        }

        public void setAppId(String r1) {
            this.mAppId = r1;
        }

        public String getOSApi() {
            return this.mOSApi;
        }

        public void setOSApi(String r1) {
            this.mOSApi = r1;
        }

        public String getDeviceId() {
            return this.mDeviceId;
        }

        public void setDeviceId(String r1) {
            this.mDeviceId = r1;
        }

        public String getNetAccessType() {
            return this.mNetAccessType;
        }

        public void setNetAccessType(String r1) {
            this.mNetAccessType = r1;
        }

        public String getVersionCode() {
            return this.mVersionCode;
        }

        public void setVersionCode(String r1) {
            this.mVersionCode = r1;
        }

        public String getDeviceType() {
            return this.mDeviceType;
        }

        public void setDeviceType(String r1) {
            this.mDeviceType = r1;
        }

        public String getAppName() {
            return this.mAppName;
        }

        public void setAppName(String r1) {
            this.mAppName = r1;
        }

        public String getSdkAppID() {
            return this.mSdkAppID;
        }

        public void setSdkAppID(String r1) {
            this.mSdkAppID = r1;
        }

        public String getSdkVersion() {
            return this.mSdkVersion;
        }

        public void setSdkVersion(String r1) {
            this.mSdkVersion = r1;
        }

        public String getChannel() {
            return this.mChannel;
        }

        public void setChannel(String r1) {
            this.mChannel = r1;
        }

        public String getOSVersion() {
            return this.mOSVersion;
        }

        public void setOSVersion(String r1) {
            this.mOSVersion = r1;
        }

        public String getDevicePlatform() {
            return this.mDevicePlatform;
        }

        public void setDevicePlatform(String r1) {
            this.mDevicePlatform = r1;
        }

        public String getDeviceBrand() {
            return this.mDeviceBrand;
        }

        public void setDeviceBrand(String r1) {
            this.mDeviceBrand = r1;
        }

        public void setDeviceModel(String r1) {
            this.mDeviceModel = r1;
        }

        public String getDeviceModel() {
            return this.mDeviceModel;
        }

        public String getVersionName() {
            return this.mVersionName;
        }

        public void setVersionName(String r1) {
            this.mVersionName = r1;
        }

        public String getUpdateVersionCode() {
            return this.mUpdateVersionCode;
        }

        public void setUpdateVersionCode(String r1) {
            this.mUpdateVersionCode = r1;
        }

        public String getManifestVersionCode() {
            return this.mManifestVersionCode;
        }

        public void setManifestVersionCode(String r1) {
            this.mManifestVersionCode = r1;
        }

        public String getAbi() {
            return this.mAbi;
        }

        public void setAbi(String r1) {
            this.mAbi = r1;
        }

        public String getHostFirst() {
            return this.mHostFirst;
        }

        public void setHostFirst(String r1) {
            this.mHostFirst = r1;
        }

        public String getHostSecond() {
            return this.mHostSecond;
        }

        public void setHostSecond(String r1) {
            this.mHostSecond = r1;
        }

        public String getHostThird() {
            return this.mHostThird;
        }

        public void setHostThird(String r1) {
            this.mHostThird = r1;
        }

        public String getDomainHttpDns() {
            return this.mDomainHttpDns;
        }

        public void setDomainHttpDns(String r1) {
            this.mDomainHttpDns = r1;
        }

        public String getDomainBoe() {
            return this.mDomainBoe;
        }

        public void setDomainBoe(String r1) {
            this.mDomainBoe = r1;
        }

        public String getDomainBoeHttps() {
            return this.mDomainBoeHttps;
        }

        public void setDomainBoeHttps(String r1) {
            this.mDomainBoeHttps = r1;
        }

        public String getIsDropFirstTnc() {
            return this.mIsDropFirstTnc;
        }

        public void setIsDropFirstTnc(String r1) {
            this.mIsDropFirstTnc = r1;
        }

        public String getStoreIdc() {
            return this.mStoreIdc;
        }

        public void setStoreIdc(String r1) {
            this.mStoreIdc = r1;
        }

        public String getRegion() {
            return this.mRegion;
        }

        public void setRegion(String r1) {
            this.mRegion = r1;
        }

        public String getSysRegion() {
            return this.mSysRegion;
        }

        public void setSysRegion(String r1) {
            this.mSysRegion = r1;
        }

        public String getCarrierRegion() {
            return this.mCarrierRegion;
        }

        public void setCarrierRegion(String r1) {
            this.mCarrierRegion = r1;
        }

        public String getInitRegion() {
            return this.mInitRegion;
        }

        public void setInitRegion(String r1) {
            this.mInitRegion = r1;
        }

        public String getTNCRequestHeader() {
            return this.mTNCRequestHeader;
        }

        public void setTNCRequestHeader(String r1) {
            this.mTNCRequestHeader = r1;
        }

        public String getTNCRequestQuery() {
            return this.mTNCRequestQuery;
        }

        public void setTNCRequestQuery(String r1) {
            this.mTNCRequestQuery = r1;
        }

        public String getTNCRequestFlags() {
            return this.mTNCRequestFlags;
        }

        public void setTNCRequestFlags(String r1) {
            this.mTNCRequestFlags = r1;
        }

        public String getHttpDnsRequestFlags() {
            return this.mHttpDnsRequestFlags;
        }

        public void setHttpDnsRequestFlags(String r1) {
            this.mHttpDnsRequestFlags = r1;
        }

        public String getIsDomestic() {
            return this.mIsDomestic;
        }

        public void setIsDomestic(String r1) {
            this.mIsDomestic = r1;
        }

        public String getAbSdkVersion() {
            return this.mAbSdkVersion;
        }

        public void setAbSdkVersion(String r1) {
            this.mAbSdkVersion = r1;
        }
    }

    public abstract AppInfo getAppInfo();

    public TTAppInfoProvider() {
    }
}
