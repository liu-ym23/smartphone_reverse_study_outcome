package com.bytedance.apm6.consumer.slardar.header;

import com.android.settingslib.applications.RecentAppOpsAccess;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class HeaderInfo {
    private int aid;
    private int apiVersion;
    private String appVersion;
    private String channel;
    private long configTime;
    private String currentUpdateVersionCode;
    private String deviceBrand;
    private String deviceId;
    private String deviceManufacturer;
    private String deviceModel;
    private String devicePlatform;
    private JSONObject dynamicExtra;
    private JSONObject filters;
    private String manifestVersionCode;
    private String monitorVersion;
    private long ntpOffset;
    private long ntpTime;

    /* JADX INFO: renamed from: os, reason: collision with root package name */
    private String f6os;
    private String osVersion;
    private String packageName;
    private long phoneStartTime;
    private String processName;
    private String releaseBuild;
    private String romVersion;
    private long sid;
    private JSONObject stableExtra;
    private long uid;
    private String updateVersionCode;
    private String verifyInfo;
    private String versionCode;
    private String versionName;

    public HeaderInfo() {
        this.f6os = "Android";
        this.devicePlatform = RecentAppOpsAccess.ANDROID_SYSTEM_PACKAGE_NAME;
        this.configTime = -1;
    }

    int getAid() {
        return this.aid;
    }

    void setOs(String r1) {
        this.f6os = r1;
    }

    void setDevicePlatform(String r1) {
        this.devicePlatform = r1;
    }

    void setOsVersion(String r1) {
        this.osVersion = r1;
    }

    void setApiVersion(int r1) {
        this.apiVersion = r1;
    }

    void setDeviceModel(String r1) {
        this.deviceModel = r1;
    }

    void setDeviceBrand(String r1) {
        this.deviceBrand = r1;
    }

    void setDeviceManufacturer(String r1) {
        this.deviceManufacturer = r1;
    }

    void setProcessName(String r1) {
        this.processName = r1;
    }

    void setSid(long r1) {
        this.sid = r1;
    }

    void setRomVersion(String r1) {
        this.romVersion = r1;
    }

    void setAid(int r1) {
        this.aid = r1;
    }

    String getDeviceId() {
        return this.deviceId;
    }

    void setDeviceId(String r1) {
        this.deviceId = r1;
    }

    String getChannel() {
        return this.channel;
    }

    void setChannel(String r1) {
        this.channel = r1;
    }

    String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    void setUpdateVersionCode(String r1) {
        this.updateVersionCode = r1;
    }

    String getAppVersion() {
        return this.appVersion;
    }

    void setAppVersion(String r1) {
        this.appVersion = r1;
    }

    String getManifestVersionCode() {
        return this.manifestVersionCode;
    }

    void setManifestVersionCode(String r1) {
        this.manifestVersionCode = r1;
    }

    String getVersionCode() {
        return this.versionCode;
    }

    void setVersionCode(String r1) {
        this.versionCode = r1;
    }

    String getVersionName() {
        return this.versionName;
    }

    void setVersionName(String r1) {
        this.versionName = r1;
    }

    String getReleaseBuild() {
        return this.releaseBuild;
    }

    void setReleaseBuild(String r1) {
        this.releaseBuild = r1;
    }

    String getOs() {
        return this.f6os;
    }

    String getDevicePlatform() {
        return this.devicePlatform;
    }

    String getOsVersion() {
        return this.osVersion;
    }

    int getApiVersion() {
        return this.apiVersion;
    }

    String getDeviceModel() {
        return this.deviceModel;
    }

    String getDeviceBrand() {
        return this.deviceBrand;
    }

    String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    String getProcessName() {
        return this.processName;
    }

    long getSid() {
        return this.sid;
    }

    String getRomVersion() {
        return this.romVersion;
    }

    String getPackageName() {
        return this.packageName;
    }

    void setPackageName(String r1) {
        this.packageName = r1;
    }

    String getMonitorVersion() {
        return this.monitorVersion;
    }

    void setMonitorVersion(String r1) {
        this.monitorVersion = r1;
    }

    long getUid() {
        return this.uid;
    }

    void setUid(long r1) {
        this.uid = r1;
    }

    public JSONObject getDynamicExtra() {
        return this.dynamicExtra;
    }

    public void setDynamicExtra(JSONObject r1) {
        this.dynamicExtra = r1;
    }

    public JSONObject getStableExtra() {
        return this.stableExtra;
    }

    public void setStableExtra(JSONObject r1) {
        this.stableExtra = r1;
    }

    long getPhoneStartTime() {
        return this.phoneStartTime;
    }

    void setPhoneStartTime(long r1) {
        this.phoneStartTime = r1;
    }

    String getVerifyInfo() {
        return this.verifyInfo;
    }

    void setVerifyInfo(String r1) {
        this.verifyInfo = r1;
    }

    JSONObject getFilters() {
        return this.filters;
    }

    void setFilters(JSONObject r1) {
        this.filters = r1;
    }

    String getCurrentUpdateVersionCode() {
        return this.currentUpdateVersionCode;
    }

    void setCurrentUpdateVersionCode(String r1) {
        this.currentUpdateVersionCode = r1;
    }

    long getConfigTime() {
        return this.configTime;
    }

    void setConfigTime(long r1) {
        this.configTime = r1;
    }

    public long getNtpTime() {
        return this.ntpTime;
    }

    public long getNtpOffset() {
        return this.ntpOffset;
    }

    public void setNtpTime(long r1) {
        this.ntpTime = r1;
    }

    public void setNtpOffset(long r1) {
        this.ntpOffset = r1;
    }

    public String toString() {
        return "HeaderInfo{aid=" + this.aid + ", deviceId='" + this.deviceId + "', channel='" + this.channel + "', updateVersionCode='" + this.updateVersionCode + "', appVersion='" + this.appVersion + "', manifestVersionCode='" + this.manifestVersionCode + "', versionCode='" + this.versionCode + "', versionName='" + this.versionName + "', releaseBuild='" + this.releaseBuild + "', os='" + this.f6os + "', devicePlatform='" + this.devicePlatform + "', osVersion='" + this.osVersion + "', apiVersion=" + this.apiVersion + ", deviceModel='" + this.deviceModel + "', deviceBrand='" + this.deviceBrand + "', deviceManufacturer='" + this.deviceManufacturer + "', processName='" + this.processName + "', sid=" + this.sid + ", romVersion='" + this.romVersion + "', packageName='" + this.packageName + "', monitorVersion='" + this.monitorVersion + "', uid=" + this.uid + ", phoneStartTime=" + this.phoneStartTime + ", verifyInfo='" + this.verifyInfo + "', dynamicExtra=" + this.dynamicExtra + ", stableExtra=" + this.stableExtra + ", filters=" + this.filters + ", currentUpdateVersionCode='" + this.currentUpdateVersionCode + "'}";
    }
}
