package com.bytedance.apm6.consumer.slardar.header;

import a.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
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
    private String os;
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
        this.os = "Android";
        this.devicePlatform = "android";
        this.configTime = -1;
    }

    public int getAid() {
        return this.aid;
    }

    public int getApiVersion() {
        return this.apiVersion;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public String getChannel() {
        return this.channel;
    }

    public long getConfigTime() {
        return this.configTime;
    }

    public String getCurrentUpdateVersionCode() {
        return this.currentUpdateVersionCode;
    }

    public String getDeviceBrand() {
        return this.deviceBrand;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceManufacturer() {
        return this.deviceManufacturer;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDevicePlatform() {
        return this.devicePlatform;
    }

    public JSONObject getDynamicExtra() {
        return this.dynamicExtra;
    }

    public JSONObject getFilters() {
        return this.filters;
    }

    public String getManifestVersionCode() {
        return this.manifestVersionCode;
    }

    public String getMonitorVersion() {
        return this.monitorVersion;
    }

    public long getNtpOffset() {
        return this.ntpOffset;
    }

    public long getNtpTime() {
        return this.ntpTime;
    }

    public String getOs() {
        return this.os;
    }

    public String getOsVersion() {
        return this.osVersion;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public long getPhoneStartTime() {
        return this.phoneStartTime;
    }

    public String getProcessName() {
        return this.processName;
    }

    public String getReleaseBuild() {
        return this.releaseBuild;
    }

    public String getRomVersion() {
        return this.romVersion;
    }

    public long getSid() {
        return this.sid;
    }

    public JSONObject getStableExtra() {
        return this.stableExtra;
    }

    public long getUid() {
        return this.uid;
    }

    public String getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public String getVerifyInfo() {
        return this.verifyInfo;
    }

    public String getVersionCode() {
        return this.versionCode;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setAid(int r1) {
        this.aid = r1;
    }

    public void setApiVersion(int r1) {
        this.apiVersion = r1;
    }

    public void setAppVersion(String r1) {
        this.appVersion = r1;
    }

    public void setChannel(String r1) {
        this.channel = r1;
    }

    public void setConfigTime(long r1) {
        this.configTime = r1;
    }

    public void setCurrentUpdateVersionCode(String r1) {
        this.currentUpdateVersionCode = r1;
    }

    public void setDeviceBrand(String r1) {
        this.deviceBrand = r1;
    }

    public void setDeviceId(String r1) {
        this.deviceId = r1;
    }

    public void setDeviceManufacturer(String r1) {
        this.deviceManufacturer = r1;
    }

    public void setDeviceModel(String r1) {
        this.deviceModel = r1;
    }

    public void setDevicePlatform(String r1) {
        this.devicePlatform = r1;
    }

    public void setDynamicExtra(JSONObject r1) {
        this.dynamicExtra = r1;
    }

    public void setFilters(JSONObject r1) {
        this.filters = r1;
    }

    public void setManifestVersionCode(String r1) {
        this.manifestVersionCode = r1;
    }

    public void setMonitorVersion(String r1) {
        this.monitorVersion = r1;
    }

    public void setNtpOffset(long r1) {
        this.ntpOffset = r1;
    }

    public void setNtpTime(long r1) {
        this.ntpTime = r1;
    }

    public void setOs(String r1) {
        this.os = r1;
    }

    public void setOsVersion(String r1) {
        this.osVersion = r1;
    }

    public void setPackageName(String r1) {
        this.packageName = r1;
    }

    public void setPhoneStartTime(long r1) {
        this.phoneStartTime = r1;
    }

    public void setProcessName(String r1) {
        this.processName = r1;
    }

    public void setReleaseBuild(String r1) {
        this.releaseBuild = r1;
    }

    public void setRomVersion(String r1) {
        this.romVersion = r1;
    }

    public void setSid(long r1) {
        this.sid = r1;
    }

    public void setStableExtra(JSONObject r1) {
        this.stableExtra = r1;
    }

    public void setUid(long r1) {
        this.uid = r1;
    }

    public void setUpdateVersionCode(String r1) {
        this.updateVersionCode = r1;
    }

    public void setVerifyInfo(String r1) {
        this.verifyInfo = r1;
    }

    public void setVersionCode(String r1) {
        this.versionCode = r1;
    }

    public void setVersionName(String r1) {
        this.versionName = r1;
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder("HeaderInfo{aid=");
        r0.append(this.aid);
        r0.append(", deviceId='");
        r0.append(this.deviceId);
        r0.append("', channel='");
        r0.append(this.channel);
        r0.append("', updateVersionCode='");
        r0.append(this.updateVersionCode);
        r0.append("', appVersion='");
        r0.append(this.appVersion);
        r0.append("', manifestVersionCode='");
        r0.append(this.manifestVersionCode);
        r0.append("', versionCode='");
        r0.append(this.versionCode);
        r0.append("', versionName='");
        r0.append(this.versionName);
        r0.append("', releaseBuild='");
        r0.append(this.releaseBuild);
        r0.append("', os='");
        r0.append(this.os);
        r0.append("', devicePlatform='");
        r0.append(this.devicePlatform);
        r0.append("', osVersion='");
        r0.append(this.osVersion);
        r0.append("', apiVersion=");
        r0.append(this.apiVersion);
        r0.append(", deviceModel='");
        r0.append(this.deviceModel);
        r0.append("', deviceBrand='");
        r0.append(this.deviceBrand);
        r0.append("', deviceManufacturer='");
        r0.append(this.deviceManufacturer);
        r0.append("', processName='");
        r0.append(this.processName);
        r0.append("', sid=");
        r0.append(this.sid);
        r0.append(", romVersion='");
        r0.append(this.romVersion);
        r0.append("', packageName='");
        r0.append(this.packageName);
        r0.append("', monitorVersion='");
        r0.append(this.monitorVersion);
        r0.append("', uid=");
        r0.append(this.uid);
        r0.append(", phoneStartTime=");
        r0.append(this.phoneStartTime);
        r0.append(", verifyInfo='");
        r0.append(this.verifyInfo);
        r0.append("', dynamicExtra=");
        r0.append(this.dynamicExtra);
        r0.append(", stableExtra=");
        r0.append(this.stableExtra);
        r0.append(", filters=");
        r0.append(this.filters);
        r0.append(", currentUpdateVersionCode='");
        return a.o(r0, this.currentUpdateVersionCode, "'}");
    }
}
