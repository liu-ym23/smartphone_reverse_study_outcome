package com.bytedance.framwork.core.sdklog;

import android.content.Context;
import android.text.TextUtils;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class LogHandler {
    protected IConfig mConfig;
    private long mLastStopTime;
    private String mLastSuccessChannel;
    protected LogQueue mLogQueue;
    private IResponseConfig mResponseConfig;
    private long mStopMoreChannelInterval;
    protected String mType;

    public static abstract class BaseConfig implements IConfig {
        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IConfig
        public long getLogExpireTime() {
            return 604800000;
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IConfig
        public int getMaxRetryCount() {
            return 4;
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IConfig
        public String getRedirectUrl() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdklog.LogHandler.IConfig
        public long getRetryInterval() {
            return 15000;
        }

        public BaseConfig() {
        }
    }

    public interface IConfig {
        List<String> getChannels();

        long getLogExpireTime();

        String getLogType();

        int getMaxRetryCount();

        String getRedirectUrl();

        long getRetryInterval();
    }

    public interface IResponseConfig {
        boolean getMoreChannelSwitch();

        boolean getRemoveSwitch();

        int getStatusCode();

        long getStopInterval();

        long getStopMoreChannelInterval();
    }

    protected void onLogSent(byte[] r1, boolean r2) {
    }

    protected abstract boolean send(String r1, byte[] r2);

    public long getLastStopTime() {
        return this.mLastStopTime;
    }

    public void setLastStopTime(long r1) {
        this.mLastStopTime = r1;
    }

    public long getStopMoreChannelInterval() {
        return this.mStopMoreChannelInterval;
    }

    public void setStopMoreChannelInterval(long r1) {
        this.mStopMoreChannelInterval = r1;
    }

    public LogHandler(Context r1, IConfig r2) {
        this.mConfig = r2;
        if (r2 == null) goto L11;
        String r3 = r2.getLogType();
        this.mType = r3;
        if (TextUtils.isEmpty(r3) == true) goto L9;
        LogQueue r4 = LogQueue.getInstance(r1);
        this.mLogQueue = r4;
        r4.registerLogHandler(this.mType, this);
        return;
    L9:
        throw new IllegalArgumentException("type is empty.");
    L11:
        throw new IllegalArgumentException("config is null.");
    }

    public LogHandler(Context r1, IConfig r2, IResponseConfig r3) {
        this.mConfig = r2;
        this.mResponseConfig = r3;
        if (r2 == null) goto L14;
        if (r3 == null) goto L12;
        String r4 = r2.getLogType();
        this.mType = r4;
        if (TextUtils.isEmpty(r4) == true) goto L10;
        LogQueue r5 = LogQueue.getInstance(r1);
        this.mLogQueue = r5;
        r5.registerLogHandler(this.mType, this);
        return;
    L10:
        throw new IllegalArgumentException("type is empty.");
    L12:
        throw new IllegalArgumentException("responseConfig is null");
    L14:
        throw new IllegalArgumentException("config is null.");
    }

    public boolean enqueue(String r1) {
        return enqueue(LogLib.safeGetBytes(r1));
    }

    public boolean enqueue(byte[] r2) {
        return this.mLogQueue.enqueue(this.mType, r2);
    }

    public void updateConfig(IConfig r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        this.mConfig = r1;
    }

    String getType() {
        return this.mType;
    }

    IConfig getConfig() {
        return this.mConfig;
    }

    IResponseConfig getResponseConfig() {
        return this.mResponseConfig;
    }

    String getLastSuccessChannel() {
        return this.mLastSuccessChannel;
    }

    public void setLastSuccessChannel(String r1) {
        this.mLastSuccessChannel = r1;
    }
}
