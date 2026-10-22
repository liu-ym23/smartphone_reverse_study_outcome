package com.bytedance.apm6.cpu.config;

/* JADX INFO: loaded from: classes3.dex */
public class CpuConfig {
    private static final long DEFAULT_BACK_COLLECT_INTERVAL = 600;
    private static final long DEFAULT_BACK_THREAD_INTERVAL = 600;
    private static final long DEFAULT_FRONT_COLLECT_INTERVAL = 120;
    private static final long DEFAULT_FRONT_THREAD_INTERVAL = 120;
    private static final long DEFAULT_MONITOR_INTERVAL = 1200;
    private long mBackCollectInterval;
    private long mBackThreadCollectInterval;
    private boolean mCollectAllProcess;
    private boolean mEnableUpload;
    private long mFrontCollectInterval;
    private long mFrontThreadCollectInterval;
    private long mMonitorInterval;

    public CpuConfig() {
        this.mEnableUpload = false;
        this.mCollectAllProcess = false;
        this.mFrontCollectInterval = 120;
        this.mBackCollectInterval = 600;
        this.mMonitorInterval = 1200;
        this.mFrontThreadCollectInterval = 120;
        this.mBackThreadCollectInterval = 600;
    }

    public long getFrontCollectInterval() {
        return this.mFrontCollectInterval * 1000;
    }

    public void setFrontCollectInterval(long r1) {
        this.mFrontCollectInterval = r1;
    }

    public long getBackCollectInterval() {
        return this.mBackCollectInterval * 1000;
    }

    public void setBackCollectInterval(long r1) {
        this.mBackCollectInterval = r1;
    }

    public long getMonitorInterval() {
        return this.mMonitorInterval * 1000;
    }

    public void setMonitorInterval(long r1) {
        this.mMonitorInterval = r1;
    }

    public boolean isEnableUpload() {
        return this.mEnableUpload;
    }

    public void setEnableUpload(boolean r1) {
        this.mEnableUpload = r1;
    }

    public long getBackThreadCollectInterval() {
        return this.mBackThreadCollectInterval * 1000;
    }

    public void setBackThreadCollectInterval(long r1) {
        this.mBackThreadCollectInterval = r1;
    }

    public long getFrontThreadCollectInterval() {
        return this.mFrontThreadCollectInterval * 1000;
    }

    public void setFrontThreadCollectInterval(long r1) {
        this.mFrontThreadCollectInterval = r1;
    }

    public boolean isCollectAllProcess() {
        return this.mCollectAllProcess;
    }

    public void setCollectAllProcess(boolean r1) {
        this.mCollectAllProcess = r1;
    }

    public String toString() {
        return "CpuConfig{mEnableUpload=" + this.mEnableUpload + ", mCollectAllProcess=" + this.mCollectAllProcess + ", mFrontCollectInterval=" + this.mFrontCollectInterval + ", mBackCollectInterval=" + this.mBackCollectInterval + ", mMonitorInterval=" + this.mMonitorInterval + ", mFrontThreadCollectInterval=" + this.mFrontThreadCollectInterval + ", mBackThreadCollectInterval=" + this.mBackThreadCollectInterval + '}';
    }
}
