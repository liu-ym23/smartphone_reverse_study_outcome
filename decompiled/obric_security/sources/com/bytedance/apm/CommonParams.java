package com.bytedance.apm;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class CommonParams {
    private int aid;
    private String appVersion;
    private String channel;
    private String deviceId;
    private JSONObject dynamicHeaderExtras;
    private int manifestVersionCode;
    private Map<String, String> paramExtras;
    private String processName;
    private String releaseBuild;
    private JSONObject staticHeaderExtras;
    private int updateVersionCode;
    private int versionCode;
    private String versionName;

    public CommonParams() {
    }

    public int getAid() {
        return this.aid;
    }

    public void setAid(int r1) {
        this.aid = r1;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public void setDeviceId(String r1) {
        this.deviceId = r1;
    }

    public long getUid() {
        if (ApmContext.getDynamicParams() != null) goto L5;
        return 0;
    L5:
        return ApmContext.getDynamicParams().getUid();
    }

    public String getSession() {
        if (ApmContext.getDynamicParams() != null) goto L5;
        return null;
    L5:
        return ApmContext.getDynamicParams().getSessionId();
    }

    public String getProcessName() {
        return this.processName;
    }

    public void setProcessName(String r1) {
        this.processName = r1;
    }

    public String getChannel() {
        return this.channel;
    }

    public void setChannel(String r1) {
        this.channel = r1;
    }

    public int getUpdateVersionCode() {
        return this.updateVersionCode;
    }

    public void setUpdateVersionCode(int r1) {
        this.updateVersionCode = r1;
    }

    public String getVersionName() {
        return this.versionName;
    }

    public void setVersionName(String r1) {
        this.versionName = r1;
    }

    public int getManifestVersionCode() {
        return this.manifestVersionCode;
    }

    public void setManifestVersionCode(int r1) {
        this.manifestVersionCode = r1;
    }

    public int getVersionCode() {
        return this.versionCode;
    }

    public void setVersionCode(int r1) {
        this.versionCode = r1;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String r1) {
        this.appVersion = r1;
    }

    public String getReleaseBuild() {
        return this.releaseBuild;
    }

    public void setReleaseBuild(String r1) {
        this.releaseBuild = r1;
    }

    public JSONObject getDynamicHeaderExtras() {
        return this.dynamicHeaderExtras;
    }

    public void setDynamicHeaderExtras(JSONObject r1) {
        this.dynamicHeaderExtras = r1;
    }

    public JSONObject getStaticHeaderExtras() {
        return this.staticHeaderExtras;
    }

    public void setStaticHeaderExtras(JSONObject r1) {
        this.staticHeaderExtras = r1;
    }

    public Map<String, String> getParamExtras() {
        return this.paramExtras;
    }

    public void setParamExtras(Map<String, String> r1) {
        this.paramExtras = r1;
    }
}
