package com.bytedance.apm.entity;

/* JADX INFO: loaded from: classes.dex */
public class UploadInfo {
    public static final long DEFAULT_SEND_DURATION = 600000;
    public String mKey;
    public long mLastSendTime;
    public boolean mUploading;

    public UploadInfo(String r1, long r2) {
        this.mKey = r1;
        this.mLastSendTime = r2;
        this.mUploading = false;
    }

    public void setUploading(boolean r1) {
        this.mUploading = r1;
    }
}
