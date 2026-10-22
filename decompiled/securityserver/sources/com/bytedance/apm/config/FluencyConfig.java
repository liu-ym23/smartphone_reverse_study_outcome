package com.bytedance.apm.config;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class FluencyConfig {
    private long atraceTag;
    private boolean blockDumpStackEnable;
    private boolean blockEnableUpload;
    private int blockMonitorMode;
    private long blockThreshold;
    private boolean dropEnableUpload;
    private boolean dropSlowMethodSwitch;
    private boolean enableGfxMonitor;
    private boolean enableStackSampling;
    private boolean enableTrace;
    private boolean fpsEnableUpload;
    private JSONObject mAllowScene;
    private boolean seriousBlockEnableUpload;
    private long seriousBlockThreshold;
    private long slowMethodDropThreshold;
    private boolean slowMethodEnableUpload;

    public FluencyConfig() {
    }

    public long getAtraceTag() {
        return this.atraceTag;
    }

    public int getBlockMonitorMode() {
        return this.blockMonitorMode;
    }

    public long getBlockThreshold() {
        return this.blockThreshold;
    }

    public long getSeriousBlockThreshold() {
        return this.seriousBlockThreshold;
    }

    public long getSlowMethodDropThreshold() {
        return this.slowMethodDropThreshold;
    }

    public boolean isAllowSceneEnable(String r2) {
        JSONObject r1 = this.mAllowScene;
        if (r1 != null) goto L6;
        return false;
    L6:
        if (r1.optInt(r2, 0) == 1) goto L8;
        return false;
    L8:
        return true;
    }

    public boolean isBlockDumpStackEnable() {
        return this.blockDumpStackEnable;
    }

    public boolean isBlockEnableUpload() {
        return this.blockEnableUpload;
    }

    public boolean isDropEnableUpload() {
        return this.dropEnableUpload;
    }

    public boolean isDropSlowMethodSwitch() {
        return this.dropSlowMethodSwitch;
    }

    public boolean isEnableGfxMonitor() {
        return this.enableGfxMonitor;
    }

    public boolean isEnableStackSampling() {
        return this.enableStackSampling;
    }

    public boolean isEnableTrace() {
        return this.enableTrace;
    }

    public boolean isFpsEnableUpload() {
        return this.fpsEnableUpload;
    }

    public boolean isSeriousBlockEnableUpload() {
        return this.seriousBlockEnableUpload;
    }

    public boolean isSlowMethodEnableUpload() {
        return this.slowMethodEnableUpload;
    }

    public void setAllowScene(JSONObject r1) {
        this.mAllowScene = r1;
    }

    public void setAtraceTag(long r1) {
        this.atraceTag = r1;
    }

    public void setBlockDumpStackEnable(boolean r1) {
        this.blockDumpStackEnable = r1;
    }

    public void setBlockEnableUpload(boolean r1) {
        this.blockEnableUpload = r1;
    }

    public void setBlockMonitorMode(int r1) {
        this.blockMonitorMode = r1;
    }

    public void setBlockThreshold(long r1) {
        this.blockThreshold = r1;
    }

    public void setDropEnableUpload(boolean r1) {
        this.dropEnableUpload = r1;
    }

    public void setDropSlowMethodSwitch(boolean r1) {
        this.dropSlowMethodSwitch = r1;
    }

    public void setEnableGfxMonitor(boolean r1) {
        this.enableGfxMonitor = r1;
    }

    public void setEnableStackSampling(boolean r1) {
        this.enableStackSampling = r1;
    }

    public void setEnableTrace(boolean r1) {
        this.enableTrace = r1;
    }

    public void setFpsEnableUpload(boolean r1) {
        this.fpsEnableUpload = r1;
    }

    public void setSeriousBlockEnableUpload(boolean r1) {
        this.seriousBlockEnableUpload = r1;
    }

    public void setSeriousBlockThreshold(long r1) {
        this.seriousBlockThreshold = r1;
    }

    public void setSlowMethodDropThreshold(long r1) {
        this.slowMethodDropThreshold = r1;
    }

    public void setSlowMethodEnableUpload(boolean r1) {
        this.slowMethodEnableUpload = r1;
    }

    public String toString() {
        return "FluencyConfig{enableStackSampling=" + this.enableStackSampling + ", enableTrace=" + this.enableTrace + ", atraceTag=" + this.atraceTag + ", blockDumpStackEnable=" + this.blockDumpStackEnable + ", enableGfxMonitor=" + this.enableGfxMonitor + ", blockMonitorMode=" + this.blockMonitorMode + ", seriousBlockEnableUpload=" + this.seriousBlockEnableUpload + ", seriousBlockThreshold=" + this.seriousBlockThreshold + ", slowMethodEnableUpload=" + this.slowMethodEnableUpload + ", dropEnableUpload=" + this.dropEnableUpload + ", fpsEnableUpload=" + this.fpsEnableUpload + ", blockThreshold=" + this.blockThreshold + ", slowMethodDropThreshold=" + this.slowMethodDropThreshold + ", blockEnableUpload=" + this.blockEnableUpload + ", dropSlowMethodSwitch=" + this.dropSlowMethodSwitch + '}';
    }
}
